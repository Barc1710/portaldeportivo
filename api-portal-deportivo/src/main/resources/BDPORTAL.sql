-- ######################################################################################
-- ####### SCRIPT DEFINITIVO PARA LA BASE DE DATOS DEL PORTAL DE NOTICIAS DEPORTIVAS #######
-- #######                         MOTOR DE BD: POSTGRESQL                           #######
-- ######################################################################################

-- ========= INICIO: REINICIO DE ESQUEMA (OPCIONAL) =========
-- Elimina las tablas en el orden correcto para evitar conflictos con las claves foráneas.
DROP TABLE IF EXISTS registros_actividad, noticias_multimedia, noticias_categorias, noticias_ligas, comentarios, estadisticas_jugador, partidos, jugadores, equipos, temporadas, ligas, noticias, categorias, multimedia, usuarios, roles CASCADE;
-- ========= FIN: REINICIO DE ESQUEMA =========


-- ========= SECCIÓN 1: SEGURIDAD Y GESTIÓN DE USUARIOS =========

CREATE TABLE roles (
    id_rol SERIAL PRIMARY KEY,
    nombre_rol VARCHAR(50) UNIQUE NOT NULL -- Ej: "Administrador", "Editor", "Usuario Registrado"
);

CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre_usuario VARCHAR(100) UNIQUE NOT NULL,
    correo_electronico VARCHAR(255) UNIQUE NOT NULL,
    contrasena_hash VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_rol INTEGER NOT NULL REFERENCES roles(id_rol)
);

-- ========= SECCIÓN 2: GESTIÓN DE CONTENIDO (NOTICIAS Y CATEGORÍAS) =========

CREATE TABLE noticias (
    id_noticia SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    slug VARCHAR(300) UNIQUE NOT NULL, -- Para URLs amigables, ej: "real-madrid-gana-la-champions"
    resumen TEXT,
    contenido TEXT NOT NULL,
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('BORRADOR', 'PUBLICADO')),
    fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    fecha_publicacion TIMESTAMPTZ,
    id_autor INTEGER REFERENCES usuarios(id_usuario) ON DELETE SET NULL -- La noticia no se borra si el autor es eliminado
);

CREATE TABLE categorias (
    id_categoria SERIAL PRIMARY KEY,
    nombre_categoria VARCHAR(100) UNIQUE NOT NULL -- Ej: "Fichajes", "Resultados", "Estadísticas"
);

CREATE TABLE comentarios (
    id_comentario SERIAL PRIMARY KEY,
    texto_contenido TEXT NOT NULL,
    fecha_creacion TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_usuario INTEGER NOT NULL REFERENCES usuarios(id_usuario) ON DELETE CASCADE, -- Los comentarios se borran con el usuario
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE, -- Los comentarios se borran con la noticia
    id_comentario_padre INTEGER REFERENCES comentarios(id_comentario) ON DELETE CASCADE -- Para anidar respuestas
);


-- ========= SECCIÓN 3: GESTIÓN DE DATOS DE COMPETICIÓN (LIGAS, EQUIPOS, PARTIDOS) =========

CREATE TABLE ligas (
    id_liga SERIAL PRIMARY KEY,
    nombre_liga VARCHAR(100) UNIQUE NOT NULL, -- Ej: "La Liga", "Premier League"
    pais VARCHAR(50) NOT NULL,
    id_externo_api INTEGER UNIQUE -- ID de esta liga en la API externa
);

CREATE TABLE temporadas (
    id_temporada SERIAL PRIMARY KEY,
    nombre_temporada VARCHAR(20) UNIQUE NOT NULL -- Ej: "2024-2025"
);

CREATE TABLE equipos (
    id_equipo SERIAL PRIMARY KEY,
    nombre_equipo VARCHAR(100) NOT NULL,
    escudo_url TEXT,
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga),
    id_externo_api INTEGER UNIQUE -- ID de este equipo en la API externa
);

CREATE TABLE jugadores (
    id_jugador SERIAL PRIMARY KEY,
    nombre_completo VARCHAR(200) NOT NULL,
    posicion VARCHAR(50),
    id_externo_api INTEGER UNIQUE -- ID de este jugador en la API externa
);

CREATE TABLE partidos (
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
    id_externo_api INTEGER UNIQUE -- ID de este partido en la API externa
);

CREATE TABLE estadisticas_jugador (
    id_estadistica SERIAL PRIMARY KEY,
    goles INTEGER DEFAULT 0,
    asistencias INTEGER DEFAULT 0,
    partidos_jugados INTEGER DEFAULT 0,
    id_jugador INTEGER NOT NULL REFERENCES jugadores(id_jugador),
    id_temporada INTEGER NOT NULL REFERENCES temporadas(id_temporada),
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga),
    UNIQUE (id_jugador, id_temporada, id_liga) -- Clave única para evitar duplicados
);


-- ========= SECCIÓN 4: TABLAS PIVOTE (RELACIONES MUCHOS A MUCHOS) =========

CREATE TABLE noticias_ligas (
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_liga INTEGER NOT NULL REFERENCES ligas(id_liga) ON DELETE CASCADE,
    PRIMARY KEY (id_noticia, id_liga)
);

CREATE TABLE noticias_categorias (
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_categoria INTEGER NOT NULL REFERENCES categorias(id_categoria) ON DELETE CASCADE,
    PRIMARY KEY (id_noticia, id_categoria)
);


-- ========= SECCIÓN 5: MULTIMEDIA Y REPORTES DE ACTIVIDAD =========

CREATE TABLE multimedia (
    id_multimedia SERIAL PRIMARY KEY,
    url_archivo TEXT NOT NULL,
    tipo_archivo VARCHAR(10) NOT NULL CHECK (tipo_archivo IN ('IMAGEN', 'VIDEO')),
    pie_de_foto TEXT,
    fecha_subida TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_usuario_subida INTEGER REFERENCES usuarios(id_usuario) ON DELETE SET NULL
);

CREATE TABLE noticias_multimedia (
    id_noticia INTEGER NOT NULL REFERENCES noticias(id_noticia) ON DELETE CASCADE,
    id_multimedia INTEGER NOT NULL REFERENCES multimedia(id_multimedia) ON DELETE CASCADE,
    orden INTEGER DEFAULT 0, -- Para ordenar las imágenes en una galería
    PRIMARY KEY (id_noticia, id_multimedia)
);

CREATE TABLE registros_actividad (
    id_registro SERIAL PRIMARY KEY,
    accion VARCHAR(100) NOT NULL, -- Ej: "CREAR_NOTICIA", "ELIMINAR_COMENTARIO"
    detalles TEXT,
    fecha_hora TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_usuario INTEGER NOT NULL REFERENCES usuarios(id_usuario)
);


-- ========= SECCIÓN 6: ÍNDICES PARA OPTIMIZAR EL RENDIMIENTO DE CONSULTAS =========

CREATE INDEX idx_usuarios_correo ON usuarios(correo_electronico);
CREATE INDEX idx_noticias_slug ON noticias(slug);
CREATE INDEX idx_noticias_autor ON noticias(id_autor);
CREATE INDEX idx_comentarios_noticia_usuario ON comentarios(id_noticia, id_usuario);
CREATE INDEX idx_partidos_fecha ON partidos(fecha_hora);
CREATE INDEX idx_partidos_equipos_temporada ON partidos(id_equipo_local, id_equipo_visitante, id_temporada);
CREATE INDEX idx_estadisticas_liga_temporada ON estadisticas_jugador(id_liga, id_temporada);




-- ######################################################################################
-- #######                          FIN DEL SCRIPT                                 #######
-- ######################################################################################