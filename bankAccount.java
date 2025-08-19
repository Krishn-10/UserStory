import java.util.Scanner;

public class bankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your 7 digit SSN number");
        long SSN = sc.nextLong();
        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter your email");
        String email = sc.next();
        System.out.println("Enter your address");
        String address = sc.next();
        System.out.println("Enter your contact number");
        long contact = sc.nextLong();
        System.out.println("Enter your Aadhaar number");
        long adhaar = sc.nextLong();
        System.out.println("Enter your pan number");
        String pan = sc.next();
        System.out.println("Enter your account number");
        long account = sc.nextLong();
        System.out.println("Enter your initial deposit");
        long initdep = sc.nextLong();
        System.out.println("Account is Created Successfully");
        int c = 0;
        Account[] customers = new Account[1000];
        customers[c] = new Account(SSN, name, email, address, contact, adhaar, pan, account, initdep);
        c++;

        while(true){
            System.out.println("Enter operation to perform");
            String op = sc.next();

            switch (op.toLowerCase()) {
                case "deposit" : {

                    System.out.println("Enter account no.");
                    int acc = sc.nextInt();
                    System.out.println("Enter amount to deposit");
                    int amount = sc.nextInt();
                    boolean flag = false;
                    for (Account customer : customers) {
                        if (acc == customer.account) {
                            flag = true;
                            if (amount > 0) {
                                customer.initdep += amount;
                                System.out.println("Amount deposited successfully");
                                System.out.println(customer.toString());
                            } else
                                System.out.println("Invalid amount");
                            break;
                        }


                    }
                    if (!flag)
                        System.out.println("Wrong account number");
                }
                case "withdrawal": {
                    System.out.println("Enter account no.");
                    int acc = sc.nextInt();
                    System.out.println("Enter amount to withdrawal");
                    int amount = sc.nextInt();
                    boolean flag = false;
                    for (Account customer : customers) {
                        if (acc == customer.account) {
                            flag = true;
                            if (amount > 0 && amount<=customer.initdep) {
                                customer.initdep -= amount;
                                System.out.println("Amount withdrawal successfully");
                                System.out.println(customer.toString());
                            } else
                                System.out.println("Invalid amount");
                            break;
                        }


                    }
                    if (!flag)
                        System.out.println("Wrong account number");
                }

                case "view account balance": {
                    System.out.println("Enter account no.");
                    int acc = sc.nextInt();
                    boolean flag = false;
                    for (Account customer : customers) {
                        if (acc == customer.account) {
                            flag = true;
                            System.out.println(customer.initdep);
                            break;
                        }
                    }
                    if (!flag)
                        System.out.println("Wrong account number");
                }


                case "exit" :
                    break;


            }
        }
    }


}
class Account {
    long SSN;
    String name;
    String email;
    String address;
    long contact;
    long aadhar;
    String pan;
    long account;
    long initdep;

    public Account(long SSN, String name, String email, String address, long contact, long aadhar, String pan, long account, long initdep){
        this.SSN = SSN;
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.aadhar = aadhar;
        this.account = account;
        this.initdep = initdep;
        this.pan = pan;
    }
}


//Developer needs to input the following information from the console using programming to Enter Customer Details:
//Customer SSN No:  A 7 digit number for
//Customer Name: A string field for Customer name(Maximum 50 characters)
//Email: A string field to capture the Email.
//        Address: A string field to capture street, city details(Maximum 100 characters)
//Contact Number:Text field. Maximum 10 characters.
//Addhar Number:Text field. Maximum 12 characters.
//Pan Number: String field. Maximum 10 characters
//Account number : String field. Maximum 20 characters
//Initial deposit amount: Digit numbers
//Once all fields are taken as input, Customer details need to be inserted in array/list/appropriate
//Collection.
//
//After successful account creation,  acknowledgment message need to be displayed
//on the console as "Account is created successfully".