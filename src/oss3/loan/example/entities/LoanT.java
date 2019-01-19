/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oss3.loan.example.entities;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Thodoris
 */
@Entity
@Table(name = "LOAN")
public class LoanT implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "CAPITAL", precision=20, scale=2)
    private double capital;
    
    @Basic(optional = false)
    @Column(name = "INTERESTRATE", precision=20, scale=2)
    private double interestrate;
    
    @Basic(optional = false)
    @Column(name = "INSTALLMENTSNUMBER")
    private short installmentsnumber;
    
    @OneToMany(mappedBy = "loanId", cascade = CascadeType.ALL)
    private List<InstallmentT> installmentTList;

    public LoanT() {
    }

    public LoanT(Integer id) {
        this.id = id;
    }

    public LoanT(Integer id, int capital, int interestrate, short installmentsnumber) {
        this.id = id;
        this.capital = capital;
        this.interestrate = interestrate;
        this.installmentsnumber = installmentsnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public short getInstallmentsnumber() {
        return installmentsnumber;
    }

    public void setInstallmentsnumber(short installmentsnumber) {
        this.installmentsnumber = installmentsnumber;
    }

    public List<InstallmentT> getInstallmentTList() {
        return installmentTList;
    }

    public void setInstallmentTList(List<InstallmentT> installmentTList) {
        this.installmentTList = installmentTList;
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
        if (!(object instanceof LoanT)) {
            return false;
        }
        LoanT other = (LoanT) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oss3.loan.example.entities.LoanT[ id=" + id + " ]";
    }
    
}
