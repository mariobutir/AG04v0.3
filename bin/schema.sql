DROP SCHEMA IF EXISTS articles;

CREATE SCHEMA articles;
USE articles;

CREATE TABLE Article (
	id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    vrijemeUnosa DATE,
    idKorisnika BIGINT,
    naslov VARCHAR(255),
    url VARCHAR(255),
    autor VARCHAR(255),
    brojGlasova INT
);
