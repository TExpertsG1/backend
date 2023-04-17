package br.com.hotel1800.controller;

import br.com.hotel1800.dao.HotelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HotelController {

    @Autowired
    private HotelDAO hotelDAO;

}