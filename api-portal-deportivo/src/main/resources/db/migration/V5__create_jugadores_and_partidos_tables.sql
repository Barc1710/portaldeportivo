-- =============================================================================
-- PORTAL DEPORTIVO - V5: Jugadores y Partidos
-- Fecha: 2025-10-09
-- Descripción: Tablas para gestión de jugadores y partidos deportivos
-- =============================================================================

-- =============================================================================
-- TABLA: jugadores
-- =============================================================================
-- Almacena información de jugadores deportivos
CREATE TABLE IF NOT EXISTS jugadores (
    id_jugador SERIAL PRIMARY KEY,
    nombre_completo VARCHAR(200) NOT NULL,
    posicion VARCHAR(50),
    id_externo_api INTEGER UNIQUE
);

-- Índices para optimizar consultas
CREATE INDEX idx_jugadores_nombre ON jugadores(nombre_completo);
CREATE INDEX idx_jugadores_posicion ON jugadores(posicion);
CREATE INDEX idx_jugadores_externo_api ON jugadores(id_externo_api);

-- Comentarios descriptivos
COMMENT ON TABLE jugadores IS 'Jugadores deportivos';
COMMENT ON COLUMN jugadores.id_jugador IS 'ID autoincremental del jugador';
COMMENT ON COLUMN jugadores.nombre_completo IS 'Nombre completo del jugador';
COMMENT ON COLUMN jugadores.posicion IS 'Posición del jugador en el campo';
COMMENT ON COLUMN jugadores.id_externo_api IS 'ID de referencia en API externa';

-- =============================================================================
-- TABLA: partidos
-- =============================================================================
-- Almacena información de partidos deportivos
CREATE TABLE IF NOT EXISTS partidos (
    id_partido SERIAL PRIMARY KEY,
    fecha_hora TIMESTAMPTZ NOT NULL,
    jornada INTEGER,
    estadio VARCHAR(150),
    estado_partido VARCHAR(20) NOT NULL CHECK (estado_partido IN ('PENDIENTE', 'EN_JUEGO', 'FINALIZADO')),
    resultado_local INTEGER,
    resultado_visitante INTEGER,
    id_equipo_local INTEGER NOT NULL REFERENCES equipos(id_equipo),
    id_equipo_visitante INTEGER NOT NULL REFERENCES equipos(id_equipo),
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga),
    id_temporada INTEGER NOT NULL REFERENCES temporadas(id_temporada),
    id_externo_api INTEGER UNIQUE
);

-- Índices para optimizar consultas
CREATE INDEX idx_partidos_fecha ON partidos(fecha_hora);
CREATE INDEX idx_partidos_equipos_temporada ON partidos(id_equipo_local, id_equipo_visitante, id_temporada);
CREATE INDEX idx_partidos_liga ON partidos(id_liga);
CREATE INDEX idx_partidos_temporada ON partidos(id_temporada);
CREATE INDEX idx_partidos_estado ON partidos(estado_partido);
CREATE INDEX idx_partidos_externo_api ON partidos(id_externo_api);

-- Comentarios descriptivos
COMMENT ON TABLE partidos IS 'Partidos deportivos';
COMMENT ON COLUMN partidos.id_partido IS 'ID autoincremental del partido';
COMMENT ON COLUMN partidos.fecha_hora IS 'Fecha y hora del partido';
COMMENT ON COLUMN partidos.jornada IS 'Número de jornada';
COMMENT ON COLUMN partidos.estadio IS 'Nombre del estadio';
COMMENT ON COLUMN partidos.estado_partido IS 'Estado del partido (PENDIENTE, EN_JUEGO, FINALIZADO)';
COMMENT ON COLUMN partidos.resultado_local IS 'Goles del equipo local';
COMMENT ON COLUMN partidos.resultado_visitante IS 'Goles del equipo visitante';
COMMENT ON COLUMN partidos.id_equipo_local IS 'Equipo que juega de local';
COMMENT ON COLUMN partidos.id_equipo_visitante IS 'Equipo que juega de visitante';
COMMENT ON COLUMN partidos.id_liga IS 'Liga del partido';
COMMENT ON COLUMN partidos.id_temporada IS 'Temporada del partido';
COMMENT ON COLUMN partidos.id_externo_api IS 'ID de referencia en API externa';
