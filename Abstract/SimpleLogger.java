import java.time.LocalDateTime;

public class SimpleLogger implements Logger {
    public void log(String message) {
        System.out.println(LocalDateTime.now() + " "+message);
    }
}
