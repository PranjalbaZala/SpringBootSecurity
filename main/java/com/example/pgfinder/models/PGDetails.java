package com.example.pgfinder.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pgdetails")
public class PGDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pg_id;
	
	@Column(nullable=false)
	private String pg_name;
	
	@Column(nullable=false)
	private String pg_address;
	
	@Column(nullable=false)
	private String phone_no;
	
	@Column(nullable=false)
	private long notice_period;
	
	@Column(nullable=false)
	private String gender;
	
	@Column(nullable=false)
	private String country;
	
	@Column(nullable=false)
	private String state;
	
	@Column(nullable=false)
	private String city;
	
	@Column(nullable=false)
	private long deposit_amt;
	
	@Column(nullable=false)
	private String food_avail;
	
	@Column(nullable=false)
	private String wifi_avail;
	
	@Column(nullable=false)
	private String request_status;
	
	public PGDetails() {
		super();
	}
	public PGDetails(String pg_name, String pg_address, String phone_no, long notice_period, String gender,
			String country, String state, String city, long deposit_amt, String food_avail, String wifi_avail,
			String request_status) {
		super();
		this.pg_name = pg_name;
		this.pg_address = pg_address;
		this.phone_no = phone_no;
		this.notice_period = notice_period;
		this.gender = gender;
		this.country = country;
		this.state = state;
		this.city = city;
		this.deposit_amt = deposit_amt;
		this.food_avail = food_avail;
		this.wifi_avail = wifi_avail;
		this.request_status = request_status;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pg_fid", referencedColumnName = "pg_id")
	private List<RoomInfo> roominfos = new ArrayList<>();
	
	public long getId() {
		return pg_id;
	}
	
	public void setId(long pg_id) {
		this.pg_id = pg_id;
	}

	public String getPg_name() {
		return pg_name;
	}

	public void setPg_name(String pg_name) {
		this.pg_name = pg_name;
	}

	public String getPg_address() {
		return pg_address;
	}

	public void setPg_address(String pg_address) {
		this.pg_address = pg_address;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public long getNotice_period() {
		return notice_period;
	}

	public void setNotice_period(long notice_period) {
		this.notice_period = notice_period;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getDeposit_amt() {
		return deposit_amt;
	}

	public void setDeposit_amt(long deposit_amt) {
		this.deposit_amt = deposit_amt;
	}

	public String getFood_avail() {
		return food_avail;
	}

	public void setFood_avail(String food_avail) {
		this.food_avail = food_avail;
	}

	public String getWifi_avail() {
		return wifi_avail;
	}

	public void setWifi_avail(String wifi_avail) {
		this.wifi_avail = wifi_avail;
	}

	public String getRequest_status() {
		return request_status;
	}

	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}


	public List<RoomInfo> getRoominfos() {
		return roominfos;
	}

	public void setRoominfos(List<RoomInfo> roominfos) {
		this.roominfos = roominfos;
	}

}
