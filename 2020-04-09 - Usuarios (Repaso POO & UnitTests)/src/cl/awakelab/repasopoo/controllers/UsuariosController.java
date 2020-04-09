package cl.awakelab.repasopoo.controllers;

import java.util.ArrayList;
import java.util.List;

import cl.awakelab.repasopoo.models.Usuario;

public class UsuariosController {

    // Attributes ------------------------------------------------------------------------------
    
    private List<Usuario> usuarios;
    
    // Constructors ----------------------------------------------------------------------------
    
    public UsuariosController() {
        usuarios = new ArrayList<>();
    }
    
    // Methods ---------------------------------------------------------------------------------
    
    public boolean validarDatos(String nombre, String dominio, String clave1, String clave2) {
        if(nombre == null || nombre.isBlank() || nombre.isEmpty() ||
                dominio == null || dominio.isBlank() || dominio.isEmpty() ||
                clave1 == null || clave1.isBlank() || clave1.isEmpty() ||
                clave2 == null || clave2.isBlank() || clave2.isEmpty()) {
            return false;
        }
        
        return true;
    }
    
    public boolean validarContrasena(String clave1, String clave2) {
        return clave1.equals(clave2);
    }
    
    public Usuario crearUsuario(String nombre, String dominio, String clave) {
        return new Usuario(nombre, dominio, clave);
    }
    
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    public void agregarUsuario(String nombre, String dominio, String clave) {
        usuarios.add(new Usuario(nombre, dominio, clave));
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public String toString() {
        return "UsuariosController [usuarios=" + usuarios + "]";
    }

}
