/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Freddy Calahorrano
 */

public class ClsContacto {
    private int _claveContacto;
    private String _nomContacto;
    private String _apellContacto;
    private String _dirContacto;
    private String _tlfContacto;
    private String _celContacto;
    
    public ClsContacto(){
     _claveContacto=0;
     _nomContacto=null;
     _apellContacto=null;
     _dirContacto=null;
     _tlfContacto=null;
     _celContacto=null;
    }
    public void leer(ResultSet cliente) throws SQLException{
     _claveContacto=cliente.getInt("claveContacto");
     _nomContacto=cliente.getString("nomContacto");
     _apellContacto=cliente.getString("apellContacto");
     _dirContacto=cliente.getString("dirContacto");
     _tlfContacto=cliente.getString("tlfContacto");
    _celContacto=cliente.getString("celContacto");
    }

    public int getClaveContacto() {
        return _claveContacto;
    }

    public void setClaveContacto(int _claveContacto) {
        this._claveContacto = _claveContacto;
    }

    public String getNomContacto() {
        return _nomContacto;
    }

    public void setNomContacto(String _nomContacto) {
        this._nomContacto = _nomContacto;
    }

    public String getApellContacto() {
        return _apellContacto;
    }

    public void setApellContacto(String _apellContacto) {
        this._apellContacto = _apellContacto;
    }

    public String getDirContacto() {
        return _dirContacto;
    }

    public void setDirContacto(String _dirContacto) {
        this._dirContacto = _dirContacto;
    }

    public String getTlfContacto() {
        return _tlfContacto;
    }

    public void setTlfContacto(String _tlfContacto) {
        this._tlfContacto = _tlfContacto;
    }

    public String getCelContacto() {
        return _celContacto;
    }

    public void setCelContacto(String _celContacto) {
        this._celContacto = _celContacto;
    }
    
}
