package org.websparrow.action;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import javafx.scene.shape.Line;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.PropertySet;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.BasePropertySet;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.search.FolderTraversal;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.EmailMessage;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.FolderSchema;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.property.complex.FolderId;
import microsoft.exchange.webservices.data.property.complex.ItemId;
import microsoft.exchange.webservices.data.search.FindFoldersResults;
import microsoft.exchange.webservices.data.search.FindItemsResults;
import microsoft.exchange.webservices.data.search.FolderView;
import microsoft.exchange.webservices.data.search.ItemView;

public class Exchange3 extends ActionSupport{
	
	private static ExchangeService service;
	
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
    	
    	return "EXCHANGE";
    }
    
    public List readEmails() {
        List msgDataList = new ArrayList();
        try {
            FolderView folder = new FolderView(Integer.MAX_VALUE);
            folder.setPropertySet(new microsoft.exchange.webservices.data.core.PropertySet(BasePropertySet.IdOnly));
            folder.getPropertySet().add(FolderSchema.DisplayName);;
            folder.setTraversal(FolderTraversal.Deep);
            
            FindFoldersResults ffr = service.findFolders(new FolderId(WellKnownFolderName.Inbox), folder);
			for(Folder folder2 : ffr){
				FolderId id 	= folder2.getId();
				for (Item item : service.findItems(id, new ItemView(Integer.MAX_VALUE))) {
					readEmail(item.getId());
					}
			}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msgDataList;
    }
    private static void readEmail(ItemId id) {
    	int no=1;
		try {
			Item itm = Item.bind(service, id);
			System.out.println("==============================");
			System.out.println(no++);
			System.out.println("ID ="+ itm.getId()); 
			System.out.println("Subject ="+ itm.getSubject());
			System.out.println("To ="+ itm.getDisplayTo());
			System.out.println("CC ="+ itm.getDisplayCc());
			System.out.println("Reply To ="+ itm.getInReplyTo());
			System.out.println("Receive ="+ itm.getDateTimeReceived());
			System.out.println("Created ="+ itm.getDateTimeCreated());
			System.out.println("Sent ="+ itm.getDateTimeSent());
//			System.out.println("Body ="+ itm.getBody());
			System.out.println("==============================");
			System.out.println("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
