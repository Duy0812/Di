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
		if (this.status.equals("Trống")) {
			return true;
		}
		return false;
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
