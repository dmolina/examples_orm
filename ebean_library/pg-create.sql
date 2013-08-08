create table author (
  id                        integer not null,
  name                      varchar(255) not null,
  direction                 varchar(255),
  genero                    varchar(255) not null,
  age                       integer,
  constraint pk_author primary key (id))
;

create table book (
  id                        integer not null,
  title                     varchar(255) not null,
  date                      date,
  constraint pk_book primary key (id))
;

create table category (
  description               varchar(255),
  recommended_age           integer)
;

create sequence author_seq;

create sequence book_seq;



