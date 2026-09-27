class Bank{
    boolean open = false;
    synchronized void waitForOpening(String name){
        System.out.println(name+ ": Waiting for bank to oepn.");
        while(!open){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+ " bank is open now");
    }
    synchronized void openBank(){
        System.out.println("------------------------");
        System.out.println("Bank: Opening Bank ");
        System.out.println("------------------------");
        open = true;
        notifyAll();
    }
}
public class BankApp{
    public static void main(String[] args){
        Bank b = new Bank();
        Thread t1 = new Thread(() ->b.waitForOpening("Customer 1"));
        Thread t2 = new Thread(() ->b.waitForOpening("Customer 2"));
        Thread t3 = new Thread(() ->b.waitForOpening("Customer 3"));
        t1.start();
        t2.start();
        t3.start();
        new Thread(() ->{
            try {
                Thread.sleep(1000);
            } catch (Exception e){}
            b.openBank();
        }).start();
    }
}