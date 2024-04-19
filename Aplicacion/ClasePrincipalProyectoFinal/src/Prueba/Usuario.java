package Prueba;

public class Usuario {
    
    private String direccionCorreoElectronico;
    private String nombre;
    private String apellidos;
    private String contraseña;
    private String telefono;
    
    public Usuario(String direccionCorreoElectronico, String nombre, String apellidos, String telefono, String contraseña) {
        this.direccionCorreoElectronico = direccionCorreoElectronico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }
    
    public String getDireccionCorreoElectronico() {
        return direccionCorreoElectronico;
    }

    public void setDireccionCorreoElectronico(String direccionCorreoElectronico) {
        this.direccionCorreoElectronico = direccionCorreoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public String toString(){
        return "Correo electronico = " + direccionCorreoElectronico + " Nombre = " + nombre + 
                " Apellidos = " + apellidos + " telefono = " + telefono + " contraseña = " + contraseña;
    }
    
}
