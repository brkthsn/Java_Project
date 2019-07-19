package com.jmstest.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * This class is JMS receiver client. JMSReceiver gets a message using a JMS queue;
 * 
 * @author www.fatihkabakci.com
 */
public class JMSReceiver {
   private QueueConnection connection;
   private QueueSession    session;
   private QueueReceiver   receiver;
   private String          queueName;
   private String          url;

   /**
    * @param url
    * @param queueName
    */
   public JMSReceiver(String url, String queueName) {
      this.url = url;
      this.queueName = queueName;
   }

   /**
    * @param timeout
    * @return
    * @throws JMSException
    */
   public Message receive(long timeout) throws JMSException {
      ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
      connection = (QueueConnection) connectionFactory.createQueueConnection();
      connection.start();

      session = connection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
      Queue queue = session.createQueue(queueName);
      receiver = session.createReceiver(queue);

      Message message = receiver.receive(timeout);
      return message;
   }

   /**
    * @throws JMSException
    */
   public void disconnect() throws JMSException {
      receiver.close();
      session.close();
      connection.close();
   }
}