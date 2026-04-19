package OOP;

import java.util.Date;

public class Test {
	public static void main(String[] args) {
        System.out.println("  HỆ THỐNG QUẢN LÝ NHÀ HÀNG TIỆC CƯỚI (DEMO)  ");

        // --- KHỞI TẠO DỮ LIỆU MẪU (Mock Data) ---
        BanquetHall hallA = new BanquetHall("H01", "Sảnh Kim Cương", 500, 15000000, null); // Sảnh 15 triệu
        Menu menu1 = new Menu("M01", "Set Menu Hải Sản Cao Cấp", null, 5000000); // Món 5 triệu/bàn
        Service service1 = new Service("S01", "Trang trí hoa tươi VIP", 3000000); // DV 3 triệu
        Service service2 = new Service("S02", "Ban nhạc Acoustic", 2000000); // DV 2 triệu
        Customer customer = new Customer("C01", "Nguyễn Văn A", "0901234567", null, null);

        // Thiết lập thông tin khách muốn đặt
        Date eventDate = new Date(); 
        String shift = "Tối";
        int numberOfTables = 10; // Đặt 10 bàn

        System.out.println("[BƯỚC 1: TRA CỨU SẢNH]");
        System.out.println("Khách hàng " + customer.getFullName() + " muốn tổ chức tiệc " + numberOfTables + " bàn vào ca " + shift + ".");

        // --- THỰC THI LUỒNG ĐẶT TIỆC ---
        if (hallA.checkAvailability(eventDate, shift)) {
            System.out.println("-> Tra cứu thành công: Sảnh [" + hallA.getHallName() + "] đang trống. Bắt đầu tạo Đơn...\n");
            
            Booking newBooking = new Booking("B001", customer, hallA, eventDate, shift);
            
            System.out.println("[BƯỚC 2: CHỌN THỰC ĐƠN & DỊCH VỤ]");
            newBooking.addMenu(menu1); 
            System.out.println(" + Đã thêm Thực đơn: " + menu1.getDishName());
            newBooking.addService(service1);
            System.out.println(" + Đã thêm Dịch vụ: " + service1.getServiceName());
            newBooking.addService(service2);
            System.out.println(" + Đã thêm Dịch vụ: " + service2.getServiceName());

            // --- TÍNH TOÁN CHI PHÍ ---
            double total = newBooking.calculateTotal();
            double deposit = newBooking.calculateDeposit();
            
            System.out.println("\n[BƯỚC 3: TÓM TẮT ĐƠN HÀNG]");
            System.out.println("- Tiền thuê sảnh cơ bản: " + String.format("%,.0f", hallA.getBasePrice()) + " VNĐ");
            System.out.println("- Tiền thực đơn (" + numberOfTables + " bàn): " + String.format("%,.0f", menu1.getPricePerTable() * numberOfTables) + " VNĐ");
            System.out.println("- Tiền dịch vụ phát sinh: " + String.format("%,.0f", service1.getUnitPrice() + service2.getUnitPrice()) + " VNĐ");
            System.out.println("----------------------------------------------");
            System.out.println("=> TỔNG GIÁ TRỊ HỢP ĐỒNG: " + String.format("%,.0f", total) + " VNĐ");
            System.out.println("=> SỐ TIỀN CẦN ĐẶT CỌC (30%): " + String.format("%,.0f", deposit) + " VNĐ\n");

            // --- THANH TOÁN ---
            System.out.println("[BƯỚC 4: THANH TOÁN CỌC]");
            IPayment paymentMethod = new CreditCardPayment(); // Khách chọn trả qua thẻ
            newBooking.payDeposit(paymentMethod);

            // --- KIỂM TRA LUỒNG NGOẠI LỆ (HỦY ĐƠN) ---
            // Bỏ comment dòng dưới nếu bạn muốn test thử việc khách hàng gọi API hủy đơn
            // newBooking.cancelBooking();

        } else {
            System.out.println("❌ Rất tiếc, sảnh đã được đặt trong thời gian này.");
        }
    }

}
