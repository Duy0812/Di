package OOP;

public class Customer {
	private String customerId;
	private String fullName;
	private String phone;
	private String email;
	private String address;

	public Customer(String customerId, String fullName, String phone, String email, String address) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void registerAccount() {
	}

	public void login() {
	}

	public void viewBookingHistory() {
	}

	public String getFullName() {
		return fullName;
	}
}
