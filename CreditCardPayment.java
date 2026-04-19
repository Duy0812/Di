package OOP;

public class CreditCardPayment implements IPayment {

	@Override
	public boolean processPayment(double amount) {
        // Giả lập kiểm tra số dư (ví dụ không quá 1 tỷ)
        if (amount > 1000000000) {
            System.out.println("Lỗi: Giao dịch bị từ chối bởi ngân hàng!");
            return false;
        }
        System.out.printf("Thanh toán thẻ thành công: %,.0f VND\n", amount);
        return true;
    }
}	}
@Override
	public boolean payDeposit(double amount) {
		// Giả lập kết nối ngân hàng
		System.out.println("Đang kết nối cổng thanh toán thẻ: " + cardNumber);
		System.out.println("Đã trừ tiền cọc: " + amount + " VNĐ từ tài khoản thẻ.");
		return true; // Giả định luôn thành công
	}
}
