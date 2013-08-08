Examples_orm
============

Same example (an library data) using different Java ORMs to compare them. 

The example has the following tables: 

- *book* Table with a list of books. 

- *author* author of the books. 

- *publish* table that relates the books with the author (a book can have several authors and an author can publish  
  several books. 

- *category* table with the available categories for the books. 

- *suggestion* table that relates the books with their categories. 


Testing
-------

All implementations use the same tests (in junit). For doing that, an interfaz (interfazBD) has been defined. All examples
have to implements a class that implements that interfaces. 

Aim of this project
-------------------
To test different ORMs to select the more adequated to students in programming courses.

Compared ORMs
=============

- *[MyBatis](http://mybatis.github.io/mybatis-3/)* This is the more flexible ORM, useful to allow students to design their own database. 

- *[EBean](http://www.avaje.org/)* This is a simple ORM using JPA. 
  > *Good* It is very simple to uses and configurate. 
  > *Average* Manual documentation, sometimes examples too simple.
  > *Bad* Error messages not very informative. 

Conclusions
-----------

ORM | Flexible | DDL  | Configuration | Popular | JPA | Documentation | Error messages
--- | --- | --- | --- | --- | --- | --- | ---
 MyBatis |  Most  | No | Average | Yes | No | Excelent | Very good
EBean | Medium | Yes | Simple | No | Yes | Good (Manual) | Bad
Hibernate | Medium  | Yes | Complex (Spring) | Yes | Yes | Good | Average
