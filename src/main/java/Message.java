public class Message {
    private int id;
    private String message;
    static int sentCounter = 0;
    static int receivedCounter = 0;

    public Message() {
    }

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
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

    public void increaseSentCounter() {
        sentCounter++;
    }

    public void decreaseSentCounter() {
        sentCounter--;
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
                ", message='" + message +
                ", sentCounter='" + sentCounter +
                ", receivedCounter='" + receivedCounter + '\'' +
                '}';
    }
}
