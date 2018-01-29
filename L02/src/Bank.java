/**
 *
 * @author Team 03
 * Emily Malnor, Kara MacClean & Karin Martin
 * 
 */

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    
    double[] accounts;
    private final Lock bankLock;
    private final Condition sufficientFunds;
    
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);  
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }
    
    //deposit amounts into accounts
    public void deposit(int accountNumber, double amount) 
    {
        Runnable r = () -> {
            accounts[accountNumber] += amount;
            System.out.println(Thread.currentThread() + "Deposit of " + amount + " into account " + accountNumber + " successful.");
            System.out.println("Balance of account " + accountNumber + ": " + accounts[accountNumber]);
        };
        
        Thread t = new Thread(r);
        t.start();
    }
    
    //transfer amounts between accounts
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        bankLock.lock();
        try
        {
            while (accounts[from] < amount)
            sufficientFunds.await();
                System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.println("Balance of account " + from + ": " + accounts[from]);
            System.out.println("Balance of account " + to + ": " + accounts[to]);
            sufficientFunds.signalAll();
        }
        finally
        {
            bankLock.unlock();
        }
    }
    
}

