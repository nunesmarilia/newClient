package com.mn.newclient.repository;

import com.mn.newclient.model.Clients;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientsRepository extends MongoRepository<Clients, String> {
    public <S extends Clients> S save(S s);
}