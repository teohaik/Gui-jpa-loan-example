package oss3.loan.example;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thodoris
 */
public class LoanTableModel extends AbstractTableModel {
    
    private Loan theLoan;
    
    private String[] columnNames;

    public LoanTableModel(Loan theLoan, String[] columnNames) {
        this.theLoan = theLoan;
        this.columnNames = columnNames;
    }   

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return theLoan.getInstallmentsNumber();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Installment installment = theLoan.getInstallment(rowIndex);
        
        switch(columnIndex){
            case 0: return installment.getNumber();
            case 1: return installment.getRemainingCapitalString();
            case 2: return installment.getTotalInstallmentAmountString();
            case 3: return installment.getBasicAmountString();
            case 4: return installment.getInterestString();
            default: return "ERROR";
        }
    }
    
}
