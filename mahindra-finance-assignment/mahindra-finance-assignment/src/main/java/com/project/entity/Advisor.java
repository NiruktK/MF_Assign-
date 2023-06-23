package com.project.entity;

import javax.persistence.*;

@Entity
@Table(name="advisor")
public class Advisor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long advisorId;
	@Column(nullable = false)
	private String advisorName;
	@Column(nullable = false)
	private String advisorPhoto;
	public Advisor() {
		super();
	}
	public Advisor(Long advisorId, String advisorName, String advisorPhoto) {
		super();
		this.advisorId = advisorId;
		this.advisorName = advisorName;
		this.advisorPhoto = advisorPhoto;
	}
	public Long getAdvisorId() {
		return advisorId;
	}
	public void setAdvisorId(Long advisorId) {
		this.advisorId = advisorId;
	}
	public String getAdvisorName() {
		return advisorName;
	}
	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}
	public String getAdvisorPhoto() {
		return advisorPhoto;
	}
	public void setAdvisorPhoto(String advisorPhoto) {
		this.advisorPhoto = advisorPhoto;
	}

	@Override
	public String toString() {
		return "Advisor{" +
				"advisorId=" + advisorId +
				", advisorName='" + advisorName + '\'' +
				", advisorPhoto='" + advisorPhoto + '\'' +
				'}';
	}
}
