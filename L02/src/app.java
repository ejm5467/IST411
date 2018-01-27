/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emily
 */
public class app {
    
    public static void main(String[] args) {
      
        Bank bank = new Bank(2,0);
        bank.deposit(0, 200);
        bank.deposit(1, 300);
        bank.transfer(0, 1, 300);
        bank.transfer(1, 0, 400);
    }
}
