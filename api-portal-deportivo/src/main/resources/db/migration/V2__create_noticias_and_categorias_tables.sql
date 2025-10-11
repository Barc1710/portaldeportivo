-- =============================================================================
-- PORTAL DEPORTIVO - V2: Gestión de Contenido
-- Fecha: 2025-10-09
-- Descripción: Tablas para noticias y categorías del portal
-- =============================================================================

-- =============================================================================
-- TABLA: noticias
-- =============================================================================
-- Almacena las noticias deportivas publicadas en el portal
CREATE TABLE IF NOT EXISTS noticias (
    id_noticia SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    slug VARCHAR(300) UNIQUE NOT NULL,
    resumen TEXT,
    contenido TEXT NOT NULL,
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('BORRADOR', 'PUBLICADO')),
    fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    fecha_publicacion TIMESTAMPTZ,
    id_autor INTEGER REFERENCES usuarios(id_usuario) ON DELETE SET NULL
);

-- Índices para optimizar consultas
CREATE INDEX idx_noticias_slug ON noticias(slug);
CREATE INDEX idx_noticias_autor ON noticias(id_autor);
CREATE INDEX idx_noticias_estado ON noticias(estado);
CREATE INDEX idx_noticias_fecha_publicacion ON noticias(fecha_publicacion);

-- Comentarios descriptivos
COMMENT ON TABLE noticias IS 'Noticias deportivas del portal';
COMMENT ON COLUMN noticias.id_noticia IS 'ID autoincremental de la noticia';
COMMENT ON COLUMN noticias.titulo IS 'Título de la noticia';
COMMENT ON COLUMN noticias.slug IS 'URL amigable (ej: real-madrid-gana-la-champions)';
COMMENT ON COLUMN noticias.resumen IS 'Resumen breve de la noticia';
COMMENT ON COLUMN noticias.contenido IS 'Contenido completo de la noticia';
COMMENT ON COLUMN noticias.estado IS 'Estado de publicación (BORRADOR, PUBLICADO)';
COMMENT ON COLUMN noticias.fecha_creacion IS 'Fecha de creación de la noticia';
COMMENT ON COLUMN noticias.fecha_publicacion IS 'Fecha de publicación de la noticia';
COMMENT ON COLUMN noticias.id_autor IS 'Usuario autor de la noticia';

-- =============================================================================
-- TABLA: categorias
-- =============================================================================
-- Categorías para clasificar las noticias deportivas
CREATE TABLE IF NOT EXISTS categorias (
    id_categoria SERIAL PRIMARY KEY,
    nombre_categoria VARCHAR(100) UNIQUE NOT NULL
);

-- Comentarios descriptivos
COMMENT ON TABLE categorias IS 'Categorías de noticias deportivas';
COMMENT ON COLUMN categorias.id_categoria IS 'ID autoincremental de la categoría';
COMMENT ON COLUMN categorias.nombre_categoria IS 'Nombre de la categoría (ej: Fichajes, Resultados, Estadísticas)';
