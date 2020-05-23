package school.controller;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import school.pojo.Goods;
import school.pojo.News;
import school.pojo.Order;
import school.service.GoodsService;
import school.service.OrderService;
import school.util.PageSupport;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;
@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private OrderService orderService;
    @RequestMapping("/goodspublish.do")
    public String addGoods(@ModelAttribute("Goods")Goods goods, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request, Model model) throws IOException {
        String targetPath = request.getServletContext().getRealPath("statics" + File.separator + "goods");
        if(!multipartFile.isEmpty()){
            String sourceFileName = multipartFile.getOriginalFilename();//源文件名
            String type = FilenameUtils.getExtension(sourceFileName);//后缀
            String uuid = UUID.randomUUID().toString().replace("-", "").substring(10);
            String targetName = uuid + "." + type;
            File targetFile = new File(targetPath, targetName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
                multipartFile.transferTo(targetFile);
            }
            goods.setPictureName(targetName);
            goods.setPictureAdd(targetPath);
        }
        goodsService.addGoods(goods);
        model.addAttribute("goodsPublish","发布成功");
        return "/user/goodspublish";
    }
    @RequestMapping("/togoodsdetails.do")
    public String goodsDetails(@RequestParam("id")String id,Model model){
        int goodsId = Integer.valueOf(id);
        Goods goods = goodsService.findGoodsById(goodsId);
        model.addAttribute("goods",goods);
        return "/user/goodsdetails";
    }
    @RequestMapping("/tosecondhand.do")
    public String secondHand(@RequestParam(value = "pageIndex",required = false)String pageIndex,Goods goods,Model model){
        PageSupport<News> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(12);
        pageSupport0.setTotalCount(goodsService.count(goods));
        if(pageIndex != null){
            int a = Integer.valueOf(pageIndex);
            pageSupport0.setCurrentPage(a);
        }else {
            pageSupport0.setCurrentPage(1);
        }
        PageSupport pageSupport = goodsService.getGoodsList(goods,pageSupport0);
        model.addAttribute("pageSupportGoods",pageSupport);
        return "/user/secondhand";
    }
    @RequestMapping("secondhandaj.do")
    @ResponseBody
    public String secondHandAj(Goods goods, @RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam(value = "school",required = false)String school,@RequestParam(value = "sortId",required = false)String sortId){
        if(school!=null){
            int id = Integer.valueOf(school);
            if(id !=0 ){
                goods.setSchoolId(id);
            }
        }
        if(sortId!=null){
            int id = Integer.valueOf(sortId);
            if(id !=0 ){
                goods.setSortId(id);
            }
        }
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(12);
        pageSupport0.setTotalCount(goodsService.count(goods));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = goodsService.getGoodsList(goods,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/goodsbutton.do")
    @ResponseBody
    public String goodsButton(@RequestParam("id")String id){
        int goodsId = Integer.valueOf(id);
        Goods goods = goodsService.findGoodsById(goodsId);
        String json = JSON.toJSONString(goods);
        return json;
    }
    @RequestMapping(value = "/goodsbuy.do",produces = "text/html; charset=UTF-8")
    public String goodsBuy(Model model,@RequestParam("userId")String userId,@RequestParam("goodsId")String goodsId,@RequestParam("price")String price,@RequestParam("count")String count) throws AlipayApiException {
        int goodsId0 = Integer.valueOf(goodsId);
        int buyId = Integer.valueOf(userId);
        int count0 = Integer.valueOf(count);
        double price0 = Double.valueOf(price);
        String number = UUID.randomUUID().toString().replace("-","").substring(20);
        Date time = new Date();
        Goods goods = goodsService.findGoodsById(goodsId0);
        Order order = new Order();
        order.setGoodsName(goods.getTitle());
        order.setGoodsContent(goods.getContent());
        order.setPictureName(goods.getPictureName());
        order.setPictureAdd(goods.getPictureAdd());
        order.setBuyId(buyId);
        order.setSellerId(goods.getUserId());
        order.setTime(time);
        order.setPrice(price0);
        order.setCount(count0);
        order.setOrderNum(number);
        order.setStatus(1);
        orderService.addOrder(order);
        Goods goods1 = new Goods();
        int countSum = goods.getCount();
        int newCount = countSum - count0;
        goods1.setCount(newCount);
        goodsService.updateGoods(goods1);
        return "redirect:/tosecondhand.do";
    }
}