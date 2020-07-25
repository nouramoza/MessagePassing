import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Initiator implements Runnable {
    private MessagePassingMain messagePassingMain;
    private Listener listener;
    private List<String> stringList;

    public Initiator(MessagePassingMain messagePassingMain, Listener listener) {
        stringList = new ArrayList<String>();
        stringList.add("HI ONE");
        stringList.add("HI TWO");
        stringList.add("HI THREE");
        stringList.add("HI FOUR");
        stringList.add("HI FIVE");
        stringList.add("HI SIX");
        stringList.add("HI SEVEN");
        stringList.add("HI EIGHT");
        stringList.add("HI NINE");
        stringList.add("HI TEN");
        this.messagePassingMain = messagePassingMain;
        this.listener = listener;
//        start();
    }

    public void run() {
        while(Message.sentCounter < 10) {
                messagePassingMain.message.add(new Message(Message.sentCounter, stringList.get(Message.sentCounter)));
                System.err.println(CommonConstants.CommonMessages.INITIATOR_MESSAGE + messagePassingMain.message.get(Message.sentCounter).getMessage());
                try {
                    sleep(CommonConstants.WaitingTime.INITIATOR_WAIT_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
                synchronized(listener) {
                    listener.notify(); // tells to the w.
                }

//            synchronized (Message.sentCounter) {
                Message.sentCounter++;
//            }
        } // end of infinite loop
//        synchronized(listener) {
//            listener.notifyAll(); // tells to the w.
//        }
    }
}
