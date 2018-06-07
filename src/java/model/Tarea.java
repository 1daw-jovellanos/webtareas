/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.*;

public class Tarea {

    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;

    public Tarea(String titulo, String descripcion, boolean completada) {
        this.id = -1;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public Tarea(int id, String titulo, String descripcion, boolean completada) {
        this(titulo,descripcion,completada);
        this.id = id;
    }

    public Tarea(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // --------------------------------------------------------------------
    public boolean create() {
        boolean resultado = false;
        String sql = "INSERT INTO tarea(titulo, descripcion, completada) "
                + "VALUES(?,?,?)";
        try (
                Connection conn = ConexionBd.obtener();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, getTitulo());
            stmt.setString(2, getDescripcion());
            stmt.setBoolean(3, getCompletada());
            int filas = stmt.executeUpdate();
            resultado = filas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean retrieve() {
        boolean resultado = false;
        String sql = "SELECT titulo, descripcion, completada "
                + " FROM tarea"
                + " WHERE id = ?";
        try (
                Connection conn = ConexionBd.obtener();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    setTitulo(rs.getString("titulo"));
                    setDescripcion(rs.getString("descripcion"));
                    setCompletada(rs.getBoolean("completada"));
                    resultado = true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean delete() {
        boolean resultado = false;
        String sql = "DELETE FROM tarea "
                + "WHERE id = ?";
        try (
                Connection conn = ConexionBd.obtener();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setInt(1, getId());
            int filas = stmt.executeUpdate();
            resultado = filas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
        public boolean update() {
        boolean resultado = false;
        String sql = "UPDATE tarea SET titulo=?, descripcion=?, completada=? "
                + "WHERE id = ?";
        try (
                Connection conn = ConexionBd.obtener();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, getTitulo());
            stmt.setString(2, getDescripcion());
            stmt.setBoolean(3, getCompletada());
            stmt.setInt(4, getId());
            int filas = stmt.executeUpdate();
            resultado = filas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

        
    public static List<Tarea> obtenerTodas() {
        List<Tarea> lista = null;
        String sql = "SELECT id, titulo, descripcion, completada "
                + "FROM tarea ORDER BY id";
        try (
                Connection conn = ConexionBd.obtener();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()
        ) {
                lista = new ArrayList<>();
                while (rs.next()) {
                    lista.add(
                        new Tarea (
                            rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("descripcion"),
                            rs.getBoolean("completada")
                        )
                    );
                }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
    
}
