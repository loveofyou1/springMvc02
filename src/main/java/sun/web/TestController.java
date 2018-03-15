package sun.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sunlei19
 * @create 2018-03-14 20:57
 */
public class TestController implements Controller{
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("test Controller!");
        return new ModelAndView("showName");
    }
}
