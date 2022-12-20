-- create table for ers roles
CREATE TABLE ers_user_roles (
	user_role_id serial PRIMARY KEY,
	user_role text
);

-- create table for ers users
CREATE TABLE ers_users(
	ers_username TEXT UNIQUE,
	ers_password TEXT,
	first_name TEXT,
	last_name TEXT,
	user_role_fk int REFERENCES ers_user_roles(user_role_id)
);

-- create table for ers reimbursement
CREATE TABLE ers_reimbursement(
	reimbursement_amount int,
	reimbursement_desc TEXT,
	reimbursement_fk int REFERENCES ers_reimbursement_type(reimbursement_type_id)
);
-- create table for ers reimbursement type
CREATE TABLE ers_reimbursement_type(
	reimbursement_type_id serial PRIMARY KEY,
	reimbursement_type TEXT 
	
);
-- create table for ers reimbursement status
CREATE TABLE ers_reimbursement_status(
	reimbursement_status_id serial PRIMARY KEY,
	reimbursement_status boolean NOT NULL,
	reimbursement_status_fk int REFERENCES ers_reimbursement_type(reimbursement_type_id)
);

--SELCET QUERY---------------------------------------------------



-- if change necessary, ALTER TABLE BELOW
ALTER --name here

-- if all else fails, DROP TABLE BELOW 
DROP TABLE -- name here