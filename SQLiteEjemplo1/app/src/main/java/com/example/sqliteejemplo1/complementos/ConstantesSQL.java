package com.example.sqliteejemplo1.complementos;

public class ConstantesSQL {

    //Constantes para utilizar consultas de tipo DDL
    //Base de datos
    public static final String BD_BEBIDA = "dbbebida";
    //Tabla
    public static final String TBL_BEBIDA = "bebida";
    //Campos tabla
    public static final String CAMPO_CODIGO = "cod_bebida";
    public static final String CAMPO_NOMBRE = "nombre_bebida";
    public static final String CAMPO_SABOR = "sabor_bebida";
    public static final String CAMPO_PRESENTACION = "presentacion_bebida";//presentacion en mililitros
    public static final String CAMPO_TIPO = "tipo_bebida";
    public static final String CAMPO_PRECIO = "precio_bebida";

    //Constante de Creacion de Tabla
    public static final String CREAR_TBL_BEBIDA = "CREATE TABLE "+TBL_BEBIDA+
            "("+CAMPO_CODIGO+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            CAMPO_NOMBRE+" TEXT NOT NULL,"+
            CAMPO_SABOR+" TEXT NOT NULL,"+
            CAMPO_PRESENTACION+" INTEGER NOT NULL,"+
            CAMPO_TIPO+" TEXT NOT NULL,"+
            CAMPO_PRECIO+" DOUBLE NOT NULL)";

    //Borrar Tabla
    public static final String BORRAR_TBL_BEBIDA = "DROP TABLE IF EXISTS "+TBL_BEBIDA;

    //Constante de Version, siempre 1
    public static final Integer VERSION = 1;

}
