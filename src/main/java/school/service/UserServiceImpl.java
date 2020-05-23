package school.service;

import org.springframework.stereotype.Service;
import school.mapper.UserMapper;
import school.pojo.Lost;
import school.pojo.Users;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Resource
    private UserMapper userMapper;
    public Users login(Users users) {
        return userMapper.getUser(users);
    }
    public int register(Users users) {
        int a = userMapper.addUser(users);
        return a;
    }

    public Users registerCode(String userCode) {
        Users users = userMapper.getUserByCode(userCode);
        return users;
    }

    public Users findUsers(int id) {
        return userMapper.findUsers(id);
    }

    public int changeUsers(Users users) {
        return userMapper.changeUsers(users);
    }

    public int countAdmin(Users users) {
        return userMapper.countAdmin(users);
    }

    public PageSupport<Lost> getUsersAdmin(Users users, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",users.getSchoolId());
        map.put("userName",users.getUserName());
        List<Users> usersList = userMapper.getUsersAdmin(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Users users1 : usersList){
            String date = simpleDateFormat.format(users1.getTime());
            users1.setDate(date);
        }
        pageSupport.setList(usersList);
        return pageSupport;
    }

    public int delUser(int id) {
        return userMapper.delUser(id);
    }
}
