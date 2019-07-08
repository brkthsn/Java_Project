package observable;

import java.util.Observable;

public class TrafficController extends Observable {

	   protected int           id                      = -1;
	   public final static int NUMBER_OF_TRAFFIC_LIGHT = 3;

	   public void run() {

	      while (true) {
	         id = (++id % NUMBER_OF_TRAFFIC_LIGHT);
	         setChanged();
	         notifyObservers(id);
	         System.out.println("-----------------------------------");
	      }
	   }
	}