package observableimplementation;

import java.util.ArrayList;
import java.util.List;

public class Initiator {
    List<Message> messages = new ArrayList<Message>();
    List<MessageChangedListener> listeners = new ArrayList<MessageChangedListener>();

    public void addMessage(Message message) {
        this.messages.add(message);
        this.notifyMessageAddedListeners(message);

    }

    public void registerMessageAddedListener (MessageChangedListener listener) {
        // Add the listener to the list of registered listeners
        this.listeners.add(listener);
    }
    public void unregisterMessageAddedListener (MessageChangedListener listener) {
        // Remove the listener from the list of the registered listeners
        this.listeners.remove(listener);
    }
    protected void notifyMessageAddedListeners (final Message message) {
        // Notify each of the listeners in the list of registered listeners
        this.listeners.forEach(listener -> listener.onMessageSent(message));
    }
}
