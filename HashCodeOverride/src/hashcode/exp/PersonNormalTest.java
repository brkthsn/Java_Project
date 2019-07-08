package hashcode.exp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonNormalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonNormal firstPerson = new PersonNormal(123L);
		 PersonNormal secondPerson= new PersonNormal(1234L);
		 PersonNormal thirdPerson= new PersonNormal(12345L);
		 PersonNormal fourthPerson= new PersonNormal(123L);


		  List<PersonNormal> personList = new ArrayList<PersonNormal>();
		  personList.add(firstPerson);
		  personList.add(secondPerson);
		  personList.add(thirdPerson);
		  personList.add(fourthPerson);
		  personList.add(firstPerson);
		  personList.add(secondPerson);
		  personList.add(thirdPerson);
		  personList.add(fourthPerson);

		  Set<PersonNormal> personSet = new HashSet<PersonNormal>();
		  personSet.addAll(personList);

		  System.out.println("list size: " + personList.size());
		  System.out.println("hash set size: " + personSet.size());
		  //equals metodunu da kullanarak eþitlik durumuna bakabiliyorum
		  System.out.println("is firstPerson equals fourthPerson: " +
		firstPerson.equals(fourthPerson));
		  System.out.println("is firstPerson equals secondPerson: " +
		firstPerson.equals(secondPerson));
	}

}
