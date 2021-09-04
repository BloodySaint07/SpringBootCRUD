package com.pkg.HelloWorld.Demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("unused")
@Entity
@Table(name = "player_info")
public class PlayerInfo {

	// @JsonIgnore

	@Id
	@SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence", allocationSize = 2, initialValue = 33)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
	@Column(name = "player_id", nullable = false, unique = true, updatable = false)
	private Integer pid;

	@Size(min = 2, message = "Size of Name should be atleast 2 chars ")
	@Column(name = "player_name")
	private String name;
	@NotBlank(message = "Position is mandatory")
	@Column(name = "player_pos")
	private String position;
	@Column(name = "player_club")
	private String club;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public PlayerInfo(Integer pid, String name, String position, String club) {
		super();
		this.pid = pid;
		this.name = name;
		this.position = position;
		this.club = club;
	}

	public PlayerInfo(String name, String position, String club) {
		super();
		this.name = name;
		this.position = position;
		this.club = club;
	}
	
	public PlayerInfo() {
		
		
	}

	@Override
	public String toString() {
		return "PlayerInfo [pid=" + pid + ", name=" + name + ", position=" + position + ", club=" + club + "]";
	}

}
