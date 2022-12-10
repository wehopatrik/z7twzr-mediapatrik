CREATE ROLE mediapatrik WITH
    LOGIN
    SUPERUSER
    CREATEDB
    CREATEROLE
    INHERIT
    REPLICATION
    CONNECTION LIMIT -1
    PASSWORD 'Password111';

CREATE TABLE product
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    image_name  VARCHAR(100) NOT NULL,
    price       INT NOT NULL,
    type        VARCHAR(100) NOT NULL
);

CREATE TABLE "user"
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE role
(
    id        SERIAL PRIMARY KEY,
    role_name VARCHAR(100)
);

CREATE TABLE product_user
(
    id          SERIAL PRIMARY KEY,
    user_id     INTEGER NOT NULL,
    product_id  INTEGER NOT NULL
);

CREATE TABLE user_role
(
    id      SERIAL PRIMARY KEY,
    user_id SERIAL NOT NULL REFERENCES "user" (id),
    role_id SERIAL NOT NULL REFERENCES role (id)
);

INSERT INTO "user" (username, password) VALUES ('admin', '$2a$12$ceJaZ2NVdYgAfCySr55xTu5y1SWpovxAIwLv3AlLvuwxemCb1Uple');
INSERT INTO "user" (username, password) VALUES ('user', '$2a$12$ceJaZ2NVdYgAfCySr55xTu5y1SWpovxAIwLv3AlLvuwxemCb1Uple');

INSERT INTO role (role_name) VALUES ('USER');
INSERT INTO role (role_name) VALUES ('ADMIN');

INSERT INTO product (name, image_name, price, type) VALUES ('iPhone 13 Pro Max', 'iphone13promax', 359990, 'MOBILE');
INSERT INTO product (name, image_name, price, type) VALUES ('iPad 10. generáció', 'ipad10', 259990, 'TABLET');
INSERT INTO product (name, image_name, price, type) VALUES ('Macbook Pro M2', 'macbookprom2', 529990, 'LAPTOP');

INSERT INTO user_role (user_id, role_id) SELECT * FROM (SELECT u.id FROM "user" u WHERE u.username = 'admin') a, (SELECT r.id FROM "role" r WHERE r.role_name = 'ADMIN') b;
INSERT INTO user_role (user_id, role_id) SELECT * FROM (SELECT u.id FROM "user" u WHERE u.username = 'admin') a, (SELECT r.id FROM "role" r WHERE r.role_name = 'USER') b;
INSERT INTO user_role (user_id, role_id) SELECT * FROM (SELECT u.id FROM "user" u WHERE u.username = 'user') a, (SELECT r.id FROM "role" r WHERE r.role_name = 'USER') b;