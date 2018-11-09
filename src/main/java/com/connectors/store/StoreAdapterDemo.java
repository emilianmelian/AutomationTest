package com.connectors.store;

import com.tools.constants.AdapterConstants;
import com.tools.data.CalcDetailsModel;
import com.tools.data.frontend.OnlineStylePartyModel;

public class StoreAdapterDemo {
	 public static void main(String[] args) {
	      Store store = new Store();
	      
	      
	      CalcDetailsModel model=new CalcDetailsModel();
	      model.setIpPoints("ip");
	      model.setShipping("shipping");
	      model.setJewelryBonus("3");
	      
	      
	      
	      
	      OnlineStylePartyModel model2=new OnlineStylePartyModel();
	      model2.setHostPassword("emilianpass2012");
	      model2.setHostUserName("ema");

	     /* store.write(Adapter.MONGO, "test write");
	      store.read(Adapter.SERENITY, "test read");*/
	      store.write(AdapterConstants.MONGO,model2,"test1");
	
	      
	      
	      
	      
	      
	   }
}
