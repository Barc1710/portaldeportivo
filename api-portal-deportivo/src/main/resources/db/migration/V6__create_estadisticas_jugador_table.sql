-- =============================================================================
-- PORTAL DEPORTIVO - V6: Estadísticas de Jugadores
-- Fecha: 2025-10-09
-- Descripción: Tabla para almacenar estadísticas de jugadores por temporada
-- =============================================================================

-- =============================================================================
-- TABLA: estadisticas_jugador
-- =============================================================================
-- Almacena estadísticas de rendimiento de jugadores por liga y temporada
CREATE TABLE IF NOT EXISTS estadisticas_jugador (
    id_estadistica SERIAL PRIMARY KEY,
    goles INTEGER DEFAULT 0,
    asistencias INTEGER DEFAULT 0,
    partidos_jugados INTEGER DEFAULT 0,
    id_jugador INTEGER NOT NULL REFERENCES jugadores(id_jugador),
    id_temporada INTEGER NOT NULL REFERENCES temporadas(id_temporada),
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga),
    UNIQUE (id_jugador, id_temporada, id_liga)
);

-- Índices para optimizar consultas
CREATE INDEX idx_estadisticas_liga_temporada ON estadisticas_jugador(id_liga, id_temporada);
CREATE INDEX idx_estadisticas_jugador ON estadisticas_jugador(id_jugador);
CREATE INDEX idx_estadisticas_goles ON estadisticas_jugador(goles DESC);
CREATE INDEX idx_estadisticas_asistencias ON estadisticas_jugador(asistencias DESC);

-- Comentarios descriptivos
COMMENT ON TABLE estadisticas_jugador IS 'Estadísticas de jugadores por temporada y liga';
COMMENT ON COLUMN estadisticas_jugador.id_estadistica IS 'ID autoincremental de la estadística';
COMMENT ON COLUMN estadisticas_jugador.goles IS 'Total de goles marcados';
COMMENT ON COLUMN estadisticas_jugador.asistencias IS 'Total de asistencias realizadas';
COMMENT ON COLUMN estadisticas_jugador.partidos_jugados IS 'Total de partidos jugados';
COMMENT ON COLUMN estadisticas_jugador.id_jugador IS 'Jugador al que pertenecen las estadísticas';
COMMENT ON COLUMN estadisticas_jugador.id_temporada IS 'Temporada de las estadísticas';
COMMENT ON COLUMN estadisticas_jugador.id_liga IS 'Liga de las estadísticas';
