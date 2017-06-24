package com.jiogarden.portlet;

import com.jiogarden.business.service.ClientSpeakService;
import com.jiogarden.business.service.ValidationService;
import com.jiogarden.business.service.impl.ClientSpeakServiceImpl;
import com.jiogarden.business.service.impl.ValidationServiceImpl;
import com.jiogarden.business.util.ClientSpeakUtils;
import com.jiogarden.log.Logger;
import com.jiogarden.model.ClientSpeak;
import com.jiogarden.service.ClientSpeakLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class ClientSpeakPortlet
 */
public class ClientSpeakPortlet extends MVCPortlet {

	Logger logger = Logger.getInstance();
	ClientSpeakService clientSpeakService = new ClientSpeakServiceImpl();
	ValidationService validationService = new ValidationServiceImpl();

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		ClientSpeakUtils.permissionChecker(renderRequest);

		this.include(viewTemplate, renderRequest, renderResponse);
	}

	public void saveOrUpdateClientSpeak(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		ClientSpeak clientSpeak = clientSpeakService
				.getClientSpeakFromRequest(actionRequest);
		List<String> errors = new ArrayList<>();
		if (validationService.validateClientSpeak(clientSpeak, errors)) {
			if (Validator.isNotNull(clientSpeak.getClientSpeakId())) {
				// update
				ClientSpeakLocalServiceUtil.updateClientSpeak(clientSpeak);
				SessionMessages.add(actionRequest, "clientspeak-updated");
				logger.info(getClass(), "Client Speak updated");
			} else {
				// add
				ClientSpeakLocalServiceUtil.addClientSpeak(clientSpeak);
				SessionMessages.add(actionRequest, "clientspeak-added");
				logger.info(getClass(), "Client Speak added");
			}
			sendRedirect(actionRequest, actionResponse);
		} else {
			for (String error : errors) {
				SessionErrors.add(actionRequest, error);
			}
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			actionResponse.setRenderParameter("jspPage",
					"/html/clientspeak/edit_clientspeak.jsp");
		}

	}

	public void saveOrUpdateClientSpeakPriority(ActionRequest actionRequest,
			ActionResponse actionResponse) throws PortalException,
			SystemException, IOException {
		ClientSpeak clientSpeak = clientSpeakService
				.getClientPrioritySpeakFromRequest(actionRequest);
		SessionMessages.add(actionRequest, "clientspeak-priority-setup",
				new String[] { String.valueOf(clientSpeak.getPriority()) });
		logger.info(getClass(), "Client Speak priority setup");
	}

	public void deleteClientSpeak(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		long clientSpeakId = ParamUtil.getLong(actionRequest, "clientSpeakId");
		if (Validator.isNotNull(clientSpeakId)) {
			// success
			clientSpeakService.deleteClientSpeak(clientSpeakId);
			SessionMessages.add(actionRequest, "clientspeak-deleted");
			logger.info(getClass(), "Client Speak deleted");
			sendRedirect(actionRequest, actionResponse);
		} else {
			// error
			SessionErrors.add(actionRequest, "clientspeak-deleted-error");
			logger.info(getClass(), "Error comes while client speak deleting");
		}
	}

	public void statusClientSpeak(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		long clientSpeakId = ParamUtil.getLong(actionRequest, "clientSpeakId");
		if (Validator.isNotNull(clientSpeakId)) {
			// success
			ClientSpeak clientSpeak = clientSpeakService
					.setClientSpeakStatus(clientSpeakId);
			if (clientSpeak.isActive_()) {
				SessionMessages.add(actionRequest, "clientspeak-activated");
			} else {
				SessionMessages.add(actionRequest, "clientspeak-deactivated");
			}
			logger.info(getClass(), "Client speak status changed");
			sendRedirect(actionRequest, actionResponse);
		} else {
			// error
			logger.info(getClass(),
					"Error comes while client speak status changed");
			SessionErrors.add(actionRequest, "clientspeak-active-error");
		}
	}

}
