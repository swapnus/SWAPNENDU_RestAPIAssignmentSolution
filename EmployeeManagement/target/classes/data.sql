
--inserting values into role table--
insert into role (role_id,name) values (1, 'ADMIN');
insert into role (role_id,name) values (2, 'USER');

--inserting values into user table--
insert into user (user_id, password,username) values (1,'$2a$12$qfkDx9ZaTvzwfMAOe28UpOaRjN/0ACoCz3li3CwBSByXU8dMQYG0m','ADMIN');
insert into user (user_id, password,username) values (2,'$2a$12$jP.0dMis1G3D6cFgSAK7POPHNHWy.vCcAxUXjKh7Jey9rhGeHKGri', 'USER');

--inserting values in users_roles--
insert into users_roles (user_id, role_id) values (1,1);
insert into users_roles (user_id, role_id) values(2,2);

--inserting values inti employee table
insert into employee (email_id, first_name, last_name) values ('swap@gmail.com', 'Swapnendu', 'Mukherjee');
insert into employee (email_id, first_name, last_name) values ('gl@gmail.com', 'great', 'learning');