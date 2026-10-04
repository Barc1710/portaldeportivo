# 📋 Documento de Análisis de Requerimientos

## Proyecto: Portal de Noticias y Estadísticas de las 5 Grandes Ligas Europeas

**Fecha:** 11 de octubre de 2025  
**Versión:** 2.0 (Actualizado con el esquema de BD)

---

## 1. 📖 Introducción

Este documento detalla los requerimientos funcionales y no funcionales para el desarrollo de un portal web de gestión de contenidos y noticias deportivas, cubriendo las cinco principales ligas de fútbol europeas: **La Liga**, **Premier League**, **Serie A**, **Bundesliga** y **Ligue 1**.

El objetivo es crear una plataforma robusta, escalable e intuitiva que permita a los usuarios acceder a información actualizada sobre el mundo del fútbol europeo.

---

## 2. 👥 Roles de Usuario

| Rol                    | Descripción                                                                  |
| ---------------------- | ---------------------------------------------------------------------------- |
| **Administrador**      | Control total sobre el sistema, incluyendo gestión de contenidos y usuarios. |
| **Editor**             | Enfocado en la gestión de contenidos (noticias, multimedia, comentarios).    |
| **Usuario Registrado** | Lector participativo que puede comentar y personalizar su perfil.            |
| **Visitante**          | Lector anónimo con permisos de solo lectura y la capacidad de compartir.     |

---

## 3. ⚙️ Requerimientos Funcionales (RF)

### 📰 RF-01: Módulo de Gestión de Contenidos y Noticias

- **RF-01.1:** Crear, editar y eliminar noticias desde un panel de control.
- **RF-01.2:** Usar un editor de texto enriquecido (WYSIWYG) para el contenido.
- **RF-01.3:** Asignar estados a las noticias: "Borrador" y "Publicado".
- **RF-01.4:** Registrar el autor de cada noticia.
- **RF-01.5:** Asociar cada noticia a una o más de las cinco ligas y a categorías (Resultados, Fichajes, etc.).

### 🖼️ RF-02: Módulo de Gestión Multimedia

- **RF-02.1:** Subir, almacenar y gestionar imágenes y videos.
- **RF-02.2:** Crear galerías de fotos y añadir pies de foto.
- **RF-02.3:** Incrustar videos de plataformas externas como YouTube.

### ⚽ RF-03: Módulo de Datos de Competición

- **RF-03.1:** Mostrar calendario, resultados y tablas de posiciones para las cinco ligas.
- **RF-03.2:** Incluir tablas de máximos goleadores y asistentes por liga.
- **RF-03.3:** Permitir la actualización manual de datos por parte de un Administrador.
- **RF-03.4:** Integrar una API externa para la actualización automática de todos los datos de competición.

### 💬 RF-04: Módulo de Interacción y Comunidad

- **RF-04.1:** Permitir a los Usuarios Registrados publicar comentarios y responder a otros.
- **RF-04.2:** Incluir botones para compartir noticias en redes sociales y copiar enlaces.

### 🔒 RF-05: Módulo de Seguridad y Acceso

- **RF-05.1:** Implementar un sistema de registro y login seguro basado en correo y contraseña cifrada.
- **RF-05.2:** Incluir una funcionalidad de "Olvidé mi contraseña".

### 📊 RF-06: Módulo de Reportes y Analíticas

- **RF-06.1:** Generar reportes filtrables por fecha y liga sobre:
  - Artículos más leídos
  - Actividad de comentarios
  - Nuevos usuarios
  - Actividad de editores

---

## 4. 🔧 Requerimientos No Funcionales (RNF)

| ID         | Categoría          | Descripción                                                                         |
| ---------- | ------------------ | ----------------------------------------------------------------------------------- |
| **RNF-01** | **Rendimiento**    | Tiempos de carga rápidos (< 3 segundos) y consultas a la base de datos optimizadas. |
| **RNF-02** | **Usabilidad**     | Interfaz intuitiva y diseño responsivo para todos los dispositivos.                 |
| **RNF-03** | **Escalabilidad**  | Arquitectura modular que permita un crecimiento futuro.                             |
| **RNF-04** | **Seguridad**      | Protección contra ataques comunes (SQL Injection, XSS, etc.).                       |
| **RNF-05** | **Mantenibilidad** | Código limpio, documentado y siguiendo buenas prácticas.                            |

---

## 5. 📝 Casos de Uso Principales

| ID        | Nombre del Caso de Uso           | Actor(es) Principal(es)       | Resumen de la Interacción                                                                                                                           |
| --------- | -------------------------------- | ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| **CU-01** | Publicar una nueva noticia       | Administrador, Editor         | El actor inicia sesión, navega al panel de noticias, completa el formulario de creación (título, contenido, liga, categoría) y publica el artículo. |
| **CU-02** | Consultar resultados de una liga | Visitante, Usuario Registrado | El actor accede a la sección de una liga y visualiza la tabla de posiciones, el calendario y los resultados actualizados.                           |
| **CU-03** | Comentar en una noticia          | Usuario Registrado            | Tras iniciar sesión, el actor abre un artículo, escribe un comentario en el formulario correspondiente y lo envía.                                  |
| **CU-04** | Registrar una nueva cuenta       | Visitante                     | El actor completa el formulario de registro y obtiene acceso como Usuario Registrado.                                                               |
| **CU-05** | Generar reporte de contenido     | Administrador, Editor         | El actor accede al panel de reportes, selecciona un informe, aplica filtros de fecha y liga, y visualiza los datos.                                 |

---

## 6. 🗄️ Modelo de Datos y Diagramas

### 6.1. Modelo Conceptual (Entidades y Tablas de la BD)

El sistema se modelará sobre las siguientes tablas principales en la base de datos **PostgreSQL**:

#### Tablas Principales

| Tabla           | Descripción                                                 | Campos Principales                                                                                                               |
| --------------- | ----------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| **roles**       | Almacena los perfiles del sistema                           | `id_rol`, `nombre_rol`                                                                                                           |
| **usuarios**    | Contiene la información de los usuarios registrados         | `id_usuario`, `nombre_usuario`, `correo_electronico`, `contrasena_hash`, `id_rol`                                                |
| **noticias**    | El contenido principal de los artículos                     | `id_noticia`, `titulo`, `contenido`, `estado`, `id_autor`                                                                        |
| **ligas**       | Las cinco competiciones principales                         | `id_liga`, `nombre_liga`, `pais`, `id_externo_api`                                                                               |
| **equipos**     | Los equipos de cada liga                                    | `id_equipo`, `nombre_equipo`, `escudo_url`, `id_liga`, `id_externo_api`                                                          |
| **partidos**    | Información de cada encuentro                               | `id_partido`, `fecha_hora`, `resultado_local`, `resultado_visitante`, `id_equipo_local`, `id_equipo_visitante`, `id_externo_api` |
| **comentarios** | Los comentarios realizados por los usuarios en las noticias | `id_comentario`, `texto_contenido`, `id_usuario`, `id_noticia`                                                                   |

#### Tablas Pivote (Relaciones Muchos a Muchos)

- `noticias_ligas`
- `noticias_categorias`
- `noticias_multimedia`

---

### 6.2. Diagrama Entidad-Relación (ER)

El diagrama ER visualizará las relaciones clave entre las tablas:

```
┌─────────────┐        ┌─────────────┐
│   roles     │───1:N──│  usuarios   │
└─────────────┘        └─────────────┘
                              │
                              │ 1:N
                              ▼
                       ┌─────────────┐        ┌─────────────┐
                       │  noticias   │───N:M──│   ligas     │
                       └─────────────┘        └─────────────┘
                              │                      │
                              │ 1:N                  │ 1:N
                              ▼                      ▼
                       ┌─────────────┐        ┌─────────────┐
                       │ comentarios │        │   equipos   │
                       └─────────────┘        └─────────────┘
                              ▲                      │
                              │                      │ 1:N
                              └──────────────────────┤
                                                     ▼
                                              ┌─────────────┐
                                              │  partidos   │
                                              └─────────────┘
```

**Relaciones Principales:**

- `roles` **(1)** ─── **(N)** `usuarios`
- `usuarios` **(1)** ─── **(N)** `noticias` _(Relación de autoría)_
- `usuarios` **(1)** ─── **(N)** `comentarios`
- `noticias` **(1)** ─── **(N)** `comentarios`
- `ligas` **(1)** ─── **(N)** `equipos`
- `equipos` **(1)** ─── **(N)** `partidos` _(Relación doble: local y visitante)_
- `noticias` **(N)** ─── **(M)** `ligas` _(A través de la tabla pivote `noticias_ligas`)_

---

### 6.3. Diagrama de Arquitectura General del Sistema

```
┌─────────────────────────────────────────────────────────┐
│                    CAPA DE PRESENTACIÓN                 │
│  ┌───────────────────────────────────────────────────┐  │
│  │   Frontend (SPA - React/Angular/Vue)              │  │
│  │   - Interfaz de usuario responsive                │  │
│  │   - Consume API REST                              │  │
│  └───────────────────────────────────────────────────┘  │
└────────────────────────┬────────────────────────────────┘
                         │ HTTP/REST
                         ▼
┌─────────────────────────────────────────────────────────┐
│                    CAPA DE LÓGICA                       │
│  ┌───────────────────────────────────────────────────┐  │
│  │   Backend (API RESTful - Java/Spring Boot)        │  │
│  │   - Controladores                                 │  │
│  │   - Servicios de negocio                          │  │
│  │   - Seguridad y autenticación                     │  │
│  └───────────────────────────────────────────────────┘  │
└────────────────┬────────────────────────┬───────────────┘
                 │                        │
                 ▼                        ▼
┌────────────────────────┐    ┌──────────────────────────┐
│   CAPA DE DATOS        │    │  SERVICIOS EXTERNOS      │
│  ┌──────────────────┐  │    │  ┌────────────────────┐  │
│  │   PostgreSQL     │  │    │  │ API Datos          │  │
│  │   - Tablas       │  │    │  │ Deportivos         │  │
│  │   - Relaciones   │  │    │  └────────────────────┘  │
│  │   - Índices      │  │    │  ┌────────────────────┐  │
│  └──────────────────┘  │    │  │ Servicio de        │  │
│                        │    │  │ Correo Electrónico │  │
└────────────────────────┘    │  └────────────────────┘  │
                              └──────────────────────────┘
```

**Componentes:**

1. **Frontend (Capa de Presentación):** Aplicación SPA (React/Angular) que consume la API REST.
2. **Backend (Capa de Lógica):** API RESTful (Java/Spring Boot) que procesa las peticiones y se comunica con la base de datos.
3. **Base de Datos (Capa de Datos):** PostgreSQL para el almacenamiento persistente de la información.
4. **Servicios Externos:** API de datos deportivos, servicio de envío de correos.

---

## 📌 Conclusión

Este documento establece las bases para el desarrollo del Portal de Noticias y Estadísticas Deportivas, proporcionando una guía clara de los requerimientos funcionales y no funcionales, así como la arquitectura y el modelo de datos necesarios para su implementación exitosa.
