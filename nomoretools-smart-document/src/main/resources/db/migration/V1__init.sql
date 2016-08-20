CREATE TABLE smart_document (
	id bigint NOT NULL,
	name varchar(100),
	description varchar(500),
	created timestamp,
	content varchar(5000),
	PRIMARY KEY (id)
);

INSERT INTO smart_document VALUES (0, 'Requirements', 'Description comes here...', now(), '<p>Content comes here...</p>' );
INSERT INTO smart_document VALUES (1, 'Analysis & Design', 'Description comes here...', now(), '<p>Content comes here...</p>' );
INSERT INTO smart_document VALUES (2, 'Implementation',  'Description comes here...', now(), '<p>Content comes here...</p>' );
INSERT INTO smart_document VALUES (3, 'Test',  'Description comes here...', now(), '<p>Content comes here...</p>' );
INSERT INTO smart_document VALUES (4, 'Delivery',  'Description comes here...', now(), '<p>Content comes here...</p>' );
INSERT INTO smart_document VALUES (5, 'Project Management',  'Description comes here...', now(), '<p>Content comes here...</p>' );
INSERT INTO smart_document VALUES (6, 'Operation & Support',  'Description comes here...', now(), '<p>Content comes here...</p>' );
