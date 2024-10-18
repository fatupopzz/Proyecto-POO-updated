-- Configuración de la base de datos
SET GLOBAL time_zone = '+00:00';
SET GLOBAL max_connections = 100;
SET GLOBAL max_allowed_packet = 16777216;

-- Crear usuario para la aplicación
CREATE USER 'app_user'@'localhost' IDENTIFIED BY 'app_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON restaurantes_uvg.* TO 'app_user'@'localhost';
FLUSH PRIVILEGES;

-- Optimizaciones
ALTER TABLE usuarios ADD INDEX idx_email (email);
ALTER TABLE calificaciones ADD INDEX idx_restaurante_fecha (restaurante_id, fecha);