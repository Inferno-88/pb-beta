--Players
CREATE TABLE players (
  id      INTEGER NOT NULL,
  name    CHARACTER VARYING(255),
  rank_id INTEGER,
  team_id INTEGER
);

CREATE SEQUENCE players_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE players_id_seq OWNED BY players.id;
ALTER TABLE ONLY players
  ALTER COLUMN id SET DEFAULT nextval('players_id_seq' :: REGCLASS);

ALTER TABLE ONLY players
  ADD CONSTRAINT players_pkey PRIMARY KEY (id);

--Fields
CREATE TABLE fields (
  id        INTEGER NOT NULL,
  name      CHARACTER VARYING(255),
  address   CHARACTER VARYING(255),
  capacity  INTEGER NOT NULL,
  rating_id INTEGER
);

CREATE SEQUENCE fields_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE fields_id_seq OWNED BY fields.id;
ALTER TABLE ONLY fields
  ALTER COLUMN id SET DEFAULT nextval('fields_id_seq' :: REGCLASS);

ALTER TABLE ONLY fields
  ADD CONSTRAINT fields_pkey PRIMARY KEY (id);

--Events
CREATE TABLE events (
  id         INTEGER NOT NULL,
  name       CHARACTER VARYING(255),
  begin_date TIMESTAMP WITHOUT TIME ZONE,
  end_date   TIMESTAMP WITHOUT TIME ZONE,
  field_id   INTEGER NOT NULL
);

CREATE SEQUENCE events_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE events_id_seq OWNED BY events.id;
ALTER TABLE ONLY events
  ALTER COLUMN id SET DEFAULT nextval('events_id_seq' :: REGCLASS);

ALTER TABLE ONLY events
  ADD CONSTRAINT events_pkey PRIMARY KEY (id);

--Teams
CREATE TABLE teams (
  id      INTEGER NOT NULL,
  name    CHARACTER VARYING(255),
  rank_id INTEGER
);

CREATE SEQUENCE teams_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE teams_id_seq OWNED BY teams.id;
ALTER TABLE ONLY teams
  ALTER COLUMN id SET DEFAULT nextval('teams_id_seq' :: REGCLASS);

ALTER TABLE ONLY teams
  ADD CONSTRAINT teams_pkey PRIMARY KEY (id);

--Ranks
CREATE TABLE ranks (
  id   INTEGER NOT NULL,
  name CHARACTER VARYING(255)
);

CREATE SEQUENCE ranks_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE ranks_id_seq OWNED BY ranks.id;
ALTER TABLE ONLY ranks
  ALTER COLUMN id SET DEFAULT nextval('ranks_id_seq' :: REGCLASS);

ALTER TABLE ONLY ranks
  ADD CONSTRAINT ranks_pkey PRIMARY KEY (id);

--Ranks
CREATE TABLE ratings (
  id       INTEGER NOT NULL,
  positive INTEGER,
  negative INTEGER
);

CREATE SEQUENCE ratings_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE ratings_id_seq OWNED BY ratings.id;
ALTER TABLE ONLY ratings
  ALTER COLUMN id SET DEFAULT nextval('ratings_id_seq' :: REGCLASS);

ALTER TABLE ONLY ratings
  ADD CONSTRAINT ratings_pkey PRIMARY KEY (id);

--Photos
CREATE TABLE photos (
  id         INTEGER NOT NULL,
  path       CHARACTER VARYING(255),
  photo_type CHARACTER VARYING(255)
);

CREATE SEQUENCE photos_id_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE
CACHE 1;

ALTER SEQUENCE photos_id_seq OWNED BY ratings.id;
ALTER TABLE ONLY photos
  ALTER COLUMN id SET DEFAULT nextval('photos_id_seq' :: REGCLASS);

ALTER TABLE ONLY photos
  ADD CONSTRAINT photos_pkey PRIMARY KEY (id);


--Player_Photos
CREATE TABLE player_photos (
  player_id INTEGER,
  photo_id INTEGER
);

--Team_Photos
CREATE TABLE team_photos (
  team_id INTEGER,
  photo_id INTEGER
);

--Field_Photos
CREATE TABLE field_photos (
  field_id INTEGER,
  photo_id INTEGER
);

--Event_Photos
CREATE TABLE event_photos (
  event_id INTEGER,
  photo_id INTEGER
);




