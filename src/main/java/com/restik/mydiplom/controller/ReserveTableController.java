package com.restik.mydiplom.controller;


import com.restik.mydiplom.dao.RestaurantDAO;
import com.restik.mydiplom.dao.TableDAO;
import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.entity.Tables;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ReserveTableController {

    @RequestMapping(value = "/reserveTable.htm", method = RequestMethod.POST)
    protected String occupiedTable(@ModelAttribute("reserve") Tables restTable, HttpServletRequest request) throws Exception {

        int tableNo = Integer.parseInt(request.getParameter("tableNo"));
        String restName = request.getParameter("restName");
        RestaurantDAO restDAO = new RestaurantDAO();
        Restaurant rest = restDAO.fetchMyRestaurant(restName);
        TableDAO tableDAO = new TableDAO();
        //RestaurantTable restaurantTable = tableDAO.fetchMyRestaurantTable(Integer.parseInt((tableNo)));
        int rowsUpdated = tableDAO.updateUserTable(tableNo, restTable.getTableStatus(), rest);
        System.out.print(rowsUpdated);
//			RestaurantTable avail=tableDAO.delete(restTable);
//			System.out.println("Table avialability is"+avail);
        // DAO.close();
        return "test";
//        return "successRestaurantAdded";
    }
}



/*    @Autowired
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
                             @RequestParam(name = "restaurantId") int restaurantId,
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

//        Visitor visitor1 = new Visitor();
//        visitor1.setVisitorName(visitorName);
        reserve.setTables(tables);
//        visitor1.setReserve(reserve);
        reserve.setReserveStart(dateReserve);

//        visitorRepository.save(visitor1);
        reserveRepository.save(reserve);

        return "add_reserve";
    }*/
//}



