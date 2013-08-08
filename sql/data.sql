delete from publish;
delete from author;
delete from book;

-- Autores
insert into author (id,name,edad,tlfno_contacto,genero) values
            (1,'Naomi Klein', 45, '906666666', 'F');
insert into author (id,name,edad,tlfno_contacto,genero) values
            (2,'Patrick Rothfuss', 42, '906696969', 'M');
-- Libros
insert into book (id,title,pages) 
values(1,'No Logo', 544);
insert into book (id,title,pages) 
values(2,'El nombre del viento', 880);

insert into publish (book,author) values(1, 1);
insert into publish (book, author) values(2, 2);

-- Añadimos categoria
insert into category(id,description,recommended_age)
    values(4,'Terror', 13),(1,'Fantasia', 8), (3,'Erotica', 18), (2,'Fantasia', 14), (5,'Ensayo', 16);

insert into suggestion(book, category)
    values(2, 2);

insert into suggestion(book, category)
    values(1, 5);

insert into suggestion(book, category)
    values(2, 1);

SELECT setval('', 42);   
