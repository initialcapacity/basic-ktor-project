create table example
(
    id   uuid primary key not null default gen_random_uuid(),
    name varchar
);
