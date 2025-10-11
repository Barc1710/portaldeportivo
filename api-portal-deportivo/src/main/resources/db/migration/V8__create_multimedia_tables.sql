-- =============================================================================
-- PORTAL DEPORTIVO - V8: Gestión de Multimedia
-- Fecha: 2025-10-09
-- Descripción: Tablas para almacenar y asociar archivos multimedia a noticias
-- =============================================================================

-- =============================================================================
-- TABLA: multimedia
-- =============================================================================
-- Almacena archivos multimedia (imágenes y videos)
CREATE TABLE IF NOT EXISTS multimedia (
    id_multimedia SERIAL PRIMARY KEY,
    url_archivo TEXT NOT NULL,
    tipo_archivo VARCHAR(10) NOT NULL CHECK (tipo_archivo IN ('IMAGEN', 'VIDEO')),
    pie_de_foto TEXT,
    fecha_subida TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_usuario_subida INTEGER REFERENCES usuarios(id_usuario) ON DELETE SET NULL
);

-- Índices para optimizar consultas
CREATE INDEX idx_multimedia_tipo ON multimedia(tipo_archivo);
CREATE INDEX idx_multimedia_fecha ON multimedia(fecha_subida);
CREATE INDEX idx_multimedia_usuario ON multimedia(id_usuario_subida);

-- Comentarios descriptivos
COMMENT ON TABLE multimedia IS 'Archivos multimedia del portal';
COMMENT ON COLUMN multimedia.id_multimedia IS 'ID autoincremental del archivo multimedia';
COMMENT ON COLUMN multimedia.url_archivo IS 'URL o ruta del archivo';
COMMENT ON COLUMN multimedia.tipo_archivo IS 'Tipo de archivo (IMAGEN, VIDEO)';
COMMENT ON COLUMN multimedia.pie_de_foto IS 'Descripción o pie de foto del archivo';
COMMENT ON COLUMN multimedia.fecha_subida IS 'Fecha y hora de subida del archivo';
COMMENT ON COLUMN multimedia.id_usuario_subida IS 'Usuario que subió el archivo';

-- =============================================================================
-- TABLA: noticias_multimedia
-- =============================================================================
-- Relación entre noticias y archivos multimedia
CREATE TABLE IF NOT EXISTS noticias_multimedia (
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_multimedia INTEGER NOT NULL REFERENCES multimedia(id_multimedia) ON DELETE CASCADE,
    orden INTEGER DEFAULT 0,
    PRIMARY KEY (id_noticia, id_multimedia)
);

-- Índices para optimizar consultas
CREATE INDEX idx_noticias_multimedia_noticia ON noticias_multimedia(id_noticia);
CREATE INDEX idx_noticias_multimedia_orden ON noticias_multimedia(id_noticia, orden);

-- Comentarios descriptivos
COMMENT ON TABLE noticias_multimedia IS 'Relación entre noticias y archivos multimedia';
COMMENT ON COLUMN noticias_multimedia.id_noticia IS 'ID de la noticia';
COMMENT ON COLUMN noticias_multimedia.id_multimedia IS 'ID del archivo multimedia';
COMMENT ON COLUMN noticias_multimedia.orden IS 'Orden de presentación en galerías (0=principal)';
