package com.tools.constants;

import java.io.File;

import com.tools.persistance.MongoReader;

/**
 * Need to make soap and environment always point to the same environment.
 * Issues might arise.
 * 
 * @author voicu.vac
 *
 */
public class UrlConstants {
	
//	public static final String RESOURCES_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "staging-aut" + File.separator;
	public static String RESOURCES_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + MongoReader.getEnvironment() + File.separator + MongoReader.getContext() + File.separator;
	public static String CONTEXT_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "context" + File.separator;
	public static String ENV_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + MongoReader.getEnvironment() + File.separator;
	public static String RESOURCES = "resources" + File.separator;

	//Staging AUT uRLs 

	public static final String YOPMAIL_WEB_MAIL = "http://yopmail.com/";
	public static final String YOPMAIL_IMBOX_SUFFIX = "";
	public static final String MAILINATOR_WEB_MAIL = "http://mailinator.com/";
	public static final String MAILINATOR_IMBOX_SUFFIX = "inbox2.jsp?public_to=";
	
	public static final String FMG_WEB_MAIL = "http://www.fakemailgenerator.com/";
	public static final String FMG_WEB_MAIL_INBOX_SUFFIX = "inbox/";
	//public static final String FMG_WEB_MAIL_DOMAIN = "rhyta.com/";
	public static final String FMG_WEB_MAIL_DOMAIN = "gustr.com/";
	
	public static final String MAIL_DROP_WEB_MAIL = "https://maildrop.cc/";
	public static final String MAIL_DROP_MAIL_INBOX_SUFFIX = "inbox/";
	
	
	public static final String DISPONSTABLE_WEB_MAIL = "http://dispostable.com/";
	public static final String DISPONSTABLE_MAIL_INBOX_SUFFIX = "inbox/";
	
	
	public static final String MAILNESIA_WEB_MAIL = "http://mailnesia.com/";
	public static final String MAILNESIA_MAIL_INBOX_SUFFIX = "mailbox/";
	
	
	public static final String TEMPMAIL_WEB_MAIL = "https://temp-mail.org/";
	
	//mailchimp
	
	public static final String URL_CHIMPMAIL = "https://login.mailchimp.com/";
	
	//unbounce
	public static final String URL_UNBOUNCE = "http://unbouncepages.com/aut-testing-disabled/";
	public static final String URL_UNBOUNCE_DYKSC = "http://unbouncepages.com/aut-testing/";
	
	
	//Frontend Composed URLS
	public static final String BASE_URL_BE = "/index.php/admin/";
	public static final String BASE_URL_AUT = "/customer/account/login/";
	public static final String WISHLIST_URL = "/wishlist/";
	public static final String KOBO_CAMPAIGN = "/kobo-campaign/";

	public static final String PROFILE_HISTORY_URL = "/sales/order/history/";
	public static final String STYLISTS_CUSTOMER_ORDER_REPORT = "/stylereports/order/myorders/?type=customerorders";
	public static final String STYLISTS_REPORTS = "/stylereports/";
	public static final String CART_PAGE_URL = "simona/checkout/cart/";
	
	//SOAP API
	public static final String API_URI = "index.php/api/v2_soap/index/";

	//Static Pages
	public static final String REGISTER_LANDING_PAGE = "/register-landing-page";
	public static final String LANDING_PAGE = "/contact-landing-page";
	
	//commision
	public static final String COMMISION_WEB_BASE = "http://commission-staging-aut.pippajean.com/api/";
//	public static final String COMMISION_WEB_BASE = "http://commission.evozon.com/api/";
	public static final String COMMISION_STYLIST_SUFFIX = "stylist.json";
	public static final String COMMISION_PARTY_SUFFIX = "party.json/";
	public static final String TEAM_PERFORMANCE_SUFFIX = "performance-team.json/";
	public static final String COMMISSION_URL = "https://commission-staging-aut.pippajean.com";
	public static final String COMMISSION_USERNAME = "admin";
	public static final String COMMISSION_PASSWORD = "qwerty";
	public static final String COMMISSION_REPORTS = "Reports";
	
	//navision
	public static final String IMPORT_INTERFACE_URL = "http://Navision:_N1v2s34N_@148.251.178.207/PjOrderImport/Home/ImportierenAut";
	public static final String INTERFACE_USERNAME = "Navision";
	public static final String INTERFACE_PASSWORD = "_N1v2s34N_";

}
