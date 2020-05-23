package school.service;

import org.springframework.stereotype.Service;
import school.mapper.GoodsMapper;
import school.pojo.Goods;
import school.pojo.Job;
import school.util.PageSupport;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
    @Resource
    private GoodsMapper goodsMapper;

    public int addGoods(Goods goods) {
        Date time = new Date();
        goods.setTime(time);
        goods.setStatus(3);
        return goodsMapper.addGoods(goods);
    }

    public List<Goods> findGoodsMain() {
        return goodsMapper.findGoods();
    }

    public Goods findGoodsById(int id) {
        Goods goods = goodsMapper.findGoodsById(id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(goods.getTime());
        goods.setDate(date);
        return goods;
    }

    public int count(Goods goods) {
        return goodsMapper.count(goods);
    }

    public PageSupport<Goods> getGoodsList(Goods goods, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",goods.getSchoolId());
        map.put("title",goods.getTitle());
        map.put("sortId",goods.getSortId());
        List<Goods> goodsList = goodsMapper.getGoodsList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Goods goods1 : goodsList){
            String date = simpleDateFormat.format(goods1.getTime());
            goods1.setDate(date);
        }
        pageSupport.setList(goodsList);
        return pageSupport;
    }

    public int myCount(Goods goods) {
        return goodsMapper.myCount(goods);
    }

    public PageSupport<Goods> getMyGoodsList(Goods goods, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("userId",goods.getUserId());
        List<Goods> goodsList = goodsMapper.getMyGoodsList(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Goods goods1 : goodsList){
            String date = simpleDateFormat.format(goods1.getTime());
            goods1.setDate(date);
        }
        pageSupport.setList(goodsList);
        return pageSupport;
    }

    public int delGoods(int id) {
        Goods goods = goodsMapper.findGoodsById(id);
        String name = goods.getPictureName();
        String path = goods.getPictureAdd();
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
        return goodsMapper.delGoods(id);
    }

    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    public PageSupport<Goods> getGoodsListAdmin(Goods goods, PageSupport pageSupport) {
        int pageSize = pageSupport.getPageSize();
        int from = (pageSupport.getCurrentPage()- 1)*pageSize;
        Map map = new HashMap();
        map.put("from",from);
        map.put("pageSize",pageSize);
        map.put("schoolId",goods.getSchoolId());
        map.put("title",goods.getTitle());
        map.put("status",goods.getStatus());
        List<Goods> goodsList = goodsMapper.getGoodsListAdmin(map);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(Goods goods1 : goodsList){
            String date = simpleDateFormat.format(goods1.getTime());
            goods1.setDate(date);
        }
        pageSupport.setList(goodsList);
        return pageSupport;
    }

    public int countAdmin(Goods goods) {
        return goodsMapper.countAdmin(goods);
    }

    public int pass(int id) {
        return goodsMapper.pass(id);
    }

    public int noPass(int id) {
        return goodsMapper.noPass(id);
    }

    public int delByUser(int userId) {
        return goodsMapper.delByUser(userId);
    }
}
