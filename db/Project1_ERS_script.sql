--CREATE TABLE ----------------------------------------------
-- create table for ers roles (manager, employee)
CREATE TABLE ers_user_roles (
	user_role_id serial PRIMARY KEY,
	user_role text
);

-- table for ers users
CREATE TABLE ers_users(
	ers_user_id serial PRIMARY KEY,
	ers_username TEXT UNIQUE,
	ers_password TEXT,
	user_role_fk int REFERENCES ers_user_roles(user_role_id)
);

-- table for ers reimbursement
CREATE TABLE ers_reimbursement(
	reimbursement_id serial PRIMARY KEY,
	reimbursement_amount int,
	reimbursement_desc TEXT,
	reimbursement_type_fk int REFERENCES ers_reimbursement_type(reimbursement_type_id),
	reimbursement_status_fk int REFERENCES ers_reimbursement_status(reimbursement_status_id),
	reimbursement_user_fk int REFERENCES ers_users(ers_user_id)
);


-- table for ers status (accept, deny, pending)
CREATE TABLE ers_reimbursement_status(
	reimbursement_status_id serial PRIMARY KEY,
	reimbursement_status TEXT 
);

-- table for ers type (travel, lodging, food, etc)
CREATE TABLE ers_reimbursement_type(
	reimbursement_type_id serial PRIMARY KEY,
	reimbursement_type TEXT 
);


--|END CREATE TABLE|--------------------------------------------
--|DROP TABLE|--------------------------------------------------
DROP TABLE ers_reimbursement;
--|SELECT QUERY|------------------------------------------------
SELECT * FROM ers_users;
SELECT * FROM ers_user_roles;
SELECT * FROM ers_reimbursement;
SELECT * FROM ers_reimbursement_type;
SELECT * FROM ers_reimbursement_status;

SELECT * FROM ers_users WHERE user_role_fk = 2;

--|INSERT into TABLE|-------------------------------------------
INSERT INTO ers_reimbursement (reimbursement_amount, reimbursement_desc, reimbursement_type_fk, reimbursement_status_fk, reimbursement_user_fk)
VALUES (200, 'microsoft certification', 2, 1, 1), (50, 'gas', 1, 3, 2);

INSERT INTO ers_reimbursement_type (reimbursement_type)
VALUES ('travel'), ('certification'), ('lodging');

INSERT INTO ers_reimbursement_status(reimbursement_status)
VALUES ('accept'), ('deny'), ('pending');

INSERT INTO ers_user_roles(user_role)
VALUES ('manager'), ('employee');

INSERT INTO ers_users (ers_username, ers_password, user_role_fk)
VALUES ('fancyf33t', 'p1password', 1), ('charlesInCharge', 'password', 2);

INSERT INTO ers_users (ers_username, ers_password, user_role_fk)
VALUES ('revStudent', 'revature', 2);


--|ALTER to set a default|------------------------------------
ALTER TABLE ers_reimbursement_status
ALTER COLUMN reimbursement_status 
SET DEFAULT 'pending';


/*Points OF improvement
EACH ers_reimbursement_status INPUT should be SET TO "pending"
*/