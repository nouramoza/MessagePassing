import java.util.List;

public class Listener extends Thread {

    private MessagePassingMain messagePassingMain;

    public Listener(MessagePassingMain messagePassingMain) {
        this.messagePassingMain = messagePassingMain;
        start();
    }

    public void run() {
        while(Message.receivedCounter < 10) {
            while(messagePassingMain.message.size() <= Message.receivedCounter) { // no order
                synchronized (this) {
                    try {
//                        if (1==2) {
                        wait(); // wait for an order
//                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                    }
                }
            }

//            synchronized (messagePassingMain.message.get(Message.receivedCounter).getMessage()) {
            String newMessage = messagePassingMain.message.get(Message.receivedCounter).getMessage()
                    .concat(": ".concat(String.valueOf(Message.receivedCounter + 1)));
            messagePassingMain.message.get(Message.receivedCounter).setMessage(newMessage);
                System.err.println(CommonConstants.CommonMessages.LISTENER_MESSAGE + newMessage);
//            }

            try {
                sleep(CommonConstants.WaitingTime.LISTENER_WAIT_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            messagePassingMain.message.get(Message.receivedCounter) = new Message();
            Message.receivedCounter++;
//            Message.counter = counter;
//            Message.counter++;
        } // end of infinite loop

    }
}
