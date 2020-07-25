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
        Initiator initiator = new Initiator(messagePassingMain, listener);

//        listener.join();
//        initiator.join();

//        for (int i = 0; i < 10; i++) {
//            System.err.println(messagePassingMain.message.get(i).getMessage());
//        }

    }
}
