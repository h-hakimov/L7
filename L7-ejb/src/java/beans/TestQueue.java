/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author DON
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myQueue")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class TestQueue implements MessageListener {

    @EJB
    private EMP_CHFacadeLocal empch;
    
    
    
    public TestQueue() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage text = (TextMessage) message;
            if (text.getStringProperty("operation").equals("Insert")){
                EMP_CH empc = EMP_CH.create(Long.parseLong(text.getText()), "Insert", new Date(System.currentTimeMillis()));
                System.out.print("Inserting");
                empch.create(empc);
            } 
            else if (text.getStringProperty("operation").equals("Remove")){
                EMP_CH empc = EMP_CH.create(Long.parseLong(text.getText()), "Remove", new Date(System.currentTimeMillis()));
                System.out.print("Deleting");
                empch.create(empc);
            }
            else {
                System.out.print("Error define message!");
            }
        } catch (JMSException e){
            e.printStackTrace();
        }
    }
    
}
