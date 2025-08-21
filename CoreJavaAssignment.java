import java.util.*;

public class CoreJavaAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = sc.next();
//        int total = 10000;
//        bank(s, total);

//        armstrong();

//        reverseWords();

        question28();

    }


    public static void bank(String request, int total){
        Scanner sc = new Scanner(System.in);

        switch (request){
            case "Withdrawl": {
                System.out.println("Enter the amount");
                int withdrawl = sc.nextInt();
                if(total > withdrawl){
                    total -= withdrawl;
                    System.out.println("Amount withdrawl, remaining amount : " + total);
                }
                else
                    System.out.println("Insufficient balance");
                break;
            }
            case "Deposit": {
                System.out.println("Enter the amount");
                int dep = sc.nextInt();
                if(0<dep){
                    total += dep;
                    System.out.println("Amount deposited, updated amount : " + total);
                }
                else
                    System.out.println("Invalid amount");
                break;
            }case "Transfer": {
                System.out.println("Enter the amount");
                int transfer = sc.nextInt();
                if(0<transfer){
                    total -= transfer;
                    System.out.println("Amount transferred, remaining balance : " + total);
                }
                else
                    System.out.println("Invalid amount");
                break;
            }
            case "Show Balance": {
                System.out.println("Account Balance: " + total);
                break;

            }

        }
    }

    public static void gradeAnalyzer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of student");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]<=100 && arr[i]>=80){
                System.out.println("A");
            }else if(arr[i]<80 && arr[i]>=60){
                System.out.println("A");
            }else if(arr[i]<60 && arr[i]>=40){
                System.out.println("C");
            }else if(arr[i]<40){
                System.out.println("D");
            }
        }
    }

    public static void armstrong(){
        for (int i = 1; i <= 1000; i++) {
            if(i>0 && i<10){
                int x = i;
                int sum = 0;
                while(x>0){
                    sum+= x%10;
                    x/=10;
                }
                if(sum==i)
                    System.out.println(i);
            }
            else if(i>9 && i<100){
                int x = i;
                int sum = 0;
                while(x>0){
                    sum+= Math.pow(x%10,2);
                    x/=10;
                }
                if(sum==i)
                    System.out.println(i);
            } else if(i>=100 && i<1000){
                int x = i;
                int sum = 0;
                while(x>0){
                    sum+= Math.pow(x%10,3);
                    x/=10;
                }
                if(sum==i)
                    System.out.println(i);
            }
        }
    }


    //22
    public static void reverseWords() {
        Scanner sc = new Scanner(System.in);
        String s = "Krishna Sharma is a TCS EMp";
        StringBuilder sb = new StringBuilder("");
        int count  = 0;

        for (int i = 0; i < s.length(); i++) {
            count = i;
            while(i<s.length() && s.charAt(i) != ' '){
                i++;
            }

            for (int j = i-1; j >= count; j--) {
                sb.append(s.charAt(j));
            }
            sb.append(" ");
        }
        System.out.println(sb.substring(0,sb.length()-1));
    }

    public static void question27(){
        Scanner sca = new Scanner(System.in);
        System.out.println("Enter your password");
        String s = sca.next();
        boolean uc = false;
        boolean lc = false;
        boolean dig = false;
        boolean sc = false;

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i)))
                dig = true;
            else if(Character.isUpperCase(s.charAt(i)))
                uc = true;
            else if(Character.isLowerCase(s.charAt(i)))
                lc = true;
            else
                sc = true;

            if(sc&&lc&&dig&&uc)
                break;

        }
        if(sc&&lc&&dig&&uc)
            System.out.println("The password is strong");
        else
            System.out.println("The password is weak");
    }

    public static void question28(){
        int[] arr = {6,5,8,97,3,1,5,3};
        Arrays.sort(arr);

        System.out.println(arr[arr.length/2]);
    }




}
