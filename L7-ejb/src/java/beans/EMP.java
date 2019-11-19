/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author DON
 */
@Entity
public class EMP implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPNO")
    private Long id;
    
    @Column(name= "ENAME")
    private String name;
    
    @Column(name= "JOB")
    private String job;
    
    @Column(name= "MGR")
    private Long manager;
    
    @Column(name= "HIREDATE")
    private Date date;
    
    @Column(name= "SAL")
    private Long sal;
    
    @Column(name= "COMM")
    private Long comm;
    
    @ManyToOne()
    @JoinColumn(name= "DEPTNO")
    private DEPT dept;
    
    public EMP(){}
    
    public static EMP create(Long id, String name, String pos, Long managerid, Long sal, Long comm, DEPT dep){
        EMP empl = new EMP();
        empl.setId(id);
        empl.setName(name);
        empl.setJob(pos);
        empl.setManager(managerid);
        empl.setDate(new Date(System.currentTimeMillis())); 
        empl.setSal(sal);
        empl.setComm(comm);
        empl.setDept(dep);
        return empl;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Long getManager() {
        return manager;
    }

    public void setManager(Long manager) {
        this.manager = manager;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getSal() {
        return sal;
    }

    public void setSal(Long sal) {
        this.sal = sal;
    }

    public Long getComm() {
        return comm;
    }

    public void setComm(Long comm) {
        this.comm = comm;
    }

    public DEPT getDept() {
        return dept;
    }

    public void setDept(DEPT dept) {
        this.dept = dept;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EMP)) {
            return false;
        }
        EMP other = (EMP) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getId() + ": " + getName() + ": " + getDept().getName() + ": " + getSal();
    }

    private DEPTFacade lookupDEPTFacadeBean() {
        try {
            Context c = new InitialContext();
            return (DEPTFacade) c.lookup("java:global/Test/Test-ejb/DEPTFacade!entity.DEPTFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
