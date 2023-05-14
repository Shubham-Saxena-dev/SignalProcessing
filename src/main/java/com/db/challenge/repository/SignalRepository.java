package com.db.challenge.repository;

import com.db.challenge.model.Signal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SignalRepository extends MongoRepository<Signal, String> {

}
