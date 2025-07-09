INSERT INTO roles (name) VALUES ('ADMIN');

INSERT INTO users (username, password, enabled) VALUES 
('admin', '$2a$10$JHs5JycjdY4Qyw8HmGQwOukdm0IuIXJcs3mCRG0.UJvlatIM/1c1a', true); -- senha: 123

INSERT INTO user_roles (user_id, role_id) VALUES 
(1, 1) -- adimin tem ROLE_ADMIN