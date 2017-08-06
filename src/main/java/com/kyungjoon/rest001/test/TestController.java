package com.kyungjoon.rest001.test;

import ch.qos.logback.classic.Logger;
import org.json.simple.JSONValue;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


@Controller
public class TestController {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestDao testDao;

    @Autowired
    private JdbcTemplate template;

   /* @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav=new ModelAndView();
        // mav.addObject("message", "업로드성공!");
        mav.setViewName("redirect:" + "/test/getList");
        return  mav;
    }*/


    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mav=new ModelAndView();
        // mav.addObject("message", "업로드성공!");
        mav.setViewName("redirect:" + "/test/list");
        return  mav;
    }


    @RequestMapping("/test/list")
    public ModelAndView list(Model model,
                             @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView mav=new ModelAndView();


        List<?> arrList = testDao.getList();

        mav.addObject("arrList", arrList);

        mav.setViewName("/test/list");
        return  mav;

    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/test/getList")
    public @ResponseBody
    String getList() throws IOException {
        HashMap resultMap = new HashMap();



        List arrList  = template.queryForList("SELECT * FROM blogs order by id desc");
        resultMap.put("arrList", arrList);
        System.out.println("고경준 천재님이십니ㅏㄴㅇflsdkflskdflksdlkflsdkflksdlfk");
        return JSONValue.toJSONString(resultMap);

    }


}
