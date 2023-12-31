interface PaymentStrategy {
    boolean pay(double amount);
}


class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPayment(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        // Implement credit card payment logic
        System.out.println("Processing credit card payment of $" + amount);
        // Validate card information, connect to payment gateway, etc.

        // Simulate success or failure
        boolean paymentSuccessful = Math.random() < 0.8; // 80% success rate

        if (paymentSuccessful) {
            System.out.println("Credit card payment successful!");
        } else {
            System.out.println("Credit card payment failed. Please try again.");
        }

        return paymentSuccessful;
    }
}

// Concrete implementation of a payment strategy (PayPal)
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {

        System.out.println("Processing PayPal payment of $" + amount);


        boolean paymentSuccessful = Math.random() < 0.8; // 80% success rate

        if (paymentSuccessful) {
            System.out.println("PayPal payment successful!");
        } else {
            System.out.println("PayPal payment failed. Please try again.");
        }

        return paymentSuccessful;
    }
}

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public boolean processPayment(double amount) {
        return paymentStrategy.pay(amount);
    }
}
