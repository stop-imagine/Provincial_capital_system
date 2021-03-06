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

@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");        //设置request对象的字符编码方式
        response.setHeader("content-type","text/html;charset=UTF-8");
        String shengming = request.getParameter("shengming");     //获得请求属性
        PrintWriter writer = response.getWriter();
        //设置request对象的字符编码方式
        request.setCharacterEncoding("UTF-8");
        boolean res = ShenghuiModel.deleteRs(shengming);
        //设置返回数据格式和编码,编码要写在定义前面,否则无效
        response.setContentType("text/json;charset=UTF-8");
        //设置response对象的字符编码方式
        response.setCharacterEncoding("UTF-8");
        //通过PrintWriter返回给客户端操作结果,输出流
        if(res) {
            writer.print("true");
        } else {
            writer.print("false");
        }
    }
}