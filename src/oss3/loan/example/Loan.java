package oss3.loan.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thodoris
 */
public class Loan {
    
    private final double capital;
    private final double interestRate;
    private final int installmentsNumber;
    
    private final List<Installment> installments;
    private final double monthlyCapital;
       
    private Double finalPaidAmount = null;
 
    public Loan(double aCapital, double anInterestRate, int installmentsNumber){
        this.capital = aCapital;
        this.interestRate = anInterestRate;
        this.installmentsNumber = installmentsNumber;
        
        monthlyCapital = capital / installmentsNumber;
        
        installments = new ArrayList<>();
        
        computeRepaymentSchedule();
    }
    
    private void computeRepaymentSchedule(){
        double capitalPaid = 0.0;
        
        for(int i = 0; i < installmentsNumber; i++){
            int installmentNumber = i+1;
            
            double remainingCapital = capital - capitalPaid;
            double monthlyInterest =  (remainingCapital * interestRate) / installmentsNumber;
            double totalMonthlyAmount = monthlyCapital + monthlyInterest;
            
            Installment installment = new Installment(installmentNumber, monthlyCapital, monthlyInterest, totalMonthlyAmount);
            installment.setRemainingCapital(remainingCapital);
            
            capitalPaid +=  monthlyCapital;
            
            installments.add(installment);
            
            System.out.println(installment.toString());
        }
    }
    
    public double getFinalPaidAmount() {
        if(finalPaidAmount != null ) return finalPaidAmount;
        
        finalPaidAmount = new Double(0);
        for(Installment installment : installments){
            finalPaidAmount += installment.getTotalInstallmentAmount();
        }
        
        return finalPaidAmount;
    }

    public int getInstallmentsNumber() {
        return installmentsNumber;
    }
    
    public Installment getInstallment(int row) {
        return installments.get(row);
    }

    public void setFinalPaidAmount(double finalPaidAmount) {
        this.finalPaidAmount = finalPaidAmount;
    }

    public double getCapital() {
        return capital;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Loan{" + "capital=" + capital + ", interestRate=" + interestRate + '}';
    }
        
}
