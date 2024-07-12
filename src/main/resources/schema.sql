-- will be adopted by embedded H2 database by default, but can be set in application.properties to used by other databases
DROP TABLE IF EXISTS Run;
CREATE TABLE IF NOT EXISTS Run (
   id INT NOT NULL,
   title varchar(250) NOT NULL,
   started_on timestamp NOT NULL,
   completed_on timestamp NOT NULL,
   miles INT NOT NULL,
   location varchar(10) NOT NULL,
   PRIMARY KEY (id)
);