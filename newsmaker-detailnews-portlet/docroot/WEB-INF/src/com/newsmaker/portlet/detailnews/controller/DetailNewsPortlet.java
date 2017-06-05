package com.newsmaker.portlet.detailnews.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.PortletActionInvoker;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.newsmaker.portlet.detailnews.helper.DetailNewsHelper;

/**
 * Portlet implementation class DetailNewsPortlet
 */
public class DetailNewsPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(DetailNewsPortlet.class);
 
	public void render (RenderRequest request,RenderResponse response) throws PortletException, IOException{
	
	DetailNewsHelper.detailNewsHelper(request, response);
	super.render(request, response);
	}
	
	
	 @ProcessAction(name = "addDiscussion")  
	   public void addDiscussion(ActionRequest actionRequest,ActionResponse actionResponse){  
	     try {  
	       PortletActionInvoker.processAction("com.liferay.portlet.messageboards.action.EditDiscussionAction", null, actionRequest, actionResponse);  
	     } catch (Exception e) {  
	    	 LOGGER.error("Exception Occured:"+e.getMessage());
	     }  
	   } 

}
