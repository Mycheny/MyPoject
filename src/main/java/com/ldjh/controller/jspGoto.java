package com.ldjh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class jspGoto {
    @RequestMapping("/jsp")
    protected void jsp(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        response.setCharacterEncoding("UTF-8");
        StringBuilder page = new StringBuilder("WEB-INF/admin/");
        String req_page = request.getParameter("page");
        page.append(req_page);// 转换跳转的url， 跳转的jsp页面
        request.getRequestDispatcher(page.toString()).forward(request, response);
    }

    @RequestMapping("/jsp1")
    public String toJsp(Model model,HttpServletRequest request){
        String req_page = request.getParameter("page");

        return "req_page";
    }
}
