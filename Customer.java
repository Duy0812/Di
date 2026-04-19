package OOP;

public class Customer implements Observer{
	private String customerId;
	private String fullName;
	private String phone;
	private String email;
	private String address;

	private static List<Customer> customerDB = new ArrayList<>();
    private static List<Booking> bookingDB = new ArrayList<>();

	
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
		boolean emailExists = customerDB.stream()
                .anyMatch(c -> c.getEmail().equals(this.email));

        if (emailExists) {
            System.out.println("❌ Đăng ký thất bại: Email '" + this.email + "' đã được sử dụng.");
            return false;
        }

		customerDB.add(this);
        System.out.println("✅ Đăng ký thành công tài khoản cho khách hàng: " + this.fullName);
        return true;
	}

	public static Optional<Customer> login(String inputEmail, String inputPassword) {
        System.out.println("\nĐang xác thực tài khoản: " + inputEmail + "...");
        
        Optional<Customer> loggedInUser = customerDB.stream()
                .filter(c -> c.getEmail().equals(inputEmail) && c.getPassword().equals(inputPassword))
                .findFirst();

        if (loggedInUser.isPresent()) {
            System.out.println("✅ Đăng nhập thành công! Chào mừng " + loggedInUser.get().getFullName());
        } else {
            System.out.println("❌ Đăng nhập thất bại: Sai email hoặc mật khẩu.");
        }
        
        return loggedInUser;
	}

	public void viewBookingHistory() {
		System.out.println("\n=== LỊCH SỬ ĐẶT TIỆC CỦA " + this.fullName.toUpperCase() + " ===");

        // Dùng Java 8 Stream để lọc ra các đơn đặt tiệc thuộc về Customer này
        List<Booking> myBookings = bookingDB.stream()
                .filter(b -> b.getCustomerId().equals(this.customerId))
                .collect(Collectors.toList());

        if (myBookings.isEmpty()) {
            System.out.println("Bạn chưa có đơn đặt tiệc nào trong hệ thống.");
        } else {
            // In ra danh sách sử dụng forEach của Java 8
            myBookings.forEach(b -> {
                System.out.println("- Mã đơn: " + b.getBookingId() 
                        + " | Ngày tổ chức: " + b.getEventDate() 
                        + " | Trạng thái: " + b.getStatus());
            });
        }
        System.out.println("==================================================");
		
	}

	public String getFullName() {
		return fullName;
	}
	public void notification(Invoice invoice){
		System.out.println(	
			"🔔 [" + name + " nhận tin]: Hợp đồng của nhà hàng '" + invoice.getinvoiceId() + "' đã có mặt tại cửa hàng!");

}
