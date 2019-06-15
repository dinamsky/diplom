package com.restik.mydiplom.controller;

import com.restik.mydiplom.entity.Reserve;
import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.entity.Tables;
import com.restik.mydiplom.entity.Visitors;
import com.restik.mydiplom.repositories.ReserveRepository;
import com.restik.mydiplom.repositories.RestaurantRepository;
import com.restik.mydiplom.repositories.TableRepository;
import com.restik.mydiplom.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    @Autowired
    TableRepository tableRepository;
    private LocalDateTime dateReserveDeltaMinus;
    private LocalDateTime dateReserveDeltaPlus;

    private int visitorsVolume;
    private LocalDateTime dateReserve;


    @RequestMapping(value = "/reserve/add", method = RequestMethod.GET)
    public String showForm(Model model) {

        model.addAttribute("restaurant", restaurantRepository.findAll());
        //  model.addAttribute("tables", tableRepository.findAll());
        model.addAttribute("reserve", new Reserve());

        return "add_reserve";
    }

    @RequestMapping(value = "/reserve/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute Reserve reserve, Model model,
                             //@RequestParam(name = "restaurantId") int restaurantId,
                             @RequestParam(name = "visitorsVolume") int visitorsVolume,
                             @RequestParam(name = "reserveStart") LocalDateTime reserveStart


    ) {
        dateReserveDeltaMinus = reserveStart.minusHours(2);
        dateReserveDeltaPlus = reserveStart.plusHours(2);

        int restaurantId = 2;

//        Restaurant restaurant = restaurantRepository.findById(Integer.valueOf(restaurantId)).get();
//        Reserve reserveNew = reserveRepository.findFreeTable(Integer.valueOf(restaurantId), Integer.valueOf(visitorsVolume),dateReserveDeltaMinus, dateReserveDeltaPlus).get();
//        Tables tables = tableRepository.findFreeTable(Integer.valueOf(restaurantId)).get();
        Tables tables = tableRepository.findFreeTable(Integer.valueOf(restaurantId), Integer.valueOf(visitorsVolume)).get();

//        Visitors visitor1 = new Visitors();
//        visitor1.setVisitorName(visitorName);
        reserve.setTables(tables);
//        visitor1.setReserve(reserve);
        reserve.setReserveStart(dateReserve);

//        visitorRepository.save(visitor1);
        reserveRepository.save(reserve);

        return "add_reserve";
    }
}



