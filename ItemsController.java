package com.itheima.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.pojo.Items;
import com.itheima.pojo.QueryVo;
import com.itheima.service.ItemsService;

@Controller
public class ItemsController {
	@Autowired
	private ItemsService itemsService;

	@RequestMapping(value = "/list.action")
	public String list(String mingcheng, String detail, Model model) {
		QueryVo queryVo = new QueryVo();
		if (null != mingcheng) {
			queryVo.setName(mingcheng);
			model.addAttribute("mingcheng", mingcheng);
		}
		if (null != detail) {
			queryVo.setDetail(detail);
			model.addAttribute("detail", detail);
		}
		List<Items> itemList = itemsService.findItemsByQueryVo(queryVo);
		model.addAttribute("itemList", itemList);
		return "itemList";
	}

}
