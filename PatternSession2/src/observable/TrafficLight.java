package observable;

import java.util.Observable;
import java.util.Observer;

public class TrafficLight implements Observer, Runnable {

	   private int     id;
	   private Colors  light;
	   private boolean isActive;

	   public TrafficLight(int id) {

	      this.setId(id);
	      this.setActive(false);
	      this.stop();
	    //  new Thread(this, "Traffic Light " + id).start();
	   }

	   public void stop() {
	      light = Colors.RED;
	   }

	   public void ready() {
	      light = Colors.YELLOW;
	   }

	   public void go() {
	      light = Colors.GREEN;
	   }

	   public Colors status() {
	      return light;
	   }

	   public int getId() {
	      return id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   public boolean isActive() {
	      return isActive;
	   }

	   public void setActive(boolean isActive) {
	      this.isActive = isActive;
	   }

	   public void run() {

	      if (isActive()) {
	         this.ready();
	         System.out.println("Traffic Light" + this.getId() + ":" + light.name()+System.currentTimeMillis());
	         this.go();
	      }
	      else {
	         this.stop();
	      }

	      try {
	         System.out.println("Traffic Light" + this.getId() + ":" + light.name());
	         Thread.sleep(2000);
	      }
	      catch (InterruptedException e) {
	         e.printStackTrace();
	      }
	   }

	   public void update(Observable arg0, Object arg1) {
	      int id = (Integer) arg1;
	      if (this.getId() == id) {
	         setActive(true);
	      }
	      else {
	         setActive(false);
	      }
	      this.run();
	   }
	}