package com.pyg.page.service;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface ItemPageService {
	public boolean createItemHtml(Long goodsId) throws IOException, TemplateException;

    boolean removeItemHtml(Long[] goodsId);
}
