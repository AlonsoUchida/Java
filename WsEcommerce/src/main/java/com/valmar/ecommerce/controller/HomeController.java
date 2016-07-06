package com.valmar.ecommerce.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// Put your Google API Server Key here
	private static final String GOOGLE_SERVER_KEY = "AIzaSyBu-nIwLrzUArpMOIV1F3m6DsFo92MMkT8";
	static final String MESSAGE_KEY = "message";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public String notification(Locale locale, Model model) {

		return "notification";
	}	
	
	private static String REG_ID_VALUE = "";
	
	@RequestMapping(value = "/GCMNotification", method = RequestMethod.POST)
	public String notification(HttpServletRequest request, HttpServletResponse response) {

		Result result = null;

		String share = request.getParameter("shareRegId");

		// GCM RedgId of Android device to send push notification
		String regId = "";

		if (share != null && !share.isEmpty()) {
			REG_ID_VALUE = request.getParameter("regId");
			request.setAttribute("pushStatus", "GCM RegId Received.");
		} else {
			try {
				String userMessage = request.getParameter("message");
				Sender sender = new Sender(GOOGLE_SERVER_KEY);
				Message message = new Message.Builder().timeToLive(30).delayWhileIdle(true)
						.addData(MESSAGE_KEY, userMessage).build();
				System.out.println("regId: " + REG_ID_VALUE);
				result = sender.send(message, REG_ID_VALUE, 1);
				request.setAttribute("pushStatus", result.toString());
			} catch (IOException ioe) {
				ioe.printStackTrace();
				request.setAttribute("pushStatus", "RegId required: " + ioe.toString());
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("pushStatus", e.toString());
			}
		}
		return "notification";

	}

}
