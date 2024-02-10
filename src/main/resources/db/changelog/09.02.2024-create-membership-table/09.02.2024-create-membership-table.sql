create table membership(
    id uuid primary key ,
    name varchar not null ,
    freeze_days smallint,
    bought_day date not null ,
    duration_days int not null,
    user_id uuid references "user"
);