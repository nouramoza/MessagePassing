import static java.lang.Thread.sleep;

// Listener class is Observer that tracks Subject changes
public class Listener implements Runnable {

    private MessagePassingMain messagePassingMain;
    private Initiator initiator;

    public Listener(MessagePassingMain messagePassingMain) {
        this.messagePassingMain = messagePassingMain;
    }

    public void run() {
        while(Message.receivedCounter < CommonConstants.CommonNumbers.NUMBER_OF_COUNT) {
            while(messagePassingMain.message.size() <= Message.receivedCounter) { // no order
                synchronized (this) {
                    try {
                        wait(); // wait for an order
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                    }
                }
            }

            update();

            try {
                sleep(CommonConstants.WaitingTime.LISTENER_WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // end of infinite loop
    }

    public void update() {
        System.err.println(CommonConstants.CommonMessages.LISTENER_RECEIVED_MESSAGE + messagePassingMain.message.get(Message.receivedCounter).getMessage());
        String newMessage = messagePassingMain.message.get(Message.receivedCounter).getMessage()
                .concat(": ".concat(String.valueOf(Message.receivedCounter + 1)));
        messagePassingMain.message.get(Message.receivedCounter).setMessage(newMessage);
        messagePassingMain.message.get(Message.receivedCounter).setStatus(MessageStatusEnum.EDITED);
        System.err.println(CommonConstants.CommonMessages.LISTENER_EDITED_MESSAGE + newMessage);
        Message.receivedCounter++;
        initiator.receiveUpdate();
    }
}
