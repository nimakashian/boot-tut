DROP TABLE IF EXISTS todo;
CREATE TABLE todo
(
  id varchar(36) not null primary key,
  description varchar(255) not null,
  created varchar(255) not null,
  modified varchar(255) not null,
  completed varchar(255) not null
);
