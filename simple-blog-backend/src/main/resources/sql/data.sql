--Create db
\connect simpleblogdb;

CREATE TABLE IF NOT EXISTS role(
    id UUID PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS "user"(
    id UUID PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    role_id UUID NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS post(
    id UUID PRIMARY KEY,
    content VARCHAR(15) NOT NULL,
    user_id UUID NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES "user"(id)
);

CREATE TABLE IF NOT EXISTS comment(
    id UUID PRIMARY KEY,
    content VARCHAR(15) NOT NULL,
    user_id UUID NOT NULL,
    post_id UUID NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES "user"(id),
    CONSTRAINT fk_post FOREIGN KEY(post_id) REFERENCES post(id)
);

CREATE TABLE IF NOT EXISTS role_permission(
    id UUID PRIMARY KEY,
    role_id UUID NOT NULL,
    permission INTEGER NOT NULL,
    permission_level INTEGER NOT NULL,
    active BOOLEAN NOT NULL,
    CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES role(id)
);
INSERT INTO role (id,name,active)
VALUES
('cc0b5db8-3568-4a34-885a-e8ec7f837a94', 'Editor', true),
('c7841a80-552d-4b9d-8d42-37a2fa3774b4', 'Viewer', true),
('ff796aa3-169d-4f87-8ba9-ba22bbfbd83b', 'Anonymous', true);

INSERT INTO "user" (id,name,role_id,active)
VALUES
('62128dcb-ab76-4949-9166-2184a9e0e4f7','Default Editor','cc0b5db8-3568-4a34-885a-e8ec7f837a94',true),
('c490ea48-65ae-4932-8468-d2682935da21','Default Viewer','c7841a80-552d-4b9d-8d42-37a2fa3774b4',true),
('bd3833e3-e1f7-4881-a943-18f056cd89d3','Default Anon','ff796aa3-169d-4f87-8ba9-ba22bbfbd83b',true);

INSERT INTO role_permission(id, role_id, permission, permission_level,active)
VALUES
('6ddb27e1-13d5-4539-82b6-2a97062704ab','cc0b5db8-3568-4a34-885a-e8ec7f837a94',1,4,true),
('192fefaa-16e1-4c4f-9f15-b530cf47da7b','cc0b5db8-3568-4a34-885a-e8ec7f837a94',2,4,true),
('d9053fb2-b665-4658-80fb-95b374011f15','cc0b5db8-3568-4a34-885a-e8ec7f837a94',3,4,true),
('198f64d5-430a-4fc3-88a6-9b758a4f3acf','c7841a80-552d-4b9d-8d42-37a2fa3774b4',1,1,true),
('28a50e1c-46ea-47bb-8a37-dd75f43880ec','c7841a80-552d-4b9d-8d42-37a2fa3774b4',2,2,true),
('5fe1700a-226d-4484-9a24-9ac1042cfef7','c7841a80-552d-4b9d-8d42-37a2fa3774b4',3,3,true),
('090abb4d-b815-4501-a6c5-10917c1ac7be','ff796aa3-169d-4f87-8ba9-ba22bbfbd83b',1,1,true),
('4ef9fa6a-12d7-42bf-bdbf-663e6b827e2f','ff796aa3-169d-4f87-8ba9-ba22bbfbd83b',2,2,true),
('584e745d-0d7a-41c1-9163-d87629c89043','ff796aa3-169d-4f87-8ba9-ba22bbfbd83b',3,2,true);
