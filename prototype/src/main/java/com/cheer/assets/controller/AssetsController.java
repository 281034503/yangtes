package com.cheer.assets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.assets.domain.AssetsEntity;
import com.cheer.assets.model.AssetsForm;
import com.cheer.assets.pagination.PagingOutput;
import com.cheer.assets.service.AssetsService;

import net.frank.yangtes.commons.web.BaseController;
import net.frank.yangtes.modules.sys.utils.UserUtils;
@Controller
@RequestMapping(value="${adminPath}/assets")
public class AssetsController extends BaseController{
	
	@Autowired
	private AssetsService assetsService;
	
	@RequestMapping(value = {"list",""})
	public String list(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		if(form == null){
			form = new AssetsForm();
		}
		PagingOutput<AssetsEntity> output = assetsService.list(form);
		form.setPageInfo(output.getPageInfo());
		form.setList(output.getList());
		model.addAttribute("form", form);
		return "modules/assets/list";
	}

	@RequestMapping(value="form")
	public String form(@ModelAttribute AssetsForm form,Model model) {
		logger.debug("Input Param[from]->"+form);
		form.setEditor(new AssetsEntity());
		form.getEditor().setStatus("p");
		model.addAttribute("form",form);
		return "modules/assets/form";
	}
	
	@RequestMapping(value = "save")
	public String save(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		String operator = UserUtils.getUser().getId();
		assetsService.save(form.getEditor(), operator);
		return list(form,model);
	}
	
	@RequestMapping(value="mine")
	public String mine() {
		return "modules/assets/mine";
	}
	
}
	
