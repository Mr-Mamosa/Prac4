class MyThread extends Thread{
    public void run(){
        System.out.println("Sytem Running.");
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread finished.");
    }
}
public class LifeCycleDemo {
    public static void main(String[] args) throws InterruptedException{
        MyThread m = new MyThread();
        System.out.println(m.getState());
        m.start();
        System.out.println(m.getState());
        Thread.sleep(1000);
        System.out.println(m.getState());
        m.join();
        System.out.println(m.getState());
    }
}