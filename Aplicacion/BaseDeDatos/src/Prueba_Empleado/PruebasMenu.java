package Prueba_Empleado;

import javax.swing.JOptionPane;

public class PruebasMenu {
    
    public static void main(String[] args) {
        String[] valores = {"Usuarios","Empleados","Salir"};
        String sel = "";
        do{
            sel = (String)JOptionPane.showInputDialog(null,"M E N U","SELECCIONA ALGUNA OPCION: ",
					JOptionPane.QUESTION_MESSAGE,null,valores,valores[0]);
            switch(sel){
                case "Usuarios":
                    new BaseDeDatosUsuarios("BDProyectoFinal");
                    ViewUsuarios vista = new ViewUsuarios();
                    ControllerUsuario  controlador = new ControllerUsuario(vista);
                    vista.conectaControlador(controlador);
                    break;
                case "Empleados":
                    break;
                case "Salir":
                    break;
            }
        }while(!sel.equalsIgnoreCase("Salir"));
    }
    
}
