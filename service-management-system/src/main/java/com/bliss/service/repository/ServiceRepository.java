package com.bliss.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bliss.service.model.BeautyService;

public interface ServiceRepository extends JpaRepository<BeautyService, Long> {
}
