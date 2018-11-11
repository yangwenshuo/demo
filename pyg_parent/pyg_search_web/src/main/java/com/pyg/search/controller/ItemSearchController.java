package com.pyg.search.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pyg.search.service.ItemSearchService;

@RestController
@RequestMapping("/itemSearch")
public class ItemSearchController {

	@Reference
	private ItemSearchService searchService;
	
	@RequestMapping("/search")
	public Map search(@RequestBody Map searchMap){
		// yws:你要想在controller接收对象的话都要加一个requestbody
		return searchService.search(searchMap);
	}
}
