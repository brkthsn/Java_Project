package puzzle;

 class Base {

	public void fun() {
		System.out.println("Base fun");
	}
	
	public static void disp () {
		System.out.println("Base static disp");
	}
 }
	
class Der  extends Base{
	public void fun() {
		System.out.println("Der fun");
	}
	
	public static void disp2 () {
		System.out.println("Der static disp");
	}
}
	
	public class HidingDemo {
		public static void main (String [] args) {
			Base b = new Der ();
			b.fun();
			b.disp();
		}
}
