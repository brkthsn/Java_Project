package hashcode.exp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonOverrideTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonOverride firstPerson = new PersonOverride(123L);
		PersonOverride secondPerson= new PersonOverride(1234L);
		PersonOverride thirdPerson= new PersonOverride(12345L);
		PersonOverride fourthPerson= new PersonOverride(123L);


		  List<PersonOverride> personList = new ArrayList<PersonOverride>();
		  personList.add(firstPerson);
		  personList.add(secondPerson);
		  personList.add(thirdPerson);
		  personList.add(fourthPerson);
		  personList.add(thirdPerson);
		  personList.add(fourthPerson);
		  personList.add(thirdPerson);
		  personList.add(fourthPerson);
		  personList.add(thirdPerson);
		  personList.add(fourthPerson);

		  Set<PersonOverride> personSet = new HashSet<PersonOverride>();
		  personSet.addAll(personList);

		  System.out.println("list size: " + personList.size());//10
		  System.out.println("hash set size: " + personSet.size()); //4
		  //equals metodunu da kullanarak eþitlik durumuna bakabiliyorum
		  System.out.println("is firstPerson equals fourthPerson: " +
		firstPerson.equals(fourthPerson));
		  System.out.println("is firstPerson equals secondPerson: " +
		firstPerson.equals(secondPerson));
	}

}
