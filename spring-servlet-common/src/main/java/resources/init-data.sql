INSERT INTO t_product (name, cost, order_id) VALUES ('Product 1', 10.0, 1);
INSERT INTO t_product (name, cost, order_id) VALUES ('Product 2', 20.0, 1);
INSERT INTO t_order (data, cost) VALUES ('2022-03-05', 30.0);

INSERT INTO users (id, status, password, username) VALUES (1, 'ACTIVE', '$2a$12$BXeONFjoaZQfI7WH/1L0JOmrJ5oV2Q2zcVIBrLh1K3ABZG73Z9nZ6', 'admin');
INSERT INTO users (id, status, password, username) VALUES (2, 'ACTIVE', '$2a$12$BXeONFjoaZQfI7WH/1L0JOmrJ5oV2Q2zcVIBrLh1K3ABZG73Z9nZ6', 'user');

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);