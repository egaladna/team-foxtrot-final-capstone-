BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO item_type (type) VALUES ('FULLBODY'), ('TOP'), ('BOTTOM'), ('FOOTWEAR'), ('ACCESSORIES'), ('OUTERWEAR');
INSERT INTO item_color (color) VALUES ('BLACK'), ('BLUE'), ('BROWN'), ('GREEN'), ('ORANGE'), ('PINK'), ('PURPLE'), ('RED'), ('WHITE'), ('YELLOW'), ('PATTERN'), ('OTHER');


INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006589/mjlqousdljfwcbezvpo7.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006605/iak1u6gigmxkjf5gfzft.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006619/zw0rhfkmpcsrghagwbtu.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006636/g0hh1rauzrdrsnoaaxhy.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006670/xyesc9fetbdn8vhph5at.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('TOP', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006687/lom2awzq5zj59gzotubx.jpg', 1);

INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006696/jhjzihmqltpbhhg1tyax.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006706/aehqsohcabrmdoeddk81.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006719/wsng03im6liwiamlwncy.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006728/fhztyq9ia1clmhf2mj9v.jpg', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('BOTTOM', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006737/qg5urou3ojsay5jenw5y.jpg', 1);

INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006942/eslakxqlfetxhlpa6otx.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006977/wxx7pzcqyubcm8pubyhk.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682006987/p0bjx5ohsuvy7win3rsg.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('FOOTWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007002/wfzoqisbqq8ay8ewioja.png', 1);

INSERT INTO clothes (type, img_url, user_id) VALUES ('ACCESSORIES', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007016/dr6euz6wfghohfngwxje.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('ACCESSORIES', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007027/zrgiqitemhjmli1fwayk.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('ACCESSORIES', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007039/k8bcsudo5dimtll5vktt.png', 1);

INSERT INTO clothes (type, img_url, user_id) VALUES ('OUTERWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007055/trsxkihxirmritefm7gr.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('OUTERWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007069/escr9cznm3co7mga6ga3.png', 1);
INSERT INTO clothes (type, img_url, user_id) VALUES ('OUTERWEAR', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007092/gf8agkgshtzaiosltdsz.png', 1);

INSERT INTO clothes (type, img_url, user_id) VALUES ('FULLBODY', 'https://res.cloudinary.com/dlnxljpbd/image/upload/v1682007106/xvyym1ou8ixkbnraiuhd.png', 1);



INSERT INTO categories (category_name) VALUES ('BUSINESS'), ('PARTY'), ('FITNESS'), ('CASUAL'), ('LOUNGE'), ('FORMAL');



COMMIT TRANSACTION;
