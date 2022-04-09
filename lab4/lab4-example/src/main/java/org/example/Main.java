package org.example;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Main {
    
    private static final String[] words = { "orange", "sin", "Nec", "lorem", "battle", "refrigerator", "radiation", "adipiscing", "cruelty", "wall" };
    
    public static void main(String[] args) throws Exception {
        try {
            Context ctx = new InitialContext();
            QueueConnectionFactory f = (QueueConnectionFactory)ctx.lookup("jms/__defaultConnectionFactory");
            QueueConnection connection = f.createQueueConnection();

            connection.start();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue t = (Queue)ctx.lookup("jms/Queue");
            QueueSender sender = session.createSender(t);

            TextMessage message = session.createTextMessage();

            for (String word : words) {
                message.setText(word);
                System.out.println("Sending message: " + message.getText());
                sender.send(message);
            }

            connection.close();
        } catch (JMSException | NamingException e) {
            System.out.println(e);
        }
    }
}
