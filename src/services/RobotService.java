package services;

import models.Robot;

import java.util.ArrayList;
import java.util.List;

public class RobotService {
    private List<Robot> robots;

    public RobotService() {
        this.robots = new ArrayList<>();
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
        System.out.println("🤖 New Robot Added: " + robot);
    }

    public Robot assignAvailableRobot() {
        for (Robot robot : robots) {
            if (robot.getStatus().equalsIgnoreCase("Available")) {
                robot.setStatus("Picking");
                return robot;
            }
        }
        System.out.println("⚠️ No available robots at the moment.");
        return null;
    }

    public void releaseRobot(Robot robot) {
        robot.setStatus("Available");
        System.out.println("✅ Robot Released: " + robot.getRobotId());
    }

    public void printRobotStatuses() {
        for (Robot robot : robots) {
            System.out.println(robot);
        }
    }
}
