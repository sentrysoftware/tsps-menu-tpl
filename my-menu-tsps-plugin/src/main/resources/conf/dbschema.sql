
-- -- Table to store properties
-- CREATE TABLE mymenu (key VARCHAR(256), value VARCHAR(512));
--
-- -- Stores overridden (by customer) properties (see ServerProperties)
-- CREATE TABLE mymenu_configuration (key VARCHAR(256), value VARCHAR(512));
--
-- CREATE TABLE mymenu_userpreference
-- (
-- PREFERENCEID BIGSERIAL PRIMARY KEY,
-- TENANT_NAME       VARCHAR(256)    NOT NULL,
-- USER_NAME       VARCHAR(256)    NOT NULL,
-- PREFERENCE      TEXT,
-- PAGE_ID         VARCHAR(1024)   DEFAULT '-1' NOT NULL  ,
-- FORMAT          VARCHAR(32)     DEFAULT 'keyvalue',
-- TYPE            VARCHAR(32)     DEFAULT '-1' NOT NULL,
-- UNIQUE (TENANT_NAME,USER_NAME,PAGE_ID,TYPE)
-- );
