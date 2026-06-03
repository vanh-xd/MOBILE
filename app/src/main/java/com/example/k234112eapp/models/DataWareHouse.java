package com.example.k234112eapp.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DataWareHouse {
    public static ArrayList<Category> getCategories()
    {
        ArrayList<Category> categories = new ArrayList<>();

        Category c1 = new Category("c1", "Trai cay", "An qua nho ke trong cay");
        Category c2 = new Category("c2", "Kimchi", "Kimchi do au");
        Category c3 = new Category("c3", "My", "My ngon ngon");
        Category c4 = new Category("c4", "Thit", "Thit nhung thuoc tuoi nhu moi");
        categories.add(c1);
        categories.add(c2);
        categories.add(c3);
        categories.add(c4);

        return categories;
    }
    public static ArrayList<Product> getProducts()
    {
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Category> categories = getCategories();

        // Trai cay (c1)
        products.add(new Product("p1", "Trai tac tui", 100, 10000, 0, 0.05, categories.get(0).getCateId()));
        products.add(new Product("p2", "Chanh khong hat", 500, 25000, 0, 0.05, categories.get(0).getCateId()));
        products.add(new Product("p3", "Bo trai", 200, 50000, 0, 0.07, categories.get(0).getCateId()));
        products.add(new Product("p4", "Xoai Cat Chu", 150, 60000, 0, 0.05, categories.get(0).getCateId()));
        products.add(new Product("p5", "Dua hau Long An", 300, 15000, 0, 0.05, categories.get(0).getCateId()));

        // Kimchi (c2)
        products.add(new Product("p6", "Kimchi cai thao", 150, 45000, 0, 0.05, categories.get(1).getCateId()));
        products.add(new Product("p7", "Kimchi cu cai", 120, 40000, 0, 0.05, categories.get(1).getCateId()));
        products.add(new Product("p8", "Kimchi dua leo", 80, 35000, 0, 0.05, categories.get(1).getCateId()));
        products.add(new Product("p9", "Kimchi gia", 100, 25000, 0, 0.05, categories.get(1).getCateId()));

        // My (c3)
        products.add(new Product("p10", "My Hao Hao", 1000, 4500, 0, 0.1, categories.get(2).getCateId()));
        products.add(new Product("p11", "My Kokomi", 800, 4000, 0, 0.1, categories.get(2).getCateId()));
        products.add(new Product("p12", "My Omachi", 600, 8000, 0, 0.1, categories.get(2).getCateId()));
        products.add(new Product("p13", "My Siu Kay", 400, 12000, 0, 0.1, categories.get(2).getCateId()));
        products.add(new Product("p14", "My 3 Mien", 1200, 3500, 0, 0.1, categories.get(2).getCateId()));

        // Thit (c4)
        products.add(new Product("p15", "Thit bo Uc", 50, 250000, 0, 0.05, categories.get(3).getCateId()));
        products.add(new Product("p16", "Thit heo ba chi", 100, 150000, 0, 0.05, categories.get(3).getCateId()));
        products.add(new Product("p17", "Thit ga ta", 70, 120000, 0, 0.05, categories.get(3).getCateId()));
        products.add(new Product("p18", "Thit cuu Ninh Thuan", 30, 350000, 0, 0.05, categories.get(3).getCateId()));

        return products;
    }
    public static ArrayList<Employee> getEmployees()
    {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("e1", "Nguyen Van A", "0912345678"));
        employees.add(new Employee("e2", "Tran Thi B", "0987654321"));
        employees.add(new Employee("e3", "Le Van C", "0901234567"));
        employees.add(new Employee("e4", "Pham Thi D", "0934567890"));
        employees.add(new Employee("e5", "Hoang Van E", "0978901234"));
        employees.add(new Employee("e6", "Huynh Thi F", "0967890123"));
        employees.add(new Employee("e7", "Phan Van G", "0945678901"));
        employees.add(new Employee("e8", "Vu Thi H", "0923456789"));
        employees.add(new Employee("e9", "Dang Van I", "0956789012"));
        employees.add(new Employee("e10", "Bui Thi K", "0911223344"));
        employees.add(new Employee("e11", "Do Van L", "0999888777"));
        return employees;
    }
    public static ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();
        Calendar cal = Calendar.getInstance();

        cal.set(1990, 0, 1);
        customers.add(new Customer("c1", "Nguyen Van A", "0912345678", "Ha Noi", "a.nguyen@example.com", cal.getTime()));

        cal.set(1992, 4, 15);
        customers.add(new Customer("c2", "Tran Thi B", "0987654321", "TP. HCM", "b.tran@example.com", cal.getTime()));

        cal.set(1985, 10, 20);
        customers.add(new Customer("c3", "Le Van C", "0901234567", "Da Nang", "c.le@example.com", cal.getTime()));

        cal.set(1995, 2, 10);
        customers.add(new Customer("c4", "Pham Thi D", "0934567890", "Can Tho", "d.pham@example.com", cal.getTime()));

        cal.set(1988, 7, 5);
        customers.add(new Customer("c5", "Hoang Van E", "0978901234", "Hai Phong", "e.hoang@example.com", cal.getTime()));

        cal.set(1993, 11, 25);
        customers.add(new Customer("c6", "Huynh Thi F", "0967890123", "Hue", "f.huynh@example.com", cal.getTime()));

        cal.set(1991, 5, 30);
        customers.add(new Customer("c7", "Phan Van G", "0945678901", "Nha Trang", "g.phan@example.com", cal.getTime()));

        cal.set(1987, 8, 12);
        customers.add(new Customer("c8", "Vu Thi H", "0923456789", "Vung Tau", "h.vu@example.com", cal.getTime()));

        cal.set(1994, 1, 14);
        customers.add(new Customer("c9", "Dang Van I", "0956789012", "Da Lat", "i.dang@example.com", cal.getTime()));

        cal.set(1996, 6, 22);
        customers.add(new Customer("c10", "Bui Thi K", "0911223344", "Quang Ninh", "k.bui@example.com", cal.getTime()));

        cal.set(1989, 3, 18);
        customers.add(new Customer("c11", "Do Van L", "0999888777", "Nam Dinh", "l.do@example.com", cal.getTime()));

        return customers;
    }
    public static ArrayList<Order> getOrders()
    {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<Employee> employees = getEmployees();
        ArrayList<Customer> customers = getCustomers();
        OrderStatus[] statuses = {OrderStatus.COMPLETED,
                OrderStatus.NOT_PAYMENT,
                OrderStatus.ON_LOGISTIC,
                OrderStatus.CUSTOMER_COMPLAIN};

        for (int i = 1; i <= 100; i++) {
            Calendar cal = Calendar.getInstance();
            // Phân bổ năm: 2024 (1-40), 2025 (41-80), 2026 Q1 (81-100)
            int year = (i <= 40) ? 2024 : (i <= 80 ? 2025 : 2026);
            int month;
            if (year == 2026) {
                month = (i % 3); // Q1: Tháng 0, 1, 2
            } else {
                month = (i % 12); // Các tháng từ 0-11
            }
            int day = (i % 28) + 1;
            cal.set(year, month, day, 8 + (i % 10), i % 60, i % 60);

            // Phân bổ cân bằng giữa nhân viên và khách hàng
            String empId = employees.get(i % employees.size()).getId();
            String cusId = customers.get(i % customers.size()).getCustomerId();

            // Chọn trạng thái xoay vòng
            OrderStatus status = statuses[i % statuses.length];

            orders.add(new Order("o" + i, empId, cusId, cal.getTime(), status));
        }

        return orders;
    }
    public static ArrayList<OrderDetail> getOrderDetails()
    {
        ArrayList<Order> orders = getOrders();
        ArrayList<Product> products = getProducts();
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        int detailCounter = 1;

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            // Số lượng chi tiết cho mỗi hóa đơn từ 1 đến 10
            int numDetails = (i % 10) + 1;
            
            for (int j = 0; j < numDetails; j++) {
                // Chọn sản phẩm xoay vòng để phủ hết danh sách sản phẩm
                Product product = products.get((i + j) % products.size());
                
                String odId = "od" + detailCounter++;
                int quantity = ((i + j) % 5) + 1;
                double price = product.getPrice();
                
                // Coupon và VAT chia sẵn cho 100 theo yêu cầu
                double coupon = ((i + j) % 15) / 100.0; // Từ 0.00 đến 0.14 (0% - 14%)
                double VAT = product.getVAT(); // Sử dụng VAT của sản phẩm (ví dụ 0.05 hoặc 0.1)

                orderDetails.add(new OrderDetail(
                        odId,
                        order.getOrderId(),
                        product.getProductId(),
                        quantity,
                        price,
                        coupon,
                        VAT
                ));
            }
        }
        
        return orderDetails;
    }
    public static double sumOfMoney(Order od)
    {
        double sum = 0;
        ArrayList<OrderDetail> orderDetails = getOrderDetails();
        for (OrderDetail detail : orderDetails) {
            if (detail.getOrderId().equals(od.getOrderId())) {
                double amount = detail.getQuantity() * detail.getPrice();
                double afterCoupon = amount * (1 - detail.getCoupon());
                double totalPerLine = afterCoupon * (1 + detail.getVAT());
                sum += totalPerLine;
            }
        }
        return sum;
    }
    public static ArrayList<Order> filterOrdersByDate(Date fromDate, Date toDate)
    {
        ArrayList<Order> orders = getOrders();
        ArrayList<Order> result_filter = new ArrayList<>();

        // Chuẩn hóa fromDate về đầu ngày (00:00:00)
        Calendar calFrom = Calendar.getInstance();
        calFrom.setTime(fromDate);
        calFrom.set(Calendar.HOUR_OF_DAY, 0);
        calFrom.set(Calendar.MINUTE, 0);
        calFrom.set(Calendar.SECOND, 0);
        calFrom.set(Calendar.MILLISECOND, 0);
        long fromTime = calFrom.getTimeInMillis();

        // Chuẩn hóa toDate về cuối ngày (23:59:59)
        Calendar calTo = Calendar.getInstance();
        calTo.setTime(toDate);
        calTo.set(Calendar.HOUR_OF_DAY, 23);
        calTo.set(Calendar.MINUTE, 59);
        calTo.set(Calendar.SECOND, 59);
        calTo.set(Calendar.MILLISECOND, 999);
        long toTime = calTo.getTimeInMillis();

        for (Order od : orders) {
            long orderTime = od.getOrderDate().getTime();
            // So sánh trong khoảng thời gian đã chuẩn hóa (bao gồm cả fromDate và toDate)
            if (orderTime >= fromTime && orderTime <= toTime) {
                result_filter.add(od);
            }
        }

        return result_filter;
    }
}
