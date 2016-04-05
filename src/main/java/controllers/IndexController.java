package controllers;

import beans.User;
import dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Raghu on 06-Mar-16.
 */

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value="/addUser",method = RequestMethod.GET)
    public Map<String, Object> createuser(@ModelAttribute User user,Model model){
            model.addAttribute("user", user);

        userRepository.save(user);
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        System.out.println("User Careated ");
        response.put("message", "user created successfully");
           response.put("user", user);
        System.out.println(response);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public User getuserDetails(@PathVariable("id") String id){
        return userRepository.findOne(id);
    }
/*
   
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(Model model)
    {
        model.addAttribute("login", new Login());
        System.out.print("Login Call");
        return  "login";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginSubmit(@ModelAttribute Login login, Model model) {
       model.addAttribute("login", login);

        model.addAttribute("userId", login.getUserId());
        model.addAttribute("password", login.getPassword());

        System.out.println("Login result Call"+login.getUserName()+" \n"+login.getPassword());
        return "welcome";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        System.out.print("FirstCall to greeting");
        return "greeting";
    }

    @RequestMapping(value="/greeting", method=RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        System.out.print("Second Call");
        return "result";
    }

    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public String registeSubmit(@ModelAttribute Customer customer, Model model) {
        System.out.println("register result Call");
        model.addAttribute("customer", customer);
        this.repository.save(new Customer("customer", customer.toString()));

        model.addAttribute("userId", login.getUserId());
        model.addAttribute("password", login.getPassword());

        System.out.println("register result Call");
        return "welcomecustomer";
    }


    //Implementing the UPDATE API


    @RequestMapping(method = RequestMethod.PUT, value="/{userId}")
    public Map<String, Object> edituser(@PathVariable("userId") String userId,
                                        @RequestBody Map<String, Object> userMap){
        User user = new User(userMap.get("id").toString(),
                userMap.get("name").toString(),
                userMap.get("dob").toString(),
                Integer.parseInt(userMap.get("address").toString()));
        user.setId(userId);

        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", "user Updated successfully");
        response.put("user", userRepository.save(user));
        return response;
    }

    //Implementing the Delete API
    @RequestMapping(method = RequestMethod.DELETE, value="/{userId}")
    public Map<String, String> deleteuser(@PathVariable("userId") String userId){
        userRepository.delete(userId);
        Map<String, String> response = new HashMap<String, String>();
        response.put("message", "user deleted successfully");

        return response;
    }

    //Implementing the Get All users API
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAllusers(){
        List<User> users = userRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("totalusers", users.size());
        response.put("users", users);
        return response;
    }
*/




}