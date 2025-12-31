package com.example.serverapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.serverapp.entity.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
	 

boolean existsByTrxId(String trxId);
}

