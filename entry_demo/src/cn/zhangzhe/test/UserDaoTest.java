package cn.zhangzhe.test;

import cn.zhangzhe.dao.UserDao;
import cn.zhangzhe.domain.User;
import org.junit.Test;

public class UserDaoTest {


    @Test
    public void testLogin(){
        UserDao dao = new UserDao();
        User loginUser = new User();
        loginUser.setUsername("zhangzhe");
        loginUser.setPassword("123");
        User user = dao.login(loginUser);
        System.out.println(user);
    }

}
