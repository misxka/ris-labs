package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Queue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class SimpleMessageBean implements MessageListener {
    @Resource
    private MessageDrivenContext mdc;

    static final Logger logger = Logger.getLogger("SimpleMessageBean");

    public SimpleMessageBean() {
    }

    @Override
    public void onMessage(Message inMessage) {
        TextMessage msg = null;

        try {
            if (inMessage instanceof TextMessage) {
                msg = (TextMessage) inMessage;
                boolean isFound = this.checkWord(msg.getText());
                if (isFound) logger.log(Level.INFO, "SUCCESS: Message {0} exists in file.", msg.getText());
                else logger.log(Level.INFO, "FAILURE: Message {0} does not exist in file.", msg.getText());
            } else {
                logger.log(Level.WARNING, "Message of wrong type: {0}", inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
            mdc.setRollbackOnly();
        } catch (Throwable te) {
            te.printStackTrace();
        }
    }
    
    private boolean checkWord(String word) {
        try {
            File file = new File("D:\\RIS-Projects\\ris-labs\\lab4\\file.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String str;
            while ((str = reader.readLine()) != null) {
                String[] words = str.split("[\\s.?!-,;]+");
                String[] wordsLower = String.join(" ", words).toLowerCase().split(" ");
                
                if (Arrays.asList(wordsLower).contains(word.toLowerCase())) 
                    return true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return false;
    }
}

