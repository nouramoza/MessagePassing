package observableimplementation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        // Create the zoo to store animals
        Initiator initiator = new Initiator();
        // Register a listener to be notified when an animal is added
        initiator.registerMessageAddedListener(new PrintMessageAddedListener());
        initiator.registerMessageAddedListener(new CountingMessageAddedListener());
        // Add an animal notify the registered listeners


        List<String> stringList = new ArrayList<String>();
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

        int count = 0;
        while (count < 10) {
            initiator.addMessage(new Message(count, stringList.get(count), MessageStatusEnum.CREATED));
            count++;
        }
    }
}
