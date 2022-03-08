create Table Pokemon (
pokemon_id int primary key,
common_name varchar(200) not null,
level int(100) not null default 0,
type varchar(200) not null,
stock int(100) not null,
purchased int(100) not null,
price int(100) not null,
image_file_name varchar(200)
);