package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Long>{

	List<Bookings> findAllByUserId(Long userId);

}
