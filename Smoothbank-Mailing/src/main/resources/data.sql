DROP TABLE IF EXISTS token;


CREATE TABLE token (
    sequence VARCHAR(32) PRIMARY KEY,
    obj_id VARCHAR(127),
    ttl INT,
    timeCreated DATETIME
);
