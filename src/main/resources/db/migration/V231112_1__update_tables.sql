INSERT INTO public.users (id, phone, password, name, latitude, longitude, role)
VALUES
    (1, '777777777', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'Uzbechka', 43.225683, 76.942217, 'SERVICE'),
    (2, '789789798', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two1', 43.232432, 76.949049, 'SERVICE'),
    (3, '498486486', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two2', 43.240134, 76.928852, 'SERVICE'),
    (4, '464531131', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two3', 43.249758, 76.891297, 'SERVICE'),
    (5, '289391429', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two4', 43.256109, 76.872729, 'SERVICE'),
    (6, '687461313', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two5', 43.290965, 76.956170, 'SERVICE'),
    (7, '956156135', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two6', 43.319898, 77.044370, 'SERVICE'),
    (8, '944351451', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'User Two7', 45.384189, 75.835312, 'SERVICE'),
    (9, '7754351960', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'Onlinebank', 43.226916, 76.943856, 'SERVICE'),
    (10, '7471445192', '$2a$10$wpWMBDFR.huoBjB4pVkfwe2hzzvNJQYt78Gq8pZ4LYxGVpXfznWeq', 'Halyk Market', 0.0, 0.0, 'SALE');

INSERT INTO public.income_info (avg_transaction_price, marketing_spending_total, other_spending_total, resource_spending_total, revenue_total, salary_spending_total, spending_total, users_id)
VALUES
    (1340, 203434, 102342, 123213, 603243, 90099, 502330, 1),
    (9060, 988890, 177548, 981989, 244486, 5228, 198096, 2),
    (3189, 571607, 461134, 301792, 379354, 56996, 323824, 3),
    (164, 244775, 753241, 854700, 954540, 99821, 32227, 4),
    (257, 654726, 775801, 791764, 373427, 17375, 544182, 5),
    (2939, 819211, 274696, 14010, 694376, 98362, 609592, 6),
    (1006, 26110, 407663, 302475, 215729, 89635, 997364, 7),
    (3508, 839532, 124236, 480617, 52649, 58081, 683965, 8),
    (9421, 49085, 979322, 54424, 683024, 25477, 296685, 9);

SELECT setval('income_info_id_seq', (SELECT MAX(id)+1 FROM income_info));
SELECT setval('users_id_seq', (SELECT MAX(id)+1 FROM users));