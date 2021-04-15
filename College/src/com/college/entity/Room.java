package com.college.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="TBL_ROOM_MASTER")
public class Room {
	
	public Room() {
		super();
	}
	public Room(String roomType, String roomLocaltion, BigDecimal roomCharge, String status, String paymentSatus) {
		super();
		this.roomType = roomType;
		this.roomLocaltion = roomLocaltion;
		this.roomCharge = roomCharge;
		this.status = status;
		this.paymentSatus = paymentSatus;
	}
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROOM_ID")
	private int roomId;
	@Column(name="ROOM_TYPE",length=10)
	private String roomType;
	@Column(name="ROOM_LOCATION",length=255)
	private String roomLocaltion;
	@Column(name="ROOM_AMOUNT",precision=10, scale=2)
	private BigDecimal roomCharge;
	@Column(name="ROOM_STATUS",length=10)
	private String status;
	@Column(name="PAYMENT_STATUS",length=10)
	private String paymentSatus;
	
	@OneToOne(mappedBy="room",fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private User user;
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getRoomLocaltion() {
		return roomLocaltion;
	}
	public void setRoomLocaltion(String roomLocaltion) {
		this.roomLocaltion = roomLocaltion;
	}
	public BigDecimal getRoomCharge() {
		return roomCharge;
	}
	public void setRoomCharge(BigDecimal roomCharge) {
		this.roomCharge = roomCharge;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentSatus() {
		return paymentSatus;
	}
	public void setPaymentSatus(String paymentSatus) {
		this.paymentSatus = paymentSatus;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", roomLocaltion=" + roomLocaltion
				+ ", roomCharge=" + roomCharge + ", status=" + status + ", paymentSatus=" + paymentSatus + ", user="
				+ user + "]";
	}
	
	
	
	

}
