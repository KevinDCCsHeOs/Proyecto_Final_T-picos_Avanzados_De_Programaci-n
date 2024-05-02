package AgregarDatosBD;

import TablasDB.Usuario;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/basededatosprincipal?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "R4ns0mw4r3";
    private Usuario usu;

    public void crearUsuario(Usuario usuario) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO Usuarios (direccionCorreoElectronico,nombre,apellidos,telefono,contraseña) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, usuario.getDireccionCorreoElectronico());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getApellidos());
            statement.setString(4, usuario.getTelefono());
            statement.setString(5, usuario.getContraseña());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha creado con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario buscarUsuarioCP(String correoElectronico, String contraseña) {
        Usuario usuario = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Usuarios WHERE direccionCorreoElectronico = ? AND  contraseña = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, correoElectronico);
            statement.setString(2, contraseña);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario(
                        resultSet.getInt("cveUsuario"),
                    resultSet.getString("direccionCorreoElectronico"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("telefono"),
                    resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public Usuario buscarUsuarioC(String correoElectronico) {
        Usuario usuario = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Usuarios WHERE direccionCorreoElectronico = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, correoElectronico);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario(
                    resultSet.getString("direccionCorreoElectronico"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("telefono"),
                    resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public Usuario buscarUsuarioT(String telefono) {
        Usuario usuario = null;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM Usuarios WHERE telefono = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, telefono);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                usuario = new Usuario(
                    resultSet.getString("direccionCorreoElectronico"),
                    resultSet.getString("nombre"),
                    resultSet.getString("apellidos"),
                    resultSet.getString("telefono"),
                    resultSet.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void actualizarUsuario(Usuario usuario) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "UPDATE Usuarios SET Nombre = ?, Apellidos = ?, Contraseña = ? WHERE direccionCorreoElectronico = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getApellidos());
            statement.setString(3, usuario.getContraseña());
            statement.setString(4, usuario.getDireccionCorreoElectronico());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(String direccionCorreoElectronico) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "DELETE FROM Usuarios WHERE direccionCorreoElectronico = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, direccionCorreoElectronico);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void setUsuario(Usuario us){
        usu = us;
    }
    
    public Usuario getUsu(){
        return usu;
    }
    
}
