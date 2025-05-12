package com.Fabrica.TelcoNova.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_notifications")
public class UserNotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    private NotificationModel notification;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    private LocalDateTime actualSendDate;

    @ManyToOne
    @JoinColumn(name = "delivery_status_id")
    private DeliveryStatusModel deliveryStatus;

    private boolean read = false;
    private LocalDateTime readDate;

     public UserNotificationModel(){
     
    }
    public UserNotificationModel(Long id, NotificationModel notification, UserModel user, LocalDateTime actualSendDate,
            DeliveryStatusModel deliveryStatus, boolean read, LocalDateTime readDate) {
        this.id = id;
        this.notification = notification;
        this.user = user;
        this.actualSendDate = actualSendDate;
        this.deliveryStatus = deliveryStatus;
        this.read = read;
        this.readDate = readDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public NotificationModel getNotification() {
        return notification;
    }
    public void setNotification(NotificationModel notification) {
        this.notification = notification;
    }
    public UserModel getUser() {
        return user;
    }
    public void setUser(UserModel user) {
        this.user = user;
    }
    public LocalDateTime getActualSendDate() {
        return actualSendDate;
    }
    public void setActualSendDate(LocalDateTime actualSendDate) {
        this.actualSendDate = actualSendDate;
    }
    public DeliveryStatusModel getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(DeliveryStatusModel deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public boolean isRead() {
        return read;
    }
    public void setRead(boolean read) {
        this.read = read;
    }
    public LocalDateTime getReadDate() {
        return readDate;
    }
    public void setReadDate(LocalDateTime readDate) {
        this.readDate = readDate;
    }

    
}
