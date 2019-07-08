package exp.binary.tre.height;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

interface Circle {
    double area(int n);
}

interface Rectangle {
    int area (int x,int y);
}

class Geometry implements Circle,Rectangle {

 public double area(int r) {
                             
        return 3.14 * (r * r);  
    }

public int area(int x,int y) {
                             
        return (x * y);  
    }



	 public static void main(String[] args) {
	        Geometry g = new Geometry();
	        System.out.println("I implemented: ");	
	        implementedInterfaceNames(g);
	        
	        Scanner in = new Scanner(System.in);
	        int height = in.nextInt();
	        int width = in.nextInt();
	        int radius = in.nextInt();
	        System.out.println("Rectangle area = " + g.area(height,width));
	        System.out.println("Circle area = " + g.area(radius));
	        in.close();
	    }
	    
	    /*
	    *  Takes an Object and prints the name of the interfaces it implemented
	    */
	    static void implementedInterfaceNames(Object o) {
	        Class[] interfaces = o.getClass().getInterfaces();
	        Arrays.sort(interfaces, new Comparator<Class>() {
	            public int compare(Class o1, Class o2) {
	                return o1.getName().compareTo(o2.getName());
	            }
	        } );
	        for (Class c : interfaces) {
	            System.out.println(c.getName());
	        }
	    }


}