/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBd {

    private static String URL = "jdbc:h2:tcp://localhost/./tareas";
    private static String USER = "sa";
    private static String PASS = "";
    private static String CREATION_STATEMENT
            = "CREATE TABLE IF NOT EXISTS tarea (\n"
            + "id INT AUTO_INCREMENT PRIMARY KEY,\n"
            + "titulo VARCHAR(50),\n"
            + "descripcion TEXT,\n"
            + "completada BOOLEAN,\n"
            + ")";

    static {
        inicializar();
    }

    /**
     *
     */
    private static void inicializar() {
        boolean hayErrorGrave = false;
        // Cargar el driver
        try {
            System.err.println("INFO: Cargando driver");
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: El Driver de h2 no está disponible");
            hayErrorGrave = true;
        }

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            int r = conn.prepareStatement(CREATION_STATEMENT).executeUpdate();
            System.err.println("INFO: Creando BD + tabla vacía:" + r);
        } catch (SQLException ex) {
            System.err.println("ERROR: no se pudo crear la tabla");
            ex.printStackTrace();
            hayErrorGrave = true;
        }
        
        if (hayErrorGrave) {
            System.err.println("*** Se encontaron errores graves relacionados con la BD. Abortando la ejecución");
            System.exit(1); // Aborta la ejecución de la app.
        }
    }

    /**
     * Crea una conexion con los parámetros obtenidos de las constantes de
     * arriba
     *
     * @return la Conexión a la DB
     * @throws SQLException
     */
    public static Connection obtener() throws SQLException {
        return DriverManager.getConnection(
                URL, USER, PASS
        );
    }

}
