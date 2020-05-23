package school.service;

import org.springframework.stereotype.Service;
import school.mapper.JobMapper;
import school.pojo.Job;
import school.pojo.News;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("jobService")
public class JobServiceImpl implements JobService{
    @Resource
    private JobMapper jobMapper;
    public List<Job> getJob() {
        List<Job> jobList = new ArrayList<>();
        jobList = jobMapper.getJob();
        return jobList;
    }

    public int count(Job job) {
        return jobMapper.count(job);
    }

    public PageSupport<Job> getJobList(Job job, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",job.getSchoolId());
        map.put("title",job.getTitle());
        map.put("userId",job.getUserId());
        List<Job> jobList = jobMapper.getJobList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Job job1 : jobList){
            String date = simpleDateFormat.format(job1.getTime());
            job1.setDate(date);
        }
        pageSupport.setList(jobList);
        return pageSupport;
    }

    public int addJob(Job job) {
        Date date = new Date();
        job.setTime(date);
        job.setSum(0);
        return jobMapper.insertJob(job);
    }

    public int myCount(Job job) {
        return jobMapper.myCount(job);
    }

    public PageSupport<Job> getMyJobList(Job job, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",job.getSchoolId());
        map.put("title",job.getTitle());
        map.put("userId",job.getUserId());
        List<Job> jobList = jobMapper.getMyJobList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Job job1 : jobList){
            String date = simpleDateFormat.format(job1.getTime());
            job1.setDate(date);
        }
        pageSupport.setList(jobList);
        return pageSupport;
    }

    public Job findJobById(int id) {
        Job job = jobMapper.findJob(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = simpleDateFormat.format(job.getTime());
        job.setDate(str);
        return job;
    }

    public void updateSum(int id) {
        Job job = findJobById(id);
        int sum0 = job.getSum();
        sum0 = sum0 + 1;
        Map map = new HashMap();
        map.put("id",id);
        map.put("sum",sum0);
        jobMapper.updateClick(map);
    }

    public int delJob(int id) {
        return jobMapper.delJob(id);
    }

    public Job lookJob(int id) {
        Job job = jobMapper.findJob(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(job.getTime());
        job.setDate(date);
        return job;
    }

    public PageSupport<Job> getJobListAdmin(Job job, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",job.getSchoolId());
        map.put("title",job.getTitle());
        map.put("status",job.getStatus());
        List<Job> jobList = jobMapper.getJobListAdmin(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Job job1 : jobList){
            String date = simpleDateFormat.format(job1.getTime());
            job1.setDate(date);
        }
        pageSupport.setList(jobList);
        return pageSupport;
    }

    public int countAdmin(Job job) {
        return jobMapper.countAdmin(job);
    }

    public int pass(int id) {
        return jobMapper.pass(id);
    }

    public int noPass(int id) {
        return jobMapper.noPass(id);
    }

    public int delByUser(int userId) {
        return jobMapper.delByUser(userId);
    }

}
