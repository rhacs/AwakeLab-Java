package cl.awakelab.repasopoo.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cl.awakelab.repasopoo.controllers.UsuariosController;
import cl.awakelab.repasopoo.models.Usuario;

class UsuariosControllerTest {

    // Attributes ------------------------------------------------------------------------------
    
    UsuariosController controller;
    
    // Setup before each test ------------------------------------------------------------------

    @BeforeEach
    void setUp() throws Exception {
        controller = new UsuariosController();
    }

    // Tests -----------------------------------------------------------------------------------

    @Test
    void validarDatosShouldReturnTrue() {
        assertTrue(controller.validarDatos("nombre", "dominio", "clave", "clave"));
        assertTrue(controller.validarDatos("nombre", "dominio", "clave", "otraClave"));
    }
    
    @Test
    void validarDatosShouldReturnFalse() {
        assertFalse(controller.validarDatos(null, "dominio", "clave", "clave"));
        assertFalse(controller.validarDatos("", "dominio", "clave", "clave"));
        assertFalse(controller.validarDatos("   ", "dominio", "clave", "clave"));
        
        assertFalse(controller.validarDatos("nombre", null, "clave", "clave"));
        assertFalse(controller.validarDatos("nombre", "", "clave", "clave"));
        assertFalse(controller.validarDatos("nombre", "   ", "clave", "clave"));
        
        assertFalse(controller.validarDatos("nombre", "dominio", null, "clave"));
        assertFalse(controller.validarDatos("nombre", "dominio", "", "clave"));
        assertFalse(controller.validarDatos("nombre", "dominio", "   ", "clave"));
        
        assertFalse(controller.validarDatos("nombre", "dominio", "clave", null));
        assertFalse(controller.validarDatos("nombre", "dominio", "clave", ""));
        assertFalse(controller.validarDatos("nombre", "dominio", "clave", "   "));
    }
    
    @Test
    void validarContrasenaShouldReturnTrue() {
        assertTrue(controller.validarContrasena("clave", "clave"));
        assertTrue(controller.validarContrasena("otraClave", "otraClave"));
    }
    
    @Test
    void validarContrasenaShouldReturnFalse() {
        assertFalse(controller.validarContrasena("clave", "otraClave"));
    }
    
    @Test
    void agregarUsuarioShouldAddNewObject() {
        Usuario usuario = new Usuario("nombre", "dominio", "clave");
        controller.agregarUsuario(usuario);
        
        assertEquals(1, controller.getUsuarios().size());
        
        controller.agregarUsuario("nombre", "dominio", "clave");
        assertEquals(2, controller.getUsuarios().size());
    }

}
