interface Refundable {
    void refund();
}

abstract class Payment {
    protected double amount;
    public Payment(double amount) {
        this.amount = amount;
    }
    public void printAmount() {
        System.out.println("So tien thanh toan: " + this.amount);
    }
    public abstract void pay();
}

class CashPayment extends Payment {
    public CashPayment(double amount) {
        super(amount);
    }
    @Override
    public void pay() {
        System.out.println("-> Da thanh toan bang Tien mat (Cash).");
    }
}

class CreditCardPayment extends Payment implements Refundable {
    public CreditCardPayment(double amount) {
        super(amount);
    }
    @Override
    public void pay() {
        System.out.println("-> Da thanh toan bang The tin dung (Credit Card).");
    }
    @Override
    public void refund() {
        System.out.println("-> Yeu cau hoan tien vao The tin dung thanh cong.");
    }
}

class EWalletPayment extends Payment implements Refundable {
    public EWalletPayment(double amount) {
        super(amount);
    }
    @Override
    public void pay() {
        System.out.println("-> Da thanh toan qua Vi dien tu (E-Wallet).");
    }
    @Override
    public void refund() {
        System.out.println("-> Yeu cau hoan tien vao Vi dien tu thanh cong.");
    }
}

public class Kha2 {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];
        payments[0] = new CashPayment(100.0);           // Khong the hoan tien
        payments[1] = new CreditCardPayment(500.0);     // Co the hoan tien
        payments[2] = new EWalletPayment(250.0);        // Co the hoan tien
        System.out.println("--- HE THONG THANH TOAN ---");
        for (Payment p : payments) {
            System.out.println("---------------------------");
            p.printAmount();
            p.pay();
            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            } else {
                System.out.println("-> Hinh thuc nay KHONG ho tro hoan tien.");
            }
        }
    }
}