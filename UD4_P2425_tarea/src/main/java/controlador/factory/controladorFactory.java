/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.factory;
//
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import modelo.dao.AvionDAO;
import modelo.dao.PasajeroDAO;
import modelo.dao.UsuarioDAO;


/**
 *
 * @author Acceso a datos
 */
public class controladorFactory {
    static String BDEmpresa = "./src/main/java/BD/ejemplo.db40";
    static ObjectContainer bd;

    public static void abrirBD() {
        bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDEmpresa);
    }

    public static void cerrarBD() {
        bd.close();
    }

    public static ObjectContainer getBD() {
        return bd;
    }
    
    public static PasajeroDAO getPasajeroDAO() {
        return new PasajeroDAO();
    }
     public static AvionDAO getAvionDAO() {
        return new AvionDAO();
    }
      public static UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
    
    
}
