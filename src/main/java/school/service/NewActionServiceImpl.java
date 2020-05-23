package school.service;

import org.springframework.stereotype.Service;
import school.mapper.NewActionMapper;
import school.pojo.NewAction;
import school.util.PageSupport;
import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("newActionService")
public class NewActionServiceImpl implements NewActionService {
    @Resource
    private NewActionMapper newActionMapper;

    public int addNewAction(NewAction newAction) {
        return newActionMapper.addNewAction(newAction);
    }

    public List<NewAction> newActionMain() {
        List<NewAction> newActionList = newActionMapper.findNewActionMain();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(NewAction newAction : newActionList){
            String date = simpleDateFormat.format(newAction.getTime());
            newAction.setDate(date);
        }
        return newActionList;
    }

    public NewAction findNewActionById(int id) {
        NewAction newAction = newActionMapper.findNewActionById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(newAction.getTime());
        newAction.setDate(date);
        int sum = newAction.getClicks();
        sum = sum + 1;
        Map map = new HashMap();
        map.put("id",id);
        map.put("clicks",sum);
        newActionMapper.updateClicks(map);
        return newAction;
    }

    public int count(NewAction newAction) {
        return newActionMapper.count(newAction);
    }

    public PageSupport<NewAction> getNewActionList(NewAction newAction, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",newAction.getSchoolId());
        map.put("title",newAction.getTitle());
        map.put("userId",newAction.getUserId());
        List<NewAction> newActionList = newActionMapper.getNewActionList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(NewAction newAction1 : newActionList){
            String date = simpleDateFormat.format(newAction1.getTime());
            newAction1.setDate(date);
        }
        pageSupport.setList(newActionList);
        return pageSupport;
    }

    public int myCount(NewAction newAction) {
        return newActionMapper.myCount(newAction);
    }

    public PageSupport<NewAction> getMyNewActionList(NewAction newAction, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",newAction.getSchoolId());
        map.put("title",newAction.getTitle());
        map.put("userId",newAction.getUserId());
        List<NewAction> newsActionList = newActionMapper.getMyNewActionList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(NewAction newAction1 : newsActionList){
            String date = simpleDateFormat.format(newAction1.getTime());
            newAction1.setDate(date);
        }
        pageSupport.setList(newsActionList);
        return pageSupport;
    }

    public NewAction myNewActionById(int id) {
        NewAction newAction = newActionMapper.findNewActionById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(newAction.getTime());
        newAction.setDate(date);
        return newAction;
    }

    public int delAction(int id) {
        NewAction newAction = newActionMapper.findNewActionById(id);
        String name1 = newAction.getPictureName1();
        String name2 = newAction.getPictureName2();
        String name3 = newAction.getPictureName3();
        String name4 = newAction.getPictureName4();
        String path1 = newAction.getPictureAdd1();
        String path2 = newAction.getPictureAdd2();
        String path3 = newAction.getPictureAdd3();
        String path4 = newAction.getPictureAdd4();
        if(name1 != null){
            File directory = new File(path1);
            File[] files = directory.listFiles();
            if(files.length != 0){
                for(File file : files){
                    if(file.getName().equals(name1)){
                        file.delete();
                    }
                }
            }
        }
        if(name2 != null){
            File directory = new File(path2);
            File[] files = directory.listFiles();
            if(files.length != 0){
                for(File file : files){
                    if(file.getName().equals(name2)){
                        file.delete();
                    }
                }
            }
        }
        if(name3 != null){
            File directory = new File(path3);
            File[] files = directory.listFiles();
            if(files.length != 0){
                for(File file : files){
                    if(file.getName().equals(name3)){
                        file.delete();
                    }
                }
            }
        }
        if(name4 != null){
            File directory = new File(path4);
            File[] files = directory.listFiles();
            if(files.length != 0){
                for(File file : files){
                    if(file.getName().equals(name4)){
                        file.delete();
                    }
                }
            }
        }
        return newActionMapper.delAction(id);
    }

    public NewAction findAction(int id) {
        NewAction newAction = newActionMapper.findNewActionById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(newAction.getTime());
        newAction.setDate(date);
        return newAction;
    }

    public PageSupport<NewAction> getNewActionListAdmin(NewAction newAction, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",newAction.getSchoolId());
        map.put("title",newAction.getTitle());
        map.put("status",newAction.getStatus());
        List<NewAction> newActionList = newActionMapper.getNewActionListAdmin(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(NewAction newAction1 : newActionList){
            String date = simpleDateFormat.format(newAction1.getTime());
            newAction1.setDate(date);
        }
        pageSupport.setList(newActionList);
        return pageSupport;
    }

    public int countAdmin(NewAction newAction) {
        return newActionMapper.countAdmin(newAction);
    }

    public int pass(int id) {
        return newActionMapper.pass(id);
    }

    public int noPass(int id) {
        return newActionMapper.noPass(id);
    }

    public int delByUser(int userId) {
        return newActionMapper.delByUser(userId);
    }
}
