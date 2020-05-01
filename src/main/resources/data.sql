insert into cuisine (cuisine_id, name) values ( 1, 'Rodizio' );
insert into cuisine (cuisine_id, name) values ( 2, 'Sushi' );
insert into cuisine (cuisine_id, name) values ( 3, 'Tapas');

insert into restaurant (name, cuisine_id) values ('Brazil, Brazil!',1);
insert into restaurant (name, cuisine_id) values ('Fuki Sushi',2);
insert into restaurant (name, cuisine_id) values ('La Tasca',3);
insert into restaurant (name, cuisine_id) values ('Flame',1);
insert into restaurant (name, cuisine_id) values ('Blowfish',2);
insert into restaurant (name, cuisine_id) values ('Plaza de Toros',3);
insert into restaurant (name, cuisine_id) values ('Favela',1);
insert into restaurant (name, cuisine_id) values ('Churrascaria',1);
insert into restaurant (name, cuisine_id) values ('Rio',1);
insert into restaurant (name, cuisine_id) values ('Impanema',1);
insert into restaurant (name, cuisine_id) values ('Vaqueiro',1);
insert into restaurant (name, cuisine_id) values ('Brazilian Heat',1);


insert into review (review_text, rating, restaurant_id)
    values('Meat! Need I say more?', 5, 1);
insert into review (review_text, rating, restaurant_id)
    values('Are you serious? I am vegan!', 1, 4);
insert into review (review_text, rating, restaurant_id)
    values('Fresh, authentic and creative. The Blowfish is to die for!', 5, 5);
insert into review (review_text, rating, restaurant_id)
    values('Not bad but nothing outstanding either.', 3, 6);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 4);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 7);
insert into review (review_text, rating, restaurant_id) values('A review', 4, 8);
insert into review (review_text, rating, restaurant_id) values('A review', 5, 9);
insert into review (review_text, rating, restaurant_id) values('A review', 2, 10);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 11);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 12);
insert into review (review_text, rating, restaurant_id) values('A review', 5, 7);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 8);
insert into review (review_text, rating, restaurant_id) values('A review', 1, 9);
insert into review (review_text, rating, restaurant_id) values('A review', 2, 10);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 11);
insert into review (review_text, rating, restaurant_id) values('A review', 3, 12);