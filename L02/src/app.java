
/**
 *
 * @author Team 3
 * Emily Malnor, Kara MacClean & Karin Martin
 *
 */
public class app {
    
    public static void main(String[] args) {
        
        Bank bank = new Bank(2,0);
      
        bank.deposit(0, 200);
        bank.deposit(1, 300);
      
        //transfer funds into first account
        Runnable r = () -> {
            try
            {
                while (true)
                {
                    bank.transfer(0, 1, 300);
                }
            }
            catch (InterruptedException e)
            {
            }            
        };
        
        Thread t = new Thread(r);
        t.start();
        
        //transfer funds into second account
        Runnable ru = () -> {
            try
            {
                while (true)
                {
                    bank.transfer(1, 0, 400);
                }
            }
            catch (InterruptedException e)
            {
            }            
         };
        
        Thread th = new Thread(ru);
        th.start();
      }
    }

