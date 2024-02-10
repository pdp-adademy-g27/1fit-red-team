create table membership
(
    id            uuid primary key,
    name          varchar not null,
    freeze_days   smallint,
    bought_day    date    not null,
    duration_days int     not null
);

create table user_membership
(
    user_id       uuid references "user",
    membership_id uuid references membership,
    primary key (user_id, membership_id)
);