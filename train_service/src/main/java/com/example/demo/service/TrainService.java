package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Train;
import com.example.demo.repository.TrainRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }
    
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainById(Integer id) {
        return trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));
    }

    public void deleteTrain(Integer id) {
        trainRepository.deleteById(id);
    }

    public List<Train> findTrains(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }

    public Train updateTrain(Integer id, Train trainDetails) {
        return trainRepository.findById(id).map(train -> {
            train.setTrainName(trainDetails.getTrainName());
            train.setSource(trainDetails.getSource());
            train.setDestination(trainDetails.getDestination());
            train.setDepartureTime(trainDetails.getDepartureTime());
            train.setArrivalTime(trainDetails.getArrivalTime());
            train.setTotalSeats(trainDetails.getTotalSeats());
            train.setAvailableSeats(trainDetails.getAvailableSeats());
            train.setTicketFare(trainDetails.getTicketFare());
            return trainRepository.save(train);
        }).orElseThrow(() -> new RuntimeException("Train not found with id " + id));
    }
    
    public boolean updateSeats(String trainNumber, int seatsToDeduct) {
        Optional<Train> trainOpt = trainRepository.findByTrainNumber(trainNumber);
        if (trainOpt.isPresent()) {
            Train train = trainOpt.get();
            if (train.getAvailableSeats() >= seatsToDeduct) {
                train.setAvailableSeats(train.getAvailableSeats() - seatsToDeduct);
                trainRepository.save(train);
                return true;
            }
        }
        return false;
    }
}
