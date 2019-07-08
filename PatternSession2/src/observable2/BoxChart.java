package observable2;

public class BoxChart implements Observer{
	int [] data;
	public BoxChart(int [] data){
		this.data = data;
	}
	public void handleNotification(){
		System.out.println("Box Chart data is : "+data[0]);
	}
}
