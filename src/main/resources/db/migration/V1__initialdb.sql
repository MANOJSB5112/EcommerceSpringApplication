CREATE TABLE category
(
    id              BIGINT NOT NULL,
    last_created_at datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NULL,
    name            VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE ms_instructor
(
    id          BIGINT NOT NULL,
    username    VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    avg_rating DOUBLE NULL,
    company     VARCHAR(255) NULL,
    fav_student VARCHAR(255) NULL,
    CONSTRAINT pk_ms_instructor PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id          BIGINT NOT NULL,
    username    VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    company     VARCHAR(255) NULL,
    fav_student VARCHAR(255) NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE product
(
    id              BIGINT NOT NULL,
    last_created_at datetime NULL,
    last_updated_at datetime NULL,
    is_deleted      BIT(1) NULL,
    title           VARCHAR(255) NULL,
    price DOUBLE NULL,
    `description`   VARCHAR(255) NULL,
    image           VARCHAR(255) NULL,
    category_id     BIGINT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE tpc_instructor
(
    id          BIGINT NOT NULL,
    username    VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    avg_rating DOUBLE NULL,
    company     VARCHAR(255) NULL,
    fav_student VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_instructor PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id          BIGINT NOT NULL,
    username    VARCHAR(255) NULL,
    password    VARCHAR(255) NULL,
    company     VARCHAR(255) NULL,
    fav_student VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id       BIGINT NOT NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);