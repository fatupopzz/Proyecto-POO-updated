-- Insertar usuarios de prueba
INSERT INTO usuarios (nombre, email, contrasena) VALUES
('Juan Pérez', 'juan@example.com', 'contrasena123'),
('María García', 'maria@example.com', 'password456'),
('Carlos López', 'carlos@example.com', 'securepass789');

-- Insertar restaurantes de prueba
INSERT INTO restaurantes (nombre, direccion, tipo_comida) VALUES
('La Pizzería', 'Calle 1-23, Zona 10', 'Italiana'),
('Burger House', 'Avenida 4-56, Zona 4', 'Comida Rápida'),
('Sushi Express', 'Boulevard 7-89, Zona 14', 'Japonesa'),
('Tacos Locos', 'Calle 10-12, Zona 1', 'Mexicana'),
('Café del Arte', 'Avenida 15-78, Zona 13', 'Cafetería');

-- Insertar algunas calificaciones de prueba
INSERT INTO calificaciones (usuario_id, restaurante_id, puntuacion, comentario) VALUES
(1, 1, 4, 'Excelente pizza, pero el servicio puede mejorar'),
(2, 1, 5, 'La mejor pizza que he probado en la ciudad'),
(3, 2, 3, 'Hamburguesas decentes, pero un poco caras'),
(1, 3, 5, 'Sushi fresco y delicioso, altamente recomendado'),
(2, 4, 4, 'Tacos auténticos y sabrosos');

-- Agregar algunos restaurantes favoritos
INSERT INTO restaurantes_favoritos (usuario_id, restaurante_id) VALUES
(1, 1),
(1, 3),
(2, 4),
(3, 2);
