/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oss3.loan.example.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thodoris
 */
@Entity
@Table(name = "INSTALLMENT")
public class InstallmentT implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "NUMBER")
    private short number;
    
    @Basic(optional = false)
    @Column(name = "BASICAMOUNT", precision=20, scale=2)
    private double basicamount;
    
    @Basic(optional = false)
    @Column(name = "INTEREST", precision=20, scale=2)
    private double interest;
    
    @Basic(optional = false)
    @Column(name = "TOTALAMOUNT", precision=20, scale=2)
    private double totalamount;
    
    @Basic(optional = false)
    @Column(name = "REMAININGCAPITAL", precision=20, scale=2)
    private double remainingcapital;
    
    @JoinColumn(name = "LOAN_ID", referencedColumnName = "ID")
    @ManyToOne
    private LoanT loanId;

    public InstallmentT() {
    }

    public InstallmentT(Integer id) {
        this.id = id;
    }

    public InstallmentT(Integer id, short number, int basicamount, int interest, int totalamount, int remainingcapital) {
        this.id = id;
        this.number = number;
        this.basicamount = basicamount;
        this.interest = interest;
        this.totalamount = totalamount;
        this.remainingcapital = remainingcapital;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public double getBasicamount() {
        return basicamount;
    }

    public void setBasicamount(double basicamount) {
        this.basicamount = basicamount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public double getRemainingcapital() {
        return remainingcapital;
    }

    public void setRemainingcapital(double remainingcapital) {
        this.remainingcapital = remainingcapital;
    }

    public LoanT getLoanId() {
        return loanId;
    }

    public void setLoanId(LoanT loanId) {
        this.loanId = loanId;
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
        if (!(object instanceof InstallmentT)) {
            return false;
        }
        InstallmentT other = (InstallmentT) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "oss3.loan.example.entities.InstallmentT[ id=" + id + " ]";
    }
    
}
