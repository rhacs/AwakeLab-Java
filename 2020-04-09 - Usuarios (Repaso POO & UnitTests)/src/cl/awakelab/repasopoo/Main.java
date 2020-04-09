package cl.awakelab.repasopoo;

import java.util.Scanner;

import cl.awakelab.repasopoo.controllers.UsuariosController;
import cl.awakelab.repasopoo.models.Usuario;

public class Main {

    // Attributes ------------------------------------------------------------------------------
    
    static UsuariosController usuarios;
    
    // Methods ---------------------------------------------------------------------------------
    
    public static int pedirNumeroEntero(Scanner scanner) {
        while(!scanner.hasNextInt()) {
            System.err.println("Por favor, ingrese un número entero:");
            scanner.next();
        }
        
        return scanner.nextInt();
    }
    
    public static int pedirNumeroEntero(Scanner scanner, int limiteInferior) {
        int entero;
        
        do {
            entero = pedirNumeroEntero(scanner);
            
            if(entero < limiteInferior)
                System.err.println("Por favor, ingrese un número entero mayor a " + limiteInferior);
            
            if(scanner.hasNextLine())
                scanner.nextLine();
            
        } while(entero < limiteInferior);
        
        return entero;
    }
    
    public static boolean solicitarDatos(Scanner scanner) {
        System.out.println("Ingrese los datos del usuario");
        
        System.out.print("  Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("  Dominio: ");
        String dominio = scanner.nextLine();
        
        System.out.print("  Contraseña: ");
        String claveUno = scanner.nextLine();
        
        System.out.print("  Vuelva a ingresar la Contraseña: ");
        String claveDos = scanner.nextLine();
        
        if(usuarios.validarDatos(nombre, dominio, claveUno, claveDos)) {
            if(usuarios.validarContrasena(claveUno, claveDos)) {
                Usuario usuario = new Usuario(nombre, dominio, claveUno);
                usuarios.agregarUsuario(usuario);

                return true;
            }
            
            System.out.println("  [!] Las contraseñas no son iguales.");
            return false;
        }
        
        System.out.println("  [!] Todos los datos son obligatorios.");
        return false;
    }
    
    // Main loop -------------------------------------------------------------------------------
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        usuarios = new UsuariosController();
        
        System.out.println("Ingrese la cantidad de usuarios a crear (n > 0): ");
        int cantidad = pedirNumeroEntero(scanner, 1);
        
        for(int i = 0; i < cantidad; i++) {
            if(!solicitarDatos(scanner))
                i--;
            
            System.out.println();
        }
        
        System.out.println("Usuarios en la base de datos: ");
        System.out.println(String.format("  %-5s%s", "ID", "Correo"));
        
        for(int i = 0; i < usuarios.getUsuarios().size(); i++) {
            System.out.println(String.format("  %-5d%s", i, usuarios.getUsuarios().get(i)));
        }
        
        scanner.close();
    }

}
