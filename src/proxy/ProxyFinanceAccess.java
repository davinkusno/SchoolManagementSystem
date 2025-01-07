package proxy;

/**
 * Proxy for managing access to finance details.
 */
public class ProxyFinanceAccess implements FinanceAccess {
    private final RealFinanceAccess realFinanceAccess;
    private final String authorizedRole;

    public ProxyFinanceAccess(String authorizedRole) {
        this.realFinanceAccess = new RealFinanceAccess();
        this.authorizedRole = authorizedRole;
    }

    @Override
    public String getFinancialSummary() {
        if (authorizedRole.equals("ADMIN")) {
            return realFinanceAccess.getFinancialSummary();
        } else {
            return "Access Denied: Insufficient Permissions";
        }
    }

    @Override
    public void addEarnings(int amount) {
        if (authorizedRole.equals("ADMIN")) {
            realFinanceAccess.addEarnings(amount);
        } else {
            System.out.println("Access Denied: Insufficient Permissions to add earnings.");
        }
    }

    @Override
    public void addExpenditure(int amount) {
        if (authorizedRole.equals("ADMIN")) {
            realFinanceAccess.addExpenditure(amount);
        } else {
            System.out.println("Access Denied: Insufficient Permissions to add expenditure.");
        }
    }
}
