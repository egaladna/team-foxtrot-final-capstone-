BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO item_type (type) VALUES ('FULL BODY'), ('TOP'), ('BOTTOM'), ('FOOTWEAR'), ('ACCESSORIES'), ('OUTERWEAR');

INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://www.rei.com/media/e1319c3d-74dc-41ba-99ce-d78ba319e9f8.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://images.express.com/is/image/expressfashion/0092_09192214_2919_f001?cache=on&wid=361&fmt=jpeg&qlt=75,1&resmode=sharp2&op_usm=1,1,5,0&defaultImage=Photo-Coming-Soon', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FULL BODY', 'https://m.media-amazon.com/images/W/IMAGERENDERING_521856-T1/images/I/61kmUxj0PFL._UX569_.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6Fa0oBMWIUf2G_qSWW7tetQf8WHnMgWQhww&usqp=CAU', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://oldnavy.gap.com/webcontent/0028/604/318/cn28604318.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://image.s5a.com/is/image/saks/0400011459582_FILMNOIR?wid=984&hei=1312&qlt=90&resMode=sharp2&op_usm=0.9,1.0,8,0', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('OUTERWEAR', 'https://calvinklein.scene7.com/is/image/CalvinKlein/14606232_010_main?wid=1459&hei=1922&fmt=pjpeg&qlt=85%2C0&resMode=sharp2&op_usm=0.9%2C1.0%2C8%2C0&iccEmbed=0', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://cdn.shopify.com/s/files/1/0277/9027/products/2021_06_02_WF-0016-BLK_Left_15707_b431caf1-3537-49fb-9778-d340b7ec29a6_2048x2048_crop_center.jpg?v=1667503744', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FULL BODY', 'https://img.ltwebstatic.com/images3_pi/2022/03/25/16481756316cfd98a171b5c2dc558a890092d7815a_thumbnail_900x.webp', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://img.ltwebstatic.com/images3_pi/2021/08/04/162807432750b234398e1fb79074240a778d65d3e6_thumbnail_405x552.webp', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://img.ltwebstatic.com/images3_pi/2021/09/13/16315208494d735f4c7dd06c1348d7e573f5a9c47d_thumbnail_900x.webp', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://img.ltwebstatic.com/images3_pi/2022/08/22/166115452625db78eff5c1d0b01bdd7d7283d7da71_thumbnail_900x.webp', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://img.ltwebstatic.com/images3_pi/2022/09/20/16636443353471d011eb2d777b465d2fee88a04fe9_thumbnail_900x.webp', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('OUTERWEAR', 'https://img.ltwebstatic.com/images3_pi/2020/12/07/160732220760729c827f2720210041d689de0582ac_thumbnail_405x552.webp', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('OUTERWEAR', 'https://img.ltwebstatic.com/images3_pi/2021/11/11/1636595671dddb386658501085f6323ee1407577d3_thumbnail_405x552.webp', 1);


INSERT INTO categories (category_name) VALUES ('BUSINESS'), ('PARTY'), ('FITNESS'), ('CASUAL'), ('LOUNGE'), ('FORMAL');



COMMIT TRANSACTION;
