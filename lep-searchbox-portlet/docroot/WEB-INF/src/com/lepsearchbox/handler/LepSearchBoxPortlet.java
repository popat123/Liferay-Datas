package com.lepsearchbox.handler;

import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;

public class LepSearchBoxPortlet extends MVCPortlet {

	public void searchSite(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		String keyword = ParamUtil.getString(actionRequest, "keyword");

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = themeDisplay.getPlid();
		String portletId = "lepsearch_WAR_lepsearchportlet";

		LiferayPortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, portletId, plid , PortletRequest.RENDER_PHASE);
		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setParameter("keywords", keyword);

		
		actionResponse.sendRedirect(portletURL.toString());

	}
}
