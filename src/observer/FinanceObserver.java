package observer;

import singleton.Finance;

public class FinanceObserver implements Observer {
    private final Finance finance;

    public FinanceObserver(Finance finance) {
        this.finance = finance;
    }

    @Override
    public void update() {
        System.out.println("Finance Updated: " + finance);
    }
}