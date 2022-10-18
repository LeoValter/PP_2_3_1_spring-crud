package crud.controller;

import crud.model.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping(value = "/")
    public String showUsers(Model model) {
        model.addAttribute("users", service.getAll());
        return "users";
    }

    @PostMapping("/adduser")
    public String addUser(User user) {
        System.out.println(user);
        service.add(user);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        System.out.println(user);
        service.update(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
