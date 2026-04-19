package OOP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Booking {
	private String bookingId;
	private Date bookingDate;
	private Date eventDate;
	private String shift;
	private String status; // Pending, Confirmed, Completed, Cancelled
		public Booking(String id, Customer customer, BanquetHall hall, Date event, String shift) {
		this.bookingId = id;
		this.customer = customer;
		this.hall = hall;
		this.eventDate = event;
		this.shift = shift;
		this.bookingDate = new Date();
		this.status = status;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BanquetHall getHall() {
		return hall;
	}

	public void setHall(BanquetHall hall) {
		this.hall = hall;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	private double depositAmount;

	// Thể hiện quan hệ kết hợp (Association) trong Class Diagram
	private Customer customer;
	private BanquetHall hall;
	private List<Menu> menus = new ArrayList<>();
	private List<Service> services = new ArrayList<>();
	private Invoice invoice; // 1 Booking sinh ra 1 Invoice


	public void addMenu(Menu m) {
		menus.add(m);
	}

	public void addService(Service s) {
		services.add(s);
	}

	public double calculateTotal() {
	double total = hall.calculateRentPrice();

		for (Menu m : menus)
			if (m != null) {
				total += m.getPricePerTable();
			}
		for (Service s : services)
			if (s != null) {
				total += s.calculateServiceFee();
			}
		return total;
	}

	public double calculateDeposit() {
		double deposit = calculateTotal() * 0.3;
		return deposit;
	}
	public void confirmBooking() {
		IPayment p = booking.getPayment();
		if (p.payDeposit()) {
            this.status = "CONFIRMED";
            System.out.println("Booking confirmed!");
        } else {
            System.out.println("Cannot confirm booking!");
        }
    }

	public void cancelBooking() {
		this.status = "Cancelled";
		this.hall.updateStatus("Trống");
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public void payDeposit(IPayment paymentMethod) {
		// TODO Auto-generated method stub
		
	}

}
