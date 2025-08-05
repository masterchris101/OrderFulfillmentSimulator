# Order Fulfillment Simulator 🏭📦

This Java project simulates an automated order fulfillment system like those used in modern warehouses and robotics environments (e.g., Amazon Robotics).

## 🚀 Features
- Simulates order creation, processing, and fulfillment
- Robot assignment and inventory management
- Console output for real-time process visualization

## 📂 Structure
- `src/models`: Includes classes for `Order`, `Product`, and `Robot`
- `Main.java`: Entry point to run the simulation
- `OrderService` & `RobotService`: Business logic for order and robot handling

## ✅ Example Output
```bash
📦 New Order: Order O001: 2 x Laptop (Fulfilled: false)
🤖 Assigning Robot: Robot R1 [Status: Available]
✅ Order Fulfilled: Order O001: 2 x Laptop (Fulfilled: true)
📦 Inventory Remaining: Laptop (ID: P001, Location: A3, Qty: 8)
🤖 Robot Status: Robot R1 [Status: Available]
