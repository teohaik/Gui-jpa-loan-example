/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oss3.loan.example.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import oss3.loan.example.Installment;
import oss3.loan.example.Loan;
import oss3.loan.example.entities.InstallmentT;
import oss3.loan.example.entities.LoanT;

/**
 *
 * @author Thodoris
 */
public class JPAManager {
    
    
    
    
    public static void saveLoan(Loan loanToSave){
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("loanPU");
            EntityManager entityManager = emf.createEntityManager();

            try {
                entityManager.getTransaction().begin();
               
                LoanT loanT = mapLoan(loanToSave);
                entityManager.persist(loanT);
                
                entityManager.getTransaction().commit();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Can't Delete DB ", JOptionPane.ERROR_MESSAGE);
                entityManager.getTransaction().rollback();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "DB problem ", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private static LoanT mapLoan(Loan loan){
        LoanT loanT = new LoanT();
        loanT.setCapital(loan.getCapital());
        loanT.setInstallmentsnumber((short)loan.getInstallmentsNumber());
        loanT.setInterestrate(loan.getInterestRate());
        
        List<InstallmentT> installments = new ArrayList<>();
        
        for(int i =0; i< loan.getInstallmentsNumber(); i++){
            Installment installment = loan.getInstallment(i);
            
            InstallmentT inT = new InstallmentT();
            inT.setBasicamount(installment.getBasicAmount());
            inT.setInterest(installment.getInterest());
            inT.setNumber((short)installment.getNumber());
            inT.setRemainingcapital(installment.getRemainingCapital());
            inT.setTotalamount(installment.getTotalInstallmentAmount());
            inT.setLoanId(loanT);
            installments.add(inT);
        }
        
        loanT.setInstallmentTList(installments);
        
        return loanT;
    }
    
}
