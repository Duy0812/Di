package OOP;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Manager extends Staff {

	public Manager(String staffId, String fullName, String phone) {
		super(staffId, fullName, "Manager", phone);
		// TODO Auto-generated constructor stub
	}
	// Thực thi thống kê doanh thu từ danh sách hóa đơn

		public void reportRevenue(List<Invoice> invoices) {
			double totalRevenue = invoices.stream().mapToDouble(Invoice::getTotalAmount).sum();

			System.out.println("=== BÁO CÁO DOANH THU ===");
			System.out.println("Tổng số hóa đơn: " + invoices.size());
			System.out.println("Tổng doanh thu: " + totalRevenue + " VND");
			System.out.println("-------------------------");
		}

		// Thống kê trạng thái các đơn đặt chỗ (Booking)

		public void reportBookingStats(List<Booking> bookings) {
			// Gom nhóm và đếm số lượng theo trạng thái (Confirmed, Pending, Cancelled)
			Map<String, Long> stats = bookings.stream()
					.collect(Collectors.groupingBy(Booking::getStatus, Collectors.counting()));

			System.out.println("=== THỐNG KÊ ĐẶT CHỖ ===");
			stats.forEach((status, count) -> {
				System.out.println("Trạng thái [" + status + "]: " + count + " đơn.");
			});
		}

		private List<BanquetHall> halls = new ArrayList<>();

		// Them sanh
		public void addBanquetHall(BanquetHall newHall) {
			halls.add(newHall);
			System.out.println("Hệ thống: Đã thêm phòng tiệc mới thành công: " + newHall.getHallName());
		}

		// Xoa sanh
		public void removeBanquetHall(String hallId) {
			boolean removed = halls.removeIf(hall -> hall.getHallId().equalsIgnoreCase(hallId));

			if (removed) {
				System.out.println("Hệ thống: Đã xóa phòng tiệc có ID: " + hallId);
			} else {
				System.out.println("Hệ thống: Không tìm thấy phòng tiệc với mã ID: " + hallId);
			}
		}

		// Phương thức hiển thị danh sách phòng hiện có
		public void displayHalls() {
			System.out.println("--- Danh sách phòng tiệc hiện tại ---");
			if (halls.isEmpty()) {
				System.out.println("Trống.");
			} else {
				halls.forEach(System.out::println);
			}
		}

		private List<Staff> staffList = new ArrayList<>();

		// Them tai khoan nv khi co nguoi moi
		public void addStaffAccount(Staff newStaff) {
			// Kiểm tra xem ID đã tồn tại chưa để tránh trùng lặp
			boolean exists = staffList.stream().anyMatch(s -> s.getStaffId().equals(newStaff.getStaffId()));

			if (exists) {
				System.out.println("Lỗi: Mã nhân viên " + newStaff.getStaffId() + " đã tồn tại!");
			} else {
				staffList.add(newStaff);
				System.out.println("Thành công: Đã thêm tài khoản cho nhân viên " + newStaff.getFullName());
			}
		}

		// Xoa tai khoan nv khi co nguoi nghi
		public void removeStaffAccount(String staffId) {
			boolean removed = staffList.removeIf(staff -> staff.getStaffId().equalsIgnoreCase(staffId));

			if (removed) {
				System.out.println("Hệ thống: Đã xóa tài khoản nhân viên ID [" + staffId + "] khỏi hệ thống.");
			} else {
				System.out.println("Lỗi: Không tìm thấy nhân viên có mã ID: " + staffId);
			}
		}

		// Hiển thị danh sách nhân sự
		public void displayStaffList() {
			System.out.println("\n===== DANH SÁCH NHÂN VIÊN =====");
			if (staffList.isEmpty()) {
				System.out.println("Chưa có nhân viên nào trong danh sách.");
			} else {
				staffList.forEach(System.out::println);
			}
			System.out.println("================================\n");
		}

		private List<Menu> menuList = new ArrayList<>();

		// Thêm một thực đơn/món ăn mới

		public void addMenu(Menu newMenu) {
			// Kiểm tra trùng ID
			boolean exists = menuList.stream().anyMatch(m -> m.getMenuId().equals(newMenu.getMenuId()));

			if (exists) {
				System.out.println("Lỗi: Mã thực đơn " + newMenu.getMenuId() + " đã tồn tại!");
			} else {
				menuList.add(newMenu);
				System.out.println("Thành công: Đã thêm '" + newMenu.getDishName() + "' vào danh mục.");
			}
		}

		// Xóa thực đơn/món ăn

		public void removeMenu(String menuId) {
			boolean removed = menuList.removeIf(m -> m.getMenuId().equalsIgnoreCase(menuId));

			if (removed) {
				System.out.println("Hệ thống: Đã xóa thực đơn mã [" + menuId + "].");
			} else {
				System.out.println("Lỗi: Không tìm thấy thực đơn nào có mã: " + menuId);
			}
		}

		
		//Hiển thị danh mục thực đơn hiện có
		public void displayMenuList() {
			System.out.println("\n========= DANH MỤC THỰC ĐƠN =========");
			if (menuList.isEmpty()) {
				System.out.println("Danh mục trống.");
			} else {
				menuList.forEach(System.out::println);
			}
			System.out.println("=====================================\n");
		}


}
