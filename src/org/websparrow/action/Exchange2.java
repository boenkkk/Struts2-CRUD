package org.websparrow.action;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.ItemId;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.ItemView;

public class Exchange2 extends ActionSupport{
	
	private static ExchangeService service;
	private static Integer NUMBER_EMAILS_FETCH = 99999;
	
    public String execute() throws Exception{
    	service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
    	service.setUrl(new URI("https://outlook.office365.com/ews/exchange.asmx"));
//    	ExchangeCredentials credentials = new WebCredentials("budi@kroaks.onmicrosoft.com", "Fud05122", "office365.com");
    	ExchangeCredentials credentials = new WebCredentials("dien@kroaks.onmicrosoft.com", "Toh63347", "office365.com");
//    	ExchangeCredentials credentials = new WebCredentials("amar@kroaks.onmicrosoft.com", "Nas99176", "office365.com");
        service.setCredentials(credentials);
        System.out.println("===Credential OK===");
        readEmails();
        System.out.println("===Read OK===");
    	
    	return "REGISTER";
    }
    
    public Map readEmailItem(ItemId itemId) {
        Map messageData = new HashMap();
        try {
            Item itm = Item.bind(service, itemId, PropertySet.FirstClassProperties);
            EmailMessage emailMessage = EmailMessage.bind(service, itm.getId());
            messageData.put("emailItemId", emailMessage.getId().toString());
            messageData.put("subject", emailMessage.getSubject().toString());
            messageData.put("fromAddress", emailMessage.getFrom().getAddress().toString());
            messageData.put("senderName", emailMessage.getSender().getName().toString());
            Date dateTimeCreated = emailMessage.getDateTimeCreated();
            messageData.put("SendDate", dateTimeCreated.toString());
            Date dateTimeRecieved = emailMessage.getDateTimeReceived();
            messageData.put("RecievedDate", dateTimeRecieved.toString());
            messageData.put("Size", emailMessage.getSize() + "");
            messageData.put("emailBody", emailMessage.getBody().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageData;
    }
    
    public List readEmails() {
        List msgDataList = new ArrayList();
        try {
            Folder folder = Folder.bind(service, WellKnownFolderName.Inbox);
//            FindItemsResults results = service.findItems(folder.getId(), new ItemView(NUMBER_EMAILS_FETCH));
            int i = 1;
            for (Item item : service.findItems(folder.getId(), new ItemView(NUMBER_EMAILS_FETCH))) {
                Map messageData = new HashMap();
                messageData = readEmailItem(item.getId());
                System.out.println("\nEmails #" + (i++) + ":");
                System.out.println("Subject : " + messageData.get("subject").toString());
                System.out.println("Sender : " + messageData.get("senderName").toString());
                System.out.println("emailItemId : " + messageData.get("emailItemId").toString());
                System.out.println("fromAddress : " + messageData.get("fromAddress").toString());
                System.out.println("SendDate : " + messageData.get("SendDate").toString());
                System.out.println("RecievedDate : " + messageData.get("RecievedDate").toString());
                System.out.println("Size : " + messageData.get("Size").toString());
//                System.out.println("emailBody : " + messageData.get("emailBody").toString());
                msgDataList.add(messageData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msgDataList;
    }
}
