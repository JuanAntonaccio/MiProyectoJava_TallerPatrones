# MiProyectoJava_TallerPatrones
Este es un posible ejemplo de como usar una proyecto como ejemplo- Uso parte curso Patrones Java
Para crear una base de datos tomamos este texto como ejemplo:

ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE;

CREATE USER USUARIO IDENTIFIED BY USUARIO DEFAULT TABLESPACE USERS;

GRANT DBA TO USUARIO;

GRANT CONNECT TO USUARIO;

GRANT ALL PRIVILEGES TO USUARIO;

Para crear una tabla Productos en la base de datos creada, utilizamos este comando:

CREATE TABLE PRODUCTOS (
ID INTEGER NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
CANTIDAD INTEGER NOT NULL,
PRECIO NUMBER NOT NULL,
VENCIMIENTO DATE NOT NULL
)
TABLESPACE "USERS";
