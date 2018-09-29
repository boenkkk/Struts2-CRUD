package org.websparrow.action;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;



public class Exchange1 extends ActionSupport{
	private static ExchangeService service;
    private static Integer NUMBER_EMAILS_FETCH = 5; // only latest 5 emails/appointments are fetched.
	
	private static final long serialVersionUID = 2139116285823340125L;
	private String uname, uemail, upass, udeg;
	private String msg = "";
	Admin admin = null;
	int ctr = 0;
	
	@Override
	public String execute() throws Exception{
		service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
    	try {
//			service.setUrl(new URI("https://mbx02.iconpln.co.id:444/EWS/Services.wsdl"));
//    		service.setUrl(new URI("https://mail.iconpln.co.id/ews/exchange.asmx"));
//    		service.setUrl(new URI("https://webmail.pln.co.id/ews/exchange.asmx"));
    		service.setUrl(new URI("https://outlook.office365.com/ews/exchange.asmx"));
    		System.out.println("===Service OK===");
			
//			MSExchangeEmailService();
//    		ExchangeCredentials credentials = new WebCredentials("pusat\rekonsiliasi", "P@ssw0rd321!", "pln.co.id");
//    		ExchangeCredentials credentials = new WebCredentials("budi@kroaks.onmicrosoft.com", "Fud05122", "outlook.com");
    		ExchangeCredentials credentials = new WebCredentials("dien@kroaks.onmicrosoft.com", "Toh63347", "office365.com");
            service.setCredentials(credentials);
            System.out.println("===Credential OK===");
			
			List msgDataList = new ArrayList();
	        try {
	            Folder folder = Folder.bind(service, WellKnownFolderName.Inbox);
	            FindItemsResults results = service.findItems(folder.getId(), new ItemView(NUMBER_EMAILS_FETCH));
//	            System.out.println("jml ="+ results.getTotalCount());
	            System.out.println(results.getItems());
	            
//	            int i = 1;
//	            for (Item item : results) {
//	                Map messageData = new HashMap();
//	                messageData = readEmailItem(item.getId());
//	                System.out.println("\nEmails #" + (i++) + ":");
//	                System.out.println("subject : " + messageData.get("subject").toString());
//	                System.out.println("Sender : " + messageData.get("senderName").toString());
//	                msgDataList.add(messageData);
//	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
			System.out.println("sampe");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		admin = new Admin();
//		try{
//			ctr = admin.registerUser(uname, uemail, upass, udeg);
//			if (ctr > 0 ){
//				msg = "Registration Success";
//			} else {
//				msg ="Error Bro";
//			}
//		} catch (Exception e) {
//			 e.printStackTrace();
//		}
		return "REGISTER";
	}
	
//	public void MSExchangeEmailService() {
////        ExchangeCredentials credentials = new WebCredentials("notifikasi.ap2t", "icon+543", "mail.iconpln.co.id");
//        ExchangeCredentials credentials = new WebCredentials("pusat\rekonsiliasi", "P@ssw0rd321!", "webmail.pln.co.id");
//        service.setCredentials(credentials);
//    }

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUdeg() {
		return udeg;
	}

	public void setUdeg(String udeg) {
		this.udeg = udeg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}
}
