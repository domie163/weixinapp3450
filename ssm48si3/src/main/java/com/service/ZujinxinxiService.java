package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZujinxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZujinxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZujinxinxiView;


/**
 * 租金信息
 *
 * @author 
 * @email 
 * @date 2021-04-09 22:16:50
 */
public interface ZujinxinxiService extends IService<ZujinxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZujinxinxiVO> selectListVO(Wrapper<ZujinxinxiEntity> wrapper);
   	
   	ZujinxinxiVO selectVO(@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);
   	
   	List<ZujinxinxiView> selectListView(Wrapper<ZujinxinxiEntity> wrapper);
   	
   	ZujinxinxiView selectView(@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZujinxinxiEntity> wrapper);
   	
}

