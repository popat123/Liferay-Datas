package com.newsmaker.portlet.news.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.PortletActionInvoker;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.newsmaker.portlet.news.helper.NewsHelper;

/**
 * Portlet implementation class NewsPortlet
 */
public class NewsPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(NewsPortlet.class);
	public void render(RenderRequest request,RenderResponse response) throws PortletException, IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		NewsHelper.getNews(request, response, themeDisplay);
		super.render(request, response);
	}
	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
	  	super.doEdit(renderRequest, renderResponse);
	}
	
	 public void addPreference(ActionRequest request, ActionResponse response) throws IOException, PortalException, SystemException, PortletException
	  {
	   
		 String structureId = request.getParameter("structureId");
		 
	      PortletPreferences prefs=request.getPreferences();
	      prefs.setValue("structureId", structureId);
	      prefs.store();
	      response.setPortletMode(PortletMode.VIEW);
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
