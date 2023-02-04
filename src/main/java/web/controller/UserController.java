package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getUserListPage(ModelMap model) {
        model.addAttribute("list", userService.getUserList());
        return "users";
    }

    @GetMapping(value = "delete")
    public String deleteUserById(@RequestParam(value = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @GetMapping(value = "newUser")
    public String getUserAddForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @GetMapping(value = "edit")
    public String getUserEditForm(@RequestParam(value = "id", required = false) Integer id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("insert")
    public String insertUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/newUser";
    }

    @PatchMapping("update/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

}
