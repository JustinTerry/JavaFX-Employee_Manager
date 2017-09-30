package employee_Manager;


public class Customer {
	private String firstName, lastName, street, city, state, email, phone, zip;
	
	public Customer(String first, String last, String stree, String cit, String stat, String zipCode, String pho, String mail) {
		firstName = first;
		lastName = last;
		street = stree;
		city = cit;
		state = stat;
		email = mail;
		phone = pho;
		zip = zipCode;
	}
	
	public String getFirst() {
		return firstName;
	}
	
	public String getLast() {
		return lastName; 
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getPhone() {
		return phone;
	}

}
