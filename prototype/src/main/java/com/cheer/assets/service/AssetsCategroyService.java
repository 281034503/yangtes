package com.cheer.assets.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.cheer.assets.domain.AssetsCategroyEntity;
import com.cheer.assets.domain.AssetsCategroyEntityExample;
import com.cheer.assets.mapper.AssetsCategroyEntityMapper;

import net.frank.yangtes.commons.service.BaseService;
import net.frank.yangtes.modules.sys.utils.UserUtils;

@Service
public class AssetsCategroyService extends BaseService {
	@Autowired
	private AssetsCategroyEntityMapper assetsCategroyMapper;
	
	@Transactional
	public void save(AssetsCategroyEntity entity,AssetsCategroyEntity parent,String operatorId) {
		AssetsCategroyEntity _parent=null;
		if(parent!=null) {
			entity.setParentId(parent.getId());
			entity.setParentIds(parent.getParentIds()+parent.getId()+",");
			
		}else {
		      entity.setParentId("0");
		      entity.setParentIds("0,");
		}
		Date currentDate=new Date();
		if(StringUtils.isEmpty (entity.getId())) {
			
			entity.setId(UUID.randomUUID().toString().replaceAll("-",""));
			entity.setCreateDate(currentDate);
			entity.setCreateBy(operatorId);
			entity.setDelFlag("0");
			assetsCategroyMapper.insert(entity);
		}else {
			entity.setUpdateBy(operatorId);
			entity.setUpdateDate(currentDate);
			
			assetsCategroyMapper.updateByPrimaryKey(entity);
		}
	
       }
	public AssetsCategroyEntity get(String assetsCategroyId) {
		return assetsCategroyMapper.selectByPrimaryKey(assetsCategroyId);
	
	}
	
	public List<AssetsCategroyEntity>all(){
		AssetsCategroyEntityExample example=new AssetsCategroyEntityExample();
		return assetsCategroyMapper.selectByExample(example);
		
	}
	
	public AssetsCategroyEntity getDefaultParent(){
		AssetsCategroyEntityExample example=new AssetsCategroyEntityExample();	
		example.createCriteria().andParentIdEqualTo("0");
		List<AssetsCategroyEntity> rt=assetsCategroyMapper.selectByExample(example);
		if(rt!=null && !rt.isEmpty()) {
			return rt.get(0);

		}else {
			return null;
		}
	}
}