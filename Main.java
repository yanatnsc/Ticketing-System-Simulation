//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        // Thread for adding tickets
        //https://stackoverflow.com/questions/3489543/how-to-call-a-method-with-a-separate-thread-in-java
        //https://stackoverflow.com/questions/34434543/how-to-run-two-threads-at-the-same-time-in-java
        new Thread(() -> { // Just realized this is lambda expression
            while (ts.cumulativeTime < 20) { // Simulate for a duration of 20 units of time
                ts.addTicket();
                ts.cumulativeTime++; // Otherwise it won't end
                try {
                    Thread.sleep(500); // Wait for 500 milliseconds before adding the next ticket
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Thread for processing tickets
        new Thread(() -> {
            while (ts.cumulativeTime < 30) { // Simulate for a duration of 30 units of time (processing will be completed after last ticket is submitted)
                ts.processTicket();
                ts.cumulativeTime++;
                try {
                    Thread.sleep(750); // Wait for 750 milliseconds before processing the next ticket
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
