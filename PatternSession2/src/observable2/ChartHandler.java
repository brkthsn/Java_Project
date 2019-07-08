package observable2;




public class ChartHandler{
	public static void main (String [] args){
		int [] data = {5};
		//We do not use int since we want to pass 
		//data by reference by using int array instead.
		BoxChart boxChart = new BoxChart(data);
		PieChart pieChart = new PieChart(data);
		ConcreteObservable observable = new ConcreteObservable();
		observable.addObserver(boxChart);
		observable.addObserver(pieChart);
		observable.notifyObservers();
		data[0] = 10;
		observable.notifyObservers();
	}
}