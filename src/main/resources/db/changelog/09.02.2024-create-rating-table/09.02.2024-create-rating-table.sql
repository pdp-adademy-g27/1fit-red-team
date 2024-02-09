create table rating
(
    id          uuid primary key,
    rating_name varchar not null,
    comment     varchar,
    star smallint,
    user_id     uuid references "user",
    studio_id   uuid references studio (id)
);