-- Initial data --
insert into Person(id, name, age)
values (10001,'Felipe',30),
       (10002,'Francisca', 28);

insert into Pet(id, name, type,owner_id)
values (10001,'Mimi','cat',10001),
       (10002,'yuki','cat', 10001),
       (10003,'Cuchito','cat', 10002),
       (10004,'Bruno','cat',10002),
       (10005,'Jin','cat', 10002);