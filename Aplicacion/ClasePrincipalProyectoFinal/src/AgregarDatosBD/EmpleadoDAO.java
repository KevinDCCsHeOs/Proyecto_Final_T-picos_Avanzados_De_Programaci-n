package AgregarDatosBD;

import java.sql.*;
import javax.swing.JOptionPane;
import TablasDB.Empleado;

public class EmpleadoDAO {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basededatosprincipal?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "R4ns0mw4r3";
    private Empleado emp;
    
    public void agregarEmpleado(Empleado empleado){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Empleado (nombre, apellidos, correoElectronico, telefono, oficina, departamento, tipoContrato, estado, ciudad, calle, codigoPostal"
                    + ", fechaDeNacimiento, puestoDeTrabajo, genero, sueldo, curp, rfc, contraseña) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getApellidos());
            statement.setString(3, empleado.getCorreoElectronico());
            statement.setString(4, empleado.getTelefono());
            statement.setString(5, empleado.getOficina());
            statement.setString(6, empleado.getDepartamento());
            statement.setString(7, empleado.getTipoContrato());
            statement.setString(8, empleado.getEstado());
            statement.setString(9, empleado.getCiudad());
            statement.setString(10, empleado.getCalle());
            statement.setInt(11, empleado.getCodigoPostal());
            statement.setString(12, empleado.getFechaNacimiento());
            statement.setString(13, empleado.getPuestoDeTrabajo());
            statement.setString(14, empleado.getGenero() + "");
            statement.setInt(15, empleado.getSueldo());
            statement.setString(16, empleado.getCurp());
            statement.setString(17, empleado.getRFC());
            statement.setString(18, empleado.getContraseña());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha creado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Empleado buscarEmpleadoC(String correoElectronico) {
        Empleado empleado = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Empleado WHERE direccionCorreoElectronico = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, correoElectronico);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empleado = new Empleado(
                        resultSet.getInt("cveUsuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correoElectronico"),
                        resultSet.getString("telefono"),
                        resultSet.getString("oficina"),
                        resultSet.getString("departamento"),
                        resultSet.getString("tipoContrato"),
                        resultSet.getString("estado"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("calle"),
                        resultSet.getInt("codigoPostal"),
                        resultSet.getString("fechaDeNacimiento"),
                        resultSet.getString("puestoDeTrabajo"),
                        resultSet.getString("genero"),
                        resultSet.getInt("sueldo"),
                        resultSet.getString("curp"),
                        resultSet.getString("rfc"),
                        resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }
    
    public Empleado buscarEmpleadoT(String telefono) {
        Empleado empleado = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Empleado WHERE telefono = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, telefono);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empleado = new Empleado(
                        resultSet.getInt("cveUsuario"),
                        resultSet.getString("nombre"),
                        resultSet.getString("apellidos"),
                        resultSet.getString("correoElectronico"),
                        resultSet.getString("telefono"),
                        resultSet.getString("oficina"),
                        resultSet.getString("departamento"),
                        resultSet.getString("tipoContrato"),
                        resultSet.getString("estado"),
                        resultSet.getString("ciudad"),
                        resultSet.getString("calle"),
                        resultSet.getInt("codigoPostal"),
                        resultSet.getString("fechaDeNacimiento"),
                        resultSet.getString("puestoDeTrabajo"),
                        resultSet.getString("genero"),
                        resultSet.getInt("sueldo"),
                        resultSet.getString("curp"),
                        resultSet.getString("rfc"),
                        resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleado;
    }
    
    public void actualizarEmpleado(String correoElectronico){
        Empleado empleado = buscarEmpleadoC(correoElectronico);
        if(empleado == null)
            JOptionPane.showMessageDialog(null, "No se pueden actualizar los datos de un "
                    + "empleado que no existe", "Empleado no encontrado", JOptionPane.ERROR_MESSAGE);
        else{
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "UPDATE Empleado SET telefono = ?, oficina = ?, departamento = ?, tipoContrato = ?, estado = ?,"
                        + " ciudad = ?, calle = ?, codigoPostal = ?, puestoDeTrabajo = ?, sueldo = ?"
                        + " WHERE correoElectronico = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                String cosa;
                String[] op = {"Mantener", "Cambiar"};
                String sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo numero de telefono o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(1, empleado.getTelefono());
                else{
                    do{
                        cosa = JOptionPane.showInputDialog("Dame el numero de telefono que no este en la base de datos");
                    }while(buscarEmpleadoT(cosa)!=null);
                    statement.setString(1, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener la misma oficina o quieres cambiarla:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(2, empleado.getOficina());
                else{
                    cosa = JOptionPane.showInputDialog("Nombre de la oficina");
                    statement.setString(2, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo departamento o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(3, empleado.getDepartamento());
                else{
                    cosa = JOptionPane.showInputDialog("Nombre del departamento");
                    statement.setString(3, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo tipo de contrato o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(4, empleado.getTipoContrato());
                else{
                    cosa = JOptionPane.showInputDialog("Tipo de contrato");
                    statement.setString(4, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo estado o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(5, empleado.getEstado());
                else{
                    cosa = JOptionPane.showInputDialog("Nombre del estado");
                    statement.setString(5, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener la misma ciudad o quieres cambiarla:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(6, empleado.getDepartamento());
                else{
                    cosa = JOptionPane.showInputDialog("Nombre de la ciudad");
                    statement.setString(6, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener la misma calle o quieres cambiarla:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(7, empleado.getCalle());
                else{
                    cosa = JOptionPane.showInputDialog("Nombre de la calle");
                    statement.setString(7, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo codigo postal o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setInt(8, empleado.getCodigoPostal());
                else{
                    cosa = JOptionPane.showInputDialog("Codigo postal");
                    statement.setInt(8, Integer.parseInt(cosa));
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo puesto de trabajo o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setString(9, empleado.getPuestoDeTrabajo());
                else{
                    cosa = JOptionPane.showInputDialog("Puesto de trabajo");
                    statement.setString(9, cosa);
                }
                sel = (String) JOptionPane.showInputDialog(null, 
                "Selecciona una si deseas mantener el mismo sueldo o quieres cambiarlo:", 
                "Menú desplegable", JOptionPane.QUESTION_MESSAGE, null, op, op[0]);
                if(sel.equals("Mantener"))
                    statement.setInt(10, empleado.getSueldo());
                else{
                    cosa = JOptionPane.showInputDialog("Sueldo");
                    statement.setInt(10, Integer.parseInt(cosa));
                }
                statement.setString(11, empleado.getCorreoElectronico());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha actualizado con exito", "Actualizacion exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void eliminarUsuario(String correoElectronico){
        Empleado empleado = buscarEmpleadoC(correoElectronico);
        if(empleado == null)
            JOptionPane.showMessageDialog(null, "No se ha encontrado el empleado a eliminar", "Empleado no encontrado",JOptionPane.ERROR_MESSAGE);
        else{
            try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
                String query = "DELETE FROM Empleado WHERE direccionCorreoElectronico = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, correoElectronico);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente", "Empleado eliminado", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
    
    public void setEmpleado(Empleado empleado){
        this.emp = empleado;
    }
    
    public Empleado getEmpleado(){
        return emp;
    }
    
}
