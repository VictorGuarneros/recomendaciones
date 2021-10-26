INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('978-3-16-148410-0', 'Frank Kafka', 1915, 'La metamorfosis', 'https://www.aglutinaeditores.com/media/resources/public/9d/9de5/9de51ef2c13340898b79f6dc6d157de0.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9782814510005', 'H.P. Lovecraft', 1928, 'La llamada de Cthulhu', 'https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1547543765i/43569517._UY1000_SS1000_.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9783453435773', 'Stephen King', 1986, 'It', 'https://images-na.ssl-images-amazon.com/images/I/71NaD6ZH4ZL.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9783957130839', 'Gabriel Garcia Marquez', 1982, 'Cien años de soledad', 'https://images-na.ssl-images-amazon.com/images/I/71YoFJSz3LL.jpg', 'Español', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9780792733591', 'Orson Scott Card', 1985, 'El juego de Ender', 'https://images-na.ssl-images-amazon.com/images/I/91fqbLUmU0L.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9780553545272', 'Philip K. Dick', 1968, '¿Sueñan los androides con ovejas eléctricas?', 'https://m.media-amazon.com/images/I/51k2u762ZGL.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9780060575915', 'Neil Gaiman', 2002, 'Coraline', 'https://images-na.ssl-images-amazon.com/images/I/71QIjs87Q5L.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9780907310105', 'Carlos Fuentes', 1962, 'Aura', 'https://images-na.ssl-images-amazon.com/images/I/91omNHYaPIL.jpg', 'Español', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9780312420277', 'Mario Vargas Llosa', 2000, 'La fiesta del Chivo', 'https://quelibroleo.com/images/libros/libro-1542795206.png', 'Español', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9780606340182', 'Daniel Keyes', 1959, 'Flores para Algernon', 'https://images-na.ssl-images-amazon.com/images/I/81B6Y6KbbLL.jpg', 'Ingles', 'Epub');
INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('9783499106354', 'Vladimir Nabokov', 1955, 'Lolita', 'https://imagenes.elpais.com/resizer/2EwoAmwrxZRHORfxitUdBBxskGA=/1960x0/arc-anglerfish-eu-central-1-prod-prisa.s3.amazonaws.com/public/45BCOBSNMS2D2QJEGRYNH7AA5M.jpg', 'Ingles', 'Epub');

INSERT INTO genero(genero) VALUES ('novela');
INSERT INTO genero(genero) VALUES ('terror');
INSERT INTO genero(genero) VALUES ('ficción');

INSERT INTO libro_genero(id_libro, id_genero) VALUES(1, 1);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(1, 2);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(2, 2);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(3, 2);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(4, 1);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(5, 3);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(6, 3);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(7, 2);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(8, 1);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(9, 1);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(10, 1);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(11, 1);

INSERT INTO usuario(correo, edad, nombre, password, role, enabled)
VALUES ('admin@gmail.com', 25, 'Victor Guarneros', '$2a$12$yxm5UiGOfcKCMNqef/ks1e/PIy2JSex8evS1BLCrQQY.WsCg3HJti', 'ADMINISTRATOR', 1);

INSERT INTO usuario(correo, edad, nombre, password, role, enabled)
VALUES ('client@gmail.com', 25, 'Hugo Santana', '$2a$12$yxm5UiGOfcKCMNqef/ks1e/PIy2JSex8evS1BLCrQQY.WsCg3HJti', 'CLIENT', 1);

INSERT INTO usuario_genero(id_usuario, id_genero) VALUES(1, 1);
INSERT INTO usuario_genero(id_usuario, id_genero) VALUES(1, 2);
INSERT INTO usuario_genero(id_usuario, id_genero) VALUES(1, 3);

--INSERT INTO calificacion(puntuacion, id_usuario, id_libro) VALUES(10, 1, 3);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(1, 1, 9);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(2, 1, 9);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(3, 1, 10);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(4, 1, 9);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(5, 1, 8);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(6, 1, 7);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(7, 1, 8);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(8, 1, 6);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(9, 1, 9);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(10, 1, 10);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(11, 1, 9);

INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(1, 2, 9);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(3, 2, 10);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(5, 2, 8);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(7, 2, 8);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(9, 2, 9);
INSERT INTO calificacion(id_libro, id_usuario, puntuacion) VALUES(11, 2, 9);