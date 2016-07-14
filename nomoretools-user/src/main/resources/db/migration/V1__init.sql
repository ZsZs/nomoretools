CREATE TABLE user (
	id bigint NOT NULL,
	name varchar(100),
	password varchar(50),
	created timestamp,
	PRIMARY KEY (id)
);

INSERT INTO user VALUES (0, 'admin', 'admin', now() );
