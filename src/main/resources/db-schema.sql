--TABLES

---BOOKS
CREATE TABLE IF NOT EXISTS books (
  id int primary key auto_increment,
  title varchar(20)
);

---CURRENCY
CREATE TABLE IF NOT EXISTS currency (
  id int primary key auto_increment,
  name varchar(30),
  symbol varchar(5)
);

---EXCHANGE_RATE
CREATE TABLE IF NOT EXISTS exchange_rate (
  crncy_from int,
  crncy_to int,
  value numeric(5,2) not null,

  foreign key (crncy_from) references currency(id),
  foreign key (crncy_to) references currency(id),
  primary key (crncy_from,crncy_to)
);
