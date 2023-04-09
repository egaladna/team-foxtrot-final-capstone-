BEGIN TRANSACTION;

DROP TABLE IF EXISTS  clothes_outfits, outfits,clothes_categories, clothes, users, categories;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_item_id 
INCREMENT by 1 
START WITH 2001 
NO MAXVALUE;

CREATE TABLE clothes (
	item_id int DEFAULT nextval('seq_item_id') NOT NULL,
	type varchar(50) NOT NULL,
	img_url varchar(500) NOT NULL,
	user_id int,
	CONSTRAINT PK_clothes PRIMARY KEY (item_id),
	CONSTRAINT FK_clothes_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT chk_clothes_type CHECK (type in ('TOP','BOTTOM', 'ACCESSORIES', 'FOOTWEAR', 'FULL BODY', 'OUTERWEAR'))
	
);

CREATE TABLE categories (
	category_id SERIAL PRIMARY KEY,
	category_name varchar(50)
);

CREATE TABLE clothes_categories (
	item_id int,
	category_id int,
	CONSTRAINT PK_clothes_categories PRIMARY KEY(item_id,category_id),
	CONSTRAINT FK_clothes_categories_item_id FOREIGN KEY (item_id) REFERENCES clothes(item_id),
	CONSTRAINT FK_clothes_categories_category_id FOREIGN KEY (category_id) REFERENCES categories(category_id)
	);
	
CREATE SEQUENCE seq_outfit_id 
INCREMENT by 1 
START WITH 4001 
NO MAXVALUE;

CREATE TABLE outfits (
	outfit_id int PRIMARY KEY DEFAULT nextval('seq_outfit_id') NOT NULL,
	user_id int,
	CONSTRAINT FK_outfits_user_id FOREIGN KEY(user_id) REFERENCES users(user_id)
);

CREATE TABLE clothes_outfits (
	outfit_id int,
	item_id int,
	CONSTRAINT PK_clothes_outfits PRIMARY KEY(outfit_id, item_id),
	CONSTRAINT FK_clothes_outfits_outfit_id FOREIGN KEY (outfit_id) REFERENCES outfits(outfit_id),
	CONSTRAINT FK_clothes_outfits_item_id FOREIGN KEY (item_id) REFERENCES clothes(item_id)
);

COMMIT TRANSACTION;
