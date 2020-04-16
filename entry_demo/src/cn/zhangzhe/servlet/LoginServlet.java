package cn.zhangzhe.servlet;

import cn.zhangzhe.dao.UserDao;
import cn.zhangzhe.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.先设置编码格式，防止出现中文乱码
        req.setCharacterEncoding("utf-8");

        //2.获取提交参数的数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //3.封装User对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);

        //4.登录
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        //5.判断是否登陆成功
        if (user==null){
            req.getRequestDispatcher("/failServlet").forward(req,resp);
            System.out.println("登陆失败");
        }else {
            //保存数据
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
            System.out.println("登陆成功");
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
