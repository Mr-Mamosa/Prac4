class UnderAgeException extends Exception {
    public UnderAgeException(String message){
        super(message);
    }
}

public class VotingApp{
    static void check(int age) throws UnderAgeException{
        if (age<18){
            throw new UnderAgeException("You must be atleast of 18 to Drive!");
        }
        System.out.println("You'r eligible to drive!");
    }

    public static void main(String[] args){
        try {
            check(16);
        } catch (UnderAgeException e) {
            System.out.println("Custom error: "+e.getMessage());
        }
    }
}