package practicaMVC;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame{
    private JPanel contenedor;
    
    private JLabel lblid_producto;
    private JLabel lbldescripcion;
    private JLabel lblprecio_intro;
    private JLabel lblprecio_lista;
    private JLabel lbltipo_producto;
    private JLabel lblunidad_medida;
    private JLabel lblimagen;
    
    protected JTextField txtid_producto;
    protected JTextField txtdescripcion;
    protected JTextField txtprecio_intro;
    protected JTextField txtprecio_lista;
    protected JTextField txttipo_producto;
    protected JTextField txtunidad_medida;
    
    protected JButton btnAdd;
    protected JButton btnDel;
    protected JButton btnUpd;
    protected JButton btnSalir;
    
    private JScrollPane scroll;
    protected Object[][] datos;
    protected String[] cabecera;
    protected DefaultTableModel dtm;
    protected JTable tabla;
    
    public View(){
        setBounds(400,100,600,500);
        setTitle("Tienda Super");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contenedor = new JPanel();
        getContentPane().add(contenedor);
        SpringLayout sp = new SpringLayout();
        contenedor.setLayout(sp);
        
        lblid_producto = new JLabel("id_producto");
        contenedor.add(lblid_producto);
        sp.putConstraint(SpringLayout.NORTH, lblid_producto, 20, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblid_producto, 10, SpringLayout.WEST, contenedor);
        lbldescripcion = new JLabel("Descripcion");
        contenedor.add(lbldescripcion);
        sp.putConstraint(SpringLayout.NORTH, lbldescripcion,40, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbldescripcion, 10, SpringLayout.WEST, contenedor);
        lblprecio_intro = new JLabel("Precio intro");
        contenedor.add(lblprecio_intro);
        sp.putConstraint(SpringLayout.NORTH, lblprecio_intro,60, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblprecio_intro, 10, SpringLayout.WEST, contenedor);
        lblprecio_lista = new JLabel("Precio de lista");
        contenedor.add(lblprecio_lista);
        sp.putConstraint(SpringLayout.NORTH, lblprecio_lista,80, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblprecio_lista, 10, SpringLayout.WEST, contenedor);
        lbltipo_producto = new JLabel("Tipo producto");
        contenedor.add(lbltipo_producto);
        sp.putConstraint(SpringLayout.NORTH, lbltipo_producto,100, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lbltipo_producto, 10, SpringLayout.WEST, contenedor);
        lblunidad_medida = new JLabel("Unidad de medida");
        contenedor.add(lblunidad_medida);
        sp.putConstraint(SpringLayout.NORTH, lblunidad_medida,120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, lblunidad_medida, 10, SpringLayout.WEST, contenedor);
        lblimagen = new JLabel();
        lblimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/practicaMVC/tienda.jpg")));
        contenedor.add(lblimagen);
        sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblimagen, 70, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblimagen, 450, SpringLayout.NORTH, contenedor);
        
        txtid_producto = new JTextField();
        contenedor.add(txtid_producto);
        sp.putConstraint(SpringLayout.NORTH, txtid_producto, 20, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtid_producto, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtid_producto, 350, SpringLayout.WEST, contenedor);
        txtdescripcion = new JTextField();
        contenedor.add(txtdescripcion);
        sp.putConstraint(SpringLayout.NORTH, txtdescripcion, 40, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtdescripcion, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtdescripcion, 350, SpringLayout.WEST, contenedor);
        txtprecio_intro = new JTextField();
        contenedor.add(txtprecio_intro);
        sp.putConstraint(SpringLayout.NORTH, txtprecio_intro, 60, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtprecio_intro, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtprecio_intro, 350, SpringLayout.WEST, contenedor);
        txtprecio_lista = new JTextField();
        contenedor.add(txtprecio_lista);
        sp.putConstraint(SpringLayout.NORTH, txtprecio_lista, 80, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtprecio_lista, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtprecio_lista, 350, SpringLayout.WEST, contenedor);
        txttipo_producto = new JTextField();
        contenedor.add(txttipo_producto);
        sp.putConstraint(SpringLayout.NORTH, txttipo_producto, 100, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txttipo_producto, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txttipo_producto, 350, SpringLayout.WEST, contenedor);
        txtunidad_medida = new JTextField();
        contenedor.add(txtunidad_medida);
        sp.putConstraint(SpringLayout.NORTH, txtunidad_medida, 120, SpringLayout.NORTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, txtunidad_medida, 120, SpringLayout.WEST, contenedor);
        sp.putConstraint(SpringLayout.EAST, txtunidad_medida, 350, SpringLayout.WEST, contenedor);
        
        scroll = new JScrollPane();
        cabecera = new String[]{"ID_producto","Descripción","Precio intro","Precio lista","Tipo producto","Unidad medida"};
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
        btnSalir = new JButton("Salir");
        contenedor.add(btnSalir);
        sp.putConstraint(SpringLayout.SOUTH, btnSalir, -10, SpringLayout.SOUTH, contenedor);
        sp.putConstraint(SpringLayout.WEST, btnSalir, 450, SpringLayout.WEST, contenedor);
        setVisible(true);
    }
    
    public void conectaControlador(Controler c){
        btnAdd.addActionListener(c);
        btnAdd.setActionCommand("INSERTAR");
        btnDel.addActionListener(c);
        btnDel.setActionCommand("BORRAR");
        btnUpd.addActionListener(c);
        btnUpd.setActionCommand("MODIFICAR");
        btnSalir.addActionListener(c);
        btnSalir.setActionCommand("SALIR");
        tabla.addMouseListener(c);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
}
