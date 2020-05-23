package school.service;

import school.pojo.Lost;
import school.pojo.Users;
import school.util.PageSupport;

import java.util.List;
import java.util.Map;

public interface UserService {
    //登录
    public Users login(Users users);
    //注册
    public int register(Users users);
    //注册名验证
    public Users registerCode(String userCode);
    public Users findUsers(int id);
    public int changeUsers(Users users);

    public int countAdmin(Users users);
    public PageSupport<Lost> getUsersAdmin(Users users,PageSupport pageSupport);
    public int delUser(int id);
}
