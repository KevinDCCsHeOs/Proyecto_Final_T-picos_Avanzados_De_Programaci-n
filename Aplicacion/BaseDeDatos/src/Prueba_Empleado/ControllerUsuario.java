package Prueba_Empleado;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class ControllerUsuario implements ActionListener, MouseListener{

    private ViewUsuarios viewU;
    
    public ControllerUsuario(ViewUsuarios viewU){
        this.viewU = viewU;
        cargarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        PreparedStatement cs;
        String comando = arg0.getActionCommand();
        
        switch(comando){
            case "INSERTAR":
                try{
                    cs = BaseDeDatosUsuarios.getConexion().prepareStatement("INSERT INTO Usuarios VALUES (?,?,?,?,?,?)");
                    cs.setInt(1,Integer.parseInt(this.viewU.txtcveUsuario.getText()));
                    cs.setString(2, this.viewU.txtdireccionCorreoElectronico.getText());
                    cs.setString(3, this.viewU.txtnombre.getText());
                    cs.setString(4, this.viewU.txtapellidos.getText());
                    cs.setString(5, this.viewU.txttelefono.getText());
                    cs.setString(6, this.viewU.txtcontraseña.getText());
                    cs.executeUpdate();
                } catch (SQLException e){
                    System.err.println("Error en la inserción");
                }
                break;
            case "BORRAR":
                int filaPulsada = this.viewU.tabla.getSelectedRow();
                if(filaPulsada >= 0){
                    int identificador = (int) this.viewU.dtm.getValueAt(filaPulsada, 0);
                    try{
                        cs = BaseDeDatosUsuarios.getConexion().prepareStatement("DELETE FROM Usuarios WHERE cveUsuario = ?");
                        cs.setInt(1, identificador);
                        cs.execute();
                    }catch (SQLException e){
                        System.err.println("Error en el borrado");
                        e.printStackTrace();
                    }
                }
                break;
            case "MODIFICAR":
                filaPulsada = this.viewU.tabla.getSelectedRow();
                if(filaPulsada >= 0){
                    int identificador = (int) this.viewU.dtm.getValueAt(filaPulsada,0);
                    try{
                        cs = BaseDeDatosUsuarios.getConexion().prepareStatement("UPDATE Usuarios SET cveUsuario = ?,"
                                + "direccionCorreoElectronico = ?, nombre = ?, apellidos = ?, telefono = ?,"
                                + "contraseña = ? WHERE cveUsuario = ?");
                        cs.setInt(1, identificador);
                        cs.setString(2, this.viewU.txtdireccionCorreoElectronico.getText());
                        cs.setDouble(3, Double.parseDouble(this.viewU.txtnombre.getText()));
                        cs.setDouble(4, Double.parseDouble(this.viewU.txtapellidos.getText()));
                        cs.setInt(5, Integer.parseInt(this.viewU.txttelefono.getText()));
                        cs.setString(6, this.viewU.txtcontraseña.getText());
                        cs.setInt(7, Integer.parseInt(this.viewU.txtcveUsuario.getText()));
                        cs.executeUpdate();
                    }catch (SQLException e){
                        System.err.println("Error en la modificación");
                        e.printStackTrace();
                    }
                }
                break;
            default:
                System.err.println("Comando no definido");
                break;
        }
        limpiar();
        cargarTabla();
    }
    
    private void limpiar(){
        this.viewU.txtcveUsuario.setText("");
        this.viewU.txtdireccionCorreoElectronico.setText("");
        this.viewU.txtnombre.setText("");
        this.viewU.txtapellidos.setText("");
        this.viewU.txttelefono.setText("");
        this.viewU.txtcontraseña.setText("");
    }
    
    protected void cargarTabla(){
        PreparedStatement cs;
        ResultSet rs;
        ArrayList<Object> fila;
        for(int i = this.viewU.dtm.getRowCount(); i > 0; i--){
            this.viewU.dtm.removeRow(i-1);
        }
        try{
            cs = BaseDeDatosUsuarios.getConexion().prepareStatement("SELECT * FROM Usuarios");
            rs = cs.executeQuery();
            while(rs.next()){
                fila = new ArrayList<>();
                fila.add(rs.getInt("cveUsuario"));
                fila.add(rs.getString("direccionCorreoElectronico"));
                fila.add(rs.getString("nombre"));
                fila.add(rs.getString("apellidos"));
                fila.add(rs.getString("telefono"));
                fila.add(rs.getString("contraseña"));
                Object [] arreglo = (Object[])fila.toArray();
                this.viewU.dtm.addRow(arreglo);
            }
        }catch (SQLException e){
            System.err.println(e.toString());
            System.err.println("ERROR AL CARGAR DATOS");
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        PreparedStatement cs;
        ResultSet rs;
        int filaPulsada = this.viewU.tabla.getSelectedRow();
        if(filaPulsada >= 0){
            int identificador = (int) this.viewU.dtm.getValueAt(filaPulsada,0);
            try{
                cs = BaseDeDatosUsuarios.getConexion().prepareStatement("SELECT cveUsuario,direccionCorreoElectronico,nombre,"
                        + "apellidos,telefono,contraseña FROM Usuarios WHERE cveUsuario = ?");
                cs.setInt(1, identificador);
                rs = cs.executeQuery();
                if (rs.next()){
                    this.viewU.txtcveUsuario.setText(rs.getString(1));
                    this.viewU.txtdireccionCorreoElectronico.setText(rs.getString(2));
                    this.viewU.txtnombre.setText(rs.getString(3));
                    this.viewU.txtapellidos.setText(rs.getString(4));
                    this.viewU.txttelefono.setText(rs.getString(5));
                    this.viewU.txtcontraseña.setText(rs.getString(6));
                    System.err.println(this.viewU.dtm.getValueAt(filaPulsada,0));
                }
            }catch (SQLException e){
                System.err.println("Error al cargar un usuario");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}
    
}
