INSERT INTO Currency (name, country)
                   VALUES
                       ('US Dollar', 'United States'),
                       ('Euro', 'European Union'),
                       ('British Pound', 'United Kingdom'),
                       ('Japanese Yen', 'Japan'),
                       ('Canadian Dollar', 'Canada'),
                       ('Australian Dollar', 'Australia');

INSERT INTO Rate (Rate.rate_value, id_currency)
VALUES
    (1.0000, 1),
    (0.8602, 2),
    (0.7593, 3),
    (154.4930, 4),
    (1.4020, 5),
    (1.5400, 6),
    (1.345, 6);

SELECT * from Currency;
SELECT * from Rate;