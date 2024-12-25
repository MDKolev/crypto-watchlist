package com.alert_service.repository;

import com.alert_service.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByCoinId(String coinId);
}
