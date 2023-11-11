SELECT setval('income_info_id_seq', (SELECT MAX(id)+1 FROM income_info));
SELECT setval('users_id_seq', (SELECT MAX(id)+1 FROM users));