INSERT INTO users (email, name, password, surname, username)
VALUES ('foo@bar.com',
        'Admin',
        '{bcrypt}$2y$12$Ngi.pR.qcdFkMKVHlQl0AeKyn68vF9tId6Hk7So478VVr54TMlLfy/q',
        'Admin',
        'Admin');

INSERT INTO role (role_name)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO user_roles (user_id, role_id)
VALUES ('1', '2');
