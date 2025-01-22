/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import com.db4o.ObjectSet;
import com.db4o.query.Query;
import controlador.controladorProyectoBase;
import controlador.factory.controladorFactory;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import modelo.vo.Departamentos;
import modelo.vo.Empleados;

/**
 *
 * @author hector.garaboacasas
 */
public class DepartamentoDAO {

    public void insertar(Departamentos d1) {
  
       controladorFactory.getBD().store(d1);
        
    
    }

    public Departamentos buscarQBE(Departamentos d) {
   
        
        
        ObjectSet result=controladorFactory.getBD().queryByExample(d);
    
        if(result.hasNext()){
            return (Departamentos)result.next();
        }else{
            return null;
        }
     
    }

    public void modificar(Departamentos d1) {
   controladorFactory.getBD().store(d1);  }
    
    
    public void cargaComboSODA(DefaultComboBoxModel modelocombo){
        Departamentos d;
        modelocombo.removeAllElements();
        Query q=controladorFactory.getBD().query();
        q.constrain(Departamentos.class);//condicion
        
        ObjectSet result=q.execute();
        while(result.hasNext()){
            d=(Departamentos)result.next();
            modelocombo.addElement(d);
        }
        
    }
    

    public void cargarCombo(DefaultComboBoxModel modelocombo) {
  
        Departamentos d;
        modelocombo.removeAllElements();
        
        ObjectSet result=controladorFactory.getBD().queryByExample(new Departamentos() );
    
        while(result.hasNext()){
        d=(Departamentos)result.next();
        modelocombo.addElement(d);
        
    }
        
    }

    public void insertarQBE(Departamentos d, Empleados e) {
  
       List<Empleados> lista=d.getEmpleadosList();
       lista.add(e);
       d.setEmpleadosList(lista);
       
        
    controladorFactory.getBD().store(d);
    
    }
    
}
