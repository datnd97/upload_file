package com.codegym.formatter;

import com.codegym.model.sub.PublishingHouse;
import com.codegym.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PublishingHouseFormatter implements Formatter<PublishingHouse> {
    private PublishingHouseService publishingHouseService;
    @Autowired
    public PublishingHouseFormatter(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }
    @Override
    public PublishingHouse parse(String text, Locale locale) throws ParseException {
        return  publishingHouseService.findById(Long.parseLong(text));
    }

    @Override
    public String print(PublishingHouse object, Locale locale) {
        return "["+object.getId()+", "+object.getName()+" ] ";
    }
}
