package com.jmstest.queue;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.broker.BrokerService;
//
//import com.fatihkabakci.Queue.JMSReceiver;
//import com.fatihkabakci.Queue.JMSSender;
//import com.fatihkabakci.Topic.JMSPublisher;
//import com.fatihkabakci.Topic.JMSSubscriber;

/**
 * Servlet implementation class JMSServlet
 * 
 * @author www.fatihkabakci.com
 */
@WebServlet("/JMSServlet")
public class JMSServlet extends HttpServlet {
   private static final long  serialVersionUID   = 1L;

   private BrokerService      broker;
   public final static String URL                = "tcp://localhost:61616";
   public final static String CONNECTION_FACTORY = "jms/ConnectionFactory";
   public final static String QUEUE              = "jms/queue/MyQueue";
   public final static String TOPIC              = "jms/topic/MyTopic";

   /**
    * @see HttpServlet#init(ServletConfig config)
    */
   public void init(ServletConfig config) throws ServletException {
      try {
         broker = new BrokerService();
         broker.addConnector("tcp://localhost:61616");
         broker.start();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
    */
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {

         PrintWriter out = response.getWriter();
         response.setContentType("text/html");
         boolean isQueueMessaging = (request.getParameter("queue") == null) ? false : true;

         if (isQueueMessaging) {
            boolean isReceive = (request.getParameter("breceive") == null) ? false : true;
            if (isReceive) {
               JMSReceiver receiver = new JMSReceiver(URL, QUEUE);
               Message message = receiver.receive(5);
               String text = getText(message);
               out.println("<h2>Message Received:" + text + "</h2>");
               receiver.disconnect();
            }
            else {
               String textMessage = request.getParameter("qmessage");
               if (textMessage != null) {
                  JMSSender sender = new JMSSender(CONNECTION_FACTORY, QUEUE);
                  sender.send(textMessage);
                  sender.disconnect();
                  out.println("<h2>Message sent !</h2>");
               }
            }
         }
         // topic messaging
//         else {
//            boolean isSubscribe = (request.getParameter("bsubscribe") == null) ? false : true;
//            if (isSubscribe) {
//               JMSSubscriber subscriber = new JMSSubscriber(URL, TOPIC);
//               subscriber.receive();
//               String text = null;
//               while ((text = subscriber.getTextFromListener()) == null);
//               out.println("<h2>Message Received:" + text + "</h2>");
//               subscriber.disconnect();
//            }
//            else {
//               String textMessage = request.getParameter("tmessage");
//               if (textMessage != null) {
//                  JMSPublisher publisher = new JMSPublisher(CONNECTION_FACTORY, TOPIC);
//                  publisher.publish(textMessage);
//                  publisher.disconnect();
//                  out.println("<h2>Message sent !</h2>");
//               }
//            }
//         }

      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.service(request, response);
   }

   /**
    * @see HttpServlet#destroy()
    */
   public void destroy() {
      try {
         broker.stop();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * @param message
    * @return
    * @throws JMSException
    */
   private String getText(Message message) throws JMSException {
      if (message instanceof TextMessage) {
         TextMessage textMessage = (TextMessage) message;
         String text = textMessage.getText();
         return text;
      }
      return null;
   }
}