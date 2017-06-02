package com.newsmaker.service.events;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class NewsMakerServicePreAction extends Action {
	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#Action()
	 */
	public NewsMakerServicePreAction() {
		super();
	}

	/* (non-Java-doc)
	 * @see com.liferay.portal.kernel.events.Action#run(HttpServletRequest arg0, HttpServletResponse arg1)
	 */
	public void run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ActionException {
		if(BrowserSnifferUtil.isIe(httpServletRequest) && httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY)!=null){
			ThemeDisplay themeDisplay = (ThemeDisplay)httpServletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			if(!themeDisplay.isSignedIn()){
				try {
					httpServletResponse.sendRedirect(themeDisplay.getURLSignIn());
				} catch (IOException e) {
					LOGGER.error("No Login URL",e);
				}
			}
		}
		
	}

	private static Log LOGGER = LogFactoryUtil.getLog(NewsMakerServicePreAction.class);
}