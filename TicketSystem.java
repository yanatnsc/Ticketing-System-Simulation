import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TicketSystem {
    Queue<Ticket> queue = new LinkedList<>();
    Random random = new Random();
    int cumulativeTime = 0;
    int ticketNumberCounter = 0; // Counter for ticket numbers

    public void addTicket() {
        int ticketNumber = ++ticketNumberCounter; // Increment the ticket number counter
        int timeStamp = cumulativeTime;
        System.out.println("At time " + cumulativeTime + ", " + "Ticket " + ticketNumber + " (arrival time " + timeStamp + ") is added to the queue.");
        cumulativeTime += random.nextInt(5) + 1; // Update cumulative time
        Ticket currentTicket = new Ticket(ticketNumber, timeStamp);
        queue.add(currentTicket);
    }

    public void processTicket() {
        if (!queue.isEmpty()) {
            Ticket currentTicket = queue.poll();
            int processingTime = random.nextInt(5) + 1; // Generate random processing time between 1 and 5
            cumulativeTime += processingTime;
            System.out.println("At time " + cumulativeTime + ", " + "Ticket " + currentTicket.getTicketNumber()
                    + " (arrival time " + currentTicket.getTimeStamp() + ") is processed from the queue.");
        }
    }
}
