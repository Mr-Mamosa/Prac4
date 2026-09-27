class MilkHouse{
    boolean milkAvailable = false;
    synchronized void waitformilk(){
        System.out.println("Customer: Waiting for milk.");
        while(!milkAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Customer: Got milk.");
    }
    synchronized void deliverMilk(){
        System.out.println("Milk Man: Delivering milk.");
        milkAvailable = true;
        notify();
    }
}

public class WaitNotifyDemo{
    public static void main(String[] args){
        MilkHouse shop = new MilkHouse();
        Thread t1 = new Thread(() -> shop.waitformilk());
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            shop.deliverMilk();
        });
        t1.start();
        t2.start();
    }
}