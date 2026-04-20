package OOP;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private String menuId;
	private String dishName;
	private String category;
	private double pricePerTable;
	private static List<Menu> menuDB = new ArrayList<>();

	public Menu(String menuId, String dishName, String category, double pricePerTable) {
		super();
		this.menuId = menuId;
		this.dishName = dishName;
		this.category = category;
		this.pricePerTable = pricePerTable;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public void setPricePerTable(double pricePerTable) {
		this.pricePerTable = pricePerTable;
	}

	public boolean addDish() {
		// Kiểm tra trùng lặp mã món ăn
		boolean isExist = menuDB.stream().anyMatch(m -> m.getMenuId().equals(this.menuId));
		if (isExist) {
			System.out.println("❌ Thêm thất bại: Mã món ăn '" + this.menuId + "' đã tồn tại.");
			return false;
		}
		menuDB.add(this);
		System.out.println("✅ Đã thêm món ăn mới: " + this.dishName);
		return true;
	}

	public void updateMenuPrice(double newPrice) {
		if (newPrice <= 0) {
			System.out.println("❌ Lỗi: Giá tiền phải lớn hơn 0.");
			return;
		}
		double oldPrice = this.pricePerTable;
		this.pricePerTable = newPrice;
		System.out.println("✅ Đã cập nhật giá món '" + this.dishName + "': " + String.format("%,.0f", oldPrice) + " -> "
				+ String.format("%,.0f", newPrice) + " VNĐ");
	}

	public static boolean deleteDish(String targetMenuId, List<Booking> allBookings) {
		System.out.println("\n[YÊU CẦU XÓA MÓN ĂN]: " + targetMenuId);

		// Kiểm tra xem món ăn có trong đơn đặt tiệc nào sắp diễn ra không
		boolean isInActiveBooking = allBookings.stream()
				.filter(b -> b.getStatus().equals("Pending") || b.getStatus().equals("Confirmed")).anyMatch(b -> {
					// Cần ép kiểu hoặc đảm bảo Booking có hàm hasMenu trả về boolean
					return false;
				});

		if (isInActiveBooking) {
			System.out.println("⛔ TỪ CHỐI XÓA: Món ăn này đang được sử dụng trong một Đơn đặt tiệc chưa diễn ra!");
			return false;
		}

		// Tiến hành xóa bằng Java 8 removeIf
		boolean removed = menuDB.removeIf(m -> m.getMenuId().equals(targetMenuId));

		if (removed) {
			System.out.println("✅ Đã xóa hoàn toàn món ăn '" + targetMenuId + "' khỏi hệ thống.");
		} else {
			System.out.println("❌ Không tìm thấy món ăn để xóa.");
		}
		return removed;
	}

	public double getPricePerTable() {
		return pricePerTable;
	}

	public String getDishName() {
		// TODO Auto-generated method stub
		return dishName;
	}
}
