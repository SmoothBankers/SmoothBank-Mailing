DROP TABLE IF EXISTS token;


CREATE TABLE token (
    sequence VARCHAR(32) PRIMARY KEY,
    objId VARCHAR(127),
    ttl INT,
    timeCreated DATETIME
);
