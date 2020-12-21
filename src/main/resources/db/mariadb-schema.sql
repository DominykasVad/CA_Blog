create table role
(
    id        bigint auto_increment
        primary key,
    role_name varchar(255) null
);

create table users
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) not null,
    name     varchar(255) null,
    password varchar(255) not null,
    surname  varchar(255) null,
    username varchar(36)  not null,
    constraint UK_6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UK_r43af9ap4edm43mmtq01oddj6
        unique (username)
);

create table posts
(
    id           bigint auto_increment
        primary key,
    created_at   datetime(6)  null,
    post_content longtext     null,
    post_title   varchar(255) null,
    updated_at   datetime(6)  null,
    user_id      bigint       null,
    constraint FK5lidm6cqbc7u4xhqpxm898qme
        foreign key (user_id) references users (id)
);

create table comments
(
    id         bigint auto_increment
        primary key,
    content    longtext     null,
    created_at datetime(6)  null,
    updated_at datetime(6)  null,
    user_id    bigint       null,
    post_id    bigint       null,
    constraint FK8omq0tc18jd43bu5tjh6jvraq
        foreign key (user_id) references users (id),
    constraint FKh4c7lvsc298whoyd4w9ta25cr
        foreign key (post_id) references posts (id)
);

create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id),
    constraint FKrhfovtciq1l558cw6udg0h0d3
        foreign key (role_id) references role (id)
);