package com.day7;


class Payment1 {
    private String payer;
    private double amount;

    public Payment1(String payer, double amount) {
        this.payer = payer;
        this.amount = amount;
    }

    public String getPayer() {
        return payer;
    }

    public double getAmount() {
        return amount;
    }
}

class PaymentBuffer {
    private Payment1 payment;
    private boolean available = false;

    public synchronized void produce(Payment1 payment) {
        while (available) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.payment = payment;
        available = true;
        System.out.println("Produced: " + payment.getPayer() + ", Amount: $" + payment.getAmount());
        notify(); 
    }

    public synchronized Payment1 consume() {
        while (!available) {
            try {
                wait(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println("Consumed: " + payment.getPayer() + ", Amount: $" + payment.getAmount());
        notify(); 
        return payment;
    }
}

class PaymentProducer extends Thread {
    private PaymentBuffer buffer;

    public PaymentProducer(PaymentBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        String[] payers = {"ram", "ravi", "chanti"};
        double[] amounts = {100.0, 250.5, 75.75};

        for (int i = 0; i < payers.length; i++) {
            Payment1 payment = new Payment1(payers[i], amounts[i]);
            buffer.produce(payment);

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class PaymentConsumer extends Thread {
    private PaymentBuffer buffer;

    public PaymentConsumer(PaymentBuffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            Payment1 payment = buffer.consume();

            try {
                Thread.sleep(1500); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
 

public class PaymentSystem {
    public static void main(String[] args) {
        PaymentBuffer buffer = new PaymentBuffer();
        PaymentProducer producer = new PaymentProducer(buffer);
        PaymentConsumer consumer = new PaymentConsumer(buffer);

        producer.start();
        consumer.start();
    }
}



