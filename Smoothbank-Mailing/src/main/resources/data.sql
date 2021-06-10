DROP TABLE IF EXISTS token;


CREATE TABLE holder (
    sequence VARCHAR(32) PRIMARY KEY,
    objId VARCHAR(127),
    ttl INT,
    timeCreated DATETIME
);
