package school.service;

import org.springframework.stereotype.Service;
import school.mapper.LostMapper;
import school.pojo.Lost;
import school.pojo.News;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("lostService")
public class LostServiceImpl implements LostService {
    @Resource
    private LostMapper lostMapper;

    public int addLost(Lost lost) {
        Date time = new Date();
        lost.setTime(time);
        lost.setClaim(1);
        lost.setStatus(3);
        return lostMapper.addLost(lost);
    }

    public List<Lost> lostMain() {
        return lostMapper.lostMain();
    }

    public Lost findLostById(int id) {
        Lost lost = lostMapper.findLostById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(lost.getTime());
        lost.setDate(date);
        return lost;
    }

    public PageSupport<Lost> getLostList(Lost lost, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",lost.getSchoolId());
        map.put("title",lost.getTitle());
        List<Lost> lostList = lostMapper.getLostList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Lost lost1 : lostList){
            String date = simpleDateFormat.format(lost1.getTime());
            lost1.setDate(date);
        }
        pageSupport.setList(lostList);
        return pageSupport;
    }

    public int count(Lost lost) {
        return lostMapper.count(lost);
    }

    public PageSupport<Lost> getMyLostList(Lost lost, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",lost.getSchoolId());
        map.put("title",lost.getTitle());
        map.put("userId",lost.getUserId());
        List<Lost> lostList = lostMapper.getMyLostList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Lost lost1 : lostList){
            String date = simpleDateFormat.format(lost1.getTime());
            lost1.setDate(date);
        }
        pageSupport.setList(lostList);
        return pageSupport;
    }

    public int myCount(Lost lost) {
        return lostMapper.myCount(lost);
    }

    public int delLost(int id) {
        Lost lost = lostMapper.findLostById(id);
        String name = lost.getPictureName();
        String path = lost.getPictureAdd();
        if(name != null){
            File directory = new File(path);
            File[] files = directory.listFiles();
            if(files.length != 0){
                for(File file : files){
                    if(file.getName().equals(name)){
                        file.delete();
                    }
                }
            }
        }
        return lostMapper.delLost(id);
    }

    public int claim(int id) {
        return lostMapper.claim(id);
    }

    public PageSupport<Lost> getLostListAdmin(Lost lost, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",lost.getSchoolId());
        map.put("title",lost.getTitle());
        map.put("status",lost.getStatus());
        List<Lost> lostList = lostMapper.getLostListAdmin(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Lost lost1 : lostList){
            String date = simpleDateFormat.format(lost1.getTime());
            lost1.setDate(date);
        }
        pageSupport.setList(lostList);
        return pageSupport;
    }

    public int countAdmin(Lost lost) {
        return lostMapper.countAdmin(lost);
    }

    public int pass(int id) {
        return lostMapper.pass(id);
    }

    public int noPass(int id) {
        return lostMapper.noPass(id);
    }

    public int delByUser(int userId) {
        return lostMapper.delByUser(userId);
    }
}
