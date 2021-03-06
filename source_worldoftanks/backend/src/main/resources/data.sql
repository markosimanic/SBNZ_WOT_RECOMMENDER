-- password hashed by BCrypt algorithm https://www.dailycred.com/article/bcrypt-calculator
-- password  123

INSERT INTO USER (id, username, password, balance, discount,recommendation_string,paidmoney,user_category, enabled) VALUES (1, 'user1','$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra',100000,false,'no_recommendation',90,'NA', true);
INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);

INSERT INTO CHARACTERISTICS (id, name) VALUES (1, 'LOW_DAMAGE');
INSERT INTO CHARACTERISTICS (id, name) VALUES (2, 'GREAT_DAMAGE');
INSERT INTO CHARACTERISTICS (id, name) VALUES (3, 'HIGH_PEN');
INSERT INTO CHARACTERISTICS (id, name) VALUES (4, 'LOW_PEN');
INSERT INTO CHARACTERISTICS (id, name) VALUES (5, 'SHORT_RELOAD');
INSERT INTO CHARACTERISTICS (id, name) VALUES (6, 'MEDIUM_RELOAD');
INSERT INTO CHARACTERISTICS (id, name) VALUES (7, 'LONG_RELOAD');
INSERT INTO CHARACTERISTICS (id, name) VALUES (8, 'SLOW_TANK');
INSERT INTO CHARACTERISTICS (id, name) VALUES (9, 'FAST_TANK');
INSERT INTO CHARACTERISTICS (id, name) VALUES (10, 'MANY_HP');
INSERT INTO CHARACTERISTICS (id, name) VALUES (11, 'LOW_HP');
INSERT INTO CHARACTERISTICS (id, name) VALUES (12, 'HUGE_ARMOR');
INSERT INTO CHARACTERISTICS (id, name) VALUES (13, 'LOW_ARMOR');
INSERT INTO CHARACTERISTICS (id, name) VALUES (14, 'GREAT_VIEW_RANGE');
INSERT INTO CHARACTERISTICS (id, name) VALUES (15, 'LOW_VIEW_RANGE');
INSERT INTO CHARACTERISTICS (id, name) VALUES (16, 'AUTOLOADER');
INSERT INTO CHARACTERISTICS (id, name) VALUES (17, 'WHEELED');
INSERT INTO CHARACTERISTICS (id, name) VALUES (18, 'DOUBLE_BARREL');
INSERT INTO CHARACTERISTICS (id, name) VALUES (19, 'CUPOLA');
INSERT INTO CHARACTERISTICS (id, name) VALUES (20, 'NO_CUPOLA');
INSERT INTO CHARACTERISTICS (id, name) VALUES (21, 'SMALL_SIZED_TANK');
INSERT INTO CHARACTERISTICS (id, name) VALUES (22, 'NORMAL_SIZED_TANK');
INSERT INTO CHARACTERISTICS (id, name) VALUES (23, 'HUGE_SIZED_TANK');
INSERT INTO CHARACTERISTICS (id, name) VALUES (24, 'MEDIUM_PEN');
INSERT INTO CHARACTERISTICS (id, name) VALUES (25, 'MEDIUM_DAMAGE');
INSERT INTO CHARACTERISTICS (id, name) VALUES (26, 'STRONG_FRONTAL_ARMOR');
INSERT INTO CHARACTERISTICS (id, name) VALUES (27, 'ANGLED_ARMOR');


--all tanks in system
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (1, 'Skropion G',4500,'PREMIUM' ,'DESTROYER');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (2, 'Progetto',4200,'PREMIUM','MEDIUM');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (3, 'MAUS',3500,'STANDARD','HEAVY');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (4, 'EBR 105',2200,'PREMIUM' ,'LIGHT');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (5, 'IS2-2',1200,'STANDARD','HEAVY');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (6, 'T26E5 SUPERPERSHING',4300,'PREMIUM','MEDIUM');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (7, 'ISU-152',4400,'STANDARD','DESTROYER');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (8, 'T-50-2',3700,'PREMIUM','LIGHT');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (9, '60TP',5200,'STANDARD','HEAVY');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (10, 'Rhm',1120,'STANDARD','DESTROYER');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (11, 'IS-3',1990,'STANDARD','HEAVY');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (12, 'Leopard 1',5940,'STANDARD','MEDIUM');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (13, 'OBJ252-u Defender',4600,'PREMIUM','HEAVY');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (14, 'E100',3300,'PREMIUM','DESTROYER');
INSERT INTO TANK (id, name, price,tank_status, tank_type) VALUES (15, 'Type 5 Heavy',4200,'STANDARD','HEAVY');

--characteristics of skorpion G
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 2);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 3);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 6);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 13);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 14);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (1, 21);

--characteristics of progetto
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 25);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 24);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 6);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 13);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 16);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (2, 22);


--characteristics for maus
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 25);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 24);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 15);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 8);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 10);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 12);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (3, 23);


--characteristics of ebr
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 17);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 25);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 24);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 16);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 7);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (4, 14);


--characteristics of IS2-2
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 2);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 3);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 7);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 18);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 8);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 22);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (5, 10);

--characteristics of T26E5 SUPERPERSHING
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 25);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 24);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 5);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 12);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 22);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (6, 26);

--characteristics of ISU-152
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 2);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 3);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 7);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 20);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 22);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 26);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (7, 8);

--characteristics of T-50-2
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 1);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 4);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 5);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 21);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 14);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (8, 11);


--characteristics of Rhm
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 2);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 2);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 8);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 13);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 11);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (10, 20);


--characteristics of OBJ252-u Defender
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 24);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 2);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 12);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 22);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 9);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 26);
INSERT INTO tank_characteristics (tank_id, characteristics_id) VALUES (13, 27);


-- tanks that user1 have
INSERT INTO USER_TANK(user_id,tank_id) VALUES (1,1);

--comment it to test discounting
--INSERT INTO USER_TANK(user_id,tank_id) VALUES (1,2);

INSERT INTO USER_TANK(user_id,tank_id) VALUES (1,3);


-- statistics of user 1
INSERT INTO PLAYER_STATISTICS(id,avg_damage,win_rate,gun_mark,user_tank_tank_id,user_tank_user_id) VALUES (1,2300,70,True,1,1);

--comment 2 rows below to test discounting
--INSERT INTO PLAYER_STATISTICS(id,avg_damage,win_rate,gun_mark,user_tank_tank_id,user_tank_user_id) VALUES (2,4300,100,True,2,1);
--INSERT INTO PLAYER_STATISTICS(id,avg_damage,win_rate,gun_mark,user_tank_tank_id,user_tank_user_id) VALUES (3,900,47,True,2,1);

INSERT INTO PLAYER_STATISTICS(id,avg_damage,win_rate,gun_mark,user_tank_tank_id,user_tank_user_id) VALUES (4,1250,51,True,3,1);