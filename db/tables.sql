CREATE TABLE countries (
    id int not null,
    name varchar(200),
    constraint pk_countries primary key (id)
);


CREATE TABLE departments (
    id int,
    name varchar(200),
    country_id int,
    constraint pk_countries primary key (id),
    constraint fk_departments_countries foreign key (country_id) references countries(id)
);


CREATE TABLE cities (
    id integer,
    name varchar(200),
    department_id int,
    constraint [pk_countries]  primary key (id),
    constraint [pk_countries]  foreign key (department_id) references departments(id)
);
