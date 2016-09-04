/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@ManagedBean
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String usuario;
    private boolean logueado = false;
    private String contrasena;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String validateUsuarioContrasena() {
        boolean valid = validate(usuario, contrasena);
        if (valid) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("usuario", usuario);
            logueado = true;
            return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario y Contraseña invalida",
                            "Por favor ingrese Usuario y Contraseña"));
            return "Login";
        }
    }

    private boolean validate(String usuario, String contrasena) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select usuario, "
                    + "contrasena "
                    + "from usuarios "
                    + "where usuario = ? and contrasena = ?");
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            DataConnect.close(con);
        }
        return false;
    }

    //logout
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "Login";
    }
}
