package hashcode.exp;

public class PersonNormal {

	
	 private Long identityNumber;
	 private String name;
	 
	 
	 public PersonNormal(Long identityNumber )
		{
			this.identityNumber=identityNumber;
		}

	 public Long getIdentityNumber() {
	  return identityNumber;
	 }

	 public void setIdentityNumber(Long identityNumber) {
	  this.identityNumber = identityNumber;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }
}