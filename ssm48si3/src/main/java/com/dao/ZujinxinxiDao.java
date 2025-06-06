package com.dao;

import com.entity.ZujinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZujinxinxiVO;
import com.entity.view.ZujinxinxiView;


/**
 * 租金信息
 * 
 * @author 
 * @email 
 * @date 2021-04-09 22:16:50
 */
public interface ZujinxinxiDao extends BaseMapper<ZujinxinxiEntity> {
	
	List<ZujinxinxiVO> selectListVO(@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);
	
	ZujinxinxiVO selectVO(@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);
	
	List<ZujinxinxiView> selectListView(@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);

	List<ZujinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);
	
	ZujinxinxiView selectView(@Param("ew") Wrapper<ZujinxinxiEntity> wrapper);
	
}
