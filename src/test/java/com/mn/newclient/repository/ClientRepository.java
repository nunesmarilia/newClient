package com.mn.newclient.repository;

import com.mn.newclient.model.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public abstract class ClientRepository implements MongoRepository<Client, String> {

    @Override
    public <S extends Client> S save(S s) {
        return null;
    }
}
