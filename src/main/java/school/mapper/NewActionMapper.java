package school.mapper;

import school.pojo.NewAction;

import java.util.List;
import java.util.Map;

public interface NewActionMapper {
    public int addNewAction(NewAction newAction);
    public List<NewAction> findNewActionMain();
    public NewAction findNewActionById(int id);
    public int updateClicks(Map map);
    public List<NewAction> getNewActionList(Map map);
    public int count(NewAction newAction);
    public List<NewAction> getMyNewActionList(Map map);
    public int myCount(NewAction newAction);
    public int delAction(int id);

    public int countAdmin(NewAction newAction);
    public List<NewAction> getNewActionListAdmin(Map map);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
