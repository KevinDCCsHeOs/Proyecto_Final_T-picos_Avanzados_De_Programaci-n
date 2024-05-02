package TablasDB;

public class Empleado {
    
    private int folioEmpleado;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String telefono;
    private String oficina;
    private String departamento;
    private String tipoContrato;
    private String estado;
    private String ciudad;
    private String calle;
    private int codigoPostal;
    private String fechaNacimiento;
    private String puestoDeTrabajo;
    private String genero;
    private int sueldo;
    private String curp;
    private String RFC;
    private String contraseña;
    
    public Empleado(){}

    public Empleado(int folioEmpleado, String nombre, String apellidos, String correoElectronico, String telefono, String oficina, String departamento, String tipoContrato, String estado, String ciudad, String calle, int codigoPostal, String fechaNacimiento, String puestoDeTrabajo, String genero, int sueldo, String curp, String RFC, String contraseña) {
        this.folioEmpleado = folioEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.oficina = oficina;
        this.departamento = departamento;
        this.tipoContrato = tipoContrato;
        this.estado = estado;
        this.ciudad = ciudad;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.fechaNacimiento = fechaNacimiento;
        this.puestoDeTrabajo = puestoDeTrabajo;
        this.genero = genero;
        this.sueldo = sueldo;
        this.curp = curp;
        this.RFC = RFC;
        this.contraseña = contraseña;
    }
    
    public Empleado(String nombre, String apellidos, String correoElectronico, String telefono, String oficina, String departamento, String tipoContrato, String estado, String ciudad, String calle, int codigoPostal, String fechaNacimiento, String puestoDeTrabajo, String genero, int sueldo, String curp, String RFC, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.oficina = oficina;
        this.departamento = departamento;
        this.tipoContrato = tipoContrato;
        this.estado = estado;
        this.ciudad = ciudad;
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.fechaNacimiento = fechaNacimiento;
        this.puestoDeTrabajo = puestoDeTrabajo;
        this.genero = genero;
        this.sueldo = sueldo;
        this.curp = curp;
        this.RFC = RFC;
        this.contraseña = contraseña;
    }
    
    public int getFolioEmpleado(){
        return folioEmpleado;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPuestoDeTrabajo() {
        return puestoDeTrabajo;
    }

    public void setPuestoDeTrabajo(String puestoDeTrabajo) {
        this.puestoDeTrabajo = puestoDeTrabajo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
