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
    id int,
    name varchar(200),
    department_id int,
    constraint pk_countries primary key (id),
    constraint fk_cities_departments  foreign key (department_id) references departments(id)
);

CREATE TABLE representatives (
    id int not null,
    name varchar(200),
    constraint pk_representatives primary key (id)
);


CREATE TABLE clients (
    id integer auto_increment,
    nit varchar(200),
    name varchar(200),
    address varchar(200),
    phone varchar(200),
    city_id int,
    maximum_amount numeric,
    assigned_credit numeric,
    visits_percenage numeric,
    constraint pk_clients primary key (id),
    constraint fk_clients_cities foreign key (city_id) references cities(id)
);


CREATE TABLE visits (
    id integer auto_increment,
    client_id int,
    representative_id int,
    date date,
    net numeric,
    total numeric,
    constraint pk_visits primary key (id),
    constraint fk_visits_clients foreign key (client_id) references clients(id),
    constraint fk_visits_representatives foreign key (representative_id) references representatives(id)
);
