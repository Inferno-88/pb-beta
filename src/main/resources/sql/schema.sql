--Ranks
CREATE TABLE ranks (
  id   BIGINT NOT NULL,
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


--Ratings
CREATE TABLE ratings (
  id       BIGINT NOT NULL,
  positive BIGINT,
  negative BIGINT
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


--Fields
CREATE TABLE fields (
  id        BIGINT NOT NULL,
  name      CHARACTER VARYING(255),
  address   CHARACTER VARYING(255),
  capacity  BIGINT NOT NULL,
  rating_id BIGINT
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

ALTER TABLE ONLY fields
  ADD CONSTRAINT fields_to_ratings FOREIGN KEY (rating_id) REFERENCES ratings(id) ON DELETE RESTRICT;


--Teams
CREATE TABLE teams (
  id      BIGINT NOT NULL,
  name    CHARACTER VARYING(255),
  rank_id BIGINT
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

ALTER TABLE ONLY teams
  ADD CONSTRAINT teams_to_ranks FOREIGN KEY (rank_id) REFERENCES ranks(id) ON DELETE RESTRICT;


--Players
CREATE TABLE players (
  id      BIGINT NOT NULL,
  name    CHARACTER VARYING(255),
  rank_id BIGINT,
  team_id BIGINT
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

ALTER TABLE ONLY players
  ADD CONSTRAINT players_to_ranks FOREIGN KEY (rank_id) REFERENCES ranks(id) ON DELETE RESTRICT;

ALTER TABLE ONLY players
  ADD CONSTRAINT players_to_teams FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE RESTRICT;


--Events
CREATE TABLE events (
  id         BIGINT NOT NULL,
  name       CHARACTER VARYING(255),
  begin_date TIMESTAMP WITHOUT TIME ZONE,
  end_date   TIMESTAMP WITHOUT TIME ZONE,
  field_id   BIGINT NOT NULL
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

ALTER TABLE ONLY events
  ADD CONSTRAINT events_to_fields FOREIGN KEY (field_id) REFERENCES fields(id) ON DELETE RESTRICT;


--Photos
CREATE TABLE photos (
  id         BIGINT NOT NULL,
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
  player_id BIGINT,
  photo_id BIGINT
);

ALTER TABLE ONLY player_photos
  ADD CONSTRAINT player_photos_to_players FOREIGN KEY (player_id) REFERENCES players(id) ON DELETE RESTRICT;

ALTER TABLE ONLY player_photos
  ADD CONSTRAINT player_photos_to_photos FOREIGN KEY (photo_id) REFERENCES photos(id) ON DELETE RESTRICT;


--Team_Photos
CREATE TABLE team_photos (
  team_id BIGINT,
  photo_id BIGINT
);

ALTER TABLE ONLY team_photos
  ADD CONSTRAINT team_photos_to_teams FOREIGN KEY (team_id) REFERENCES teams(id) ON DELETE RESTRICT;

ALTER TABLE ONLY team_photos
  ADD CONSTRAINT team_photos_to_photos FOREIGN KEY (photo_id) REFERENCES photos(id) ON DELETE RESTRICT;


--Field_Photos
CREATE TABLE field_photos (
  field_id BIGINT,
  photo_id BIGINT
);

ALTER TABLE ONLY field_photos
  ADD CONSTRAINT field_photos_to_fields FOREIGN KEY (field_id) REFERENCES fields(id) ON DELETE RESTRICT;

ALTER TABLE ONLY field_photos
  ADD CONSTRAINT field_photos_to_photos FOREIGN KEY (photo_id) REFERENCES photos(id) ON DELETE RESTRICT;


--Event_Photos
CREATE TABLE event_photos (
  event_id BIGINT,
  photo_id BIGINT
);

ALTER TABLE ONLY event_photos
  ADD CONSTRAINT event_photos_to_events FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE RESTRICT;

ALTER TABLE ONLY event_photos
  ADD CONSTRAINT event_photos_to_photos FOREIGN KEY (photo_id) REFERENCES photos(id) ON DELETE RESTRICT;




