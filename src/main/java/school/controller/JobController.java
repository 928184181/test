package school.controller;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import school.pojo.Job;
import school.service.JobService;
import school.util.PageSupport;

import javax.annotation.Resource;
@Controller
public class JobController {
    @Resource
    private JobService jobService;
    //兼职分页查询 进入页面
    @RequestMapping("/tonewjob.do")
    public String jobList(Job job, Model model){
        PageSupport<Job> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.count(job));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = jobService.getJobList(job,pageSupport0);
        model.addAttribute("pageSupport",pageSupport);
        return "/user/newjob";
    }
    @RequestMapping("/joblistaj.do")
    @ResponseBody
    public String jobListaj(Job job, @RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "school",required = false)String school){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                job.setSchoolId(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.count(job));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = jobService.getJobList(job,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    //兼职发布
    @RequestMapping("/addjob.do")
    public String publish(Job job,@RequestParam(value = "school") String school,Model model){
        int schoolId = Integer.valueOf(school);
        job.setSchoolId(schoolId);
        job.setStatus(3);
        jobService.addJob(job);
        model.addAttribute("jobPublishSuccess","发布成功！");
        return "/user/jobpublish";
    }
    //我的发布
    @RequestMapping("/myjobpublish.do")
    public String myJob(Job job,Model model,@RequestParam("userId")String userId){
        int id = Integer.valueOf(userId);
        job.setUserId(id);
        PageSupport<Job> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.myCount(job));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = jobService.getMyJobList(job,pageSupport0);
        model.addAttribute("pageSupportMyJob",pageSupport);
        return "/user/myjobpublish";
    }
    @RequestMapping("/myjobpublishaj.do")
    @ResponseBody
    public String myJobListAj(Job job,@RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.myCount(job));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = jobService.getMyJobList(job,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    //我的兼职发布查看
    @RequestMapping("/tomyjoblook.do")
    public String myJobLook(@RequestParam("id") String id,Model model){
        int jobId = Integer.valueOf(id);
        Job job = jobService.findJobById(jobId);
        model.addAttribute("jobLook",job);
        return "/user/myjoblook";
    }
    //删除发布兼职
    @RequestMapping("/myjobdel.do")
    @ResponseBody
    public String myJobDel(@RequestParam("id") String id,@RequestParam("pageIndex") String pageIndex,Job job){
        int jobId = Integer.valueOf(id);
        jobService.delJob(jobId);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(10);
        pageSupport0.setTotalCount(jobService.myCount(job));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = jobService.getMyJobList(job,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    //查看
    @RequestMapping("/joblook.do")
    public String jobLook(@RequestParam("id") String id,Model model){
        int jobId = Integer.valueOf(id);
        Job job = jobService.lookJob(jobId);
        jobService.updateSum(jobId);
        model.addAttribute("job",job);
        return "/user/joblook";
    }
}