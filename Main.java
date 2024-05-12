//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();
        // Thread for adding tickets
        //https://stackoverflow.com/questions/3489543/how-to-call-a-method-with-a-separate-thread-in-java
        new Thread(() -> {
            while (ts.cumulativeTime < 20) { // Simulate for a duration of 20 units of time
                ts.addTicket();
                ts.cumulativeTime++;
                try {
                    Thread.sleep(500); // Wait for 500 milliseconds before adding the next ticket
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Thread for processing tickets
        new Thread(() -> {
            while (ts.cumulativeTime < 30) { // Simulate for a duration of 50 units of time (processing will be completed after last ticket is submitted)
                ts.processTicket();
                ts.cumulativeTime++;
                try {
                    Thread.sleep(750); // Wait for 700 milliseconds before processing the next ticket
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}