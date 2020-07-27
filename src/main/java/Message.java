public class Message {
    private int id;
    private String message;
    private MessageStatusEnum status;
    static int receivedCounter = 0;

    public Message() {
    }

    public Message(int id, String message, MessageStatusEnum status) {
        this.id = id;
        this.message = message;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageStatusEnum getStatus() {
        return status;
    }

    public void setStatus(MessageStatusEnum status) {
        this.status = status;
    }

    public void increaseReceivedCounter() {
        receivedCounter++;
    }

    public void decreaseReceivedCounter() {
        receivedCounter--;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
