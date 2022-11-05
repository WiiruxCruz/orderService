drop table if exists order_header cascade;

create table order_header
(
    id        bigint not null auto_increment primary key,
    customer      varchar(255)
) engine = InnoDB;

insert into order_header (customer) values ('Craig Walls');
insert into order_header (customer) values ('Smith Futher');