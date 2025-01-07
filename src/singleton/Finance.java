package singleton;

import observer.FinanceObserver;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;

/**
 * Represents the financial management of the school.
 * Handles money earned, spent, and tracks the balance.
 */
public class Finance implements Subject {
    private static Finance instance;
    private int totalMoneyEarned;
    private int totalMoneySpent;
    private final ArrayList<Observer> observers = new ArrayList<>();

    /**
     * Creates a new Finance object with initial balances set to zero.
     */
    private Finance() {
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    public static Finance getInstance() {
        if (instance == null) {
            synchronized (Finance.class) {
                if (instance == null) {
                    instance = new Finance();
                }
            }
        }
        return instance;
    }

    public void addObserver(FinanceObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(FinanceObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    /**
     * Updates the total money earned by the school.
     *
     * @param amount the amount of money earned (must be positive).
     */
    public void addMoneyEarned(int amount) {
        if (amount > 0) {
            this.totalMoneyEarned += amount;
            notifyObservers();
        }
    }

    /**
     * Updates the total money spent by the school.
     *
     * @param amount the amount of money spent (must be positive).
     */
    public void addMoneySpent(int amount) {
        if (amount > 0) {
            this.totalMoneySpent += amount;
            notifyObservers();
        }
    }

    /**
     * Calculates the current balance of the school.
     *
     * @return the balance (total earned - total spent).
     */
    public int getBalance() {
        return totalMoneyEarned - totalMoneySpent;
    }

    // Getters
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    @Override
    public String toString() {
        return "Finance{" +
               "totalMoneyEarned=$" + totalMoneyEarned +
               ", totalMoneySpent=$" + totalMoneySpent +
               ", balance=$" + getBalance() +
               '}';
    }
}
