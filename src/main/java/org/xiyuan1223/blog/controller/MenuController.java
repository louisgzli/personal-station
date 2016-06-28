package org.xiyuan1223.blog.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xiyuan1223.blog.node.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * �˵�������
 * 
 * @author wang.sheng
 * 
 */
@RestController
@RequestMapping("/menu")
public class MenuController
{
	Log log = LogFactory.getLog(getClass());

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Node[] load(@PathVariable String id)
	{
		log.info("load node: " + id);
		Node node1 = new Node();
		node1.setId("node1");
		node1.setText("����ҳ��");
		node1.setParentId(id);
		node1.setLeaf(true);
		Node node2 = new Node();
		node2.setId("node2");
		node2.setText("�ٶ�");
		node2.setHref("http://www.baidu.com");
		node2.setHrefTarget("_blank");
		node2.setLeaf(true);
		node2.setParentId(id);
		return new Node[] { node1, node2 };
	}
}
