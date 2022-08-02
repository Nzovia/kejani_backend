CREATE TABLE bills_data
(
    bill_id       BIGINT       NOT NULL,
    logo          VARCHAR(255) NULL,
    payment_date  date         NULL,
    bill_balance  INT          NOT NULL,
    bill_amount   INT          NOT NULL,
    bill_status   INT          NULL,
    bill_priority INT          NULL,
    user_identity BIGINT       NOT NULL,
    CONSTRAINT pk_bills_data PRIMARY KEY (bill_id)
);

ALTER TABLE bills_data
    ADD CONSTRAINT FK_BILLS_DATA_ON_USERIDENTITY FOREIGN KEY (user_identity) REFERENCES user_data (user_id);