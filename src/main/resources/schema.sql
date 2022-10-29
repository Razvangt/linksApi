CREATE TABLE IF NOT EXISTS LINK (
    id uuid,
    name VARCHAR(50),
    url VARCHAR(200),
    PRIMARY KEY (link_id)
);

CREATE TABLE IF NOT EXISTS WORKSPACE (
    id uuid,
    name VARCHAR(50),
    url VARCHAR(200),
    PRIMARY KEY (link_id)
);