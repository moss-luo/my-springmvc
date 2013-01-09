CREATE TABLE USER(id IDENTITY PRIMARY KEY, name CHAR(16), password CHAR(32), mobile CHAR(32), email CHAR(32));

INSERT INTO USER(name, password,mobile,email) VALUES('User1', '123456','13888888888','User@163.com');

