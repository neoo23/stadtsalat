DROP TABLE IF EXISTS APPUSER;

CREATE TABLE APPUSER
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(150) NOT NULL,
    last_name  VARCHAR(150) NOT NULL
);

INSERT INTO APPUSER (first_name, last_name)
VALUES ('Test', 'User'),
       ('Other', 'User');