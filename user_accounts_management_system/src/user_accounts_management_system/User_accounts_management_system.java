/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package user_accounts_management_system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Naveen Raj. K
 */
class Account implements Serializable{
    String accno;
    String name;
    double balance;
    String address;
    
    Account(){ }
    
    Account(String a,String n,double b,String ad){
        accno=a;
        name=n;
        balance=b;
        address=ad;
    }
    public String toString(){
        return "Account_Details"+"\nACCOUNT NUMBER :"+accno+
                "\nNAME :"+name+
                "\nBALANCE :"+balance+
                "\nADDRESS :"+address+"\n";
    }
}
public class User_accounts_management_system {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        Account acc=null;
        
        HashMap<String,Account> hm=new HashMap<>();
        
        try{
            FileInputStream fis=new FileInputStream("C:/Users/Naveen Raj. K/OneDrive/Documents/NetBeansProjects/user_accounts_management_system/src/user_accounts_management_system/user_account.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            int count=ois.readInt();
            for(int i=0;i<count;i++){
                acc=(Account)ois.readObject();
                System.out.println(acc);
                hm.put(acc.accno,acc);
            }
            fis.close();
            ois.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        FileOutputStream fos=new FileOutputStream("C:/Users/Naveen Raj. K/OneDrive/Documents/NetBeansProjects/user_accounts_management_system/src/user_accounts_management_system/user_account.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        
        int choice;
        String accno;
        String name;
        double balance;
        String address;
        
        do{
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. View Account");
            System.out.println("4. View  All Accounts");
            System.out.println("5. Save Accounts");
            System.out.println("6. Exit");            
            System.out.println("Enter your choice :");
            choice=sc.nextInt();
            
            
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            
            switch(choice)
            {
                case 1:
                    System.out.println("Enter AccountNo, Name,Account Balance,Address:");
                    accno=sc.nextLine();
                    name=sc.nextLine();
                    balance=sc.nextDouble();
                    sc.nextLine();
                    address=sc.nextLine();
                    acc=new Account(accno,name,balance,address);
                    hm.put(accno, acc);
                    System.out.println("Account created for "+name);
                    break;
                    
                case 2:
                    System.out.println("Enter AccountNo :");
                    accno=sc.nextLine();
                    hm.remove(accno);
                    break;
                    
                case 3:
                    
                    accno=sc.nextLine();
                    acc=hm.get(accno);
                    System.out.println(acc);
                    break;
                    
                case 4:
                    for(Account a:hm.values())
                        System.out.println(a);
                    break;
                    
                case 5:
                    
                    
                case 6:
                    oos.writeInt(hm.size());
                    
                    for(Account a:hm.values())
                        oos.writeObject(a);
                    break;
            }

        }while(choice!=6);
        oos.flush();
        fos.close();
        oos.close();
        sc.close();
        
            
    }
    
}
