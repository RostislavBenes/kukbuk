-- noinspection SqlNoDataSourceInspectionForFile
DROP TABLE IF EXISTS category;

CREATE TABLE category (
  id         BIGINT IDENTITY PRIMARY KEY ,
  name VARCHAR(30),
  createdTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE recipe (
  id         BIGINT IDENTITY PRIMARY KEY ,
  name VARCHAR(30),
  category_id BIGINT,
  FOREIGN KEY(category_id) REFERENCES category(id)
);