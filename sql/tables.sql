drop table suggestion;
drop table category;
drop table publish;
drop table book;
drop table author;

create table author(
    id serial primary key,
    edad smallint check(edad >= 18),
    genero char(1) not null check(genero = 'M' or genero = 'F'),
    name varchar(30) not null,
    direction varchar(100),
    tlfno_contacto varchar(30) not null
);
create table book(
    id serial primary key,
    title varchar(20) not null unique,
    published date not null default current_date,
    pages smallint not null check(pages > 0)
);
create table publish(
        id serial primary key,
        book serial references book,
        author serial references author
);
create table category(
    id serial primary key,
    description varchar(300) not null,
    recommended_age smallint not null check(recommended_age >= 0 
	and recommended_age <= 18),
    unique(description, recommended_age)
);

create table suggestion(
    id serial primary key,
    book serial references book,
    category serial references category,
    unique(book, category)
);

drop table bookv2;

create table bookv2(
    id serial primary key,
    title varchar(20) not null unique,
    pages smallint not null check(pages > 0),
    category serial not null references category
);
