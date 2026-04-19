package OOP;

import java.util.Date;

public class BanquetHall {
	private String hallId;
	private String hallName;
	private int capacity;
	private double basePrice;
	private String status; // Trống, Đã đặt cọc, Đang bảo trì

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public BanquetHall(String hallId, String hallName, int capacity, double basePrice, String status) {
		this.hallId = hallId;
		this.hallName = hallName;
		this.capacity = capacity;
		this.basePrice = basePrice;
		this.status = status;
	}

	public String getHallId() {
		return hallId;
	}

	public void setHallId(String hallId) {
		this.hallId = hallId;
	}

	public boolean checkAvailability(Date date, String shift) {
		if (this.status.equalsIgnoreCase("đang bảo trì")) {
			System.out.println("Sảnh đang bảo trì");
			return false;
		}
		for (int i = 0; i < hallBooking.size(); i++) {
			Booking b = hallBooking.get(i);
			// check ngày đặt và chổ ngòi
			if (b.getEvenDate().compareTo(date) == 0 && b.getShift().equalsIgnoreCase(shift)) {
				System.out.println("Sảnh đã đặt");
				return false;
			}

		}
		return true;
	}

	public void updateStatus(String newStatus) {
		this.status = newStatus;
		System.out.println("Sảnh " + this.hallName + " đã chuyển sang trạng thái: " + newStatus);
	}

	public double calculateRentPrice() {
		return this.basePrice;
	}

	// Getters
	public double getBasePrice() {
		return basePrice;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

}
