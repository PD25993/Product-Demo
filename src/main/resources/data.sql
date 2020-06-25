-- INSERT INTO product_category (id, category_name) VALUES(1,'ELECTRONICS');
-- INSERT INTO product_category (id, category_name) VALUES(2,'Clothing');

-- INSERT INTO PRODUCTS (id, product_code, product_name, product_price,categoryid) VALUES(1,  'P01', 'Mobile', 20000.50, 1);
-- INSERT INTO PRODUCTS (id, product_code, product_name, product_price, categoryid) VALUES(2,  'P02', 'EarPhone', 1000.00, 1);
-- INSERT INTO PRODUCTS (id, product_code, product_name, product_price, categoryid) VALUES(3,'P03','Skirt', 4000.50, 2);
-- INSERT INTO PRODUCTS (id, product_code, product_name, product_price, categoryid) VALUES(4,'P04','Dress', 5000, 2);

-- 
insert into users (id, user_name, password, roles, active) values (1,'poulami','pass','ROLE_ADMIN,ROLE_USER',true);
insert into users (id, user_name, password, roles, active) values (2,'mou','123456','ROLE_ADMIN',true);
insert into users (id, user_name, password, roles, active) values (3,'parth','123456','ROLE_USER',true);

-- INSERT INTO Category (category_id, category_name) VALUES(1,'ELECTRONICS');
-- INSERT INTO Category (category_id, category_name) VALUES(2,'Clothing');