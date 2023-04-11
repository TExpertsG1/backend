package br.com.hotel1800.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.hotel1800.dao.HotelDAO;

@Controller
public class HotelController {
    
    @Autowired
    private HotelDAO hotelDAO;

}