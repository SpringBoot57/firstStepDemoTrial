package com.example.posttracking.repository;

import com.example.posttracking.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {}
