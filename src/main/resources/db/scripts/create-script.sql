DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS meal_image;


CREATE TABLE category (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE,
  description VARCHAR(2000),
  parent_category_id INTEGER,
  createdTime DATETIME DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_category_parent_category_id FOREIGN KEY(parent_category_id) REFERENCES category(id)
);

CREATE TABLE recipe (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(255) NOT NULL,
  procedure VARCHAR(5000) NOT NULL,
  comment VARCHAR(5000),
  serving_count INT,
  preparation_time BIGINT,
  difficulty INT,
  rating INT,
  category_id INTEGER NOT NULL,
  createdTime DATETIME DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_recipe_category_id FOREIGN KEY(category_id) REFERENCES category(id)
);

CREATE TABLE ingredient (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR(255) NOT NULL,
  quantity VARCHAR(255) NOT NULL,
  recipe_id INTEGER NOT NULL ,
  createdTime DATETIME DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_ingredient_recipe_id FOREIGN KEY(recipe_id) REFERENCES recipe(id)
);

CREATE TABLE meal_image (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  description VARCHAR(1000),
  width INT NOT NULL,
  height INT NOT NULL,
  image BINARY NOT NULL,
  recipe_id INTEGER NOT NULL,
  createdTime DATETIME DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_meal_image_recipe_id FOREIGN KEY(recipe_id) REFERENCES recipe(id)
);

insert into category (name, description) values ('Categories','Root category, hidden for the user');

--just for development, remove!
insert into category (name, description,parent_category_id) values ('Chicken','food from chicken',1);
insert into category (name, description,parent_category_id) values ('Pork','food from portk',1);