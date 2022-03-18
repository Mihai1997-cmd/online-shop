INSERT INTO users (username, password, email) VALUES ('apopescu', 'pass', 'a.popescu@companyname.com');
INSERT INTO users (username, password, email) VALUES ('vtudoran', 'pass', 'victor.tudoran@companyname.com');

--TRUNCATE TABLE table_name RESTART IDENTITY;

CREATE TABLE  warehouse(
    ID BIGSERIAL,
    name text,
    parentId BIGSERIAL,
    PRIMARY KEY (ID),
    FOREIGN KEY (parentId) REFERENCES warehouse (ID)
);

INSERT INTO warehouse (name) VALUES ('default warehouse');
INSERT INTO warehouse (name,parentid) VALUES ('warehouse 1',1);
INSERT INTO warehouse (name,parentid) VALUES ('warehouse 2',1);
INSERT INTO warehouse (name,parentid) VALUES ('cell 11',2);
INSERT INTO warehouse (name,parentid) VALUES ('cell 12',2);
INSERT INTO warehouse (name,parentid) VALUES ('cell 21',3);
INSERT INTO warehouse (name,parentid) VALUES ('cell 22',3);
INSERT INTO warehouse (name,parentid) VALUES ('cell 111',4);
INSERT INTO warehouse (name,parentid) VALUES ('cell 211',6);


INSERT INTO BrandAuto (name) Values('Opel');
INSERT INTO BrandAuto (name) Values('Ford');

INSERT INTO ModelAuto (IdBrand,name) Values(1,'Opel Zafira');
INSERT INTO ModelAuto (IdBrand,name) Values(1,'Opel Astra');
INSERT INTO ModelAuto (IdBrand,name) Values(1,'Opel Corsa');
INSERT INTO ModelAuto (IdBrand,name) Values(2,'Ford Fiesta');
INSERT INTO ModelAuto (IdBrand,name) Values(2,'Ford Focus');

sudo su postgres
psql -d marketdb

INSERT INTO items (IdModelAuto,name,description,pret,imageURL,cantitate) Values (1,'Anvelope ZAFIRA PRIMACY 4','Tehnologiile Evergrip permit menținerea unor performanțe excelente pentru frânare pe carosabil umed','365 lei','assets/imagesMarket/anvelopeZafira1.jpeg','6');
INSERT INTO items (IdModelAuto,name,description,pret,imageURL,cantitate) Values (1,'Nuca Schimbator Viteze Astra','6 trepte','180 lei','assets/imagesMarket/astraSchimbator.jpeg','4');
INSERT INTO items (IdModelAuto,name,description,pret,imageURL,cantitate) Values (1,'Airbag volan Opel Astra G - Zafira A','','250 lei','assets/imagesMarket/volan.jpeg','2');

INSERT INTO items (IdModelAuto,name,description,pret,imageURL,cantitate) Values (1,'Anvelope ZAFIRA PRIMACY 4','Tehnologiile Evergrip permit menținerea unor performanțe excelente pentru frânare pe carosabil umed',365,'assets/imagesMarket/anvelopeZafira1.jpeg',6);
INSERT INTO items (IdModelAuto,name,description,pret,imageURL,cantitate) Values (1,'Nuca Schimbator Viteze Astra','6 trepte',180 ,'assets/imagesMarket/astraSchimbator.jpeg',4);
INSERT INTO items (IdModelAuto,name,description,pret,imageURL,cantitate) Values (1,'Airbag volan Opel Astra G - Zafira A','',250 ,'assets/imagesMarket/volan.jpeg',2);