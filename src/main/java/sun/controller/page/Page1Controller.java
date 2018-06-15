package sun.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.entity.UserVO;
import sun.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @author sunlei19
 * @create 2018-02-23 11:45
 */

@Controller
@RequestMapping(value = "/")
public class Page1Controller {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/testAction", method = RequestMethod.GET)
    @ResponseBody
    public String testAction(String userName, int age, String password, HttpServletRequest request, Model model) {
        UserVO userVO = new UserVO();
        //userVO.setId(2);
        userVO.setUserName(userName);
        userVO.setAge(age);
        userVO.setPassword(password);
        String msg = userService.save(userVO);
        if (msg == "showName") {
            if (userVO != null) {
                request.setAttribute("name", userVO.getUserName());
                model.addAttribute("name", userVO.getUserName());
                return "showName";
            }
        }
        return msg;
    }

    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    public String queryUserById(int id, Model model) {
        UserVO userVO;
        userVO = userService.queryUserInfoById(id);
        if (userVO != null) {
            model.addAttribute("name", userVO.getUserName());
            model.addAttribute("age", userVO.getAge());
            return "showName";
        }
        return "error";
    }

    @RequestMapping(value = "/queryUserByName", method = RequestMethod.GET)
    public String queryUserByName(String name, Model model) {
        UserVO userVO;
        userVO = userService.queryUserInfo(name);
        if (userVO != null) {
            model.addAttribute("name", userVO.getUserName());
            model.addAttribute("age", userVO.getAge());
            return "showName";
        }
        return "error";
    }
}
