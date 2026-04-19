package OOP;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Test {

	// Các danh sách lưu trữ dữ liệu hệ thống
	public static List<BanquetHall> BanquetHall = new ArrayList<>();
	public static List<Staff> Staff = new ArrayList<>();
	public static List<Menu> Menu = new ArrayList<>();
	public static List<Booking> booking = new ArrayList<>();
	public static List<Customer> Customer = new ArrayList<>();

	static {
		// 1. Khởi tạo Sảnh có sẵn

		BanquetHall bh1 = new BanquetHall("H01", "Sao Vàng", 20, 5000000, "Trống");
		BanquetHall bh2 = new BanquetHall("H02", "Mùa Thu", 30, 10000000, "Trống");
		BanquetHall bh3 = new BanquetHall("H03", "Mùa Xuân", 50, 20000000, "Trống");
		BanquetHall bh4 = new BanquetHall("H04", "Sao Băng", 60, 30000000, "Trống");
		BanquetHall bh5 = new BanquetHall("H05", "Đại Hỷ", 90, 50000000, "Trống");
		BanquetHall bh6 = new BanquetHall("H06", "Cát Tường", 100, 100000000, "Trống");
		BanquetHall.add(bh1);
		BanquetHall.add(bh2);
		BanquetHall.add(bh3);
		BanquetHall.add(bh4);
		BanquetHall.add(bh5);
		BanquetHall.add(bh6);

		// 2. Khởi tạo Nhân viên có sẵn
		Staff st1 = new Receptionist("REC01", "Hà Thị Loan", "Receptionist", "0976749067");
		Staff st2 = new Receptionist("REC02", "Lê Bảo", "Receptionist", "0970015648");
		Staff st3 = new Receptionist("REC03", "Trường Anh", "Receptionist", "0987659385");
		Staff st4 = new Kitchen("KEC01", "Phạm Ngọc Linh", "Kitchen", "096547207");
		Staff st5 = new Kitchen("KEC01", "Nguyễn Đoàn Mạnh duy", "Kitchen", "0969164925");
		Staff st6 = new Kitchen("KEC01", "Hà Thị Linh", "Kitchen", "0986392655");
		Staff st7 = new Kitchen("KEC01", "Nguyễn Hà Anh Sơn", "Kitchen", "0986392657");
		Staff st8 = new Kitchen("KEC01", "Jonathan", "Kitchen", "0977825492");
		Staff st9 = new Kitchen("KEC01", "Anna", "Kitchen", "0982720156");
		Staff.add(st1);
		Staff.add(st2);
		Staff.add(st3);
		Staff.add(st4);
		Staff.add(st5);
		Staff.add(st6);
		Staff.add(st7);
		Staff.add(st8);
		Staff.add(st9);
		
        // 3. Khởi tạo menu
		Menu M1 = new Menu("M01", "Gà Quay Tứ Xuyên", "Gỏi ngó sen, Chè khoai môn", 3500000);
		Menu M2 = new Menu("M02", "Lẩu Hải Sản", "Súp bắp, Trái cây", 6500000);
		Menu M3 = new Menu("M03", "Gà Quay Mật Ong", "Chả giò, Tiramisu", 9500000);
		Menu M4 = new Menu("M04", "Heo quay", "Gỏi gà, Sữa chua", 7500000);
		Menu M5 = new Menu("M05", "Lẩu cá tầm", "Salad trái cây, Bánh Flan", 8500000);
		Menu M6 = new Menu("M06", "Gà lá giang", "salad cá hồi, Chè Thái", 2500000);
		Menu M7 = new Menu("M01", "Beefsteak", "Salad cá ngừ, sinh tố trái cây", 1500000);
		Menu M8 = new Menu("M07", "Vịt quay Tứ Xuyên", "Súp vi ca, Whey protein", 5500000);
		Menu.add(M1);
		Menu.add(M2);
		Menu.add(M3);
		Menu.add(M4);
		Menu.add(M5);
		Menu.add(M6);
		Menu.add(M7);
Menu.add(M8);
		
 		// 4. Khởi tạo các đơn đã đặt thành công hoặc bị hủy
		// Cách 2: Dùng Calendar để tạo một ngày cụ thể (Ví dụ: 20/05/2024)
		Calendar cal = Calendar.getInstance();
		cal.set(2024, Calendar.MAY, 01);
		Booking b1 = new Booking("B001", cal.getTime(), "Confirmed", 50000000);
		cal.set(2024, Calendar.MAY, 15);
		Booking b2 = new Booking("B002", cal.getTime(), "Cancelled", 70000000);
		cal.set(2024, Calendar.MAY, 17);
		Booking b3 = new Booking("B003", cal.getTime(), "Confirmed", 40000000);
		cal.set(2024, Calendar.MAY, 18);
		Booking b4 = new Booking("B004", cal.getTime(), "Cancelled", 60000000);
		cal.set(2024, Calendar.MAY, 20);
		Booking b5 = new Booking("B005", cal.getTime(), "Cancelled", 20000000);
		cal.set(2024, Calendar.MAY, 25);
		Booking b6 = new Booking("B006", cal.getTime(), "Cancelled", 90000000);
		booking.add(b1);
		booking.add(b2);
		booking.add(b3);
		booking.add(b4);
		booking.add(b5);
		booking.add(b6);

	}

	public static void main(String[] args) {
		Manager admin = new Manager("MGR01", "Nguyễn Văn Tĩnh", "Manager", "0901");
		Staff.add(admin);
		
		// Dieu kien kết quả doanh thu
		double total = admin.calculateTotalRevenue(booking);
		if (total > 100000000) {
			System.out.println("=> Kết quả: Doanh thu tháng này đạt chỉ tiêu xuất sắc!");
		} else {
			System.out.println("=> Kết quả: Doanh thu tháng này Không đạt chỉ tiêu!");
		}
		
		System.out.println("\n");

		
		
		
		// Hiển thị danh sách có sẵn ban đầu
		System.out.println("=== DANH SÁCH SẢNH CÓ SẴN TRONG HỆ THỐNG ===");
		DataBaseStore.BanquetHall.forEach(h -> {
			System.out.printf("%s - %s - %d - %s - %,.0f VND\n", h.getHallId(), h.getHallName(), h.getCapacity(),
					h.getStatus(), h.getBasePrice());
		}); // Kết thúc forEach tại đây

		System.out.println("\n--- THÊM SẢNH MỚI ---");

		BanquetHall bh3 = new BanquetHall("H03", "Mùa Xuân", 50, 20000000, "Trống");
		admin.addBanquetHall(bh3);
		BanquetHall bh7 = new BanquetHall("H07", "Phượng Hoàng", 50, 20000000, "Trống");
		admin.addBanquetHall(bh7);

		System.out.println("\n=== DANH SÁCH SẢNH SAU KHI CẬP NHẬT ===");
		DataBaseStore.BanquetHall.forEach(h -> {
			// Sử dụng printf để định dạng tiền tệ đẹp mắt (%,.0f)
			System.out.printf("%s - %s - %d người - %s - %,.0f VND\n", h.getHallId(), h.getHallName(), h.getCapacity(),
					h.getStatus(), h.getBasePrice());
		});

		System.out.println("\n--- XÓA SẢNH CŨ ---");

		admin.removeBanquetHall(bh3.getHallId());

		System.out.println("\n=== DANH SÁCH SẢNH SAU KHI CẬP NHẬT ===");
		DataBaseStore.BanquetHall.forEach(h -> {
			// Sử dụng printf để định dạng tiền tệ đẹp mắt (%,.0f)
			System.out.printf("%s - %s - %d người - %s - %,.0f VND\n", h.getHallId(), h.getHallName(), h.getCapacity(),
					h.getStatus(), h.getBasePrice());
		});
System.out.println("\n");
        //PHỤC VU CHO NHÂN VIÊN
		// Hiển thị danh sách có sẵn ban đầu
		System.out.println("=== DANH SÁCH NHÂN VIÊN CÓ SẴN TRONG HỆ THỐNG ===");
		DataBaseStore.Staff.forEach(s -> {
			System.out.printf("%s - %s - %s - %s\n", s.staffId, s.fullName, s.role, s.phone);
		}); // Kết thúc forEach tại đây

		
		
		
		System.out.println("\n");
		//PHỤC VỤ CHO MENU
		// Hiển thị danh sách có sẵn ban đầu
				System.out.println("=== DANH SÁCH Menu CÓ SẴN TRONG HỆ THỐNG ===");
				DataBaseStore.Menu.forEach(m -> {
					System.out.printf("%s - %s - %s - %,.0f VND\n", m.getMenuId(), m.getDishName(), m.getCategory(), m.getPricePerTable() );
				}); // Kết thúc forEach tại đây
		
	}

}
