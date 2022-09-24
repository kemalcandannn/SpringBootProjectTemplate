CREATE DATABASE template
    WITH 
    OWNER = postgres
	TEMPLATE = 'template0'
    ENCODING = 'UTF8'
    LC_COLLATE = 'tr_TR.UTF8'
    LC_CTYPE = 'tr_TR.UTF8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA system;

-- AFTER RUN PROJECT ------------------------------------
-- INSERT INTO system.user (id, admin, birthday, name, password, username) VALUES(-1, true, CURRENT_TIMESTAMP, 'Admin', 'admin', 'admin');
-- INSERT INTO system.role (id, name) VALUES(-1, 'System Administration');
-- INSERT INTO system.user_role (id, user_id, role_id) VALUES(nextVal('hibernate_sequence'), -1, -1);
------------------------------------------------------- LAST -------------------------------------------------------	
