BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO item_type (type) VALUES ('TOP'), ('BOTTOM'), ('FULL BODY'), ('FOOTWEAR'), ('ACCESSORIES'), ('OUTERWEAR');

INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://www.rei.com/media/e1319c3d-74dc-41ba-99ce-d78ba319e9f8.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://images.express.com/is/image/expressfashion/0092_09192214_2919_f001?cache=on&wid=361&fmt=jpeg&qlt=75,1&resmode=sharp2&op_usm=1,1,5,0&defaultImage=Photo-Coming-Soon', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FULL BODY', 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61kmUxj0PFL._UX569_.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6Fa0oBMWIUf2G_qSWW7tetQf8WHnMgWQhww&usqp=CAU', 1);

INSERT INTO outfits (user_id) VALUES (1) RETURNING outfit_id;
INSERT INTO clothes_outfits (outfit_id, item_id) VALUES (4001, 2001);
INSERT INTO clothes_outfits (outfit_id, item_id) VALUES (4001, 2002);
INSERT INTO clothes_outfits (outfit_id, item_id) VALUES (4001, 2004);

INSERT INTO categories (category_name) VALUES ('BUSINESS'), ('PARTY'), ('FITNESS'), ('CASUAL'), ('LOUNGE'), ('FORMAL');


COMMIT TRANSACTION;
