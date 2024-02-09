create table course
(
    id          uuid primary key,
    name        varchar   not null,
    description varchar   not null,
    start_time  timestamp not null,
    end_time    timestamp not null,
    studio_id   uuid,
    foreign key (studio_id) references studio (id)
);

create table comment
(
    id        uuid primary key,
    comment   varchar not null,
    course_id uuid references course (id),
    user_id   uuid references "user"
);