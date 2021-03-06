import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

// Initiator class is our Subject that other objects are tracking its changes
public class Initiator implements Runnable {
    //constructor Injection
    private static MessagePassingMain messagePassingMain;
    private Listener listener;
    //initial Messages
    private List<String> stringList;

    public Initiator(MessagePassingMain messagePassingMain, Listener listener) {
        this.messagePassingMain = messagePassingMain;
        this.listener = listener;
        //initiate the messages to be transfer
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
    }

    public void run() {
        while (messagePassingMain.message.size() < CommonConstants.CommonNumbers.NUMBER_OF_COUNT ||
                Message.receivedCounter < CommonConstants.CommonNumbers.NUMBER_OF_COUNT) {
            addToMessages(messagePassingMain.message.size());
            try {
                sleep(CommonConstants.WaitingTime.INITIATOR_WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
            synchronized (listener) {
                listener.notify(); // tells to the Listener
            }
        } // end of infinite loop
    }

    public void addToMessages(int sentMessageCount) {
        if (sentMessageCount < CommonConstants.CommonNumbers.NUMBER_OF_COUNT) {
            messagePassingMain.message.add(new Message(sentMessageCount, stringList.get(sentMessageCount), MessageStatusEnum.CREATED));
            System.err.println(CommonConstants.CommonMessages.INITIATOR_MESSAGE + messagePassingMain.message.get(sentMessageCount).getMessage());
        }
    }

    public static void receiveUpdate() {
        if (messagePassingMain.message.size() >= Message.receivedCounter &&
                messagePassingMain.message.get(Message.receivedCounter - 1).getStatus().equals(MessageStatusEnum.EDITED)) {
            System.err.println(CommonConstants.CommonMessages.INITIATOR_RECEIVED_BACK_MESSAGE + messagePassingMain.message.get(Message.receivedCounter - 1).getMessage());
            messagePassingMain.message.get(Message.receivedCounter - 1).setStatus(MessageStatusEnum.READ);

        }
    }
}
