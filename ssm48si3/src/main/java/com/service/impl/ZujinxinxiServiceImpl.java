package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZujinxinxiDao;
import com.entity.ZujinxinxiEntity;
import com.service.ZujinxinxiService;
import com.entity.vo.ZujinxinxiVO;
import com.entity.view.ZujinxinxiView;

@Service("zujinxinxiService")
public class ZujinxinxiServiceImpl extends ServiceImpl<ZujinxinxiDao, ZujinxinxiEntity> implements ZujinxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZujinxinxiEntity> page = this.selectPage(
                new Query<ZujinxinxiEntity>(params).getPage(),
                new EntityWrapper<ZujinxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZujinxinxiEntity> wrapper) {
		  Page<ZujinxinxiView> page =new Query<ZujinxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZujinxinxiVO> selectListVO(Wrapper<ZujinxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZujinxinxiVO selectVO(Wrapper<ZujinxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZujinxinxiView> selectListView(Wrapper<ZujinxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZujinxinxiView selectView(Wrapper<ZujinxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
