/**
 * 
 */
package com.jiogarden.business.util;

import com.jiogarden.model.ClientSpeak;
import com.jiogarden.service.ClientSpeakLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;

/**
 * @author vishal5.shah
 *
 */
public class ClientSpeakUtils {

	public static void permissionChecker(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = themeDisplay
				.getPermissionChecker();

		renderRequest.setAttribute("permissionCheck", (permissionChecker
				.isOmniadmin() || permissionChecker.isGroupAdmin(themeDisplay
				.getScopeGroupId())));
	}

	public static List<Integer> getPriorityNumbers(long clientSpeakId)
			throws SystemException {
		List<ClientSpeak> clientSpeaks = ClientSpeakLocalServiceUtil
				.getPrioritySpeaks();
		List<Integer> integers = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			integers.add(i);
		}
		for (ClientSpeak clientSpeak : clientSpeaks) {
			if ((clientSpeak.getPriority() > GetterUtil.DEFAULT_INTEGER)
					&& (clientSpeak.getClientSpeakId() != clientSpeakId)) {
				integers.remove(clientSpeak.getPriority());
			}
		}
		return integers;
	}

	public static void searchContainer(
			SearchContainer<ClientSpeak> searchContainer, String clientName,
			String clientDesignation) throws SystemException {
		DisplayTerms displayTerms = searchContainer.getDisplayTerms();
		int start = searchContainer.getStart();
		int end = searchContainer.getEnd();
		List<ClientSpeak> results = new ArrayList<>();
		int total = results.size();
		if (displayTerms.isAdvancedSearch()) {
			results = ClientSpeakLocalServiceUtil.getSearchClientSpeaks(
					clientName, clientDesignation,
					displayTerms.isAndOperator(), start, end);
			total = ClientSpeakLocalServiceUtil
					.getSearchClientSpeaksCount(clientName, clientDesignation,
							displayTerms.isAndOperator());
		} else {
			String keywords = displayTerms.getKeywords();
			results = ClientSpeakLocalServiceUtil.getSearchClientSpeaks(
					keywords, keywords, false, start, end);
			total = ClientSpeakLocalServiceUtil.getSearchClientSpeaksCount(
					keywords, keywords, false);
		}
		searchContainer.setResults(results);
		searchContainer.setTotal(total);
	}
}
