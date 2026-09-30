package com.santhosh.springcore;

class NotificationService {
    void send() {
        System.out.println("Notification sent");
    }
}

class UserService {
    private NotificationService notificationService;

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void notifyUser() {
        notificationService.send();
        System.out.println("User notified");
    }
}

public class SetterInjectionDemo {
    public static void main(String[] args) {
        UserService service = new UserService();
        service.setNotificationService(new NotificationService());
        service.notifyUser();
    }
}
