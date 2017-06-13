create table posts (
    post_id         bigserial primary key,
    title           varchar,
    body            varchar,
    author          varchar not null,
    last_updated    datetime
)