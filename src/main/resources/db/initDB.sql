DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id         INT AUTO_INCREMENT NOT NULL,
    first_name VARCHAR(255)       NOT NULL,
    last_name  VARCHAR(255)       NOT NULL,
    age        INT                NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);