package com.usage_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usage_service.entity.UsageLog;

@Repository
public interface UsageLogRepository  extends JpaRepository<UsageLog, Long> {
    List<UsageLog> findByUserId(Long userId);
}
   