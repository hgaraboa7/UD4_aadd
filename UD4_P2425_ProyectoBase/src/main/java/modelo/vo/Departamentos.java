/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author Acceso a datos
 */
@Data  //Esta opción junto a la librería de lombok permite quitar los getter/setter y toString
@Entity
@Table(name = "departamentos")
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d"),
    @NamedQuery(name = "Departamentos.findByDeptNo", query = "SELECT d FROM Departamentos d WHERE d.deptNo = :deptNo"),
    @NamedQuery(name = "Departamentos.findByDnombre", query = "SELECT d FROM Departamentos d WHERE d.dnombre = :dnombre"),
    @NamedQuery(name = "Departamentos.findByLoc", query = "SELECT d FROM Departamentos d WHERE d.loc = :loc")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dept_no")
    private Short deptNo;
    @Column(name = "dnombre")
    private String dnombre;
    @Column(name = "loc")
    private String loc;
    //ES IMPORTANTE QUE LE QUITES EL cascade. Nosotros haremos el borrado en cascada
    // por código y no que lo haga la base de datos.  
    
    //La opción de cambiar deptNo por departamentos ya es opcional. Lo hago porque creo que
    //se comprende mejor. Acuerdate de cambiarlo también en la clase empleados.
    //Este cambio no es obligario hacerlo.
    
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptNo")   
    @OneToMany(mappedBy = "departamentos")
    private List<Empleados> empleadosList;

    public Departamentos() {
    }

    //Constructor creado para el enunciado 3 para dar de alta un departamento.
    public Departamentos(Short deptNo, String dnombre, String loc) {
        this.deptNo = deptNo;
        this.dnombre = dnombre;
        this.loc = loc;
        this.empleadosList=new ArrayList<>();
    }

    public Departamentos(Short deptNo) {
        this.deptNo = deptNo;
    }
    
    //En el combo del enunciado 2 queremos que cargue el nombre
    @Override
    public String toString(){
        return this.dnombre;
    }
}
