package hashcode.exp;

public class PersonOverride {
	private Long identityNumber;
	private String name;

	public PersonOverride(Long identityNumber) {
		this.identityNumber = identityNumber;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonOverride other = (PersonOverride) obj;
		if (identityNumber == null) {
			if (other.identityNumber != null)
				return false;
		} else if (!identityNumber.equals(other.identityNumber))
			return false;
		return true;
	}

}
