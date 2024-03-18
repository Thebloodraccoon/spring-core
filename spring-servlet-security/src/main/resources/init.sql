

INSERT INTO t_roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO t_roles (name) VALUES ('ROLE_USER');

INSERT INTO t_users (status, username, password)
VALUES ('Active', 'admin', '$2a$10$1VzzGG7IobXd5biSKU0Y5eo4wHIdCbyixKX6t0IHWP7ZYqG0BCm5m');

INSERT INTO t_users (status, username, password)
VALUES ('Active', 'user', '$2a$10$LkoGjxkSBVyl8Gb1xcLSTOLzyH89ibeKEw.SffOp4/RXc3ZOxk8C.');

INSERT INTO t_user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO t_user_roles (user_id, role_id) VALUES (2, 2);