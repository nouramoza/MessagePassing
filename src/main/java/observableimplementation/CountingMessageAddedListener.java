package observableimplementation;

public class CountingMessageAddedListener implements MessageChangedListener{
    private static int messageAddedCount = 0;

    @Override
    public void onMessageSent(Message message) {
        // Increment the number of animals
        messageAddedCount++;
        // Print the number of animals
        System.out.println("Total messages added: " + messageAddedCount);
    }
}
