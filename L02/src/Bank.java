
import java.util.Arrays;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Team 03
 */
public class Bank {
    
    double[] accounts;
    
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);      
    }
    
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
    
    public void transfer(int from, int to, double amount)
    {
        Runnable r = () -> {
        System.out.println(Thread.currentThread() + "Transfering " + amount + " from account " + from + " to account " + to + ".");
        accounts[from] -= amount;
        accounts[to] += amount;
        System.out.println("Balance of account " + from + ": " + accounts[from]);
        System.out.println("Balance of account " + to + ": " + accounts[to]);
        };
        Thread t = new Thread(r);
        t.start();
    }
}
