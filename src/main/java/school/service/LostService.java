package school.service;

import school.pojo.Lost;
import school.pojo.NewAction;
import school.pojo.News;
import school.util.PageSupport;

import java.util.List;

public interface LostService {
    public int addLost(Lost lost);
    public List<Lost> lostMain();
    public Lost findLostById(int id);
    public PageSupport<Lost> getLostList(Lost lost,PageSupport pageSupport);
    public int count(Lost lost);
    public PageSupport<Lost> getMyLostList(Lost lost,PageSupport pageSupport);
    public int myCount(Lost lost);
    public int delLost(int id);
    public int claim(int id);

    public PageSupport<Lost> getLostListAdmin(Lost lost, PageSupport pageSupport);
    public int countAdmin(Lost lost);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
