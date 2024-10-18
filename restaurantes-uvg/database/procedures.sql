DELIMITER //

-- Procedimiento para calcular y actualizar la calificación promedio de un restaurante
CREATE PROCEDURE actualizar_calificacion_promedio(IN restaurante_id BIGINT)
BEGIN
    UPDATE restaurantes r
    SET r.calificacion_promedio = (
        SELECT AVG(puntuacion)
        FROM calificaciones c
        WHERE c.restaurante_id = r.id
    )
    WHERE r.id = restaurante_id;
END //

-- Procedimiento para agregar una nueva calificación y actualizar el promedio
CREATE PROCEDURE agregar_calificacion(
    IN p_usuario_id BIGINT,
    IN p_restaurante_id BIGINT,
    IN p_puntuacion INT,
    IN p_comentario TEXT
)
BEGIN
    INSERT INTO calificaciones (usuario_id, restaurante_id, puntuacion, comentario)
    VALUES (p_usuario_id, p_restaurante_id, p_puntuacion, p_comentario);
    
    CALL actualizar_calificacion_promedio(p_restaurante_id);
END //

-- Función para obtener el número de calificaciones de un restaurante
CREATE FUNCTION get_num_calificaciones(restaurante_id BIGINT) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE num_calificaciones INT;
    SELECT COUNT(*) INTO num_calificaciones
    FROM calificaciones
    WHERE restaurante_id = restaurante_id;
    RETURN num_calificaciones;
END //

DELIMITER ;