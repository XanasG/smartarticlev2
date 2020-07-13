/* Initial Migration
 * 06/07/2020
 */

CREATE TABLE ARTICLE (
    ID VARCHAR(36) PRIMARY KEY,
    RELEASE_DATE DATE NOT NULL,
    SOURCE_ID VARCHAR(36) NOT NULL,
    CONTENT_ID VARCHAR(36) NOT NULL,
    NEWS_TAG VARCHAR(14) NOT NULL,
    AUTHOR_ID VARCHAR(36) NULL,
    LANGUAGE VARCHAR(6) NOT NULL,
    DATE_CREATED DATE NOT NULL

    /* Constraints */
);

CREATE TABLE CONTENT (
    ID VARCHAR(36) PRIMARY KEY,
    ARTICLE_ID VARCHAR(36) NOT NULL,
    HEADER VARCHAR(100) NOT NULL,
    INTRODUCTORY VARCHAR(150) NOT NULL,
    CONTENT TEXT NOT NULL,

    /* Constraints */
    CONSTRAINT CONST_FK_ARTICLE_ID FOREIGN KEY FK_ARTICLE_ID (ARTICLE_ID) REFERENCES ARTICLE(ID) ON DELETE CASCADE
);

CREATE TABLE IMAGE (
    ID VARCHAR(36) PRIMARY KEY,
    TITLE VARCHAR(50) NOT NULL,
    IMAGE BLOB NOT NULL
);

CREATE TABLE IMAGE_CONTENT_RELATION (
    ID VARCHAR(36) PRIMARY KEY,
    CONTENT_ID VARCHAR(36) NOT NULL,
    IMAGE_ID VARCHAR(36) NOT NULL,

    /* Constraints */
    CONSTRAINT CONST_FK_CONTENT_ID FOREIGN KEY FK_CONTENT_ID (CONTENT_ID) REFERENCES CONTENT(ID) ON DELETE CASCADE
);

CREATE TABLE SOURCE (
    ID VARCHAR(36) PRIMARY KEY,
    NAME VARCHAR(20) NOT NULL,
    LANGAUGE VARCHAR(6) NOT NULL,
    COUNTRY VARCHAR(30) NULL,
    STATUS VARCHAR(16) NOT NULL
);

CREATE TABLE SOURCE_TAG (
    ID VARCHAR(36) PRIMARY KEY,
    TAG VARCHAR(20) NOT NULL
);

CREATE TABLE SOURCE_TAG_RELATION (
    ID VARCHAR(36) PRIMARY KEY,
    SOURCE_ID VARCHAR(36) NOT NULL,
    SOURCE_TAG_ID VARCHAR(36) NOT NULL,

    /* Constraints */
    CONSTRAINT CONST_FK_SOURCE_ID FOREIGN KEY FK_SOURCE_ID (SOURCE_ID) REFERENCES SOURCE(ID),
    CONSTRAINT CONST_FK_SOURCE_TAG_ID FOREIGN KEY FK_SOURCE_TAG_ID (SOURCE_TAG_ID) REFERENCES SOURCE_TAG(ID)
);