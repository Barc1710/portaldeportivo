-- =============================================================================
-- PORTAL DEPORTIVO - V7: Tablas de Relación (Muchos a Muchos)
-- Fecha: 2025-10-09
-- Descripción: Tablas pivote para relaciones entre noticias, ligas y categorías
-- =============================================================================

-- =============================================================================
-- TABLA: noticias_ligas
-- =============================================================================
-- Relación muchos a muchos entre noticias y ligas
CREATE TABLE IF NOT EXISTS noticias_ligas (
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga) ON DELETE CASCADE,
    PRIMARY KEY (id_noticia, id_liga)
);

-- Índices para optimizar consultas
CREATE INDEX idx_noticias_ligas_noticia ON noticias_ligas(id_noticia);
CREATE INDEX idx_noticias_ligas_liga ON noticias_ligas(id_liga);

-- Comentarios descriptivos
COMMENT ON TABLE noticias_ligas IS 'Relación entre noticias y ligas deportivas';
COMMENT ON COLUMN noticias_ligas.id_noticia IS 'ID de la noticia';
COMMENT ON COLUMN noticias_ligas.id_liga IS 'ID de la liga';

-- =============================================================================
-- TABLA: noticias_categorias
-- =============================================================================
-- Relación muchos a muchos entre noticias y categorías
CREATE TABLE IF NOT EXISTS noticias_categorias (
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_categoria INTEGER NOT NULL REFERENCES categorias(id_categoria) ON DELETE CASCADE,
    PRIMARY KEY (id_noticia, id_categoria)
);

-- Índices para optimizar consultas
CREATE INDEX idx_noticias_categorias_noticia ON noticias_categorias(id_noticia);
CREATE INDEX idx_noticias_categorias_categoria ON noticias_categorias(id_categoria);

-- Comentarios descriptivos
COMMENT ON TABLE noticias_categorias IS 'Relación entre noticias y categorías';
COMMENT ON COLUMN noticias_categorias.id_noticia IS 'ID de la noticia';
COMMENT ON COLUMN noticias_categorias.id_categoria IS 'ID de la categoría';
