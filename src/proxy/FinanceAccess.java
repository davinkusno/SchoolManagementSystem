package proxy;

public interface FinanceAccess {
    String getFinancialSummary();
    void addEarnings(int amount);
    void addExpenditure(int amount);
}
