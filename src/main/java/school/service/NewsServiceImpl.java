package school.service;

import org.springframework.stereotype.Service;
import school.mapper.CommentMapper;
import school.mapper.NewsMapper;
import school.pojo.NewAction;
import school.pojo.News;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;
    @Resource
    private CommentMapper commentMapper;

    public int addPublic(News news) {
        return newsMapper.addNews(news);
    }
    public List<News> newListMain() {
        List<News> newsList = newsMapper.findNewsMain();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (News news: newsList) {
            Date time = news.getTime();
            String date = simpleDateFormat.format(time);
            news.setDate(date);
        }
        return newsList;
    }

    public News findNewsById(int id) {
        News news = newsMapper.findNewsById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(news.getTime());
        news.setDate(date);
        return news;
    }

    public News newsLook(int id){
        News news = findNewsById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(news.getTime());
        news.setDate(date);
        int sum = news.getClicks();
        sum = sum + 1;
        Map map = new HashMap();
        map.put("id",id);
        map.put("clicks",sum);
        newsMapper.updateClicks(map);
        System.out.println(news.getDate()+"1111111");
        return news;
    }

    public int count(News news) {
        return newsMapper.count(news);
    }

    public PageSupport<News> getNewsList(News news, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",news.getSchoolId());
        map.put("title",news.getTitle());
        map.put("userId",news.getUserId());
        List<News> newsList = newsMapper.getNewsList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(News news1 : newsList){
            String date = simpleDateFormat.format(news1.getTime());
            news1.setDate(date);
        }
        pageSupport.setList(newsList);
        return pageSupport;
    }

    public int myCount(News news) {
        return newsMapper.myCount(news);
    }

    public PageSupport<News> getMyNewsList(News news, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",news.getSchoolId());
        map.put("title",news.getTitle());
        map.put("userId",news.getUserId());
        List<News> newsList = newsMapper.getMyNewsList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(News news1 : newsList){
            String date = simpleDateFormat.format(news1.getTime());
            news1.setDate(date);
        }
        pageSupport.setList(newsList);
        return pageSupport;
    }

    public int delNews(int id) {
        News news = newsMapper.findNewsById(id);
        String name1 = news.getPictureName1();
        String name2 = news.getPictureName2();
        String name3 = news.getPictureName3();
        String name4 = news.getPictureName4();
        String path1 = news.getPictureAdd1();
        String path2 = news.getPictureAdd2();
        String path3 = news.getPictureAdd3();
        String path4 = news.getPictureAdd4();
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
        return newsMapper.delNews(id);
    }

    public PageSupport<News> getNewsListClicks(News news, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",news.getSchoolId());
        map.put("title",news.getTitle());
        map.put("userId",news.getUserId());
        List<News> jobList = newsMapper.getNewsListClicks(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(News news1 : jobList){
            String date = simpleDateFormat.format(news1.getTime());
            news1.setDate(date);
        }
        pageSupport.setList(jobList);
        return pageSupport;
    }

    public PageSupport<News> getNewsListTimes(News news, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",news.getSchoolId());
        map.put("title",news.getTitle());
        map.put("userId",news.getUserId());
        List<News> jobList = newsMapper.getNewsListTime(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(News news1 : jobList){
            String date = simpleDateFormat.format(news1.getTime());
            news1.setDate(date);
        }
        pageSupport.setList(jobList);
        return pageSupport;
    }

    public PageSupport<News> getNewsListAdmin(News news, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",news.getSchoolId());
        map.put("title",news.getTitle());
        map.put("status",news.getStatus());
        List<News> newsList = newsMapper.getNewsListAdmin(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(News news1 : newsList){
            String date = simpleDateFormat.format(news1.getTime());
            news1.setDate(date);
        }
        pageSupport.setList(newsList);
        return pageSupport;
    }

    public int countAdmin(News news) {
        return newsMapper.countAdmin(news);
    }

    public int pass(int id) {
        return newsMapper.pass(id);
    }

    public int noPass(int id) {
        return newsMapper.noPass(id);
    }

    public int delByUser(int userId) {
        List<News> newsList = getNewsListByUser(userId);
        for(News news : newsList){
            commentMapper.delComment(news.getId());
        }
        return newsMapper.delByUser(userId);
    }

    public List<News> getNewsListByUser(int userId) {
        List<News> newsList = newsMapper.getNewsListByUser(userId);
        return newsList;
    }
}
