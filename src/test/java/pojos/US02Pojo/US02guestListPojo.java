package pojos.US02Pojo;

import java.io.Serializable;

public class US02guestListPojo implements Serializable {

	private String name;
	private String phoneNumber;
	private String ssn;
	private String surname;
	private String username;

	public US02guestListPojo() {
	}


	public US02guestListPojo(String name, String surname, String phoneNumber, String ssn, String username) {

		this.name = name;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.surname = surname;
		this.username = username;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber(){
		return phoneNumber;
	}

	public void setSsn(String ssn){
		this.ssn = ssn;
	}

	public String getSsn(){
		return ssn;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getSurname(){
		return surname;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"US02guestListPojo{" +
			",name = '" + name + '\'' +
			",phoneNumber = '" + phoneNumber + '\'' +
			",ssn = '" + ssn + '\'' + 
			",surname = '" + surname + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}