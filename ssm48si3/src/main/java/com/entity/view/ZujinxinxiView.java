package com.entity.view;

import com.entity.ZujinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 租金信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-09 22:16:50
 */
@TableName("zujinxinxi")
public class ZujinxinxiView  extends ZujinxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZujinxinxiView(){
	}
 
 	public ZujinxinxiView(ZujinxinxiEntity zujinxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, zujinxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
