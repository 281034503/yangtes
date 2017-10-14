package com.cheer.assets.servise;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.assets.domain.AssetsCategroyEntity;
import com.cheer.assets.service.AssetsCategroyService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:spring/spring-context.xml")
		})

public class AssetsCategroyServiceTester {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AssetsCategroyService service;
	
	@Test
	public void init(){
		
			AssetsCategroyEntity item = new AssetsCategroyEntity();
			item.setName("����Ʒ��");
			item.setBnsPre("ABS");
			service.save(item, null, "1");
		
			AssetsCategroyEntity item0 = new AssetsCategroyEntity();
			item0.setName("�칫�Ҿ�");
			item0.setBnsPre("JG");
			
			service.save(item0, item, "1");
		
			AssetsCategroyEntity item1 = new AssetsCategroyEntity();
			item1.setName("��");
			item1.setBnsPre("DK");
			service.save(item1, item0, "1");
		
			AssetsCategroyEntity item2 = new AssetsCategroyEntity();
			item2.setName("��");
			item2.setBnsPre("CR");
			service.save(item2, item0, "1");
		
	}
	
	@Test
	public void testAll(){
		List<AssetsCategroyEntity> all = service.all();
		log.info("Varible [all] -> " + all);
	}
}
