package cl.awakelab.repasopoo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.repasopoo.models.Usuario;

class UsuarioTest {

    Usuario usuario;
    
    String nombre;
    String dominio;
    String clave;
    
    // Setup before each test ------------------------------------------------------------------
    
    @BeforeEach
    void setUp() throws Exception {
        usuario = new Usuario();
        
        nombre = "nombre";
        dominio = "dominio.ext";
        clave = "clave";
        
        usuario.setNombre(nombre);
        usuario.setDominio(dominio);
        usuario.setClave(clave);
    }

    // Tests -----------------------------------------------------------------------------------
    
    @Test
    void shouldReturnNombre() {
        assertEquals(nombre, usuario.getNombre());
    }
    
    @Test
    void shouldReturnDominio() {
        assertEquals(dominio, usuario.getDominio());
    }
    
    @Test
    void shouldReturnClave() {
        assertEquals(clave, usuario.getClave());
    }
    
    @Test
    void shouldChangeNombre() {
        String nombre = "Nuevo Nombre";
        usuario.setNombre(nombre);
        
        assertEquals(nombre, usuario.getNombre());
    }
    
    @Test
    void shouldChangeDominio() {
        String dominio = "nuevodominio.ext";
        usuario.setDominio(dominio);
        
        assertEquals(dominio, usuario.getDominio());
    }
    
    @Test
    void shouldChangeClave() {
        String clave = "claveMasSegura";
        usuario.setClave(clave);
        
        assertEquals(clave, usuario.getClave());
    }
    
}
