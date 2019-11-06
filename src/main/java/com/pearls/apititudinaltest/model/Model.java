package com.pearls.apititudinaltest.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import com.pearls.apititudinaltest.common.Utils;
import com.pearls.apititudinaltest.dto.DTO;

import org.springframework.beans.BeanUtils;

public abstract class Model<T extends DTO> {

    public Model() {
    }

    public Model(T dto) {
        this.populate(dto);
    }

    final protected void populate(@NotNull DTO dto) {
        BeanUtils.copyProperties(dto, this);

        Field fields[] = this.getClass().getDeclaredFields();
        List<String> dtoFieldNames = Stream.of(dto.getClass().getDeclaredFields()).map(f -> f.getName())
                .collect(Collectors.toList());

        for (Field field : fields) {

            Class<?> type = field.getType();
            if (Model.class.isAssignableFrom(type)
                    && dtoFieldNames.stream().anyMatch(fn -> fn.equals(field.getName() + "DTO"))) {

                String fieldNameCapitalized = Utils.capitalize(field.getName());
                String dtoGetter = "get" + fieldNameCapitalized + "DTO";

                DTO dtoValue = this.getDtoValueFromFieldName(dto, dtoGetter);
                if (dtoValue != null) {
                    String modelSetter = "set" + fieldNameCapitalized;
                    this.setDtoValueBySetter(dtoValue, modelSetter, type);
                }

            }

        }
    }

    private DTO getDtoValueFromFieldName(DTO dto, String getter) {
        Class<? extends DTO> dtoClass = dto.getClass();
        try {

            Method dtoMethod = dtoClass.getMethod(getter);
            return (DTO) dtoMethod.invoke(dto);

        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            throw new RuntimeException("Getter " + getter + " for class " + dtoClass + " not found or standarized", e);
        }
    }

    private void setDtoValueBySetter(DTO dto, String setter, Class<?> setterType) {
        Class<?> modelClass = this.getClass();

        Method dtoMethod;
        try {
            dtoMethod = modelClass.getMethod(setter, setterType);
        } catch (NoSuchMethodException | SecurityException e) {
            String msg = "Setter " + setter + " for class " + modelClass + " not found or standarized";
            throw new RuntimeException(msg, e);
        }

        try {
            Model<?> model = (Model<?>) setterType.newInstance();
            model.populate(dto);

            dtoMethod.invoke(this, model);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException("Class " + Model.class + " has no dto initilizer ");
        }
    }

    public abstract T getDTO();
}