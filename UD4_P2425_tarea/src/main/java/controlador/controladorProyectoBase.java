/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.factory.controladorFactory;
import modelo.dao.AvionDAO;
import modelo.dao.PasajeroDAO;
import modelo.dao.UsuarioDAO;
import modelo.vo.Usuario;
import vista.ProyectoBase;

/**
 *
 * @author Acceso a datos
 */
public class controladorProyectoBase {

    //Declaramos los dao
    public static ProyectoBase ventana = new ProyectoBase();

    public static AvionDAO avion;
    public static UsuarioDAO user;
    public static PasajeroDAO pasaj;

    public static void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

    public static void iniciaBD() {

        controladorFactory.abrirBD();
        //instanciar los dao
        // depDAO=controladorFactory.getDepartamentoDAO();
        avion = controladorFactory.getAvionDAO();
        user = controladorFactory.getUsuarioDAO();
        pasaj = controladorFactory.getPasajeroDAO();
    }

    public static void cerrarBD() {
        controladorFactory.cerrarBD();
    }

    public static void iniciarDatos() {
//
//        Usuario  user1=user.buscarQBE(new Usuario("pepe",null));
//        Usuario  user2=user.buscarQBE(new Usuario("pepe2",null));
//        
        
        
        
    }
}
