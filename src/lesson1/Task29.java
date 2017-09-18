package lesson1;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task29 {

    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(new LogEntry());
        Map<String, Long> clickCount =
                logs.stream()
                        .collect(Collectors.groupingBy(item -> item.getUrl(), Collectors.counting()));


    }
}

class LogEntry {
    private Date created;
    private String login;
    private String url;

    public Date getCreated() {
        return created;
    }

    public String getLogin() {
        return login;
    }

    public String getUrl() {
        return url;
    }
}
