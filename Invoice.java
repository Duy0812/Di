package OOP;

import java.util.Date;

public class Invoice {
	private String invoiceId;
	private Date paymentDate;
	private double tax;
	private double totalAmount;
	private String paymentMethod;
	private IPayment paymentProcessor; // Sử dụng Interface

	public Invoice(String invoiceId, Date paymentDate, double tax, double totalAmount, String paymentMethod) {
		super();
		this.invoiceId = invoiceId;
		this.paymentDate = paymentDate;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.paymentProcessor = paymentProcessor;
	}

	public Invoice(String id, double tax, double totalAmount) {
		this.invoiceId = id;
		this.tax = tax;
		this.totalAmount = totalAmount;
		this.paymentDate = new Date();
	}

	public void processPayment(IPayment method) {
		this.paymentProcessor = method;
		this.paymentProcessor.processPayment(this.totalAmount + (this.totalAmount * tax));
		this.paymentMethod = method.getClass().getSimpleName();
	}

	public void generateInvoice() {
		System.out.println("Đã xuất hóa đơn: " + invoiceId);
		System.out.println("Phương thức thanh toán: " + paymentMethod);
	}

	public void refundDeposit(double amount) {
		System.out.println("Hoàn tiền cọc: " + amount);
	}
	public void setPaymentMethod(IPayment method) {
		this.paymentProcessor = method;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}


}
