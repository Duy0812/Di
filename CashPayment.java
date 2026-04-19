package OOP;

public class CashPayment implements IPayment {

	@Override
	public boolean processPayment(double amount) {
		// TODO Auto-generated method stub
		if(amount <= 0){
			System.out.println("Lỗi: Số tiền thanh toán không hợp lệ!");
			return false;
		}
		System.out.printf("Thanh toán tiền mặt thành công: %,.0f VND\n", amount);
		return true;
	}

}
