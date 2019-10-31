/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Clsconexion {
    private Connection base;
    private Statement tabla;
    private ResultSet agenda;

   public Clsconexion(String dirbase) {
        try {
            base = DriverManager.getConnection("jdbc:ucanaccess://" + dirbase);
            System.out.println("***CONEXIÓN EXITOSA***");
            tabla = base.createStatement(ResultSet.FETCH_UNKNOWN, ResultSet.TYPE_SCROLL_SENSITIVE);

        } catch (Exception err) {
            System.out.println("***CONEXIÓN FALLIDA***" + err);
        }

    }

    public ResultSet _cliente() {
        return agenda;
    }

    
    public boolean consulta(String _tabla) throws SQLException {
        boolean comprobar = false;
        String comando = " SELECT * FROM " + _tabla;
        agenda = null;
        tabla.execute(comando);
        agenda = tabla.getResultSet();
        if (agenda != null) {
            comprobar = true;
        }
        return comprobar;
    }
    
     public boolean verAgenada(int clave) throws SQLException {
        agenda = null;
        boolean comprobar = false;
        String comando = "SELECT * FROM TbAgenda WHERE claveContacto  = " + clave;
        tabla.execute(comando);
        agenda = tabla.getResultSet();
        if (agenda != null) {
            comprobar = true;
        }
        return comprobar;
    }

     public boolean registrarContacto(String n, String a, String d, String t, String c) throws SQLException {
        agenda = null;
        boolean registrar = false;
        try {
            String insertar = "INSERT INTO TbAgenda"
                    + "(nomContacto,apellContacto,dirContacto,tlfContacto,celContacto)"
                    + "VALUES"
                    + "('" + n + "','" + a + "','" + d + "','" + t + "','" + c +  "');";
            tabla = base.createStatement();
            tabla.execute(insertar);
            agenda = tabla.getResultSet();
            if (agenda != null) {
                registrar = true;
            }
        } catch (SQLException re) {
            System.out.println("No" + re);
        }
        return registrar;
    }
     
      public boolean actualizarContacto(String d, String t, String c, int clave) throws SQLException {
        agenda = null;

        boolean actualizar = false;
        try {
            String comando = "UPDATE TbAgenda SET dirContacto= '" + d + "'," + "tlfContacto ='" + t + "'," + "celContacto ='" + c + "'"
                    + "WHERE claveContacto =" + clave;

            tabla = base.createStatement();
            tabla.execute(comando);
            agenda = tabla.getResultSet();
            actualizar = true;
        } catch (SQLException err) {
            System.out.println("No" + err);
        }
        return actualizar;
    }
      
       public boolean eliminarContacto(int _clave) {
        agenda = null;

        boolean eliminar = false;
        try {
            String comando = "DELETE FROM TbAgenda WHERE claveContacto = " + _clave;
            tabla = base.createStatement();
            tabla.execute(comando);
            agenda = tabla.getResultSet();
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("No" + e);
        }
        return eliminar;
    }

public void siguiente() {
        try {

            if (!(agenda.next())) {
                agenda.first();
            }
        } catch (SQLException err) {
            System.out.println("***ERROR AL RECORRER");
        }
    }

    public void anterior() {
        try {
            if (!(agenda.previous())) {
                agenda.last();
            }
        } catch (SQLException err) {
            System.out.println("***ERROR AL RECORRER");
        }
    }

}
