package com.codegym.service;

import com.codegym.model.sub.PublishingHouse;

public interface PublishingHouseService {
    Iterable<PublishingHouse> findAll();
    PublishingHouse findById(Long id);
    void save(PublishingHouse publishingHouse);
    void remove(Long id);
}
