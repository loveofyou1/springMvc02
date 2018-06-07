package sun.web;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.entity.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author sunlei19
 * @create 2018-06-02 15:53
 */
@Controller
public class Testcontroller1 {

    /**
     * http://localhost:8080/baseType.do?xage=
     * 包装类可以传null值
     *
     * @param age
     * @return
     */
    @RequestMapping(value = "/baseType.do")
    @ResponseBody
    public String baseType(@RequestParam(value = "xage") Integer age) {

        return "age:" + age;
    }

    /**
     * http://localhost:8080/array.do?name=sun&name=lei
     * 数组数据绑定
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/array.do")
    @ResponseBody
    public String array(String[] name) {
        StringBuilder result = new StringBuilder();
        for (String str : name) {
            result.append(str + " ");
        }
        return result.toString();
    }

    /**
     * http://localhost:8080/object.do?id=1&userName=sun&age=10&password=124&contractInfo
     * .address=beijing&contractInfo.phone=10086
     * <p>
     * http://localhost:8080/admin.do?userVO.age=5&admin.age=10同属性的多对象通过数据绑定
     * 单层级对象
     * 多层级对象
     * 同层级对象
     *
     * @param userVO
     * @return
     */
    @RequestMapping(value = "/object.do")
    @ResponseBody
    public String object(UserVO userVO) {
        return userVO.toString();
    }

    @RequestMapping(value = "/admin.do")
    @ResponseBody
    public String admin(UserVO userVO, Admin admin) {
        return userVO.toString() + admin.toString();
    }

    @InitBinder("userVO")
    public void initUserVO(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("userVO.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("admin.");
    }

    /**
     * 需要做数据收集对象
     * http://localhost:8080/list.do?users[0].name=sun&users[20].name=lei
     * 是可以跨索引的赋值，中间值都打印空值
     *
     * @param userListForm
     * @return
     */
    @RequestMapping(value = "/list.do")
    @ResponseBody
    public String list(UserListForm userListForm) {
        return userListForm.toString();
    }

    /**
     * http://localhost:8080/set.do?users[0].name=sun&users[1].name=lei
     * set的绑定，springmvc对set处理不好
     *
     * @param userSetForm
     * @return
     */
    @RequestMapping(value = "/set.do")
    @ResponseBody
    public String set(UserSetForm userSetForm) {
        return userSetForm.toString();
    }

    /**
     * http://localhost:8080/map.do?users[%22x%22].name=sun&users[%22y%22].name=lei
     * map的数据绑定
     *
     * @param userMapform
     * @return
     */
    @RequestMapping(value = "/map.do")
    @ResponseBody
    public String map(UserMapform userMapform) {
        return userMapform.toString();
    }


    @RequestMapping(value = "/json.do")
    @ResponseBody
    public String json(Admin user) {
        return user.toString();
    }

    @RequestMapping(value = "/restful.do/{hello}")
    @ResponseBody
    public String restful(@PathVariable(value = "hello") String hello) {

        return hello;
    }

    @RequestMapping(value = "/normal.do")
    @ResponseBody
    public String normal(HttpServletRequest request) {
        String hello = request.getParameter("hello");
        return hello;
    }

    @RequestMapping(value = "/submitFile.do", method = RequestMethod.POST)
    public String submitFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File("d:\\", System.currentTimeMillis
                    () + file.getOriginalFilename())));

        }
        return "success";
    }

    @RequestMapping(value = "/page3.do")
    public String page3(HttpServletRequest request, HttpServletResponse response) {
        return "page3";
    }

    @RequestMapping(value = "/page4.do")
    public String page4() {
        return "JsonPage4";
    }

    @RequestMapping(value = "/showJson.do")
    @ResponseBody
    public String showJson(HttpServletRequest request,HttpServletResponse response, ModelMap model) {
        UserVO userVO = new UserVO();
        userVO.setId(1);
        userVO.setAge(20);
        userVO.setUserName("sunlei");
        userVO.setPassword("jd618");
        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setAddress("科创十一街18号院");
        contractInfo.setPhone("123456778901");
        userVO.setContractInfo(contractInfo);
        model.addAttribute("jsonText", JSON.toJSONString(userVO));
        return JSON.toJSONString(userVO);
    }
}
