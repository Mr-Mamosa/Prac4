class Ticket_Booking{
    int tickets_available = 100;
    public synchronized void book_ticket(String person){
        if(tickets_available>0){
            System.out.println(person+ " is booking a ticket.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tickets_available--;
            System.out.println("Your ticket is booked sucessfully! ");
        }else{
            System.out.println("Sorry, " +person+ " tickets are unavailable!");
        }
    }
}

class People extends Thread{
    Ticket_Booking b = new Ticket_Booking();
    String person_name;
    People(Ticket_Booking b, String person_name){
        this.b = b;
        this.person_name = person_name;
    }
    public void run(){
        b.book_ticket(person_name);
    }
}

public class TicketBooking {
    public static void main(String[] args){
        Ticket_Booking b = new Ticket_Booking();
        People p1 = new People(b, "Amit ji");
        People p2 = new People(b, "Tanmay");
        p1.run();
        p2.run();
    }
}