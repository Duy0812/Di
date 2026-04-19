package OOP;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BookingManager {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);

    // --- PHƯƠNG THỨC 1: KHÁCH HÀNG CHỦ ĐỘNG HỦY ---
    public void customerCancelBooking(Booking booking) {
        if (booking.getStatus().equals("CANCELLED")) {
            System.out.println("Booking này đã được hủy trước đó.");
            return;
        }

        // Logic bổ sung: Ví dụ nếu đã thanh toán thì hoàn tiền một phần
        if (booking.getPayment() != null && booking.getPayment().isProcessed()) {
            System.out.println("Hệ thống: Khách đã cọc, thực hiện hoàn tiền 80%...");
        }

        booking.setStatus("CANCELLED");
        System.out.println("Thông báo: Khách hàng " + booking.getCustomerName() + " đã chủ động hủy booking.");
    }

    // --- PHƯƠNG THỨC 2: TỰ ĐỘNG HỦY DO QUÁ HẠN 24 GIỜ ---
    public void setupTimeoutCancel(Booking booking, IPayment payment) {
        System.out.println("Hệ thống: Bắt đầu đếm ngược 24 giờ cho Booking " + booking.getId());

        scheduler.schedule(() -> {
            // Kiểm tra: Nếu chưa thanh toán cọc VÀ booking chưa bị hủy bởi khách/quản lý
            if (!payment.isProcessed() && !booking.getStatus().equals("CANCELLED")) {
                
                booking.setStatus("CANCELLED");
                
                System.out.println("------------------------------------------------");
                System.out.println("HỆ THỐNG TỰ ĐỘNG HỦY:");
                System.out.println("Booking ID: " + booking.getId());
                System.out.println("Lý do: Quá 24 giờ mà chưa hoàn tất thanh toán tiền cọc.");
                System.out.println("------------------------------------------------");
            }
        }, 24, TimeUnit.HOURS); 
        // Khi chạy test, bạn hãy đổi TimeUnit.HOURS thành TimeUnit.SECONDS để thấy kết quả ngay
    }
}
