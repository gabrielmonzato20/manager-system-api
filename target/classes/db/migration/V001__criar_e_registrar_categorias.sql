CREATE TABLE category(
    id int  Primary key AUTO_INCREMENT ,
    namecli varchar(80) NOT NULL
)Engine=innoDB DEFAULT CHARSET=utf8;

INSERT INTO category (namecli ) VALUES ('Lazer');
INSERT INTO category (namecli ) VALUES ('Alimentação');
INSERT INTO category (namecli ) VALUES ('Farmacia');
INSERT INTO category (namecli ) VALUES ('Mercado');
INSERT INTO category (namecli ) VALUES ('Outros');
