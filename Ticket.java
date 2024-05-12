public class Ticket {
    int ticketNumber;
    int timeStamp;

    public Ticket(int ticketNumber, int timeStamp) {
        this.ticketNumber = ticketNumber;
        this.timeStamp = timeStamp;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getTimeStamp() {
        return timeStamp;
    }
}