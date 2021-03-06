/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author dam2
 */
public class Constantes {

    public static final String SQL_SENTENCIA_DAME_TODO = "SELECT * FROM GAME";
    public static final String SQL_SENTENCIA_UPDATE = "update GAME set NOMBRE = ?,FECHA_CREACION=?, VENTAS=?,GAME_TYPE=?,GAME_CREATOR=? where ID = ?";
    public static final String SQL_SENTENCIA_INSERT = "INSERT INTO GAME (nombre,fecha_creacion,ventas,game_type,game_creator) values (?,?,?,?,?)";
    public static final String SQL_SENTENCIA_ULTIMO_ID="SELECT LAST_INSERT_ROWID()";
    public static final String SQL_SENTENCIA_DELETE = "DELETE FROM GAME WHERE id=?";
    public static final String SQL_SENTENCIA_DAME_TODO_TIPOS = "SELECT * FROM GAMETYPE";
    public static final String SQL_SENTENCIA_DAME_TODO_CREADORES = "SELECT * FROM GAMECREATOR";
    public static final int NUMERO_COLUMNAS=6;
    public static final int NUMERO_COLUMNA_TIPO=4;
    public static final int NUMERO_COLUMNA_CREADOR=5;
}
