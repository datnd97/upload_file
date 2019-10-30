package com.codegym.controller;

import com.codegym.model.sub.PublishingHouse;
import com.codegym.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublishingHouseController {
    @Autowired
    private PublishingHouseService publishingHouseService;

    @GetMapping("/publish-house")
    public ModelAndView listPH() {
        Iterable<PublishingHouse> publishingHouses = publishingHouseService.findAll();
        ModelAndView modelAndView = new ModelAndView("/ph/list-ph");
        modelAndView.addObject("publist-house",publishingHouses);
        return modelAndView;
    }
}
