package school.mapper;

import school.pojo.NewAction;
import school.pojo.News;

import java.util.List;
import java.util.Map;

public interface NewsMapper {
    public int addNews(News news);
    public List<News> findNewsMain();
    public News findNewsById(int id);
    public int updateClicks(Map map);
    public List<News> getNewsList(Map map);
    public int count(News news);
    public List<News> getMyNewsList(Map map);
    public int myCount(News news);
    public int delNews(int id);
    public List<News> getNewsListClicks(Map map);
    public List<News> getNewsListTime(Map map);

    public int countAdmin(News news);
    public List<News> getNewsListAdmin(Map map);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
    public List<News> getNewsListByUser(int userId);
}