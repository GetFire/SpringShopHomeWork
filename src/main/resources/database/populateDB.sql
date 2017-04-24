INSERT INTO security.products (name,manufacturer,price,description)
    VALUES
      ('Galaxy s8','Samsung.co','600','Amazing smartphone'),
      ('Asus x555lb','AsusCO','420','Monitor'),
      ('Iphone 7','Apple','850','The best brend of all smartphones');


INSERT INTO users (login, password) VALUES ('GetFire', '$2a$11$bA7RhT/zY.x1VmRNRF1NWeavmtoQdP5QH87KDlj2pu2EB96DpPYrq');

INSERT INTO roles (name)
VALUES
  ('USER'), ('ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);
