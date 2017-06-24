package com.jiogarden.business.service;

import com.jiogarden.model.ClientSpeak;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import javax.portlet.ActionRequest;

public interface ClientSpeakService {

	/**
	 * 
	 * Fetch the Client Speak details from action request
	 * 
	 * @param actionRequest
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	ClientSpeak getClientSpeakFromRequest(ActionRequest actionRequest)
			throws PortalException, SystemException;

	/**
	 * Fetch and Setup Client Speak priority
	 * 
	 * @param actionRequest
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	ClientSpeak getClientPrioritySpeakFromRequest(ActionRequest actionRequest)
			throws PortalException, SystemException;

	/**
	 * Delete Client Speak details
	 * 
	 * @param clientSpeakId
	 */
	void deleteClientSpeak(long clientSpeakId) throws PortalException,
			SystemException;

	/**
	 * 
	 * Change the status for visible or not (activate or deactivate)
	 * 
	 * @param clientSpeakId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	ClientSpeak setClientSpeakStatus(long clientSpeakId)
			throws PortalException, SystemException;
}
