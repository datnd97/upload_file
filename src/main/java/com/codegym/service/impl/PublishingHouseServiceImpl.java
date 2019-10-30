package com.codegym.service.impl;

import com.codegym.model.sub.PublishingHouse;
import com.codegym.repository.sub.PublishingHouseRepository;
import com.codegym.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;

public class PublishingHouseServiceImpl implements PublishingHouseService {
    @Autowired
    private PublishingHouseRepository publishingHouseRepository;
    @Override
    public Iterable<PublishingHouse> findAll() {
        return publishingHouseRepository.findAll();
    }

    @Override
    public PublishingHouse findById(Long id) {
        return publishingHouseRepository.findOne(id);
    }

    @Override
    public void save(PublishingHouse publishingHouse) {
        publishingHouseRepository.save(publishingHouse);
    }

    @Override
    public void remove(Long id) {
        publishingHouseRepository.delete(id);
    }
}
