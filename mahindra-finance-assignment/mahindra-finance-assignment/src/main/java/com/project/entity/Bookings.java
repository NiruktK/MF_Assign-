package com.project.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Bookings {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name="user_id")
    private Long userId;
    
    @Column(name="advisor_id")
    private Long advisorId;
    
    private LocalDate date;

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookings(Long id, Long userId, Long advisorId, LocalDate date) {
		super();
		this.id = id;
		this.userId = userId;
		this.advisorId = advisorId;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getAdvisorId() {
		return advisorId;
	}

	public void setAdvisorId(Long advisorId) {
		this.advisorId = advisorId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
