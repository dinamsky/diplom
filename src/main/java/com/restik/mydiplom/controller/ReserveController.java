package com.restik.mydiplom.controller;

import com.restik.mydiplom.entity.Reserve;
import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.entity.Visitors;
import com.restik.mydiplom.repositories.ReserveRepository;
import com.restik.mydiplom.repositories.RestaurantRepository;
import com.restik.mydiplom.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class ReserveController {
    @Autowired
    ReserveRepository reserveRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    VisitorRepository visitorRepository;

    @RequestMapping(value = "/reserve/add", method = RequestMethod.GET)
    public String showForm (Model model){
        model.addAttribute("restaurant", reserveRepository.findAll());
        model.addAttribute("visitors", new Visitors());
        model.addAttribute("reserve", new Reserve());
        return "add_reserve";
    }

    @RequestMapping(value = "/reserve/add", method = RequestMethod.POST)
    public String submitForm (@ModelAttribute Reserve reserve, Model model,
                              @RequestParam(name = "restaurantId") int restaurantId,
                              @RequestParam(name = "visitorsVolume") int visitorsVolume,
                              @RequestParam(name = "dateReserve") LocalDateTime dateReserve,
                              @RequestParam(name = "visitorName") String visitorName

    ) {
        Restaurant restaurant = restaurantRepository.findById(Integer.valueOf(restaurantId)).get();
        Reserve reserveNew = reserveRepository.findFreeTable(Integer.valueOf(restaurantId), Integer.valueOf(visitorsVolume), dateReserve);

        Visitors visitor1 = new Visitors();
        visitor1.setVisitorName(visitorName);
        reserveNew.setVisitor(visitor1);
        visitor1.setReserve(reserve);
        reserve.setReserveStart(dateReserve);

visitorRepository.save(visitor1);
        reserveRepository.save(reserveNew);
        //model.addAttribute("addInfo", reserve.getVisitorName());

        return "add_reserve";
    }
}



