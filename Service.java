package OOP;

import java.util.ArrayList;
import java.util.List;

public class Service {
	private String serviceId;
	private String serviceName;
	private double unitPrice;
	private static List<Service> serviceDB = new ArrayList<>();

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public Service(String serviceId, String serviceName, double unitPrice) {
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.unitPrice = unitPrice;
	}

	public boolean addService() {
		boolean isExist = serviceDB.stream().anyMatch(s -> s.getServiceId().equals(this.serviceId));
		if (isExist) {
			System.out.println("❌ Thêm thất bại: Mã dịch vụ '" + this.serviceId + "' đã tồn tại.");
			return false;
		}
		serviceDB.add(this);
		System.out.println("✅ Đã thêm dịch vụ mới: " + this.serviceName);
		return true;
	}

	public double calculateServiceFee(int quantity) {
		// Trong trường hợp dịch vụ tính theo số lượng (VD: thuê 3 ca sĩ, 2 máy chiếu)
		double totalFee = this.unitPrice * quantity;
		System.out.println("   -> Phí dịch vụ '" + this.serviceName + "' (SL: " + quantity + "): "
				+ String.format("%,.0f", totalFee) + " VNĐ");
		return totalFee;
	}

	public double getServiceFee() {
		return calculateServiceFee(getUnitPrice());
	}

	public static boolean deleteService(String targetServiceId, List<Booking> allBookings) {
		System.out.println("\n[YÊU CẦU XÓA DỊCH VỤ]: " + targetServiceId);

		boolean isInActiveBooking = allBookings.stream()
				.filter(b -> b.getStatus().equals("Pending") || b.getStatus().equals("Confirmed")).anyMatch(b -> {
					return false; // Thay bằng b.hasService(targetServiceId) nếu Booking đã hoàn thiện
				});

		if (isInActiveBooking) {
			System.out.println("⛔ TỪ CHỐI XÓA: Dịch vụ này đang được khách hàng đặt cho sự kiện sắp tới!");
			return false;
		}

		boolean removed = serviceDB.removeIf(s -> s.getServiceId().equals(targetServiceId));
		if (removed) {
			System.out.println("✅ Đã xóa hoàn toàn dịch vụ '" + targetServiceId + "' khỏi hệ thống.");
		}
		return removed;
	}

	public String getServiceName() {
		// TODO Auto-generated method stub
		return serviceName;
	}

	public int getUnitPrice() {
		// TODO Auto-generated method stub
		return (int) this.unitPrice;
	}

}
