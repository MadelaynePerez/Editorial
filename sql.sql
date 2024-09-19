CREATE TABLE IF NOT EXISTS anuncio (
  id_anuncio bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fecha_inicio date,
  id_perido_de_tiempo bigint,
  id_usuario bigint,
  activo TINYINT(1),
  tipo_anuncio bigint,
  texto text,
  ruta_imagen text
);

CREATE TABLE IF NOT EXISTS `cartera digital` (
  id_cartera bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_usuario bigint,
  saldo double
);

CREATE TABLE IF NOT EXISTS categoria (
  id_categoria bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tipo_categoria varchar(200)
);

CREATE TABLE IF NOT EXISTS comentario (
  id_comentario bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  texto text,
  id_usuario bigint,
  id_revista bigint,
  fecha bigint
);

CREATE TABLE IF NOT EXISTS costo (
  id_costo bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  costo_por_revista double
);

CREATE TABLE IF NOT EXISTS pago (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS periodo_de_tiempo (
  id_periodo_de_tiempo bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  periodo_disponible bigint,
  tipo varchar(200)
);

CREATE TABLE IF NOT EXISTS revista (
  id_revista bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_categoria bigint,
  descripcion varchar(200),
  autor varchar(200),
  fecha_de_creacion date,
  costo_por_dia double,
  precio double,
  ruta text,
  acepar_comentario TINYINT(1),
  aceptar_me_gusta TINYINT(1)
);

CREATE TABLE IF NOT EXISTS revista_tag (
  id_revista_tag bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_revista bigint,
  id_tag bigint
);

CREATE TABLE IF NOT EXISTS suscripcion (
  id_sucripcion bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fecha_de_suscripcion date,
  id_revista bigint,
  id_usuario bigint,
  activo TINYINT(1),
  me_gusta TINYINT(1)
);

CREATE TABLE IF NOT EXISTS tag (
  id_tag bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  etiqueta varchar(200)
);

CREATE TABLE IF NOT EXISTS tipo_de_anuncio (
  id_tipo_anuncio bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tipo_anuncio varchar(200),
  precio double
);

CREATE TABLE IF NOT EXISTS tipo_de_usuario (
  id_tipo_usuario bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  tipo_de_usuario varchar(200)
);

CREATE TABLE IF NOT EXISTS usuario (
  nombre varchar(200),
  id_usuario bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  contrasena varchar(200),
  correo_electronico varchar(200),
  hobbie varchar(200),
  descripcion varchar(200),
  temas_de_interes varchar(200),
  gustos varchar(200),
  tipo_usuario bigint,
  foto varchar(200)
);

ALTER TABLE anuncio ADD CONSTRAINT anuncios_id_perido_de_tiempo_fk FOREIGN KEY (id_perido_de_tiempo) REFERENCES periodo_de_tiempo (id_periodo_de_tiempo);
ALTER TABLE anuncio ADD CONSTRAINT anuncios_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE anuncio ADD CONSTRAINT anuncios_tipo_anuncio_fk FOREIGN KEY (tipo_anuncio) REFERENCES tipo_de_anuncio (id_tipo_anuncio);
ALTER TABLE `cartera digital` ADD CONSTRAINT `cartera digital_id_usuario_fk` FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE comentario ADD CONSTRAINT comentario_id_revista_fk FOREIGN KEY (id_revista) REFERENCES revista (id_revista);
ALTER TABLE comentario ADD CONSTRAINT comentario_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE revista ADD CONSTRAINT revista_id_categoria_fk FOREIGN KEY (id_categoria) REFERENCES categoria (id_categoria);
ALTER TABLE revista_tag ADD CONSTRAINT revista_tag_id_revista_fk FOREIGN KEY (id_revista) REFERENCES revista (id_revista);
ALTER TABLE revista_tag ADD CONSTRAINT revista_tag_id_tag_fk FOREIGN KEY (id_tag) REFERENCES tag (id_tag);
ALTER TABLE suscripcion ADD CONSTRAINT suscripcion_id_revista_fk FOREIGN KEY (id_revista) REFERENCES revista (id_revista);
ALTER TABLE suscripcion ADD CONSTRAINT suscripcion_id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario);
ALTER TABLE usuario ADD CONSTRAINT usuario_tipo_usuario_fk FOREIGN KEY (tipo_usuario) REFERENCES tipo_de_usuario (id_tipo_usuario);

