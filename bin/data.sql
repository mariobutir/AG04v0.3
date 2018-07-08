drop table article;
create table article (
	id BIGINT,
    vrijemeUnosa DATETIME,
    idKorisnika BIGINT,
    naslov VARCHAR(255),
    url VARCHAR(255),
    autor VARCHAR(255),
);

insert into article (idKorisnika,naslov,url,autor)
values(00001,'What is spring?','/what-is-spring','user');

insert into article (idKorisnika,naslov,url,autor)
values(00001,'Java8','/java8','user');