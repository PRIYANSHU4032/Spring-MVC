package com.zig.first.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
	@Id
	private String aid;
	private String aname;
	
	
	
	
	
	public Alien(String aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}

	public Alien() {
		
	}

	
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
}
