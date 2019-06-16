package com.restik.mydiplom.controller;



import com.restik.mydiplom.dao.RestaurantDAO;
import com.restik.mydiplom.entity.AdminOfRestaurant;
import com.restik.mydiplom.entity.Person;
import com.restik.mydiplom.entity.Restaurant;
import com.restik.mydiplom.exception.ProjException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class RestaurantController {

    @RequestMapping(method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute("restAdd") Person user) {
        return "successRestaurantAdded";
    }

    @RequestMapping(value = "addRestaurant.htm", method = RequestMethod.POST)
    protected ModelAndView doSubmitAction(@ModelAttribute("restAdd") Restaurant rest, HttpServletRequest request) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}
        ModelAndView mv = new ModelAndView();
        try {
            HttpSession session = request.getSession();
            System.out.print("test");
            RestaurantDAO restDAO = new RestaurantDAO();
            System.out.print("test1");
            AdminOfRestaurant restAd = (AdminOfRestaurant) session.getAttribute("person");
            Restaurant re = restDAO.getMyRestaurant(restAd);
            if (re == null) {
                Restaurant restaurant = restDAO.create(rest.getRestName(), restAd);

                session.setAttribute("restSessionObj", restaurant);
                mv.addObject("myRestaurant", restaurant);
                mv.setViewName("successRestaurantAdded");
                return mv;
            } else {
                mv.setViewName("restAdminHome");
                System.out.println("You already have a restaurant added to the system");
                return mv;
            }
            // DAO.close();
        } catch (ProjException e) {
            System.out.println("Exception: " + e.getMessage());
            mv.addObject("myRestaurant", null);
            mv.setViewName("restAdminHome");
            return mv;
        }
    }


    @RequestMapping(value = "viewRestaurant.htm")
    protected ModelAndView addRestaurantDetails(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        try {
            HttpSession session = request.getSession();
            RestaurantDAO restDAO = new RestaurantDAO();
            AdminOfRestaurant restAd = (AdminOfRestaurant) session.getAttribute("person");

            Restaurant myRest = restDAO.getMyRestaurant(restAd);
            if (myRest != null) {
                mv.addObject("myRestaurant", myRest);
                mv.setViewName("successRestaurantAdded");
                return mv;
            } else {
                mv.setViewName("restAdminHome");
                System.out.println("Please add a restaurant to the system");
                return mv;
            }
        } catch (ProjException e) {
            System.out.println("Exception: " + e.getMessage());
            mv.addObject("myRestaurant", null);
            mv.setViewName("restAdminHome");
            return mv;
        }


    }

}
/*    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private TableRepository tableRepository;

    @RequestMapping(value = "/restaurant/add", method = RequestMethod.GET)
    public String showForm (Model model){
        model.addAttribute("restaurant", new Restaurant());
        return "AddRestaurant";
    }

    @RequestMapping(value = "/restaurant/add", method = RequestMethod.POST)
    public String submitForm (@ModelAttribute Restaurant restaurant, Model model,
                              @RequestParam(name = "count") int[]count){
        System.out.println("количество мест на каждый стол : " + Arrays.toString(count));
        for (int i = 0; i < count.length; i++) {
            Tables tables = new Tables();
            tables.setVisitorsVolume(count[i]);
            tables.setRestaurant(restaurant);
            restaurant.getTablesList().add(tables);
        }
        restaurantRepository.save(restaurant);
        model.addAttribute("addInfo", restaurant.getRestaurantName());

        return "AddRestaurant";
    }*/

