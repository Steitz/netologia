import java.time.LocalDateTime;


public class SmartLogger implements Logger {
    protected int cnt=0;
    public void log(String message) {
        cnt++;

       // message.toUpperCase().replace("ERROR", "ERROR"`);

        String err =message.substring(0,5);
        if (err.equals("ERROR")) {
            System.out.println("ERROR#" + cnt + " " + LocalDateTime.now() + " " + message);
        }
        else
            System.out.println("INFO#"+cnt+" "+LocalDateTime.now() + " "+message);
        }

}
