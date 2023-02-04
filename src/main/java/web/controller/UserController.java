package web.controller;

import org.hibernate.hql.internal.ast.tree.IdentNode;
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
    public String indexPage(ModelMap model) {
        model.addAttribute("list", userService.getUserList());
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping(value = "delete")
    public String removeUser(@RequestParam(value = "id") int id) {
        userService.removeUserById(id);
        return "redirect:/";
    }

    @PostMapping(value = "add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "edit")
    public String editUser(@RequestParam(value = "id", required = false) Integer id, ModelMap model) {
        System.out.println(userService.getUserById(id));
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("save/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }
}
