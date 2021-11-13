package by.zhenekns.dev.telegram.bot.entity;

public class Message {
    private String description;

    public Message(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
