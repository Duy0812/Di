package OOP;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		System.out.println("========== BẮT ĐẦU KIỂM THỬ TOÀN BỘ HỆ THỐNG ==========\n");

		/*
		 * =============================================================================
		 * ======= PHẦN 1: KIỂM THỬ CHỨC NĂNG CỦA QUẢN LÝ (MANAGER) & SETUP HỆ THỐNG
		 * =============================================================================
		 * =======
		 */
		System.out.println("--- 1. TEST CHỨC NĂNG QUẢN LÝ (MANAGER) ---");
		Manager admin = new Manager("MGR01", "Nguyễn Văn Tĩnh", "0912345678");

		// Test thêm/xóa Sảnh tiệc
		BanquetHall hall1 = new BanquetHall("H01", "Sảnh Kim Cương", 100, 50000000, "Trống");
		admin.addBanquetHall(hall1);
		admin.addBanquetHall(new BanquetHall("H02", "Sảnh Bạch Kim", 80, 40000000, "Trống"));
		admin.removeBanquetHall("H02"); // Test xóa
		admin.displayHalls(); // In danh sách

		// Test thêm/xóa Nhân viên
		Staff rec1 = new Receptionist("REC01", "Lễ tân A", "Receptionist", "0988");
		admin.addStaffAccount(rec1);
		admin.displayStaffList();

		// Test thêm/xóa Thực đơn qua Manager
		Menu menu1 = new Menu("M01", "Combo Đám Cưới 1", "Trọn gói", 5000000);
		admin.addMenu(menu1);
		admin.displayMenuList();

		/*
		 * =============================================================================
		 * ======= PHẦN 2: KIỂM THỬ TÀI KHOẢN KHÁCH HÀNG (CUSTOMER) & OBSERVER PATTERN
		 * =============================================================================
		 * =======
		 */
		System.out.println("\n--- 2. TEST TÀI KHOẢN KHÁCH HÀNG ---");
		Customer customer1 = new Customer("C01", "Trần Khách Hàng", "0999888777", "khach@gmail.com", "Hà Nội",
				"123456");

		// Đăng ký và Đăng nhập
		customer1.registerAccount();
		customer1.registerAccount(); // Thử đăng ký lại để test báo lỗi trùng Email
		Customer.login("khach@gmail.com", "123456"); // Test login đúng
		Customer.login("khach@gmail.com", "sai_pass"); // Test login sai

		/*
		 * =============================================================================
		 * ======= PHẦN 3: KIỂM THỬ THÊM DỊCH VỤ & THỰC ĐƠN ĐỘC LẬP
		 * =============================================================================
		 * =======
		 */
		System.out.println("\n--- 3. TEST DỊCH VỤ (SERVICE) VÀ THỰC ĐƠN (MENU) ---");
		Service s1 = new Service("SV01", "Thuê Ca Sĩ", 2000000);
		s1.addService();
		s1.calculateServiceFee(3); // Test tính phí 3 ca sĩ

		Menu m2 = new Menu("M02", "Lẩu Thái Hải Sản", "Món Chính", 3000000);
		m2.addDish();
		m2.updateMenuPrice(3500000); // Test cập nhật giá tiền món ăn

		/*
		 * =============================================================================
		 * ======= PHẦN 4: KIỂM THỬ LUỒNG ĐẶT TIỆC (BOOKING) & THANH TOÁN (STRATEGY
		 * PATTERN)
		 * =============================================================================
		 * =======
		 */
		System.out.println("\n--- 4. TEST ĐẶT TIỆC VÀ THANH TOÁN ---");

		// Tạo ngày sự kiện là 15 ngày sau kể từ hôm nay
		Calendar eventDate = Calendar.getInstance();
		eventDate.add(Calendar.DAY_OF_MONTH, 15);

		Booking booking1 = new Booking("B001", new Date(), eventDate.getTime(), "Tối", "PENDING", 50000000);

		System.out.println("Tổng tiền dự kiến (Base): " + booking1.calculateTotal() + " VNĐ");
		System.out.println("Tiền cọc cần thanh toán (30%): " + booking1.calculateDeposit() + " VNĐ");

		// Áp dụng Strategy Pattern cho Thanh Toán (Credit Card)
		IPayment creditCardPay = new CreditCardPayment();
		Invoice invoice1 = new Invoice("INV001", new Date(), 0.1, booking1.calculateTotal(), "CreditCard");

		// Khách hàng tiến hành thanh toán cọc để xác nhận
		System.out.println("\n[Khách hàng tiến hành thanh toán cọc]");
		booking1.confirmBooking(creditCardPay); // Gọi logic xác nhận cọc của Booking

		// Test Observer: Gửi thông báo hóa đơn cho khách hàng
		customer1.update(invoice1);

		/*
		 * =============================================================================
		 * ======= PHẦN 5: KIỂM THỬ HỦY TIỆC (BOOKING MANAGER) & TÍNH PHÍ PHẠT
		 * =============================================================================
		 * =======
		 */
		System.out.println("\n--- 5. TEST HỦY ĐƠN VÀ TÍNH PHÍ PHẠT ---");
		BookingManager bookingManager = new BookingManager();

		// Test khách hàng chủ động hủy
		bookingManager.customerCancelBooking(booking1);

		// Test hệ thống tự động hủy (Setup timeout giả lập)
		Booking booking2 = new Booking("B002", new Date(), eventDate.getTime(), "Sáng", "PENDING", 20000000);
		bookingManager.setupTimeoutCancel(booking2); // Sẽ chạy ngầm tiến trình 24h

		/*
		 * =============================================================================
		 * ======= PHẦN 6: KIỂM THỬ BÁO CÁO THỐNG KÊ (REPORT)
		 * =============================================================================
		 * =======
		 */
		System.out.println("\n--- 6. TEST BÁO CÁO THỐNG KÊ CHO QUẢN LÝ ---");

		// Giả lập danh sách hóa đơn và Booking để thống kê
		Invoice invoice2 = new Invoice("INV002", 0.1, 40000000); // Đơn giản hóa constructor
		List<Invoice> invoiceList = Arrays.asList(invoice1, invoice2);
		List<Booking> currentBookings = Arrays.asList(booking1, booking2);

		admin.reportRevenue(invoiceList); // In tổng doanh thu
		admin.reportBookingStats(currentBookings); // Đếm số lượng theo trạng thái

		System.out.println("\n========== HOÀN TẤT KIỂM THỬ ==========");
	}
}
