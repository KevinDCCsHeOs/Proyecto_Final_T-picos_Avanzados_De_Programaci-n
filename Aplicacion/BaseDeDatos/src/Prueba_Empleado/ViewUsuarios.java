package Prueba_Empleado;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewUsuarios extends JFrame{
    private JPanel contenedor;
    
    private JLabel lblcveUsuario;
    private JLabel lbldireccionCorreoElectronico;
    private JLabel lblnombre;
    private JLabel lblapellidos;
    private JLabel lbltelefono;
    private JLabel lblcontraseña;
    
    protected JTextField txtcveUsuario;
    protected JTextField txtdireccionCorreoElectronico;
    protected JTextField txtnombre;
    protected JTextField txtapellidos;
    protected JTextField txttelefono;
    protected JTextField txtcontraseña;
    
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
    
    private JScrollPane scroll;
    protected Object[][] datos;
    protected String[] cabecera;
    protected DefaultTableModel dtm;
    protected JTable tabla;
    
    public ViewUsuarios(){
        setBounds(550,350,600,500);
        setTitle("Tienda Super");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contenedor = new JPanel();
        getContentPane().add(contenedor);
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        
        lblcveUsuario = new JLabel("Clave Usuario");
        contenedor.add(lblcveUsuario);
        sp.putConstraint(SpringLayout.NORTH, lblcveUsuario, 20, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblcveUsuario, 10, SpringLayout.WEST, contenedor);
        lbldireccionCorreoElectronico = new JLabel("Correo Electronico");
        contenedor.add(lbldireccionCorreoElectronico);
        sp.putConstraint(SpringLayout.NORTH, lbldireccionCorreoElectronico,40, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbldireccionCorreoElectronico, 10, SpringLayout.WEST, contenedor);
        lblnombre = new JLabel("Nombre");
        contenedor.add(lblnombre);
        sp.putConstraint(SpringLayout.NORTH, lblnombre,60, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblnombre, 10, SpringLayout.WEST, contenedor);
        lblapellidos = new JLabel("Apellidos");
        contenedor.add(lblapellidos);
        sp.putConstraint(SpringLayout.NORTH, lblapellidos,80, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblapellidos, 10, SpringLayout.WEST, contenedor);
        lbltelefono = new JLabel("Telefono");
        contenedor.add(lbltelefono);
        sp.putConstraint(SpringLayout.NORTH, lbltelefono,100, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbltelefono, 10, SpringLayout.WEST, contenedor);
        lblcontraseña = new JLabel("Contraseña");
        contenedor.add(lblcontraseña);
        sp.putConstraint(SpringLayout.NORTH, lblcontraseña,120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblcontraseña, 10, SpringLayout.WEST, contenedor);
        
        txtcveUsuario = new JTextField();
        contenedor.add(txtcveUsuario);
        sp.putConstraint(SpringLayout.NORTH, txtcveUsuario, 20, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtcveUsuario, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtcveUsuario, 350, SpringLayout.WEST, contenedor);
        txtdireccionCorreoElectronico = new JTextField();
        contenedor.add(txtdireccionCorreoElectronico);
        sp.putConstraint(SpringLayout.NORTH, txtdireccionCorreoElectronico, 40, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtdireccionCorreoElectronico, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtdireccionCorreoElectronico, 350, SpringLayout.WEST, contenedor);
        txtnombre = new JTextField();
        contenedor.add(txtnombre);
        sp.putConstraint(SpringLayout.NORTH, txtnombre, 60, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtnombre, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtnombre, 350, SpringLayout.WEST, contenedor);
        txtapellidos = new JTextField();
        contenedor.add(txtapellidos);
        sp.putConstraint(SpringLayout.NORTH, txtapellidos, 80, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtapellidos, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtapellidos, 350, SpringLayout.WEST, contenedor);
        txttelefono = new JTextField();
        contenedor.add(txttelefono);
        sp.putConstraint(SpringLayout.NORTH, txttelefono, 100, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txttelefono, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txttelefono, 350, SpringLayout.WEST, contenedor);
        txtcontraseña = new JTextField();
        contenedor.add(txtcontraseña);
        sp.putConstraint(SpringLayout.NORTH, txtcontraseña, 120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtcontraseña, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtcontraseña, 350, SpringLayout.WEST, contenedor);
        
        scroll = new JScrollPane();
        cabecera = new String[]{"Clave Usuario","Correo Electronico","Nombre","Apellidos","Telefono","Contraseña"};
        dtm = new DefaultTableModel(datos,cabecera);
        tabla = new JTable(dtm);
        scroll.setViewportView(tabla);
        contenedor.add(scroll);
        sp.putConstraint(SpringLayout.NORTH, scroll, 150, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, scroll, 10, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, scroll, -10, SpringLayout.EAST, contenedor);
        sp.putConstraint(SpringLayout.SOUTH, scroll, -150, SpringLayout.SOUTH, contenedor);
        
        btnAdd = new JButton("Agregar");
        contenedor.add(btnAdd);
        sp.putConstraint(SpringLayout.SOUTH, btnAdd, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnAdd, 80, SpringLayout.WEST, contenedor);
        btnDel = new JButton("Borrar");
        contenedor.add(btnDel);
        sp.putConstraint(SpringLayout.SOUTH, btnDel, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnDel, 210, SpringLayout.WEST, contenedor);
        btnUpd = new JButton("Modificar");
        contenedor.add(btnUpd);
        sp.putConstraint(SpringLayout.SOUTH, btnUpd, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnUpd, 330, SpringLayout.WEST, contenedor);
        setVisible(true);
    }
    
    public void conectaControlador(ControllerUsuario c){
        btnAdd.addActionListener(c);
        btnAdd.setActionCommand("INSERTAR");
        btnDel.addActionListener(c);
        btnDel.setActionCommand("BORRAR");
        btnUpd.addActionListener(c);
        btnUpd.setActionCommand("MODIFICAR");
        tabla.addMouseListener(c);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
