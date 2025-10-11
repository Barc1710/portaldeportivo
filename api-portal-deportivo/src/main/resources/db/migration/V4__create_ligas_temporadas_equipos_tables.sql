-- =============================================================================
-- PORTAL DEPORTIVO - V4: Competiciones Deportivas
-- Fecha: 2025-10-09
-- Descripción: Tablas para ligas, temporadas y equipos
-- =============================================================================

-- =============================================================================
-- TABLA: ligas
-- =============================================================================
-- Almacena las ligas o competiciones deportivas
CREATE TABLE IF NOT EXISTS ligas (
    id_liga SERIAL PRIMARY KEY,
    nombre_liga VARCHAR(100) UNIQUE NOT NULL,
    pais VARCHAR(50) NOT NULL,
    id_externo_api INTEGER UNIQUE
);

-- Índices para optimizar consultas
CREATE INDEX idx_ligas_pais ON ligas(pais);
CREATE INDEX idx_ligas_externo_api ON ligas(id_externo_api);

-- Comentarios descriptivos
COMMENT ON TABLE ligas IS 'Ligas y competiciones deportivas';
COMMENT ON COLUMN ligas.id_liga IS 'ID autoincremental de la liga';
COMMENT ON COLUMN ligas.nombre_liga IS 'Nombre de la liga (ej: La Liga, Premier League)';
COMMENT ON COLUMN ligas.pais IS 'País de la liga';
COMMENT ON COLUMN ligas.id_externo_api IS 'ID de referencia en API externa';

-- =============================================================================
-- TABLA: temporadas
-- =============================================================================
-- Define las temporadas deportivas
CREATE TABLE IF NOT EXISTS temporadas (
    id_temporada SERIAL PRIMARY KEY,
    nombre_temporada VARCHAR(20) UNIQUE NOT NULL
);

-- Comentarios descriptivos
COMMENT ON TABLE temporadas IS 'Temporadas deportivas';
COMMENT ON COLUMN temporadas.id_temporada IS 'ID autoincremental de la temporada';
COMMENT ON COLUMN temporadas.nombre_temporada IS 'Nombre de la temporada (ej: 2024-2025)';

-- =============================================================================
-- TABLA: equipos
-- =============================================================================
-- Almacena los equipos deportivos
CREATE TABLE IF NOT EXISTS equipos (
    id_equipo SERIAL PRIMARY KEY,
    nombre_equipo VARCHAR(100) NOT NULL,
    escudo_url TEXT,
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga),
    id_externo_api INTEGER UNIQUE
);

-- Índices para optimizar consultas
CREATE INDEX idx_equipos_liga ON equipos(id_liga);
CREATE INDEX idx_equipos_externo_api ON equipos(id_externo_api);
CREATE INDEX idx_equipos_nombre ON equipos(nombre_equipo);

-- Comentarios descriptivos
COMMENT ON TABLE equipos IS 'Equipos deportivos';
COMMENT ON COLUMN equipos.id_equipo IS 'ID autoincremental del equipo';
COMMENT ON COLUMN equipos.nombre_equipo IS 'Nombre del equipo';
COMMENT ON COLUMN equipos.escudo_url IS 'URL de la imagen del escudo del equipo';
COMMENT ON COLUMN equipos.id_liga IS 'Liga a la que pertenece el equipo';
COMMENT ON COLUMN equipos.id_externo_api IS 'ID de referencia en API externa';
