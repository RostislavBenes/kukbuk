DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS meal_image;


CREATE TABLE category (
  id BIGINT IDENTITY PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(2000),
  createdTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recipe (
  id BIGINT IDENTITY PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  procedure VARCHAR(5000) NOT NULL,
  comment VARCHAR(5000),
  serving_count SMALLINT,
  preparation_time BIGINT,
  difficulty SMALLINT,
  rating SMALLINT,
  category_id BIGINT NOT NULL,
  createdTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_recipe_category_id FOREIGN KEY(category_id) REFERENCES category(id)
);

CREATE TABLE ingredient (
  id BIGINT IDENTITY PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  quantity VARCHAR(255) NOT NULL,
  recipe_id BIGINT NOT NULL ,
  createdTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT fk_ingredient_recipe_id FOREIGN KEY(recipe_id) REFERENCES recipe(id)
);

CREATE TABLE meal_image (
  id BIGINT IDENTITY PRIMARY KEY,
  description VARCHAR(1000),
  width BIGINT NOT NULL,
  height BIGINT NOT NULL,
  image BINARY NOT NULL,
  recipe_id BIGINT NOT NULL ,
  CONSTRAINT fk_meal_image_recipe_id FOREIGN KEY(recipe_id) REFERENCES recipe(id)
)

