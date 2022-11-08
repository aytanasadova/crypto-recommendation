DROP TABLE CRYPTO_DATA IF EXISTS;

--CREATE TABLE CRYPTO_DATA  (
--  timestamp VARCHAR(100),
--  symbol VARCHAR(100),
--  price VARCHAR(100)
--);

CREATE TABLE CRYPTO_DATA  (
--  ID int GENERATED ALWAYS AS IDENTITY PRIMARY KEY
    id int,
  timestamp timestamp,
  symbol VARCHAR(10),
  price NUMERIC(10, 2)
) ;

