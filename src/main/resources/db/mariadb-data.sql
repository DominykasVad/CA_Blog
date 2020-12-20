INSERT INTO users (email, name, password, surname, username)
VALUES ('foo@bar.com',
        'Admin',
        '{bcrypt}$2y$12$opcSBUuyU/i5S9SWcN5mc.f85WaioHDbT1Pi2WQbtCAVOoBl91cFC',
        'Admin',
        'admin');

INSERT INTO role (role_name)
VALUES ('USER'),
       ('ADMIN');

INSERT INTO user_roles (user_id, role_id)
VALUES ('1', '2');
