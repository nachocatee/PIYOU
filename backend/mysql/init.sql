CREATE DATABASE IF NOT EXISTS piyou;

create table piyou
(
    piyou_id bigint auto_increment
        primary key,
    degree   int          null,
    eng_name varchar(255) null,
    name     varchar(20)  not null,
    constraint UK_baxnm0e8jgse3nw33w2578v2b
        unique (name)
);

INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (1, 1, 'brave', '용감한피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (2, 1, 'orange', '오렌지피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (3, 1, 'overcooked', '누룽지피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (4, 3, 'fairy', '요정피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (5, 1, 'nut', '밤톨피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (6, 1, 'chick', '병아리피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (7, 2, 'ink', '수묵피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (8, 1, 'baked', '탄피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (9, 2, 'banana', '바나나피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (10, 1, 'tanned', '태닝피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (11, 1, 'soft', '솜털피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (12, 3, 'stripe', '줄무늬피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (13, 1, 'bluegreen', '청록피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (14, 2, 'tropical', '트로피칼피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (15, 2, 'mint', '민트피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (16, 2, 'sea', '바다피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (17, 3, 'redvelvet', '레드벨벳피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (18, 2, 'cottoncandy', '솜사탕피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (19, 1, 'mustang', '무스탕피유');
INSERT INTO piyou.piyou (piyou_id, degree, eng_name, name) VALUES (20, 1, 'greentea', '그린티피유');

