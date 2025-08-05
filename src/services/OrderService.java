package services;

import models.Order;

import java.util.LinkedList;
import java.util.Queue;

public class OrderService {
    private Queue<Order> orderQueue;

    public OrderService() {
        orderQueue = new LinkedList<>();
    }

    public void addOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("🆕 Order Added: " + order);
    }

    public Order getNextOrder() {
        return orderQueue.poll(); // Returns and removes the head of the queue
    }

    public boolean hasOrders() {
        return !orderQueue.isEmpty();
    }

    public int getOrderCount() {
        return orderQueue.size();
    }
}
