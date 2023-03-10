package all.simplebankaccount;
import java.util.*;
import java.util.logging.*;
public class SimpleBankAccount 
{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    protected SimpleBankAccount(){
        LOGGER.info("Simple Bank Account initiated");
    }
    public static void run()
    {
        Scanner sc = new Scanner(System.in);
        LOGGER.log(Level.INFO,"My bank \n");
        LOGGER.log(Level.INFO,"name :");
        String name = sc.next();
        LOGGER.log(Level.INFO,"account number :");
        int accno  = sc.nextInt();
        BANK b = new BANK(name,accno,500);
        int start = 1;
        do{
            try{
                LOGGER.info("1.deposit 2.withdraw 3.check balance 4.exit");
                int s = sc.nextInt();
                if(s == 1){
                    LOGGER.info("Enter amount: ");
                    int amount = sc.nextInt();
                    b.deposit(amount);
                }
                else if(s == 2){
                    LOGGER.info("Enter amount: ");
                    int amount = sc.nextInt();
                    b.withdraw(amount);
                    
                }
                else if(s == 3){
                    String m = ""+b.balance;
                    LOGGER.info(m);
                }
                else if(s == 4){
                    start = 0;
                }
            }catch(Exception e){
                String s = ""+e;
                LOGGER.info(s);
                sc.nextLine();
                LOGGER.info("_______________________________________________");
            }
        }while(start== 1);
    }
}
