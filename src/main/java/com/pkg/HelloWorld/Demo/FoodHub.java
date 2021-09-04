package com.pkg.HelloWorld.Demo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "food_hub")
public class FoodHub {

	@Id
	@GeneratedValue
	@Column(name = "food_id", unique = true, updatable = false)
	private Integer fid;

	private String food_name;

	private String food_cat;

	private Date startdate;

	private Date enddate = Date.valueOf("9999-01-01");

	private Character active_flag;
	private String record_updated_flag;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public String getFood_cat() {
		return food_cat;
	}

	public void setFood_cat(String food_cat) {
		this.food_cat = food_cat;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Character getActive_flag() {
		return active_flag;
	}

	public void setActive_flag(Character active_flag) {
		this.active_flag = active_flag;
	}

	public String getRecord_updated_flag() {
		return record_updated_flag;
	}

	public void setRecord_updated_flag(String record_updated_flag) {
		this.record_updated_flag = record_updated_flag;
	}

	public FoodHub(Integer fid, String food_name, String food_cat, Date startdate, Date enddate, Character active_flag,
			String record_updated_flag) {
		super();
		this.fid = fid;
		this.food_name = food_name;
		this.food_cat = food_cat;
		this.startdate = startdate;
		this.enddate = enddate;
		this.active_flag = active_flag;
		this.record_updated_flag = record_updated_flag;
	}

	public FoodHub(String food_name, String food_cat, Date startdate, Character active_flag,
			String record_updated_flag) {
		super();
		this.food_name = food_name;
		this.food_cat = food_cat;
		this.startdate = startdate;
		this.active_flag = active_flag;
		this.record_updated_flag = record_updated_flag;
	}

	public FoodHub() {

	}

	@Override
	public String toString() {
		return "FoodHub [fid=" + fid + ", food_name=" + food_name + ", food_cat=" + food_cat + ", startdate="
				+ startdate + ", enddate=" + enddate + ", active_flag=" + active_flag + ", record_updated_flag="
				+ record_updated_flag + "]";
	}

}
