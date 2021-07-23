insert into Libro(isbn, autor, anioPublicacion, titulo, imagenUrl , idioma, formato)
values('978-3-16-148410-0', 'Frank Kafka', 1915, 'La metamorfosis', '#', 'Ingles', 'Epub');
insert into Libro(isbn, autor, anioPublicacion, titulo, imagenUrl , idioma, formato)
values('978-3-16-148410-1', 'Yuval Noah Harari', 2016, 'Homo Deus', '#', 'Ingles', 'Epub');
insert into Libro(isbn, autor, anioPublicacion, titulo, imagenUrl , idioma, formato)
values('978-3-16-148410-2', 'Dante Alighieri', 1472, 'La divina comedia', '#', 'Ingles', 'Epub');
insert into Genero(genero,libros)
values('novela',);
insert into Genero(genero,libros)
values('ensayo',);
insert into Genero(genero,libros)
values('poema',);
insert into Usuario(nombre, correo, edad, password, generos , role, enabled)
values ('ADMINISTRATOR', 'KAFKA', 'ESCOM', '1996-01-30', 'MALE',
'admin@gmail.com', '$2y$12$zsnqNBPA32JmW5m6MocMT.R0Kl5wCAOKJR.0QGsnAvHFp1edLVu5K', '55 6677 8899', 'ADMINISTRATOR', 1);