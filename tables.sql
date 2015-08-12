
CREATE TABLE department
(
	id serial NOT NULL,
	department_name text,
	CONSTRAINT department_pkey PRIMARY KEY (id)
);


CREATE TABLE user_detail
(
	id serial NOT NULL,
	username text,
	date_added timestamp without time zone,
	age integer,
	department_id integer,
	CONSTRAINT user_detail_pkey PRIMARY KEY (id),
	CONSTRAINT "departFK" FOREIGN KEY (department_id)
		REFERENCES department (id) MATCH SIMPLE
		ON UPDATE NO ACTION ON DELETE NO ACTION
  );



