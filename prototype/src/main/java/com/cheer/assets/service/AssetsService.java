package com.cheer.assets.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.domain.AssetsEntityExample;
import com.cheer.assets.mapper.AssetsCategroyEntityMapper;
import com.cheer.assets.mapper.AssetsEntityMapper;
import com.cheer.assets.model.AssetsForm;
import com.cheer.assets.model.CategroyCnt;
import com.cheer.assets.pagination.PaginationCallback;
import com.cheer.assets.pagination.PaginationUtil;
import com.cheer.assets.pagination.PagingOutput;
import net.frank.yangtes.commons.service.BaseService;


@Service
public class AssetsService extends BaseService {
	
	@Autowired
	private AssetsEntityMapper assetsMapper;

	@Autowired
	private AssetsCategroyEntityMapper assetsCategroyMapper;
	
	public void viewMaintain(){
		
	}
	
	public void userHistory(){
		logger.info("AssetsService.userHistory() triggered!");
	}
	
	public void deprecition(){
		
	}
	

public PagingOutput<AssetsEntity> list(AssetsForm form) {
	return PaginationUtil.processPaging(form, new PaginationCallback<AssetsEntity>() {
		@Override
		public List<AssetsEntity> doProcess() {
			AssetsEntityExample example = new AssetsEntityExample();
			example.createCriteria().andDelFlagEqualTo("0");
			return assetsMapper.selectByExample(example);
		}
	});
}

@Transactional
public void save(AssetsEntity entity,String operator){
	Date current = new Date();
	CategroyCnt cntInfo = assetsCategroyMapper.preparePreCnt(entity.getCategoryId());
	logger.debug("Varible [cntInfo] -> " + cntInfo);
	//K-PC-0000001
	String bnsId = "K-" + cntInfo.getBnsPre() + "-" +   StringUtils.leftPad(( (cntInfo.getCnt()+1) + ""), 7, "0");
	logger.debug("Varible [bnsId] -> " + bnsId);
	entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
	entity.setBnsId(bnsId);
	entity.setCreateBy(operator);
	entity.setCreateDate(current);
	entity.setDelFlag("0");
	assetsMapper.insert(entity);
}

	
	
}
