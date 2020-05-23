package school.service;

import school.pojo.NewAction;
import school.pojo.News;
import school.util.PageSupport;

import java.util.List;

public interface NewsService {
    public int addPublic(News news);
    public List<News> newListMain();
    public News findNewsById(int id);
    public News newsLook(int id);
    public int count(News news);
    public PageSupport<News> getNewsList(News news, PageSupport pageSupport);
    public int myCount(News news);
    public PageSupport<News> getMyNewsList(News news,PageSupport pageSupport);
    public int delNews(int id);
    public PageSupport<News> getNewsListClicks(News news, PageSupport pageSupport);
    public PageSupport<News> getNewsListTimes(News news, PageSupport pageSupport);

    public PageSupport<News> getNewsListAdmin(News news, PageSupport pageSupport);
    public int countAdmin(News news);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
    public List<News> getNewsListByUser(int userId);
}
