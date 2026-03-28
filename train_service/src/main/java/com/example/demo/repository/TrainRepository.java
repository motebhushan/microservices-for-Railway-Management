package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Train;
import java.util.List;
import java.util.Optional;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
    List<Train> findBySourceAndDestination(String source, String destination);
    Optional<Train> findByTrainNumber(String trainNumber);
}
