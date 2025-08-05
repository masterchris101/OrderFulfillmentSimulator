import models.Order;
import models.Product;
import models.Robot;
import services.OrderService;
import services.RobotService;

public class Main {
    public static void main(String[] args) {
        // Set up inventory
        Product laptop = new Product("P001", "Laptop", "A3", 10);
        Product phone = new Product("P002", "Phone", "B1", 5);

        // Create services
        OrderService orderService = new OrderService();
        RobotService robotService = new RobotService();

        // Add robots
        robotService.addRobot(new Robot("R1"));
        robotService.addRobot(new Robot("R2"));

        // Add orders
        orderService.addOrder(new Order("O001", laptop, 2));
        orderService.addOrder(new Order("O002", phone, 1));
        orderService.addOrder(new Order("O003", laptop, 3));

        // Fulfill all orders
        while (orderService.hasOrders()) {
            Order order = orderService.getNextOrder();
            Robot assignedRobot = robotService.assignAvailableRobot();

            if (assignedRobot != null) {
                System.out.println("📦 Processing " + order.getOrderId() + " with " + assignedRobot.getRobotId());
                simulateDelay("🔄 Robot is picking...");

                try {
                    order.getProduct().reduceQuantity(order.getQuantity());
                    order.markFulfilled();
                    System.out.println("✅ Order Fulfilled: " + order);
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Failed to fulfill " + order.getOrderId() + ": " + e.getMessage());
                }

                simulateDelay("🚚 Robot is delivering...");
                robotService.releaseRobot(assignedRobot);
            } else {
                System.out.println("🕓 Waiting for a robot to become available...");
                simulateDelay("...");
                orderService.addOrder(order); // Re-add the order to the queue
            }
        }

        System.out.println("\n🚀 All orders processed.");
        robotService.printRobotStatuses();
    }

    private static void simulateDelay(String message) {
        System.out.println(message);
        try {
            Thread.sleep(1000); // 1 second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
