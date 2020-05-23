package school.mapper;
import school.pojo.Users;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public Users getUserByCode(String userCode);
    public int addUser(Users users);
    public Users findUsers(int id);
    public int changeUsers(Users users);
    public Users getUser(Users users);

    public int countAdmin(Users users);
    public List<Users> getUsersAdmin(Map map);
    public int delUser(int id);

}
