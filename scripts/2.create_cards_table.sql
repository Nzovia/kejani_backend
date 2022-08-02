CREATE TABLE user_cards
(
    id          INT          NOT NULL,
    card_type   VARCHAR(255) NULL,
    card_number BIGINT       NULL,
    card_expiry date         NULL,
    card_cvv    VARCHAR(255) NULL,
    holder_name VARCHAR(255) NULL,
    user_id     BIGINT       NULL,
    CONSTRAINT pk_user_cards PRIMARY KEY (id)
);

ALTER TABLE user_cards
    ADD CONSTRAINT uc_user_cards_card_number UNIQUE (card_number);

ALTER TABLE user_cards
    ADD CONSTRAINT FK_USER_CARDS_ON_USER FOREIGN KEY (user_id) REFERENCES user_data (user_id);