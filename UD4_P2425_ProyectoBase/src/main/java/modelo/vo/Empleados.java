/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.vo;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Acceso a datos.
 */
@Entity
@Table(name = "empleados")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByEmpNo", query = "SELECT e FROM Empleados e WHERE e.empNo = :empNo"),
    @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleados.findByOficio", query = "SELECT e FROM Empleados e WHERE e.oficio = :oficio"),
    @NamedQuery(name = "Empleados.findByDir", query = "SELECT e FROM Empleados e WHERE e.dir = :dir"),
    @NamedQuery(name = "Empleados.findByFechaAlt", query = "SELECT e FROM Empleados e WHERE e.fechaAlt = :fechaAlt"),
    @NamedQuery(name = "Empleados.findBySalario", query = "SELECT e FROM Empleados e WHERE e.salario = :salario"),
    @NamedQuery(name = "Empleados.findByComision", query = "SELECT e FROM Empleados e WHERE e.comision = :comision")})
public class Empleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "emp_no")
    private Short empNo;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "oficio")
    private String oficio;
    @Column(name = "dir")
    private Short dir;
    @Column(name = "fecha_alt")
    @Temporal(TemporalType.DATE)
    private Date fechaAlt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Float salario;
    @Column(name = "comision")
    private Float comision;
    @JoinColumn(name = "dept_no", referencedColumnName = "dept_no")
    @ManyToOne(optional = false)
    //cambio realizado por coherencia con la clase Departamentos.
    // private Departamentos deptNo; //este nombre debe ser el mismo en ambas clases
    private Departamentos departamentos;

    public Empleados() {
    }

    //Constructor para el enunciado 5
    public Empleados(short id, String apellido, String oficio, short dir, float sal, Departamentos departamento) {
        this.empNo = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.dir = dir;
        this.fechaAlt = Date.from(Instant.now());
        this.salario = sal;
        this.comision = null;
        this.departamentos = departamento;
    }
    
    public Empleados(Short id, String apellido, Float sal, Departamentos departamento) {
        this.empNo = id;
        this.apellido = apellido;
        
        
        this.fechaAlt = Date.from(Instant.now());
        this.salario = sal;
        
        this.departamentos = departamento;
    }

    public Empleados(Short empNo) {
        this.empNo = empNo;
    }

    public Short getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Short empNo) {
        this.empNo = empNo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public Short getDir() {
        return dir;
    }

    public void setDir(Short dir) {
        this.dir = dir;
    }

    public Date getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

//    public Departamentos getDeptNo() {
//        return deptNo;
//    }
//
//    public void setDeptNo(Departamentos deptNo) {
//        this.deptNo = deptNo;
//    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empNo != null ? empNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.empNo == null && other.empNo != null) || (this.empNo != null && !this.empNo.equals(other.empNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.vo.Empleados[ empNo=" + empNo + " ]";
    }

}
