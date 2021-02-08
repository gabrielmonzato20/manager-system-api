CREATE TABLE person(
id int primary key AUTO_INCREMENT,
namep varchar(40),
logradouro varchar(50),
housenumber varchar(20),
complement varchar(20),
neiberhood varchar(30),
zipcode varchar(15),
city varchar(50),
statey varchar(30),
aticve BOOLEAN NOT NULL
)Engine=innoDB DEFAULT CHARSET= utf8;

    INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('João Silva', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-12', 'Uberlândia', 'MG', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Maria Rita', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-12', 'Ribeirão Preto', 'SP', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Pedro Santos', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-12', 'Goiânia', 'GO', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Ricardo Pereira', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Josué Mariano', 'Av Rio Branco', '321', null, 'Jardins', '56.400-12', 'Natal', 'RN', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Pedro Barbosa', 'Av Brasil', '100', null, 'Tubalina', '77.400-12', 'Porto Alegre', 'RS', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Henrique Medeiros', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Carlos Santana', 'Rua da Manga', '433', null, 'Centro', '31.400-12', 'Belo Horizonte', 'MG', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Leonardo Oliveira', 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG', true);
 INSERT INTO person(namep,logradouro,housenumber,complement,neiberhood,zipcode,city,statey,aticve)
  values ('Isabela Martins', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM', true);