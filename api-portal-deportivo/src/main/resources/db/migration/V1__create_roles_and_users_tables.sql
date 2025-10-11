-- =============================================================================
-- PORTAL DEPORTIVO - V1: Seguridad y Gestión de Usuarios
-- Fecha: 2025-10-09
-- Descripción: Tablas base para roles y usuarios del sistema
-- =============================================================================

-- =============================================================================
-- TABLA: roles
-- =============================================================================
-- Define los roles de acceso al portal (Administrador, Editor, Usuario)
CREATE TABLE IF NOT EXISTS roles (
    id_rol SERIAL PRIMARY KEY,
    nombre_rol VARCHAR(50) UNIQUE NOT NULL
);

-- Comentarios descriptivos
COMMENT ON TABLE roles IS 'Roles de acceso al portal de noticias deportivas';
COMMENT ON COLUMN roles.id_rol IS 'ID autoincremental del rol';
COMMENT ON COLUMN roles.nombre_rol IS 'Nombre del rol (ej: Administrador, Editor, Usuario Registrado)';

-- =============================================================================
-- TABLA: usuarios
-- =============================================================================
-- Almacena la información de los usuarios registrados en el portal
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre_usuario VARCHAR(100) UNIQUE NOT NULL,
    correo_electronico VARCHAR(255) UNIQUE NOT NULL,
    contrasena_hash VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,
    id_rol INTEGER NOT NULL REFERENCES roles(id_rol)
);

-- Índices para optimizar consultas
CREATE INDEX idx_usuarios_correo ON usuarios(correo_electronico);
CREATE INDEX idx_usuarios_rol ON usuarios(id_rol);

-- Comentarios descriptivos
COMMENT ON TABLE usuarios IS 'Usuarios registrados en el portal deportivo';
COMMENT ON COLUMN usuarios.id_usuario IS 'ID autoincremental del usuario';
COMMENT ON COLUMN usuarios.nombre_usuario IS 'Nombre de usuario único';
COMMENT ON COLUMN usuarios.correo_electronico IS 'Email único del usuario';
COMMENT ON COLUMN usuarios.contrasena_hash IS 'Contraseña encriptada (BCrypt o similar)';
COMMENT ON COLUMN usuarios.fecha_registro IS 'Fecha y hora de registro en el sistema';
COMMENT ON COLUMN usuarios.id_rol IS 'Referencia al rol del usuario';
