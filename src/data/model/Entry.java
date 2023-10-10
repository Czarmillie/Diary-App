package data.model;

import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    private String body;
    private LocalDateTime localDateTime;

    public String setOwnerName(String ownerName) {
        return ownerName;
    }

    public String getOwnerName() {
        return null;
    }
}
