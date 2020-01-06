package servlet;

import entity.ShengHui;
import model.ShenghuiModel;
import util.JSONToShenghui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @author Pierce
 */
@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request对象的字符编码方式
        request.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String shengming = request.getParameter("shengming");
        String huiming = request.getParameter("huiming");
        String meishi = request.getParameter("meishi");
        String jingdian = request.getParameter("jingdian");
        String gaoxiao = request.getParameter("gaoxiao");
        //ShengHui sh = new ShengHui(shengming,huiming,meishi,jingdian,gaoxiao);
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean res = ShenghuiModel.addRs(shengming,huiming,meishi,jingdian,gaoxiao);

        if(res) {
            writer.print("true");
        } else {
            writer.print("false");
        }

    }
}