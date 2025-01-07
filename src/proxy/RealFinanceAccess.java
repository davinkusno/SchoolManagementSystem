package proxy;

import singleton.Finance;

/**
 * Real subject implementation of FinanceAccess.
 */
public class RealFinanceAccess implements FinanceAccess {
    private final Finance finance = Finance.getInstance();

    @Override
    public String getFinancialSummary() {
        return "Total Earned: $" + finance.getTotalMoneyEarned() +
                ", Total Spent: $" + finance.getTotalMoneySpent() +
                ", Balance: $" + finance.getBalance();
    }

    @Override
    public void addEarnings(int amount) {
        finance.addMoneyEarned(amount);
    }

    @Override
    public void addExpenditure(int amount) {
        finance.addMoneySpent(amount);
    }
}
