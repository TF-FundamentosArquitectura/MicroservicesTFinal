package com.bliss.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bliss.appointment.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
