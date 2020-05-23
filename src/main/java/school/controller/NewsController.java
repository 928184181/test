package school.controller;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import school.pojo.Comment;
import school.pojo.News;
import school.service.CommentService;
import school.service.NewsService;
import school.util.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;
@Controller
public class NewsController {
    @Resource
    private NewsService newsService;
    @Resource
    private CommentService commentService;
        @RequestMapping("/publish.do")
        public String publish(@ModelAttribute("News")News news, @RequestParam("file") MultipartFile[] multipartFile, HttpServletRequest request, Model model) throws IOException {
            String targetPath = request.getServletContext().getRealPath("statics" + File.separator + "news");
            for(int i=0 ;i<multipartFile.length;i++) {
                if(!multipartFile[i].isEmpty()){
                    String sourceFileName = multipartFile[i].getOriginalFilename();//源文件名
                    String type = FilenameUtils.getExtension(sourceFileName);//后缀
                    String uuid = UUID.randomUUID().toString().replace("-", "").substring(10);
                    String targetName = uuid + "." + type;
                    File targetFile = new File(targetPath, targetName);
                    if (!targetFile.exists()) {
                        targetFile.mkdirs();
                        multipartFile[i].transferTo(targetFile);
                    }
                    if (i == 0) {
                        news.setPictureName1(targetName);
                        news.setPictureAdd1(targetPath);
                    } else if (i == 1) {
                        news.setPictureName2(targetName);
                        news.setPictureAdd2(targetPath);
                    } else if (i == 2) {
                        news.setPictureName3(targetName);
                        news.setPictureAdd3(targetPath);
                    } else if(i == 3) {
                        news.setPictureName4(targetName);
                        news.setPictureAdd4(targetPath);
                    }
                }
            }
            Date date = new Date();
            news.setTime(date);
            news.setClicks(0);
            news.setStatus(3);
            newsService.addPublic(news);
            model.addAttribute("publishSuccess","发帖成功！");
            return "/user/publish";
        }
        @RequestMapping("/tonewslook.do")
        public String toNewsLook(@RequestParam("id") String id,Model model){
            int newsId = Integer.valueOf(id);
            News news = newsService.newsLook(newsId);
            model.addAttribute("newsLook",news);
            PageSupport<Comment> pageSupport0 = new PageSupport<>();
            pageSupport0.setPageSize(5);
            pageSupport0.setTotalCount(commentService.count(newsId));
            pageSupport0.setCurrentPage(1);
            PageSupport pageSupport = commentService.getCommentList(newsId,pageSupport0);
            model.addAttribute("pageSupport",pageSupport);
            return "/user/newslook";
        }
        //资讯分页查询 进入页面
        @RequestMapping("/tomessage.do")
        public String toMessage(News news, Model model){
            PageSupport<News> pageSupport0 = new PageSupport<>();
            pageSupport0.setPageSize(10);
            pageSupport0.setTotalCount(newsService.count(news));
            pageSupport0.setCurrentPage(1);
            PageSupport pageSupport = newsService.getNewsList(news,pageSupport0);
            model.addAttribute("pageSupportNews",pageSupport);
            return "/user/message";
        }
        @RequestMapping("/newslistaj.do")
        @ResponseBody
        public String newsListaj(News news, @RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "school",required = false)String school,@RequestParam(value = "flag")String flag){
            System.out.println(school+"school");
            System.out.println(flag+"flag");
            String json = "";
            if(flag.equals("hot")){
                System.out.println("hot");
                if(school!=null){
                    int id = Integer.valueOf(school);
                    if(id !=0 ){
                        news.setSchoolId(id);
                    }
                }
                PageSupport pageSupport0 = new PageSupport();
                pageSupport0.setPageSize(10);
                pageSupport0.setTotalCount(newsService.count(news));
                if(pageIndex == null){
                    pageSupport0.setCurrentPage(1);
                }else {
                    pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
                }
                PageSupport pageSupport = newsService.getNewsListClicks(news,pageSupport0);
                json = JSON.toJSONString(pageSupport);
            }else if(flag.equals("new")){
                System.out.println("new");
                if(school!=null){
                    int id = Integer.valueOf(school);
                    if(id !=0 ){
                        news.setSchoolId(id);
                    }
                }
                PageSupport pageSupport0 = new PageSupport();
                pageSupport0.setPageSize(10);
                pageSupport0.setTotalCount(newsService.count(news));
                if(pageIndex == null){
                    pageSupport0.setCurrentPage(1);
                }else {
                    pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
                }
                PageSupport pageSupport = newsService.getNewsListTimes(news,pageSupport0);
                json = JSON.toJSONString(pageSupport);
            }
            return json;
        }
        //我的发布
        @RequestMapping("/mynewspublish.do")
        public String myJob(News news,Model model,@RequestParam("userId")String userId){
            int id = Integer.valueOf(userId);
            news.setUserId(id);
            PageSupport<News> pageSupport0 = new PageSupport<>();
            pageSupport0.setPageSize(10);
            pageSupport0.setTotalCount(newsService.myCount(news));
            pageSupport0.setCurrentPage(1);
            PageSupport pageSupport = newsService.getMyNewsList(news,pageSupport0);
            model.addAttribute("pageSupportMyNews",pageSupport);
            return "/user/mynews";
        }
        @RequestMapping("/mynewspublishaj.do")
        @ResponseBody
        public String myNewsPublish(News news,@RequestParam(value = "pageIndex",required = false)String pageIndex){
            PageSupport pageSupport0 = new PageSupport();
            pageSupport0.setPageSize(10);
            pageSupport0.setTotalCount(newsService.myCount(news));
            if(pageIndex == null){
                pageSupport0.setCurrentPage(1);
            }else {
                pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
            }
            PageSupport pageSupport = newsService.getMyNewsList(news,pageSupport0);
            String json = JSON.toJSONString(pageSupport);
            return json;
        }
        @RequestMapping("/tomynewslook.do")
        public String myNewsLook(@RequestParam("id") String id,Model model){
            int newsId = Integer.valueOf(id);
            News news = newsService.newsLook(newsId);
            model.addAttribute("newsLook",news);
            PageSupport<Comment> pageSupport0 = new PageSupport<>();
            pageSupport0.setPageSize(5);
            pageSupport0.setTotalCount(commentService.count(newsId));
            pageSupport0.setCurrentPage(1);
            PageSupport pageSupport = commentService.getCommentList(newsId,pageSupport0);
            model.addAttribute("pageSupport",pageSupport);
            return "/user/mynewslook";
        }
        @RequestMapping("/mynewsdel.do")
        @ResponseBody
        public String myNewsDel(@RequestParam("id") String id,@RequestParam("pageIndex") String pageIndex,News news){
            int newsId = Integer.valueOf(id);
            newsService.delNews(newsId);
            PageSupport pageSupport0 = new PageSupport();
            pageSupport0.setPageSize(10);
            pageSupport0.setTotalCount(newsService.myCount(news));
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
            PageSupport pageSupport = newsService.getMyNewsList(news,pageSupport0);
            String json = JSON.toJSONString(pageSupport);
            return json;
        }
        @RequestMapping("/comment.do")
        @ResponseBody
        public String comment(Comment comment){
            commentService.addComment(comment);
            return "success";
        }
        @RequestMapping("/commentaj.do")
        @ResponseBody
        public String commentAj(@RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "newsId")String newsId){
            int id = Integer.valueOf(newsId);
            PageSupport pageSupport0 = new PageSupport();
            pageSupport0.setPageSize(5);
            pageSupport0.setTotalCount(commentService.count(id));
            if(pageIndex == null){
                pageSupport0.setCurrentPage(1);
            }else {
                pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
            }
            PageSupport pageSupport = commentService.getCommentList(id,pageSupport0);
            String json = JSON.toJSONString(pageSupport);
            return json;
        }
}
