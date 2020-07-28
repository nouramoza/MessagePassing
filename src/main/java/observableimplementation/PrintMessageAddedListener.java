package observableimplementation;

public class PrintMessageAddedListener implements MessageChangedListener {

    @Override
    public void onMessageSent(Message message) {
        // Print the name of the newly added animal
        System.out.println("Added a new message '" + message.getMessage() + "'");

    }
}
