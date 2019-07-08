package observable;

public class Main {
	 public static void main(String[] args) {

	      TrafficLight tl1 = new TrafficLight(0);
	      TrafficLight tl2 = new TrafficLight(1);
	      TrafficLight tl3 = new TrafficLight(2);

	      TrafficController controller = new TrafficController();

	      controller.addObserver(tl1);
	      controller.addObserver(tl2);
	      controller.addObserver(tl3);

	      controller.run();
	   }
}
