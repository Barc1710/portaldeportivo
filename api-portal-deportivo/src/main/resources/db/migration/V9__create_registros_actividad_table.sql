-- =============================================================================
-- PORTAL DEPORTIVO - V9: Auditoría y Registros de Actividad
-- Fecha: 2025-10-09
-- Descripción: Tabla para registrar actividades de usuarios en el sistema
-- =============================================================================

-- =============================================================================
-- TABLA: registros_actividad
-- =============================================================================
-- Almacena un log de actividades de usuarios para auditoría
CREATE TABLE IF NOT EXISTS registros_actividad (
    id_registro SERIAL PRIMARY KEY,
    accion VARCHAR(100) NOT NULL,
    detalles TEXT,
    fecha_hora TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_usuario INTEGER NOT NULL REFERENCES usuarios(id_usuario)
);

-- Índices para optimizar consultas
CREATE INDEX idx_registros_usuario ON registros_actividad(id_usuario);
CREATE INDEX idx_registros_fecha ON registros_actividad(fecha_hora);
CREATE INDEX idx_registros_accion ON registros_actividad(accion);

-- Comentarios descriptivos
COMMENT ON TABLE registros_actividad IS 'Log de actividades de usuarios para auditoría';
COMMENT ON COLUMN registros_actividad.id_registro IS 'ID autoincremental del registro';
COMMENT ON COLUMN registros_actividad.accion IS 'Tipo de acción realizada (ej: CREAR_NOTICIA, ELIMINAR_COMENTARIO)';
COMMENT ON COLUMN registros_actividad.detalles IS 'Información adicional sobre la acción';
COMMENT ON COLUMN registros_actividad.fecha_hora IS 'Fecha y hora de la acción';
COMMENT ON COLUMN registros_actividad.id_usuario IS 'Usuario que realizó la acción';
