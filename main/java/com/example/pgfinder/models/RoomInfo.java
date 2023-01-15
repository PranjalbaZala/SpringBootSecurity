package com.example.pgfinder.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "roominfo")
public class RoomInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private long shared_no;
	
	@Column(nullable=false)
	private long no_of_rooms;
	
	@Column(nullable=false)
	private long total_capacity;
	
	@Column(nullable=false)
	private long vacancy;
	
	@Column(nullable=false)
	private long rent_per_month;
	
	@Column(nullable=false)
	private long pg_fid;
	
	public RoomInfo() {

	}
	
	public RoomInfo(long shared_no, long no_of_rooms, long total_capacity, long vacancy, long rent_per_month, long pg_fid) {
		super();
		this.shared_no = shared_no;
		this.no_of_rooms = no_of_rooms;
		this.total_capacity = total_capacity;
		this.vacancy = vacancy;
		this.rent_per_month = rent_per_month;
		this.pg_fid = pg_fid;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getShared_no() {
		return shared_no;
	}
	public void setShared_no(long shared_no) {
		this.shared_no = shared_no;
	}
	public long getNo_of_rooms() {
		return no_of_rooms;
	}
	public void setNo_of_rooms(long no_of_rooms) {
		this.no_of_rooms = no_of_rooms;
	}
	public long getTotal_capacity() {
		return total_capacity;
	}
	public void setTotal_capacity(long total_capacity) {
		this.total_capacity = total_capacity;
	}
	public long getVacancy() {
		return vacancy;
	}
	public void setVacancy(long vacancy) {
		this.vacancy = vacancy;
	}
	public long getRent_per_month() {
		return rent_per_month;
	}
	public void setRent_per_month(long rent_per_month) {
		this.rent_per_month = rent_per_month;
	}

	public long getPg_fid() {
		return pg_fid;
	}

	public void setPg_fid(long pg_fid) {
		this.pg_fid = pg_fid;
	}
	
}
