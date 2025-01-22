/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.factory.controladorFactory;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.dao.DepartamentoDAO;
import modelo.dao.EmpleadoDAO;
import modelo.vo.Departamentos;
import modelo.vo.Empleados;
import vista.Enunciado1;
import vista.ProyectoBase;

/**
 *
 * @author acceso a datos
 */
public class controladorProyectoBase {

    //Declaramos los dao
    public static Enunciado1 ventana = new Enunciado1();
    public static DepartamentoDAO depDAO;
    public static EmpleadoDAO emp;

    public static DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();

    public static void iniciar() {
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

        ventana.getCbDepartamentos().setModel(modelocombo);
    }

    public static void iniciaBD() {

        controladorFactory.abrirBD();
        //instanciar los dao
        depDAO = controladorFactory.getDepartamentoDAO();

        emp = controladorFactory.getEmpleadoDAO();

    }

    public static void cerrarBD() {
        controladorFactory.cerrarBD();
    }

    //este ejercicio vale 1 punto
    public static void iniciarDatos() {

        Departamentos d200 = depDAO.buscarQBE(new Departamentos(Short.valueOf("200")));
        //buscar el dep100
        Departamentos d100 = depDAO.buscarQBE(new Departamentos(Short.valueOf("100")));

        if (d100 == null) {
            d100 = new Departamentos(Short.valueOf("100"), "recursos", "vimianzo");

            depDAO.insertar(d100);
        }

        if (d200 == null) {
            d200 = new Departamentos(Short.valueOf("200"), "pedidos", "zas");

            depDAO.insertar(d200);
        }

        //empleados
        Empleados e1;
        e1 = new Empleados(Short.valueOf("1234"), "garcia",
                "vendedor", Short.valueOf("111"), 111.1f, d100);

        Empleados e2;
        e2 = new Empleados(Short.valueOf("111"), "pepe",
                "director", Short.valueOf("111"), 666.1f, d100);

        List<Empleados> listaEmpleados = new ArrayList<>();

        listaEmpleados.addAll(d100.getEmpleadosList());

        if (!listaEmpleados.contains(e1)) {
            listaEmpleados.add(e1);
        }
        if (!listaEmpleados.contains(e2)) {
            listaEmpleados.add(e2);
        }
        //modificacion d100 e insercion empleados
        d100.setEmpleadosList(listaEmpleados);
        depDAO.modificar(d100);

        //depDAO.cargarCombo(modelocombo);
        depDAO.cargaComboSODA(modelocombo);

    }

    public static void insertarDep() {

        Departamentos d = depDAO.buscarQBE(new Departamentos(Short.valueOf(ventana.getTxtIdDep().getText())));

        if (d == null) {
            d = new Departamentos(Short.valueOf(ventana.getTxtIdDep().getText()),
                    ventana.getTxtNomDep().getText(),
                    ventana.getTxtLocDep().getText());

            depDAO.insertar(d);
        } else {
            System.out.println("no insertado");
        }

    }

    public static void modificarDep() {

//  
//        
    }

    public static void borrarDep() {

    }

    public static void cargarCombo() {
        depDAO.cargaComboSODA(modelocombo);

    }

    public static void insertarEmp() {

        if (ventana.getTxtIdEmp().getText().isBlank()
                || ventana.getTxtApellidoEmp().getText().isBlank()
                || ventana.getTxtSalarioEmp().getText().isBlank()) {

            JOptionPane.showMessageDialog(null, "faltan datos");
            return;

        }

        //qbe
        // Empleados e = emp.comprobarEmp(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));
        //SODA
        // Empleados e=emp.comprobarSODA(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));
        //NativeQuery
        Empleados e = emp.comprobarNativeInsertar(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));

        Departamentos d = (Departamentos) ventana.getCbDepartamentos().getSelectedItem();

        if (e == null) {
            e = new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText()),
                    ventana.getTxtApellidoEmp().getText(),
                    Float.valueOf(ventana.getTxtSalarioEmp().getText()),
                    d);

            List<Empleados> listaEmpleados = new ArrayList<>();

            listaEmpleados.addAll(d.getEmpleadosList());

            if (!listaEmpleados.contains(e)) {
                listaEmpleados.add(e);

                d.setEmpleadosList(listaEmpleados);
                depDAO.modificar(d);

                System.out.println("insertado");
            } else {
                System.out.println("no insertado 1");
            }

        } else {
            System.out.println("no insertado 2");
        }

    }

    public static void modificarEmp() {

        if (ventana.getTxtIdEmp().getText().isBlank()
                || ventana.getTxtApellidoEmp().getText().isBlank()
                || ventana.getTxtSalarioEmp().getText().isBlank()) {

            JOptionPane.showMessageDialog(null, "faltan datos");
            return;

        }

        //qbe
        //Empleados e = emp.comprobarEmp(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));
        //SODA
        //  Empleados e=emp.comprobarSODA(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));
        //NativeQuery
        Empleados e = emp.comprobarNative(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));

        if (e != null) {
            e.setApellido(ventana.getTxtApellidoEmp().getText());
            e.setSalario(Float.valueOf(ventana.getTxtSalarioEmp().getText()));

            // List<Empleados> listaEmpleados = new ArrayList<>();
            //listaEmpleados.addAll(d.getEmpleadosList());
//            for(Empleados emple:listaEmpleados){//                
//                if(emple.getEmpNo()==e.getEmpNo()){
//                    emple.setApellido(e.getApellido());
//                    emple.setSalario(e.getSalario());                    
            // emp.modificar(e);                   
            // }                     
            // }        
//            d.setEmpleadosList(listaEmpleados);
//            depDAO.modificar(d);
            emp.modificar(e);
            System.out.println("modificado");

        } else {
            System.out.println(" no se puede modificar 2");
        }

    }

    public static void borrarEmp() {

        if (ventana.getTxtIdEmp().getText().isBlank()) {

            JOptionPane.showMessageDialog(null, "faltan datos");
            return;

        }

        //qbe
        //Empleados e = emp.comprobarEmp(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));
        //SODA
          Empleados e=emp.comprobarSODA(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));
        //NativeQuery
        // Empleados e = emp.comprobarNative(new Empleados(Short.valueOf(ventana.getTxtIdEmp().getText())));

        if (e != null) {

            Departamentos d = e.getDepartamentos();

            List<Empleados> listaEmpleados = new ArrayList<>();
            listaEmpleados.addAll(d.getEmpleadosList());

           
                    listaEmpleados.remove(e);
                
            emp.borrarQBE(e);
            d.setEmpleadosList(listaEmpleados);
            depDAO.modificar(d);

            System.out.println("borrado");

        } else {
            System.out.println(" no se puede borrar");
        }

    }

}
