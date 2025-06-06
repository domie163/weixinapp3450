package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZujinxinxiEntity;
import com.entity.view.ZujinxinxiView;

import com.service.ZujinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 租金信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-09 22:16:50
 */
@RestController
@RequestMapping("/zujinxinxi")
public class ZujinxinxiController {
    @Autowired
    private ZujinxinxiService zujinxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZujinxinxiEntity zujinxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuke")) {
			zujinxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			zujinxinxi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZujinxinxiEntity> ew = new EntityWrapper<ZujinxinxiEntity>();
		PageUtils page = zujinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zujinxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZujinxinxiEntity zujinxinxi, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuke")) {
			zujinxinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			zujinxinxi.setFangdongzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZujinxinxiEntity> ew = new EntityWrapper<ZujinxinxiEntity>();
		PageUtils page = zujinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zujinxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZujinxinxiEntity zujinxinxi){
       	EntityWrapper<ZujinxinxiEntity> ew = new EntityWrapper<ZujinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zujinxinxi, "zujinxinxi")); 
        return R.ok().put("data", zujinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZujinxinxiEntity zujinxinxi){
        EntityWrapper< ZujinxinxiEntity> ew = new EntityWrapper< ZujinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zujinxinxi, "zujinxinxi")); 
		ZujinxinxiView zujinxinxiView =  zujinxinxiService.selectView(ew);
		return R.ok("查询租金信息成功").put("data", zujinxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZujinxinxiEntity zujinxinxi = zujinxinxiService.selectById(id);
        return R.ok().put("data", zujinxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZujinxinxiEntity zujinxinxi = zujinxinxiService.selectById(id);
        return R.ok().put("data", zujinxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZujinxinxiEntity zujinxinxi, HttpServletRequest request){
    	zujinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zujinxinxi);

        zujinxinxiService.insert(zujinxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZujinxinxiEntity zujinxinxi, HttpServletRequest request){
    	zujinxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zujinxinxi);
    	zujinxinxi.setUserid((Long)request.getSession().getAttribute("userId"));

        zujinxinxiService.insert(zujinxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ZujinxinxiEntity zujinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zujinxinxi);
        zujinxinxiService.updateById(zujinxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zujinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ZujinxinxiEntity> wrapper = new EntityWrapper<ZujinxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("zuke")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("fangdong")) {
			wrapper.eq("fangdongzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = zujinxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
