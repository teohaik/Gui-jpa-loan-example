package oss3.loan.example;

import java.text.DecimalFormat;

/**
 *
 * @author Thodoris
 */
public class Installment {
    
    private int number;    
    private double basicAmount;
    private double interest;
    private double totalInstallmentAmount;
    private double remainingCapital;
    
    private DecimalFormat decimalformatter = new DecimalFormat("#.##");

    public Installment(int num, double basicAmount, double interest, double totalInstallmentAmount) {
        this.number = num;
        this.basicAmount = basicAmount;
        this.interest = interest;
        this.totalInstallmentAmount = totalInstallmentAmount;
    }

    public double getRemainingCapital() {
        return remainingCapital;
    }
    
    public String getRemainingCapitalString() {
        return decimalformatter.format(remainingCapital);
    }

    public void setRemainingCapital(double remainingCapital) {
        this.remainingCapital = remainingCapital;
    }
    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    public double getBasicAmount() {
        return basicAmount;
    }
       
    public String getBasicAmountString() {
        return decimalformatter.format(basicAmount);
    }
    
    public void setBasicAmount(double basicAmount) {
        this.basicAmount = basicAmount;
    }

    public double getInterest() {
        return interest;
    }
    
    public String getInterestString() {
        return decimalformatter.format(interest);
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getTotalInstallmentAmount() {
        return totalInstallmentAmount;
    }
    
    public String getTotalInstallmentAmountString(){
       return decimalformatter.format(totalInstallmentAmount);
    }

    public void setTotalInstallmentAmount(double totalInstallmentAmount) {
        this.totalInstallmentAmount = totalInstallmentAmount;
    }

    @Override
    public String toString() {
        return number + " | "+ getRemainingCapitalString() + " "
                + "| " + getTotalInstallmentAmountString() + ""
                + " (" + getBasicAmountString() + " + " + getInterestString() + ")"; 
    }
        
    
}
