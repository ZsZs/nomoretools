CREATE TABLE discipline (
	id bigint NOT NULL,
	name varchar(100),
	description varchar(500),
	created timestamp,
	PRIMARY KEY (id)
);

INSERT INTO discipline VALUES (0, 'Requirements', '', now() );
INSERT INTO discipline VALUES (1, 'Analysis & Design', '', now() );
INSERT INTO discipline VALUES (2, 'Implementation',  '', now() );
INSERT INTO discipline VALUES (3, 'Test',  '', now() );
INSERT INTO discipline VALUES (4, 'Delivery',  '', now() );
INSERT INTO discipline VALUES (5, 'Project Management',  '', now() );
INSERT INTO discipline VALUES (6, 'Operation & Support',  '', now() );
