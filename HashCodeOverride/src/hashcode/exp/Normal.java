package hashcode.exp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Normal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> stringList = new ArrayList<String>();
		stringList.add("String1");
		stringList.add("String2");
		stringList.add("String2");
		stringList.add("String3");
		stringList.add("String3");
		stringList.add("String3");

		Set<String> stringSet = new HashSet<String>();
		stringSet.addAll(stringList);
		stringSet.add("6");
		stringSet.add("6");
		

		System.out.println("list size: " + stringList.size());
		System.out.println("hash set size: " + stringSet.size());
	}

}
