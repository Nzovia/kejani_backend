CREATE TABLE user_data
(
    user_id       BIGINT       NOT NULL,
    user_name     VARCHAR(255) NULL,
    user_email    VARCHAR(200) NULL,
    user_phone    VARCHAR(100) NULL,
    user_password VARCHAR(255) NULL,
    CONSTRAINT pk_userdata PRIMARY KEY (user_id)
);

ALTER TABLE user_data
    ADD CONSTRAINT uc_userdata_user_email UNIQUE (user_email);

ALTER TABLE user_data
    ADD CONSTRAINT uc_userdata_user_phone UNIQUE (user_phone);