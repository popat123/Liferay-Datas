package com.trinet.CalendarEvent;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class CalendarEvent
 */
public class CalendarEvent extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(CalendarEvent.class);
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		LOGGER.info("===================Fetching Preferences===================");
		/*PortletPreferences prefs= renderRequest.getPreferences();
		String status = prefs.getValue("STATUS", "");
		LOGGER.info("Prefernce Value::>"+status);
		renderRequest.setAttribute("statusPreference",status);
		Locale locale=null;*/
		ThemeDisplay themeDisplay= (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		ClassLoader classLoader = (ClassLoader)PortletBeanLocatorUtil.locate("calendar-portlet","portletClassLoader");
		
		DynamicQuery calendarBookingQuery = DynamicQueryFactoryUtil.forClass(CalendarBooking.class,classLoader);
		
		
		LOGGER.info("Scope GroupId==="+themeDisplay.getScopeGroupId());
		Criterion criterionGroupId = RestrictionsFactoryUtil.eq("groupId",themeDisplay.getScopeGroupId());
		LOGGER.info("criterionGroupId==="+criterionGroupId);
		calendarBookingQuery.add(criterionGroupId);
		StringBuffer jsonString = this.getJsonString(calendarBookingQuery);
		renderRequest.setAttribute("events", jsonString);
		
		
		/*if(status.equals(LanguageUtil.get(locale, "everything")))
		{
			
			try {
				List<Group> userSites = themeDisplay.getUser().getSiteGroups();
				Long groupId = themeDisplay.getLayout().getGroupId();
				
				
				LOGGER.info("groupid===="+groupId);
				List<Long> userSiteIds = new ArrayList<Long>();
				for(Group site : userSites){
					userSiteIds.add(site.getGroupId());
					LOGGER.info("userSiteIds is ====>>>>"+userSiteIds);
				}
				userSiteIds.add(groupId);
				//Criterion criterionGroupId = RestrictionsFactoryUtil.in("groupId", userSiteIds);
				Criterion criterionGroupId = RestrictionsFactoryUtil.in("groupId", userSiteIds);
				LOGGER.info("criterionGroupId==="+criterionGroupId);
				calendarBookingQuery.add(criterionGroupId);
				StringBuffer jsonString = this.getJsonString(calendarBookingQuery);
				LOGGER.info("jsonString Rajni===="+jsonString);
				renderRequest.setAttribute("events", jsonString);
				
			} catch (SystemException e) {
				LOGGER.info("System Exception Occured"+e);
				
			} catch (PortalException e) {
				LOGGER.info("Portal Exception Occured"+e);
			
			}

			
		}
		else if(status.equals(LanguageUtil.get(locale, "currentSite")))
		{
			LOGGER.info("Scope GroupId==="+themeDisplay.getScopeGroupId());
			Criterion criterionGroupId = RestrictionsFactoryUtil.eq("groupId",themeDisplay.getScopeGroupId());
			LOGGER.info("criterionGroupId==="+criterionGroupId);
			calendarBookingQuery.add(criterionGroupId);
			StringBuffer jsonString = this.getJsonString(calendarBookingQuery);
			renderRequest.setAttribute("events", jsonString);
		}
		else{
	//		StringBuffer jsonString = this.getJsonString(calendarBookingQuery);
			LOGGER.info("===== Not Getting Events ====");
			renderRequest.setAttribute("events", "{}");
		}*/
		
		super.doView(renderRequest, renderResponse);
	}
	
	/*@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		PortletPreferences prefs= renderRequest.getPreferences();
		String status = prefs.getValue("STATUS", "");
		LOGGER.info("Prefernce Value::>"+status);
		renderRequest.setAttribute("statusPreference",status);
		super.doEdit(renderRequest, renderResponse);
	}*/
	
	private StringBuffer getJsonString(DynamicQuery bookingQuery){
		
		StringBuffer jsonString = new StringBuffer();
		
		try {	
			
			List<CalendarBooking> calendarBookingList = CalendarBookingLocalServiceUtil.dynamicQuery(bookingQuery);
			
			LOGGER.info("Calendar Bookking Events List ::>"+calendarBookingList);
			LOGGER.info("Event count is "+ calendarBookingList.size());
			
			jsonString.append(StringPool.OPEN_CURLY_BRACE);
			if(calendarBookingList.size()>0)
			{
				Calendar startCal = Calendar.getInstance();
				Calendar endCal = Calendar.getInstance();
				
				LOGGER.info("Start Cal"+startCal);
				LOGGER.info("End Cal"+endCal);
				Map<String,String> map = new HashMap<String,String>(); 
				String key =null;
				String value = null;
				for(CalendarBooking calendarBooking : calendarBookingList)
				{
				  if(calendarBooking.getStatus()!=8){
					 startCal.setTimeInMillis(calendarBooking.getStartTime());
					 endCal.setTimeInMillis(calendarBooking.getEndTime());
					 LOGGER.info("date is :"+calendarBooking.getStatusDate());
					
					
					 String timeString="";
					 String timeString1="";
					 int hour = startCal.get(Calendar.HOUR_OF_DAY);
					 int ehour = endCal.get(Calendar.HOUR_OF_DAY);
					 LOGGER.info("hour"+hour);
					 if (hour == 0) {
					     timeString =  "AM ";  
					 } else if (hour < 12) {
					     timeString = "AM";
					 } else if (hour == 12) {
					     timeString = "PM";
					 } else {
					   hour = hour - 12;
					     timeString = "PM";
					 }
					 if (ehour == 0) {
                       timeString1 =  "AM";  
                   } else if (ehour < 12) {
                       timeString1 = "AM";
                   } else if (ehour == 12) {
                       timeString1 = "PM";
                   } else {
                       ehour = ehour - 12;
                       timeString1 = "PM";
                   }
					 
					 LOGGER.info("timestring"+timeString);
					 LOGGER.info("Start date is "+ startCal.get(Calendar.DAY_OF_MONTH) +"/" + startCal.get(Calendar.MONTH) +"/" + startCal.get(Calendar.YEAR));
					 LOGGER.info("End date is "+ endCal.get(Calendar.DAY_OF_MONTH) +"/" + endCal.get(Calendar.MONTH) +"/" + endCal.get(Calendar.YEAR));
					 LOGGER.info("Start Time is:"+startCal.get(Calendar.HOUR_OF_DAY)+":"+ startCal.get(Calendar.MINUTE)+ " " +startCal.get(Calendar.AM_PM));
					 LOGGER.info("End Time is:"+endCal.get(Calendar.HOUR_OF_DAY)+ ":" +endCal.get(Calendar.MINUTE) +" "+ endCal.get(Calendar.AM_PM));
					 
					 while (!startCal.after(endCal)) {
						 LOGGER.info("Event is added for Date "+ startCal.get(Calendar.DAY_OF_MONTH) +"/" + startCal.get(Calendar.MONTH) +"/" + startCal.get(Calendar.YEAR));	 
						 key = getFormatedDate(startCal);
						 value = map.get(key);
						 
						 if(null == value) {
						     LOGGER.info("\nVALUE is null");
							 value = calendarBooking.getTitle(Locale.ENGLISH) +" " + hour+":"+ startCal.get(Calendar.MINUTE)+ " " +timeString +"-"+ehour+ ":" +endCal.get(Calendar.MINUTE) +" "+ timeString1;
						 }
						 else {
							 value = value +"<br>"+calendarBooking.getTitle(Locale.ENGLISH) +" " + hour+":"+ startCal.get(Calendar.MINUTE)+ " " +timeString +"-"+ehour+ ":" +endCal.get(Calendar.MINUTE) +" "+ timeString1;
						 }
					 map.put(key, value);
						 startCal.add(Calendar.DATE, 1);
					 }
				}
				}
				Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
				while(iterator.hasNext()){					   
					Map.Entry<String, String> entry = iterator.next();
			        jsonString.append(StringPool.QUOTE + entry.getKey() + StringPool.QUOTE);
			        jsonString.append(StringPool.COLON);			        
			        jsonString.append(StringPool.OPEN_BRACKET);
			        jsonString.append(StringPool.QUOTE+ "<span>" + entry.getValue() + "</span>" +StringPool.QUOTE);
			        jsonString.append(StringPool.CLOSE_BRACKET);
			        if(iterator.hasNext())
			        {
			        	jsonString.append(StringPool.COMMA);
			        }
				}
			}
			jsonString.append(StringPool.CLOSE_CURLY_BRACE);

			LOGGER.info("Json string is "+ jsonString.toString());
			
			

			
		} catch (SystemException e) {
			LOGGER.info("Error ::> "+e);
		}
		return jsonString;
	}
		
	
	
	private String getFormatedDate(Calendar calendar) {
		
		Date date = new Date(calendar.getTimeInMillis());
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		String dateFormatted = dateFormat.format(date);
		return (dateFormatted);
	}
		
	 /*public void addPrefernce(ActionRequest request, ActionResponse response) throws ValidatorException, IOException, ReadOnlyException, PortletModeException
		{
			 String status = request.getParameter("statusPreference");
				PortletPreferences prefs=request.getPreferences();
				prefs.setValue("STATUS", status);	
				prefs.store();
				response.setPortletMode(PortletMode.VIEW);
				SessionMessages.add(request, "calendarPreferences-added-successfully");
				sendRedirect(request, response);
		 }*/
}