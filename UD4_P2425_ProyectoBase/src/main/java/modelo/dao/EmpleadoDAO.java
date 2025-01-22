/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import controlador.factory.controladorFactory;
import java.util.List;
import modelo.vo.Empleados;

/**
 *
 * @author hector.garaboacasas
 */
public class EmpleadoDAO {

    public Empleados comprobarEmp(Empleados empleado) {

        ObjectSet result = controladorFactory.getBD().queryByExample(empleado);

        if (result.hasNext()) {
            return (Empleados) result.next();
        } else {
            return null;
        }

    }

    public Empleados comprobarSODA(Empleados e) {

        Query q = controladorFactory.getBD().query();
        q.constrain(Empleados.class);
        
        short id=e.getEmpNo();

        q.descend("empNo").constrain(id).equal();
        ObjectSet result = q.execute();
        if (result.hasNext()) {
            
            return (Empleados) result.next();
        } else {
            return null;
        }

    }

    public Empleados comprobarNative(Empleados e) {

        List<Empleados> result = controladorFactory.getBD().query(new Predicate<Empleados>() {

            public boolean match(Empleados e1) {
                return e1.getEmpNo().equals(e.getEmpNo());
            }
        });

//         if (result.size()==1) {
//            return (Empleados) result.getFirst();
//        } else {
            return result.getFirst();
        
    
    }

    public void modificar(Empleados e) {
   
         controladorFactory.getBD().store(e);
    
    }

    public void borrarQBE(Empleados e) {
    controladorFactory.getBD().delete(e);
    }

    public Empleados comprobarNativeInsertar(Empleados e) {
   
        List<Empleados> result = controladorFactory.getBD().query(new Predicate<Empleados>() {

            public boolean match(Empleados e1) {
                return e1.getEmpNo().equals(e.getEmpNo());
            }
        });

         if (result.size()==1) {
            return (Empleados) result.getFirst();
        } else {
            return null;
        }
    
    }

}
