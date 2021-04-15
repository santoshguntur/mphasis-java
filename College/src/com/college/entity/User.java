package com.college.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_USERS")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="USER_ID")
	private int userId;
	@Column(name="FIRST_NAME",length=45)
	private String firstName;
	@Column(name="LAST_NAME",length=45)
	private String lastName;
	@Column(name="EMAIL_ID",length=45)
	private String emilId;
	@Column(name="ROLE",length=1)
	private String role;
	
	@Column(name="PASSWORD",length=45)
	private String password;
	
	@Column(name="HOME_ADDRESS",length=255)
	private String address;
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="ROOM_ID")
	private Room room;
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmilId() {
		return emilId;
	}
	public void setEmilId(String emilId) {
		this.emilId = emilId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", emilId=" + emilId
				+ ", role=" + role + ", password=" + password +", address="
				+ address + ", Room=" + room + "]";
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
