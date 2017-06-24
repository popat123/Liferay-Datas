package com.jiogarden.business.service.impl;

import com.jiogarden.business.service.ClientSpeakService;
import com.jiogarden.business.service.UploadService;
import com.jiogarden.model.ClientSpeak;
import com.jiogarden.service.ClientSpeakLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

import javax.portlet.ActionRequest;

public class ClientSpeakServiceImpl implements ClientSpeakService {

	private static final String FOLDER_NAME = "Client Speak";
	private static final String FOLDER_DESCRIPTION = "Client Speak Images";

	UploadService uploadService = new UploadServiceImpl();

	@Override
	public ClientSpeak getClientSpeakFromRequest(ActionRequest actionRequest)
			throws PortalException, SystemException {

		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		ClientSpeak clientSpeak = ClientSpeakLocalServiceUtil
				.createClientSpeak(GetterUtil.DEFAULT_LONG);
		long clientSpeakId = ParamUtil.getLong(uploadRequest, "clientSpeakId");
		if (Validator.isNotNull(clientSpeakId) && clientSpeakId > 0) {
			clientSpeak = ClientSpeakLocalServiceUtil
					.getClientSpeak(clientSpeakId);
		}
		clientSpeak.setClientName(ParamUtil.getString(uploadRequest,
				"clientName"));
		clientSpeak.setClientDesignation(ParamUtil.getString(uploadRequest,
				"clientDesignation"));
		clientSpeak.setClientSpeak(ParamUtil.getString(uploadRequest,
				"clientSpeak"));
		clientSpeak.setUserId(PortalUtil.getUserId(uploadRequest));
		clientSpeak.setCompanyId(PortalUtil.getCompanyId(uploadRequest));
		clientSpeak.setGroupId(PortalUtil.getScopeGroupId(uploadRequest));

		// Upload Document - in Document Library
		String description = new StringBundler()
				.append(clientSpeak.getClientName()).append(StringPool.SPACE)
				.append("Image").toString();

		long fileEntryId = uploadService.getFileEntryId(actionRequest,
				uploadRequest, "clientImage", description,
				clientSpeak.getClientImage(), FOLDER_NAME, FOLDER_DESCRIPTION);

		if (fileEntryId != GetterUtil.DEFAULT_LONG) {
			clientSpeak.setClientImage(fileEntryId);
		}
		return clientSpeak;
	}

	@Override
	public ClientSpeak getClientPrioritySpeakFromRequest(
			ActionRequest actionRequest) throws PortalException,
			SystemException {
		long clientSpeakId = ParamUtil.getLong(actionRequest, "clientSpeakId");
		int priority = ParamUtil.getInteger(actionRequest, "priority");
		ClientSpeak clientSpeak = ClientSpeakLocalServiceUtil
				.getClientSpeak(clientSpeakId);
		clientSpeak.setPriority(priority);
		clientSpeak = ClientSpeakLocalServiceUtil
				.updateClientSpeak(clientSpeak);
		return clientSpeak;
	}

	@Override
	public void deleteClientSpeak(long clientSpeakId) throws PortalException,
			SystemException {
		ClientSpeak clientSpeak = ClientSpeakLocalServiceUtil
				.deleteClientSpeak(clientSpeakId);
		if (Validator.isNotNull(clientSpeak.getClientImage())) {
			DLAppLocalServiceUtil.deleteFileEntry(clientSpeak.getClientImage());
		}
	}

	@Override
	public ClientSpeak setClientSpeakStatus(long clientSpeakId)
			throws PortalException, SystemException {
		ClientSpeak clientSpeak = ClientSpeakLocalServiceUtil
				.getClientSpeak(clientSpeakId);
		boolean status = clientSpeak.isActive_();
		if (!status) {
			clientSpeak.setPriority(0);
		}
		clientSpeak.setActive_(!status);
		clientSpeak = ClientSpeakLocalServiceUtil
				.updateClientSpeak(clientSpeak);
		return clientSpeak;
	}

}
