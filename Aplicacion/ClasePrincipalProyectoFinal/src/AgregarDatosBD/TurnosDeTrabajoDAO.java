package AgregarDatosBD;

import java.sql.*;
import javax.swing.JOptionPane;
import TablasDB.TurnosDeTrabajo;

public class TurnosDeTrabajoDAO {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basededatosprincipal?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "R4ns0mw4r3";
    
    public void crearTurnoDeTrabajo(TurnosDeTrabajo turnoDeTrabajo){
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO TurnosDeTrabajo (turno, horaEs) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, turnoDeTrabajo.getTurno());
            statement.setString(2, turnoDeTrabajo.getHoraES());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha creado un turno con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public TurnosDeTrabajo buscarTurno(String hora){
        TurnosDeTrabajo tdt = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM turnosDeTrabajo WHERE horaES = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, hora);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                tdt = new TurnosDeTrabajo(
                        resultSet.getInt("cveTurno"),
                        resultSet.getString("turno"),
                        resultSet.getString("horaES")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tdt;
    }
    
    public void actualizarTurno(String hora){
        TurnosDeTrabajo tdt = buscarTurno(hora);
        if(tdt == null)
            JOptionPane.showMessageDialog(null, "No se pueden actualizar los datos de un "
                    + "turno que no existe", "Turno no encontrado", JOptionPane.ERROR_MESSAGE);
        else {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "UPDATE turnosDeTrabajo SET turno = ?, horaES = ?"
                        + " WHERE cveTurno = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, tdt.getTurno());
                statement.setString(2, tdt.getHoraES());
                statement.setInt(3, tdt.getCveTurno());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha actualizado con exito", "Actualizacion exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void eliminarTurno(String hora){
        TurnosDeTrabajo tdt = buscarTurno(hora);
        if(tdt == null)
            JOptionPane.showMessageDialog(null, "No se ha encontrado la hora a eliminar", "Hora no encontrada",JOptionPane.ERROR_MESSAGE);
        else {
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                String query = "DELETE FROM turnosDeTrabajo WHERE hora = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, tdt.getHoraES());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Turno eliminado correctamente", "Turno eliminado", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
