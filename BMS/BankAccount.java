package BMS;

public class BankAccount {
    String name;
    String address;
    long phoneno;
    String emailid;
    String accounttype;
    long accountno;
    String companyname;
    int balance=0;



    public BankAccount(String name, String address, long phoneno, String emailid, String accounttype, long accountno) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.emailid = emailid;
        this.accounttype = accounttype;
        this.accountno = accountno;
    }
    public BankAccount(String name, String address, long phoneno, String emailid, String accounttype, long accountno,String companyname) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
        this.emailid = emailid;
        this.accounttype = accounttype;
        this.accountno = accountno;
        this.companyname=companyname;
    }
public String getcompanyName()
{
    return companyname;
}
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getPhoneno() {
        return phoneno;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public long getAccountno() {
        return accountno;
    }

    public String getCompanyname() {
        return companyname;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneno=" + phoneno +
                ", emailid='" + emailid + '\'' +
                ", accounttype='" + accounttype + '\'' +
                ", accountno=" + accountno +
                '}';
    }
}
