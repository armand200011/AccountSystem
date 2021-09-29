CREATE SCHEMA ARMAND;

CREATE SEQUENCE ARMAND.ACCOUNT_TYPE_GENERIC_SEQ START WITH 5002 INCREMENT 1;
CREATE SEQUENCE ARMAND.ACCOUNT_TRANS_GENERIC_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE ARMAND.MEMBER_GENERIC_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE ARMAND.ACCOUNT_TYPE(
ACCOUNT_TYPE_ID BIGINT NOT NULL,
ACCOUNT_TYPE_CODE VARCHAR(100),
ACCOUNT_TYPE_NAME VARCHAR(100),
ACCOUNT_TYPE_DATE_CREATED DATE not null,
PRIMARY KEY (ACCOUNT_TYPE_ID)
);

CREATE TABLE ARMAND.ACCOUNT_MEMBER(
MEMBER_ID BIGINT NOT NULL,
MEMBER_FULLNAME VARCHAR(30) UNIQUE,
BALANCE NUMBER(15,2),
PRIMARY KEY (MEMBER_ID)
);
