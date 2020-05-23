package school.mapper;
import school.pojo.Goods;
import school.pojo.Job;

import java.util.List;
import java.util.Map;
public interface GoodsMapper {
    public int addGoods(Goods goods);
    public List<Goods> findGoods();
    public Goods findGoodsById(int id);
    public int count(Goods goods);
    public List<Goods> getGoodsList(Map map);
    public int myCount (Goods goods);
    public List<Goods> getMyGoodsList(Map map);
    public int delGoods(int id);
    public int updateGoods(Goods goods);
    public int countAdmin(Goods goods);
    public List<Goods> getGoodsListAdmin(Map map);
    public int pass(int id);
    public int noPass(int id);
    public int delByUser(int userId);
}
