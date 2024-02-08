create table studio
(
    id         uuid primary key,
    name       varchar not null unique,
    description varchar,
    for_female bool    not null
);

create table category
(
    name varchar primary key
);

create table studio_category
(
    category_id varchar references category,
    studio_id   uuid references studio,
    primary key (category_id, studio_id)
);

create table location
(
    id        uuid primary key,
    name      varchar not null unique,
    longitude double precision   not null,
    latitude  double precision   not null,
    studio_id uuid    unique ,
    foreign key (studio_id) references studio(id)
);
