drop table article;
create table article (
	id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    vrijemeUnosa DATE,
    idKorisnika BIGINT,
    naslov VARCHAR(255),
    url VARCHAR(255),
    brojGlasova BIGINT,
    autor VARCHAR(255)
    
);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/12/2017', 'DD/MM/YYYY'),00001,'What is spring?','/what-is-spring','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('20/11/2015', 'DD/MM/YYYY'),00001,'Java8','/java8','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/11/2017', 'DD/MM/YYYY'),00001,'Hibernate','/hibernate','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/2/2017', 'DD/MM/YYYY'),00001,'Thymeleaf','/thymeleaf','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/12/2017', 'DD/MM/YYYY'),00001,'Groovy','/groovy','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/12/2017', 'DD/MM/YYYY'),00001,'C guide','/c-guide','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/12/2017', 'DD/MM/YYYY'),00001,'Eclipse or Idea?','/eclipse-or-idea','user',0);

insert into article (vrijemeUnosa,idKorisnika,naslov,url,autor,brojGlasova)
values(TO_DATE('17/12/2017', 'DD/MM/YYYY'),00001,'Javascript','/javacsript','user',0);