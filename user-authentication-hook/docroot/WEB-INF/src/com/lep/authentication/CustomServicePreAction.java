package com.lep.authentication;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomServicePreAction extends Action{

	private static final Log LOGGER = LogFactoryUtil.getLog(CustomServicePreAction.class);
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		ThemeDisplay themeDisplay = null;
		long accessDeniedPlid = 0;
		boolean hasRole = false;
		
		try {
			themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			hasRole = RoleServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PropsUtil.get("lep.user.role"), true);
			accessDeniedPlid = getAccessDeniedPlid(themeDisplay);
			/*String logoutPageUrl = "/c/portal/logout";
			System.out.println("url signout:"+themeDisplay.getURLSignOut());
			System.out.println("url current:"+themeDisplay.getURLCurrent());
			System.out.println("logout.url:"+PropsUtil.get("logout.url"));*/
			
			if(themeDisplay.isSignedIn() 
					&& !hasRole
					&& accessDeniedPlid != themeDisplay.getPlid()
					&& !themeDisplay.getPermissionChecker().isOmniadmin()
					&& !PropsUtil.get("logout.url").equals(themeDisplay.getURLCurrent())){
				response.sendRedirect(themeDisplay.getPortalURL()+"/web/guest"+PropsUtil.get("access.denied.page"));
				
			}
		
		} catch (Exception e) {
			LOGGER.error("Exception in CustomServicePreAction.run() :"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private long getAccessDeniedPlid(ThemeDisplay themeDisplay){
		long accessDeniedPlid = 0;
		Layout accessDeniedLayout = null;
		try {
			accessDeniedLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(themeDisplay.getScopeGroupId(), false, PropsUtil.get("access.denied.page"));
			if(accessDeniedLayout != null){
				accessDeniedPlid = accessDeniedLayout.getPlid();
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return accessDeniedPlid;
	}

}
