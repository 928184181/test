package school.mapper;

import school.pojo.Lost;
import school.pojo.News;

import java.util.List;
import java.util.Map;

public interface LostMapper {
    public int addLost(Lost lost);
    public List<Lost> lostMain();
    public Lost findLostById(int id);
    public List<Lost> getLostList(Map map);
    public int count(Lost lost);
    public List<Lost> getMyLostList(Map map);
    public int myCount(Lost lost);
    public int delLost(int id);
    public int claim(int id);

    public int countAdmin(Lost lost);
    public List<Lost> getLostListAdmin(Map map);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
