--Create db
\connect simpleblogdb;

CREATE TABLE IF NOT EXISTS role(
    id UUID PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    active INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS "user"(
    id UUID PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    role_id UUID NOT NULL,
    active INTEGER NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS post(
    id UUID PRIMARY KEY,
    content VARCHAR(15) NOT NULL,
    user_id UUID NOT NULL,
    active INTEGER NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES "user"(id)
);

CREATE TABLE IF NOT EXISTS comment(
    id UUID PRIMARY KEY,
    content VARCHAR(15) NOT NULL,
    user_id UUID NOT NULL,
    post_id UUID NOT NULL,
    active INTEGER NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES "user"(id),
    CONSTRAINT fk_post FOREIGN KEY(post_id) REFERENCES post(id)
);

CREATE TABLE IF NOT EXISTS role_permission(
    id UUID PRIMARY KEY,
    role_id UUID NOT NULL,
    permission INTEGER NOT NULL,
    permission_level INTEGER NOT NULL,
    active INTEGER NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES role(id)
);


