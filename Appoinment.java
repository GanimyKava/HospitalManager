package com.example.demo.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appoinment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int Patid;
	private int doctid;
	private int  date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatid() {
		return Patid;
	}
	public void setPatid(int patid) {
		Patid = patid;
	}
	public int getDoctid() {
		return doctid;
	}
	public void setDoctid(int doctid) {
		this.doctid = doctid;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}

}
