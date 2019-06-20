package com.restik.mydiplom.controller;

import com.restik.mydiplom.dao.PersonDAO;
import com.restik.mydiplom.entity.Person;
import com.restik.mydiplom.exception.ProjException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login.htm")
public class LoginController {

    @Autowired
    PersonDAO personDAO;
    //	@Autowired
//	@Qualifier("userValidator")
//	UserValidator validator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(validator);
//	}
    @RequestMapping(method = RequestMethod.GET)
    public String initializeForm(@ModelAttribute("logPerson") Person person) {
        return "test";
//        return "userHome";
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("logPerson") Person person, HttpServletRequest request) throws Exception {
//		validator.validate(user, result);
//		if (result.hasErrors()) {
//			return "addUserForm";
//		}

        try {
            System.out.print("test");

            System.out.print("test1");

            HttpSession session = request.getSession();
            Person loggedPerson = personDAO.get(person.getUsername(), person.getPassword());
            session.setAttribute("person", loggedPerson);

            if (loggedPerson != null) {
                if (loggedPerson.getRoleType().equals("user")) {
                    return "userHome";
                } else {
                    return "restAdminHome";
                }
            } else {
                System.out.println("Username does not exist");
                return "home";
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return "home";
    }
}