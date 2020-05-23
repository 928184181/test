package school.controller;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import school.pojo.Goods;
import school.pojo.Order;
import school.pojo.Users;
import school.service.GoodsService;
import school.service.OrderService;
import school.service.UserService;
import school.util.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller
public class UserController {
    @Resource
    private OrderService orderService;
    @Resource
    private GoodsService goodsService;
    @Resource
    private UserService userService;
    @RequestMapping("/touser.do")
    public String toUser(@RequestParam("id")String id, Model model){
        int userId = Integer.valueOf(id);
        Order order = new Order();
        order.setBuyId(userId);
        PageSupport<Order> pageSupport0 = new PageSupport<>();
        pageSupport0.setPageSize(5);
        pageSupport0.setTotalCount(orderService.buyCount(order));
        pageSupport0.setCurrentPage(1);
        PageSupport pageSupport = orderService.buyOrder(order,pageSupport0);
        model.addAttribute("pageSupportBuyOrder",pageSupport);
        Goods goods = new Goods();
        goods.setUserId(userId);
        PageSupport<Goods> pageSupportg = new PageSupport<>();
        pageSupportg.setPageSize(5);
        pageSupportg.setTotalCount(goodsService.myCount(goods));
        pageSupportg.setCurrentPage(1);
        PageSupport pageSupportg1 = goodsService.getMyGoodsList(goods,pageSupportg);
        model.addAttribute("pageSupportMyGoods",pageSupportg1);
        return "/user/user";
    }
    @RequestMapping("/buyorderaj.do")
    @ResponseBody
    public String buyOrderAj(Order order,@RequestParam(value = "pageIndex",required = false)String pageIndex,@RequestParam("userId")String userId,@RequestParam("flag")String flag){
        int id = Integer.valueOf(userId);
        if(flag.equals("buy")){
            order.setBuyId(id);
            PageSupport pageSupport0 = new PageSupport();
            pageSupport0.setPageSize(5);
            pageSupport0.setTotalCount(orderService.buyCount(order));
            if(pageIndex == null){
                pageSupport0.setCurrentPage(1);
            }else {
                pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
            }
            PageSupport pageSupport = orderService.buyOrder(order,pageSupport0);
            String json = JSON.toJSONString(pageSupport);
            return json;
        }else {
            order.setSellerId(id);
            PageSupport pageSupport0 = new PageSupport();
            pageSupport0.setPageSize(5);
            pageSupport0.setTotalCount(orderService.sellerCount(order));
            if(pageIndex == null){
                pageSupport0.setCurrentPage(1);
            }else {
                pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
            }
            PageSupport pageSupport = orderService.sellerOrder(order,pageSupport0);
            String json = JSON.toJSONString(pageSupport);
            return json;
        }
    }
    @RequestMapping("/usergoodsaj.do")
    @ResponseBody
    public String goodsAj(Goods goods,@RequestParam(value = "pageIndex",required = false)String pageIndex){
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(5);
        pageSupport0.setTotalCount(goodsService.myCount(goods));
        if(pageIndex == null){
            pageSupport0.setCurrentPage(1);
        }else {
            pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        }
        PageSupport pageSupport = goodsService.getMyGoodsList(goods,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/usergoodsdel.do")
    @ResponseBody
    public String goodsDel(@RequestParam("id") String id, @RequestParam("pageIndex") String pageIndex,Goods goods){
        int goodsId = Integer.valueOf(id);
        goodsService.delGoods(goodsId);
        PageSupport pageSupport0 = new PageSupport();
        pageSupport0.setPageSize(5);
        pageSupport0.setTotalCount(goodsService.myCount(goods));
        pageSupport0.setCurrentPage(Integer.valueOf(pageIndex));
        PageSupport pageSupport = goodsService.getMyGoodsList(goods,pageSupport0);
        String json = JSON.toJSONString(pageSupport);
        return json;
    }
    @RequestMapping("/tousergoods.do")
    public String goodsLook(@RequestParam("id")String id,Model model){
        int goodsId = Integer.valueOf(id);
        Goods goods = goodsService.findGoodsById(goodsId);
        model.addAttribute("goods",goods);
        return "/user/usergoods";
    }
    @RequestMapping("/usergoodschange.do")
    public String goodsChange(@RequestParam("userId")String userId,Goods goods, @RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
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
        goodsService.updateGoods(goods);
        return "redirect:/touser.do?id="+userId;
    }
    @RequestMapping("/touserchange.do")
    public String toUserChange(@RequestParam("id")String id,Model model){
        int userId = Integer.valueOf(id);
        Users users = userService.findUsers(userId);
        model.addAttribute("users",users);
        return "/user/userchange";
    }
    @RequestMapping("/userchange.do")
    public String userChange(Users users){
        userService.changeUsers(users);
        int id = users.getId();
        return "redirect:/touser.do?id="+id;
    }
}
