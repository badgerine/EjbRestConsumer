/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@Path("prison")
@Stateless
public class Cell{

//  @Override
  public void onMessage(Message message){
    TextMessage tm = (TextMessage) message;
    try {
      System.out.println("message received: " + tm.getText());
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
  
  @GET
  @Produces("text/plain")
  public String getData(){
      System.out.println("hitting rest endpoint");
      return "i feel i like it ease";
  }
}
