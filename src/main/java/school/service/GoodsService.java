package school.service;

import school.pojo.Goods;
import school.pojo.Job;
import school.util.PageSupport;

import java.util.List;

public interface GoodsService {
    public int addGoods(Goods goods);
    public List<Goods> findGoodsMain();
    public Goods findGoodsById(int id);
    public int count(Goods goods);
    public PageSupport<Goods> getGoodsList(Goods goods,PageSupport pageSupport);
    public int myCount(Goods goods);
    public PageSupport<Goods> getMyGoodsList(Goods goods,PageSupport pageSupport);
    public int delGoods(int id);
    public int updateGoods(Goods goods);

    public PageSupport<Goods> getGoodsListAdmin(Goods goods, PageSupport pageSupport);
    public int countAdmin(Goods goods);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
