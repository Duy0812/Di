package OOP;

public class Staff {
	private String staffId;
	private String fullName;
	private String role;
	private String phone;

	public Staff(String staffId, String fullName, String role, String phone) {
		super();
		this.staffId = staffId;
		this.fullName = fullName;
		this.role = role;
		this.phone = phone;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void confirmBooking(String bookingId) {
		System.out.println(this.fullName + " đã xác nhận đơn: " + bookingId);
	}

	public void manageSchedule() {
		System.out.println(this.fullName + " đang quản lý lịch trình.");
	}
	
	public String toString() {
        return String.format("ID: %s | Tên: %-15s | Chức vụ: %-12s | SĐT: %s", 
                              staffId, fullName, role, phone);
    }


}
