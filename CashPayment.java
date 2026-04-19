package OOP;

public class CashPayment implements IPayment {

	@Override
	public boolean processPayment(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Khách hàng thanh toán tiền mặt: " + amount + " VNĐ");
		return true;
	}

}
