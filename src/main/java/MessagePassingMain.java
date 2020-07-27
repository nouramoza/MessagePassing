import java.util.ArrayList;
import java.util.List;

public class MessagePassingMain {

    public List<Message> message;
    public MessagePassingMain() {
        message = new ArrayList<Message>();
    }

    public static void main(String[] args) throws InterruptedException {
        MessagePassingMain messagePassingMain = new MessagePassingMain();
        Listener listener = new Listener(messagePassingMain);
        new Thread(listener).start();
        new Thread(new Initiator(messagePassingMain, listener)).start();
    }
}
