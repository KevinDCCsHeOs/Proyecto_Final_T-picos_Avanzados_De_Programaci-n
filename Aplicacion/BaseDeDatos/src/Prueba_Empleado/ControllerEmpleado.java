package Prueba_Empleado;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class ControllerEmpleado implements ActionListener, MouseListener{
    
    private ViewEmpleado viewE;
    
    public ControllerEmpleado(ViewEmpleado viewE){
        this.viewE = viewE;
        cargarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        PreparedStatement cs;
        String comando = arg0.getActionCommand();
        
        switch(comando){
            case "INSERTAR":
                try{
                    cs = BaseDeDatosUsuarios.getConexion().prepareStatement("INSERT INTO Empleado VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    cs.setInt(1,Integer.parseInt(this.viewE.txtfolioEmpleado.getText()));
                    cs.setString(2, this.viewE.txtnombre.getText());
                    cs.executeUpdate();
                } catch (SQLException e){
                    System.err.println("Error en la inserción");
                }
                break;
            case "BORRAR":
                int filaPulsada = this.viewE.tabla.getSelectedRow();
                if(filaPulsada >= 0){
                    int identificador = (int) this.viewE.dtm.getValueAt(filaPulsada, 0);
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
                filaPulsada = this.viewE.tabla.getSelectedRow();
                if(filaPulsada >= 0){
                    int identificador = (int) this.viewE.dtm.getValueAt(filaPulsada,0);
                    try{
                        cs = BaseDeDatosUsuarios.getConexion().prepareStatement("UPDATE Empleado SET folioEmpleado = ?,"
                                + " nombre = ?, apellidos = ?, correoElectronico = ?, telefono = ?, oficina = ?, departamento = ?, "
                                + "tipoContrato = ?, estado = ?, ciudad = ?, calle = ?, codigoPostal = ?, fechaDeNacimiento = ?, "
                                + "puestoDeTrabajo = ?, genero = ?, sueldo = ?, curp = ?, rfc = ?,"
                                + "contraseña = ? WHERE folioEmpleado = ?");
                        cs.setInt(1, identificador);
                        cs.setString(2, this.viewE.txtnombre.getText());
                        cs.setString(3, this.viewE.txtapellidos.getText());
                        cs.setString(4, this.viewE.txtcorreoElectronico.getText());
                        cs.setString(5, this.viewE.txttelefono.getText());
                        cs.setString(6, this.viewE.txtoficina.getText());
                        cs.setString(7, this.viewE.txtdepartamento.getText());
                        cs.setString(8, this.viewE.txttipoContrato.getText());
                        cs.setString(9, this.viewE.txtestado.getText());
                        cs.setString(10, this.viewE.txtciudad.getText());
                        cs.setString(11, this.viewE.txtcalle.getText());
                        cs.setInt(12, Integer.parseInt(this.viewE.txtcodigoPostal.getText()));
                        cs.setString(13, this.viewE.txtfechaDeNacimiento.getText());
                        cs.setString(14, this.viewE.txtpuestoDeTrabajo.getText());
                        cs.setString(15, this.viewE.txtgenero.getText());
                        cs.setInt(16, Integer.parseInt(this.viewE.txtsueldo.getText()));
                        cs.setString(17, this.viewE.txtcurp.getText());
                        cs.setString(18, this.viewE.txtrfc.getText());
                        cs.setString(19, this.viewE.txtcontraseña.getText());
                        cs.setInt(20, Integer.parseInt(this.viewE.txtfolioEmpleado.getText()));
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
        this.viewE.txtfolioEmpleado.setText("");
        this.viewE.txtnombre.setText("");
        this.viewE.txtapellidos.setText("");
        this.viewE.txtcorreoElectronico.setText("");
        this.viewE.txttelefono.setText("");
        this.viewE.txtoficina.setText("");
        this.viewE.txtdepartamento.setText("");
    }
    
    protected void cargarTabla(){
        PreparedStatement cs;
        ResultSet rs;
        ArrayList<Object> fila;
        for(int i = this.viewE.dtm.getRowCount(); i > 0; i--){
            this.viewE.dtm.removeRow(i-1);
        }
        try{
            cs = BaseDeDatosUsuarios.getConexion().prepareStatement("SELECT * FROM Empleado");
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
                this.viewE.dtm.addRow(arreglo);
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
        int filaPulsada = this.viewE.tabla.getSelectedRow();
        if(filaPulsada >= 0){
            int identificador = (int) this.viewE.dtm.getValueAt(filaPulsada,0);
            try{
                cs = BaseDeDatosUsuarios.getConexion().prepareStatement("SELECT folioEmpleado,"
                        + "nombre,apellidos,correoElectronico,telefono,oficina,departamento,"
                        + "tipoContrato,estado,ciudad,calle,codigoPostal,fechaDeNacimiento,"
                        + "puestoDeTrabajo,genero,sueldo,curp,rfc,contraseña"
                        + " FROM Empleado WHERE folioEmpleado = ?");
                cs.setInt(1, identificador);
                rs = cs.executeQuery();
                if (rs.next()){
                    this.viewE.txtfolioEmpleado.setText(rs.getString(1));
                    this.viewE.txtnombre.setText(rs.getString(2));
                    this.viewE.txtapellidos.setText(rs.getString(3));
                    this.viewE.txtcorreoElectronico.setText(rs.getString(4));
                    this.viewE.txttelefono.setText(rs.getString(5));
                    this.viewE.txtoficina.setText(rs.getString(6));
                    this.viewE.txtdepartamento.setText(rs.getString(7));
                    this.viewE.txttipoContrato.setText(rs.getString(8));
                    this.viewE.txtestado.setText(rs.getString(9));
                    this.viewE.txtciudad.setText(rs.getString(10));
                    this.viewE.txtcalle.setText(rs.getString(11));
                    this.viewE.txtcodigoPostal.setText(rs.getString(12));
                    this.viewE.txtfechaDeNacimiento.setText(rs.getString(13));
                    this.viewE.txtpuestoDeTrabajo.setText(rs.getString(14));
                    this.viewE.txtgenero.setText(rs.getString(15));
                    this.viewE.txtsueldo.setText(rs.getString(16));
                    this.viewE.txtcurp.setText(rs.getString(17));
                    this.viewE.txtrfc.setText(rs.getString(18));
                    this.viewE.txtcontraseña.setText(rs.getString(19));
                    System.err.println(this.viewE.dtm.getValueAt(filaPulsada,0));
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
