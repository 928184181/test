package school.service;

import school.pojo.NewAction;
import school.util.PageSupport;

import java.util.List;

public interface NewActionService {
    public int addNewAction(NewAction newAction);
    public List<NewAction> newActionMain();
    public NewAction findNewActionById(int id);
    public int count(NewAction newAction);
    public PageSupport<NewAction> getNewActionList(NewAction newAction,PageSupport pageSupport);
    public int myCount(NewAction newAction);
    public PageSupport<NewAction> getMyNewActionList(NewAction newAction,PageSupport pageSupport);
    public NewAction myNewActionById(int id);
    public int delAction(int id);
    public NewAction findAction(int id);

    public PageSupport<NewAction> getNewActionListAdmin(NewAction newAction,PageSupport pageSupport);
    public int countAdmin(NewAction newAction);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
