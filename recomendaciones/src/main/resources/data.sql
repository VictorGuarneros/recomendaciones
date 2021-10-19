INSERT INTO libro (isbn, autor, anio_publicacion, titulo, imagen_url, idioma, formato) VALUES ('978-3-16-148410-0', 'Frank Kafka', 1915, 'La metamorfosis', '#', 'Ingles', 'Epub');

INSERT INTO genero(genero) VALUES ('novela');
INSERT INTO genero(genero) VALUES ('terror');

INSERT INTO libro_genero(id_libro, id_genero) VALUES(1, 1);
INSERT INTO libro_genero(id_libro, id_genero) VALUES(1, 2);

INSERT INTO usuario(correo, edad, nombre, password, role)
VALUES ('admin@gmail.com', 25, 'Victor Guarneros', '$2a$12$m6FEylOZEBLuxeH5i1pt9.R72LrjIAI1rDb6qRF1rxOQXQbm2IU76', 'ADMINISTRATOR');


INSERT INTO usuario_genero(id_usuario, id_genero) VALUES(1, 1);
INSERT INTO usuario_genero(id_usuario, id_genero) VALUES(1, 2);

INSERT INTO usuario_libro(id_libro, id_usuario, puntuacion) VALUES(1, 1, 9);