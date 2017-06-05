package com.jio.hook.portlet;

import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;


public class CustomLoginAction extends BaseStrutsPortletAction  {
	
	/** Serve Resource used for getting captcha
	*
	*/
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
          throws  IOException, PortletException {

          try {
                CaptchaUtil.serveImage(resourceRequest, resourceResponse);
          }
          catch (Exception e) {
                //_log.error(e);
          }
    }

		
	public void processAction(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {
		try{
			CaptchaUtil.check(actionRequest);
			originalStrutsPortletAction.processAction(portletConfig, actionRequest, actionResponse);

		}catch(CaptchaTextException e){
			SessionErrors.add(actionRequest, e.getClass(),e);
		}
		
		catch(CaptchaMaxChallengesException e){
			SessionErrors.add(actionRequest, e.getClass(),e);
		}
				
		
	}

	
	    
	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return originalStrutsPortletAction.render(portletConfig, renderRequest,
				renderResponse);
	}


	
	
	
}