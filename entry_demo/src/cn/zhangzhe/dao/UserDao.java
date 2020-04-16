package cn.zhangzhe.dao;

import cn.zhangzhe.domain.User;
import cn.zhangzhe.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/*
* 数据库操作类，用来验证用户登录
*
* */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());



    /*
    * 登录验证方法
    * @parameter loginUser 只有用户名和密码
    * @return User包含用户全部数据
    * */

    public User login(User loginUser){
        try{
            //在day14的数据库中查询user表
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
