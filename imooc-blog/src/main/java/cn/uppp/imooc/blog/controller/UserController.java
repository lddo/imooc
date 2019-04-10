package cn.uppp.imooc.blog.controller;

import cn.uppp.imooc.blog.entity.User;
import cn.uppp.imooc.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView list() {
        ModelAndView view = new ModelAndView("list");
        view.addObject("userList", userService.list());
        return view;
    }

    @GetMapping("/{id}")
    public ModelAndView getById(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("redirect:/users");
        view.addObject("user", userService.getById(id));
        return view;
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(User user) {
        ModelAndView view = new ModelAndView("redirect:/users");
        view.addObject("result", userService.saveOrUpdate(user));
        return view;
    }

    @GetMapping("/remove/{id}")
    public ModelAndView remove(@PathVariable Integer id) {
        ModelAndView view = new ModelAndView("redirect:/users");
        view.addObject("result", userService.remove(id));
        return view;
    }

    @GetMapping("/goSaveOrUpdate")
    public ModelAndView goAddView(Integer id){
        ModelAndView view = new ModelAndView("saveOrUpdate");
        if (id != null) {
            view.addObject("user", userService.getById(id));
        }
        return view;
    }
}
