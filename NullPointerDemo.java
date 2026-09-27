public class NullPointerDemo {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception Caught");
        } finally {
            System.out.println("Program Ended");
        }
    }
}