/*
1- what is the solve of write Scanner input = new Scanner(System.in); in every method.
2- ask about ifUserAskAntherService() method to ask user about anther service or not
*/
package BankSystem;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //first we ask Allah to help us in this program and i make it in a good way.
        //in the first of the program it will ask about the password.
        Scanner input = new Scanner(System.in);
        //we will call the function of chicking the password.
        chickPassword();
        /*
        After chicking the password we will give him our services and we will take his chose again with
        varable called "serviceNumber"
        */
        byte serviceNumber= userService();
        /*
        after we take the varable "serviceNumber" we will give him to anther method to deside what will we
        do with him with method called "chossingServiceMethod()"
        */
        chossingServiceMethod(serviceNumber);
    }

    public static void chickPassword(){
        Scanner input = new Scanner(System.in);
        String userPassword ="0000";
        String enterdPassword;
        //we will take the user password.
        do {
            System.out.print("Pleasee Enter Your Correct Password : ");
             enterdPassword = input.next();
        }while (!enterdPassword.equals(userPassword));
    }

    public static byte userService(){
        Scanner input = new Scanner(System.in);
        byte serviceNumber ;
        System.out.print("To Cash Deposot     Enter #1 \n" +
                         "To Cash Withdrawal  Enter #2 \n" +
                         "To Cash Transfer    Enter #3 \n" +
                         "To Cash Query       Enter #4 \n");
        do {
            System.out.print("Please Enter Correct Service Number :");
            serviceNumber = input.nextByte();
        } while (serviceNumber != 1 && serviceNumber != 2 && serviceNumber != 3 && serviceNumber != 4);
        return serviceNumber;
    }

    public static void chossingServiceMethod(byte serviceNumber){
        //we take in our mind that the user balance is 1000 but we will take it from database
        double userBalance =1000.0;
        switch (serviceNumber){
            case 1:
                //if the  user enter 1 we will take him to end the Deposot service
                userBalance = Deposot(userBalance);
                break;
            case 2:
                //if the  user enter 1 we will take him to end the Withdrawal service
                userBalance =Withdrawal(userBalance);
                break;
            case 3:
            //if the  user enter 1 we will take him to end the Transfer service
                //Transfer();
                break;
            case 4:
                //if the  user enter 1 we will take him to end the Query service
                Query(userBalance);
                break;
        }
    }

    public static double Deposot(double userBalance){
        Scanner input = new Scanner(System.in);
        // we set the varable deposotMoney to the money which the user will but in the ATM
        double deposotMoney;
        //we will take the user deposot Money in the varable "deposotMoney" and add it to user balance
        System.out.print("Please enter the number or deposoted money : ");
        deposotMoney = input.nextDouble();

        userBalance += deposotMoney;
        //we will display the new balance of the user
        System.out.println("\n Your new balance is "+userBalance);
        /*
        we create this method only to ask the user
        if he want to ask anther service before end the program or not
        */
        //ifUserAskAntherService();

        //we will return the user balance again to make anther operations on it
        return userBalance;
    }

    private static double Withdrawal(double userBalance) {
        Scanner input = new Scanner(System.in);
        double WithdrawalMoney;
        System.out.print("Please enter the number of money you need to take : ");
        WithdrawalMoney =input.nextDouble();
        //we will use "chickUserBalance()" method to test if the balance is enough for the process
        WithdrawalMoney = chickUserBalance(WithdrawalMoney,userBalance);
        userBalance -= WithdrawalMoney;
        System.out.println("\n Your new balance is "+userBalance);
        return userBalance;
    }

    /*
        public static void ifUserAskAntherService(){
            Scanner input = new Scanner(System.in);
            byte antherServiceChoose ;
            System.out.println("if you want anther service Enter 1 or enter any key to end");
            antherServiceChoose = input.nextByte();
            if (antherServiceChoose == 1)
                userService();
            else return;

        }
    */

    public static double chickUserBalance(double enterdNumber, double userBalance){
        Scanner input = new Scanner(System.in);
        //this loop to make the user enter number smaller than the balance
        while (enterdNumber > userBalance){
                System.out.print("Your balance isn't enough to contanue \n"+
                                   "Please enter number smaller than your balance "+userBalance +": ");
                enterdNumber = input.nextDouble();
        }
        return enterdNumber;
    }

    public static void Query(double userBalance){
        System.out.println("your balance is "+ userBalance);
    }

}
