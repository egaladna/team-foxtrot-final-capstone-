BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://www.rei.com/media/e1319c3d-74dc-41ba-99ce-d78ba319e9f8.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://images.express.com/is/image/expressfashion/0092_09192214_2919_f001?cache=on&wid=361&fmt=jpeg&qlt=75,1&resmode=sharp2&op_usm=1,1,5,0&defaultImage=Photo-Coming-Soon', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FULL BODY', 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61kmUxj0PFL._UX569_.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6Fa0oBMWIUf2G_qSWW7tetQf8WHnMgWQhww&usqp=CAU', 1);

INSERT INTO categories (category_name) VALUES ('BUSINESS'), ('PARTY'), ('FITNESS'), ('CASUAL'), ('LOUNGE'), ('FORMAL');

COMMIT TRANSACTION;
