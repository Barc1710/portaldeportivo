-- =============================================================================
-- PORTAL DEPORTIVO - V3: Sistema de Comentarios
-- Fecha: 2025-10-09
-- Descripción: Tabla para comentarios en noticias con soporte de anidación
-- =============================================================================

-- =============================================================================
-- TABLA: comentarios
-- =============================================================================
-- Almacena comentarios de usuarios en noticias con soporte para respuestas anidadas
CREATE TABLE IF NOT EXISTS comentarios (
    id_comentario SERIAL PRIMARY KEY,
    texto_contenido TEXT NOT NULL,
    fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_usuario INTEGER NOT NULL REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_comentario_padre INTEGER REFERENCES comentarios(id_comentario) ON DELETE CASCADE
);

-- Índices para optimizar consultas
CREATE INDEX idx_comentarios_noticia_usuario ON comentarios(id_noticia, id_usuario);
CREATE INDEX idx_comentarios_noticia ON comentarios(id_noticia);
CREATE INDEX idx_comentarios_padre ON comentarios(id_comentario_padre);
CREATE INDEX idx_comentarios_fecha ON comentarios(fecha_creacion);

-- Comentarios descriptivos
COMMENT ON TABLE comentarios IS 'Comentarios de usuarios en noticias deportivas';
COMMENT ON COLUMN comentarios.id_comentario IS 'ID autoincremental del comentario';
COMMENT ON COLUMN comentarios.texto_contenido IS 'Contenido del comentario';
COMMENT ON COLUMN comentarios.fecha_creacion IS 'Fecha y hora de creación del comentario';
COMMENT ON COLUMN comentarios.id_usuario IS 'Usuario que realizó el comentario';
COMMENT ON COLUMN comentarios.id_noticia IS 'Noticia comentada';
COMMENT ON COLUMN comentarios.id_comentario_padre IS 'Comentario padre para respuestas anidadas (NULL si es comentario principal)';
