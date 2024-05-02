package AgregarDatosBD;

import java.sql.*;
import javax.swing.JOptionPane;
import TablasDB.EmpleadoTurno;

public class EmpleadoTurnoDAO {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basededatosprincipal?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "R4ns0mw4r3";
    
    public void agregarEmpleadoTurno(String correo, String hora){
        EmpleadoDAO emp = null;
        emp.setEmpleado(emp.buscarEmpleadoC(correo));
        TurnosDeTrabajoDAO tur = null;
        if(emp.getEmpleado() == null || tur.buscarTurno(hora) == null)
            return;
        else if(buscarTurnoEmpleadoFC(emp.getEmpleado().getFolioEmpleado(), tur.buscarTurno(hora).getCveTurno()) == null)
            return;
        else{
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "INSERT INTO empleadoTurno (folioEmpleado, cveTurno) VALUES (?, ?)";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, emp.getEmpleado().getFolioEmpleado());
                statement.setInt(2, tur.buscarTurno(hora).getCveTurno());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha asignado un turno a un empleado con éxito",
                        "Terminado",JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public EmpleadoTurno buscarTurnoEmpleadoFC(int folioEmpleado, int cveTurno){
        EmpleadoTurno empDAO = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM EmpleadoTurno WHERE folioEmpleado = ? AND cveTurno = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, folioEmpleado);
            statement.setInt(2, cveTurno);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empDAO = new EmpleadoTurno(
                        resultSet.getInt("folioEmpleado"),
                        resultSet.getInt("cveTurno")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empDAO;
    }
    
    public EmpleadoTurno buscarTurnoEmpleadoF(int folioEmpleado){
        EmpleadoTurno empDAO = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM EmpleadoTurno WHERE folioEmpleado = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, folioEmpleado);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                empDAO = new EmpleadoTurno(
                        resultSet.getInt("folioEmpleado"),
                        resultSet.getInt("cveTurno")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empDAO;
    }
    
    public void actualizarEmpleadoTurno(int folioEmpleado){
        EmpleadoTurno emp = buscarTurnoEmpleadoF(folioEmpleado);
        if(emp == null)
            JOptionPane.showMessageDialog(null, "No se pueden actualizar los datos de un "
                    + "empleado que no tiene turno", "No encontrado", JOptionPane.ERROR_MESSAGE);
        else{
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "UPDATE EmpleadoTurno SET cveTurno = ? WHERE folioEmpleado = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setInt(1, emp.getCveTurno());
                statement.setInt(2, emp.getFolioEmpleado());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha actualizado con exito", "Actualizacion exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
