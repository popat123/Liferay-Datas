package com.lep.search.handler;

import com.lep.search.helper.LepSearchHelper;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class LepSearchPortlet extends MVCPortlet {

	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		LepSearchHelper.getJournalSearchResults(request,response);
		
		super.render(request, response);
	}
}
