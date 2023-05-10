package BMS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

public class Operations {
    ArrayList<BankAccount> list = new ArrayList<BankAccount>();
    BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public void addAccount() throws IOException {
        Random random = new Random();
        long accNum = random.nextLong() % 100000000000L;
        System.out.println("Enter name");
        String name = sc.readLine();
        System.out.println("Enter address");
        String address = sc.readLine();
        System.out.println("Enter phn number");
        long phonenum = Long.parseLong(sc.readLine());
        System.out.println("Enter email");
        String email = sc.readLine();
        System.out.println("Enter acc type(current/savings");
        String accounttype = sc.readLine();
        if (accounttype.equalsIgnoreCase("current")) {
            System.out.println("Enter company name::");
            String companyname = sc.readLine();
            list.add(new BankAccount(name, address, phonenum, email, accounttype, accNum, companyname));
        } else {
            list.add(new BankAccount(name, address, phonenum, email, accounttype, accNum));
        }
        System.out.println("Your account number is::" + accNum);


    }

    public void Deposit() throws IOException {
        long accountNum;
        System.out.println("Enter acc number");
        while (true) {
            try {
                accountNum = Long.parseLong(sc.readLine());
                break;
            } catch (IOException e) {
                System.out.println("Invalid input");
            }
        }
        for (BankAccount b : list) {
            if (accountNum == b.accountno) {
                System.out.println("Current balance is::" + b.getBalance());

                System.out.println("Enter amount to deposit:");
                int deposit = Integer.parseInt(sc.readLine());
                b.balance = b.balance + deposit;
                System.out.println("DEPOSIT SUCESSFUL");
                System.out.println("CURRENT BALANCE IS:" + b.getBalance());

            } else {
                try {
                    throw new AccountNotPresentException();
                } catch (AccountNotPresentException e) {
                    e.getMessage();
                }
            }
        }
    }

    public void withdraw() throws IOException {
        long accountNum;
        System.out.println("Enter acc number:");
        while (true) {
            try {
                accountNum = Long.parseLong(sc.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input!!");
            }
        }
        for (BankAccount b : list) {
            if (accountNum == b.accountno) {
                System.out.println("CURRENT BALANCE: Rs." + b.getBalance());
                System.out.println("Enter Amount to Withdrawl:");
                int wAmount = Integer.parseInt(sc.readLine());
                if (wAmount > b.balance) {
                    try {
                        throw new InsufficientBalanceException();
                    } catch (InsufficientBalanceException e) {
                        e.getMessage();
                    }
                } else {
                    b.balance -= wAmount;
                    System.out.println("WITHDRAWL SUCESSFULL!");
                    System.out.println("CURRENT BALANCE: Rs." + b.getBalance());
                }
            } else {
                try {
                    throw new AccountNotPresentException();
                } catch (AccountNotPresentException e) {
                    e.getMessage();
                }
            }
        }
    }
        public void Display() throws  IOException{
            long accountNum;
            while (true) {
                System.out.println("Enter Account Number:");
                try {
                    accountNum = Long.parseLong(sc.readLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Input Mismatch!");
                }
            }

            for (BankAccount b : list) {
                if (accountNum == b.accountno) {
                    if (b.accounttype.equalsIgnoreCase("current")) {
                        System.out.println("------------------------------");
                        System.out.println("Name:        | " + b.getName());
                        System.out.println("Phone No:    | " + b.getPhoneno());
                        System.out.println("Account Type:| " + b.getAccounttype());
                        System.out.println("Company Name:| " + b.getCompanyname());
                        System.out.println("Balance:     | " + b.getBalance());
                        System.out.println("------------------------------");
                    } else {
                        System.out.println("------------------------------");
                        System.out.println("Name:        | " + b.getName());
                        System.out.println("Phone No:    | " + b.getPhoneno());
                        System.out.println("Account Type:| " + b.getAccounttype());
                        System.out.println("Balance:     | " + b.getBalance());
                        System.out.println("------------------------------");
                    }

                } else {
                    try {
                        throw new AccountNotPresentException();
                    } catch (AccountNotPresentException e) {
                        e.getMessage();
                    }
                }
            }
        }
    }

