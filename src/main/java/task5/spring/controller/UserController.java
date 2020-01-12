package task5.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import task5.spring.model.User;

import task5.spring.service.UserService;
import task5.spring.validator.UserValidator;

@Controller
public class UserController {
    private UserService userService;



    @Autowired
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //GET - page Read list of users
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String readUserList(Model model) {
      //  model.addAttribute("allUsers", userService.getAllUsers());
        return "welcome";
        //return "user";
        //  return "login_old";
    }


    //GET - page Read list of users
/*    @RequestMapping(value = "/admin/read", method = RequestMethod.GET)
    public String readUserList2(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "admin/read";
    }
*/

    @RequestMapping(value = "/admin/read", method = RequestMethod.GET)
    public ModelAndView readUserList3() {
        ModelAndView modelAndView = new ModelAndView();
        //передаем на JSP объект allUsers
        modelAndView.addObject("allUsers", userService.getAllUsers());
        //указываем вьюхе страницу
        modelAndView.setViewName("admin/read");
        return modelAndView;
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "create";
    }
    //GET - page Create
    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String addPage(@ModelAttribute("create") User user, Model model) {
        model.addAttribute("user", new User());
        return "admin/create";
    }


    //POST - page Create - create the user
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String addUserByUser(@ModelAttribute("create") User user,
                                @RequestParam String selectedRole,
                                BindingResult bindingResult) {


        // userService.save(user);
        userService.addUserWithRoleUser(user);

        //После регистрации - логин
 //       securityService.autoLogin(user.getUsername(), user.getConfirmPassword());

        System.out.println("Controller  - Create - 2 user");
        return "redirect:/";
    }
    //POST - page Create - create the user
    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String addUserByAdmin(@ModelAttribute("create") User user,
                                 @RequestParam String selectedRole,
                                 BindingResult bindingResult) {

        System.out.println("Controller  - Create - 1 user");
        // userService.save(user);
        userService.addUser2(user, selectedRole);
        System.out.println("Controller  - Create - 2 user");
        return "admin/read";
    }



/////////////////////////////////////////////

    //GET - обновляем страница обновления
    @RequestMapping(value = "/admin/update/{id}", method = RequestMethod.GET)
    public ModelAndView updatePage(@PathVariable("id") int id) {
 //       User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/update");
 //       modelAndView.addObject("user", user);
        return modelAndView;
    }


    //POST - обновляем юзера
    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(name = "selectedRole") String selectedRole,
                             @ModelAttribute("user") User user, Model model) {
        userService.updateUserAndRole(user, selectedRole);
        model.addAttribute("allUsers", userService.getAllUsers());// ? а зачем - в риде должно быть
        // return "redirect:/read";
        return "admin/read";
    }

    //GET - delete page - confirmation
    @RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
    public String deleteUserPage(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/delete";
    }

    //Post- delete
    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("user") User user, Model model) {
        userService.deleteUserById(user.getId());
        model.addAttribute("allUsers", userService.getAllUsers()); // ? а зачем - в риде должно быть
        //  return "redirect:/read";
        return "/admin/read";
    }






    @RequestMapping(value = "/user/user", method = RequestMethod.GET)
    public String userPage(Model model) {

        return "user/user";
    }
///////////////////////////

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

}




