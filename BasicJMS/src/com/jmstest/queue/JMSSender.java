package com.jmstest.queue;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSSender {
	   QueueConnection connection;
	   QueueSession    session;
	   QueueSender     sender;

	   String          connectionFactoryName;
	   String          queueName;

	   public JMSSender(String connectionFactoryName, String queueName) {
	      this.connectionFactoryName = connectionFactoryName;
	      this.queueName = queueName;
	   }

	   /**
	    * 
	    * @param text
	    */
	   public void send(String text) {
	      try {
	         InitialContext initContext = new InitialContext();
	         // get the environment context
	         Context context = (Context) initContext.lookup("java:comp/env");
	         // create connection factory
	         QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup(connectionFactoryName);
	         // create connection
	         connection = connectionFactory.createQueueConnection();
	         // create session
	         session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
	         // create queue
	         Queue queue = session.createQueue(queueName);
	         // create sender
	         sender = session.createSender(queue);
	         // create message
	         TextMessage msg = session.createTextMessage();
	         // fill message
	         msg.setText(text);
	         // send message
	         sender.send(msg);
	      }
	      catch (JMSException e) {
	         e.printStackTrace();
	      }
	      catch (NamingException e) {
	         e.printStackTrace();
	      }
	   }

	   /**
	    * 
	    * @throws JMSException
	    */
	   public void disconnect() throws JMSException {
	      sender.close();
	      session.close();
	      connection.close();
	   }
	}