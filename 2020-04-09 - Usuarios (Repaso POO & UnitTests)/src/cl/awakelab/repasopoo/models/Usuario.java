package cl.awakelab.repasopoo.models;

public class Usuario {
    
    // Attributes ------------------------------------------------------------------------------
    
    private String nombre;
    private String dominio;
    private String clave;
    
    // Constructors ----------------------------------------------------------------------------
    
    public Usuario() {
        super();
    }
    
    public Usuario(String nombre, String dominio, String clave) {
        super();
        this.nombre = nombre;
        this.dominio = dominio;
        this.clave = clave;
    }
    
    // Getters ---------------------------------------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }

    public String getDominio() {
        return dominio;
    }

    public String getClave() {
        return clave;
    }
    
    // Setters ---------------------------------------------------------------------------------
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    // Inheritances ----------------------------------------------------------------------------
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        
        result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        Usuario other = (Usuario) obj;
        
        if (dominio == null) {
            if (other.dominio != null)
                return false;
            
        } else if (!dominio.equals(other.dominio))
            return false;
        
        if (nombre == null) {
            if (other.nombre != null)
                return false;
            
        } else if (!nombre.equals(other.nombre))
            return false;
        
        return true;
    }

    @Override
    public String toString() {
        return nombre + "@" + dominio;
    }
    
}
