package com.lepuserprofile.handler;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserConstants;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class LEPUserProfile extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String jobTitle = ParamUtil.getString(actionRequest, "jobTitle");
		String bioData = ParamUtil.getString(actionRequest, "bioData");
		
		try {
			User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setJobTitle(jobTitle);
			
			UserLocalServiceUtil.updateUser(user);
			
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		super.processAction(actionRequest, actionResponse);
	}
	
	@Override
	public void render(RenderRequest renderReq, RenderResponse renderRes)
			throws PortletException, IOException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderReq
				.getAttribute(WebKeys.THEME_DISPLAY);

		long groupId = themeDisplay.getScopeGroupId();
				
		
		User user;
		try {
			user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
			renderReq.setAttribute("ImagePath", UserConstants.getPortraitURL(themeDisplay.getPathImage(), user.isMale(), user.getPortraitId()));
			renderReq.setAttribute("lepUser", user);
			
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		super.render(renderReq, renderRes);
	}
}
