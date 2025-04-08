package com.spring.demo.repository;

import com.spring.demo.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ServiceRepository extends JpaRepository<ServiceRepository, Integer> {
    Optional<ServiceModel> findById(int id);

    Optional<ServiceModel> findAllById(int id);
}
