package practicaMVC;

import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Controler implements ActionListener, MouseListener{
    
    private View view;
    
    public Controler(View view){
        this.view = view;
        cargarTabla();
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0){
        PreparedStatement cs;
        String comando = arg0.getActionCommand();
        
        switch(comando){
            case "INSERTAR":
                try{
                    cs = BaseDatos.getConexion().prepareStatement("INSERT INTO productos (id_producto,descripcion,"
                            + "precio_introductor,precio_detallista,tipo_producto,unidad_medida) VALUES (?,?,?,?,?,?)");
                    cs.setInt(1,Integer.parseInt(this.view.txtid_producto.getText()));
                    cs.setString(2, this.view.txtdescripcion.getText());
                    cs.setDouble(3, Double.parseDouble(this.view.txtprecio_intro.getText()));
                    cs.setDouble(4, Double.parseDouble(this.view.txtprecio_lista.getText()));
                    cs.setInt(5, Integer.parseInt(this.view.txttipo_producto.getText()));
                    cs.setString(6, this.view.txtunidad_medida.getText());
                    cs.executeUpdate();
                } catch (SQLException e){
                    System.err.println("Error en la inserción");
                }
                break;
            case "BORRAR":
                int filaPulsada = this.view.tabla.getSelectedRow();
                if(filaPulsada >= 0){
                    int identificador = (int) this.view.dtm.getValueAt(filaPulsada, 0);
                    try{
                        cs = BaseDatos.getConexion().prepareStatement("DELETE FROM productos WHERE id_producto = ?");
                        cs.setInt(1, identificador);
                        cs.execute();
                    }catch (SQLException e){
                        System.err.println("Error en el borrado");
                        e.printStackTrace();
                    }
                }
                break;
            case "MODIFICAR":
                filaPulsada = this.view.tabla.getSelectedRow();
                if(filaPulsada >= 0){
                    int identificador = (int) this.view.dtm.getValueAt(filaPulsada,0);
                    try{
                        cs = BaseDatos.getConexion().prepareStatement("UPDATE productos SET id_producto = ?,"
                                + "descripcion = ?, precio_introductor = ?, precio_detallista = ?, tipo_producto = ?,"
                                + "unidad_medida = ? WHERE id_producto = ?");
                        cs.setInt(1, identificador);
                        cs.setString(2, this.view.txtdescripcion.getText());
                        cs.setDouble(3, Double.parseDouble(this.view.txtprecio_intro.getText()));
                        cs.setDouble(4, Double.parseDouble(this.view.txtprecio_lista.getText()));
                        cs.setInt(5, Integer.parseInt(this.view.txttipo_producto.getText()));
                        cs.setString(6, this.view.txtunidad_medida.getText());
                        cs.setInt(7, Integer.parseInt(this.view.txtid_producto.getText()));
                        cs.executeUpdate();
                    }catch (SQLException e){
                        System.err.println("Error en la modificación");
                        e.printStackTrace();
                    }
                }
                break;
            case "SALIR":
                view.dispose();
                break;
            default:
                System.err.println("Comando no definido");
                break;
        }
        limpiar();
        cargarTabla();
    }
    
    private void limpiar(){
        this.view.txtid_producto.setText("");
        this.view.txtdescripcion.setText("");
        this.view.txtprecio_intro.setText("");
        this.view.txtprecio_lista.setText("");
        this.view.txttipo_producto.setText("");
        this.view.txtunidad_medida.setText("");
    }
    
    protected void cargarTabla(){
        PreparedStatement cs;
        ResultSet rs;
        ArrayList<Object> fila;
        for(int i = this.view.dtm.getRowCount(); i > 0; i--){
            this.view.dtm.removeRow(i-1);
        }
        try{
            cs = BaseDatos.getConexion().prepareStatement("SELECT * FROM productos");
            rs = cs.executeQuery();
            while(rs.next()){
                fila = new ArrayList<>();
                fila.add(rs.getInt("id_producto"));
                fila.add(rs.getString("descripcion"));
                fila.add(rs.getString("precio_introductor"));
                fila.add(rs.getString("precio_detallista"));
                fila.add(rs.getString("tipo_producto"));
                fila.add(rs.getString("unidad_medida"));
                Object [] arreglo = (Object[])fila.toArray();
                this.view.dtm.addRow(arreglo);
            }
        }catch (SQLException e){
            System.err.println(e.toString());
            System.err.println("ERROR AL CARGAR DATOS");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent arg0){
        PreparedStatement cs;
        ResultSet rs;
        int filaPulsada = this.view.tabla.getSelectedRow();
        if(filaPulsada >= 0){
            int identificador = (int) this.view.dtm.getValueAt(filaPulsada,0);
            try{
                cs = BaseDatos.getConexion().prepareStatement("SELECT id_producto,descripcion,precio_introductor,"
                        + "precio_detallista,tipo_producto,unidad_medida FROM productos WHERE id_producto = ?");
                cs.setInt(1, identificador);
                rs = cs.executeQuery();
                if (rs.next()){
                    this.view.txtid_producto.setText(rs.getString(1));
                    this.view.txtdescripcion.setText(rs.getString(2));
                    this.view.txtprecio_intro.setText(rs.getString(3));
                    this.view.txtprecio_lista.setText(rs.getString(4));
                    this.view.txttipo_producto.setText(rs.getString(5));
                    this.view.txtunidad_medida.setText(rs.getString(6));
                    System.err.println(this.view.dtm.getValueAt(filaPulsada,0));
                }
            }catch (SQLException e){
                System.err.println("Error al cargar un cliente");
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}
    
    @Override
    public void mousePressed(MouseEvent arg0) {}

    @Override
    public void mouseReleased(MouseEvent arg0) {}    
    
}
