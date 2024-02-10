create table history(
    id uuid primary key ,
    when_coming timestamp not null ,
    when_left timestamp not null ,
    user_id uuid references "user",
    course_id uuid references course
)