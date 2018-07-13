CREATE TABLE Article (
	id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    vrijemeUnosa TIMESTAMP,
    korisnik VARCHAR(255) NOT NULL,
    naslov VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    brojglasova INTEGER
);

CREATE TABLE UserVote (
	korisnik VARCHAR(255),
	articleid BIGINT,
	up VARCHAR(255),
	down VARCHAR(255)
);
	
