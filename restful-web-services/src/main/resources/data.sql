insert into user_details(id, name, birth_date)
values
    (1001, 'Doge', current_date),
    (1002, 'Thor', current_date),
    (1003, 'Sparrow', current_date),
    (1004, 'Eagle', current_date);

insert into post(id, description, user_id)
values
    (2001, 'Doge to the Moon', 1001),
    (2002, 'Lomki ka bhai', 1002),
    (2003, 'Storm Beaker', 1002),
    (2004, 'Bamdal ke upar udta hu mai Hui hui ', 1004),
    (2005, 'Ninja Doge', 1001);