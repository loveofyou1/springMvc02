package sun.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.entity.UserVO;
import sun.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunlei19
 * @create 2018-02-24 10:34
 */
@Controller
@RequestMapping(value = "/")
public class UserController {
    @Resource
    private IUserService userService;


    @RequestMapping(value = "/showUserName", method = RequestMethod.GET)
    public String showUserName(int uid, HttpServletRequest request, Model model) {
        System.out.println("showname");
        UserVO userVO = userService.queryUserInfoById(uid);
        if (userVO != null) {
            request.setAttribute("name", userVO.getUserName());
            model.addAttribute("name", userVO.getUserName());
            return "showName";
        }
        request.setAttribute("error", "没有找到该用户!");
        return "error";
    }

    @RequestMapping(value = "redictNewPage")
    public String redictNewPage(HttpServletRequest request, HttpServletResponse response) {
        return "showName";
    }
}
