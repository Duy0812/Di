package OOP;

public class CreditCardPayment implements IPayment {

	@Override
	public boolean processPayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Đang xử lý thanh toán thẻ tín dụng: " + amount + " VNĐ");
		return true;
	}

}
