package com.thy.mercury.object_comparator;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;
import com.google.gson.Gson;
import com.thy.commons.coolbox.configloader.ConfigurationLoaderException;
import com.thy.commons.coolbox.configloader.FileConfigurationLoader;
import com.thy.mercury.couchbase.Couchbase;
import com.thy.mercury.couchbase.CouchbaseClientException;
import com.thy.mercury.couchbase.CouchbaseConnectionHandler;
import com.thy.mercury.couchbase.config.CouchbaseClientConfig;
import com.thy.mercury.inventory.all.model.FlightInventory;
import com.thy.mercury.object.comparator.ChangeReportDisplay;
import com.thy.mercury.object.comparator.InventoryChangeReporter;
import com.thy.mercury.object.comparator.ObjectComparator;
import com.thy.mercury.object.comparator.ObjectTreeComparator;
import com.thy.mercury.object.comparator.model.ChangeReport;
import com.thy.mercury.object.comparator.model.ComparatorConfig;
import com.thy.mercury.object.comparator.model.InventoryComparatorConfig;

public class ObjectComparatorTest
{
    @Test
    public void testStringIntStringConstructor() throws ConfigurationLoaderException
    {
        connectCouchBase();
        ComparatorConfig<?> config = InventoryComparatorConfig.getInventoryComparatorConfig();
        ObjectComparator comparator = new ObjectTreeComparator(config);
        FlightInventory inventoryOld;
        try
        {
            inventoryOld = getInventoryMC("IA_TK_0543_2019-10-15@G");
            FlightInventory inventoryNew = getInventory("IA_TK_0543_2019-10-15@G");
            /*  FlightInventory inventoryOld = getInventoryMC("IA_TK_1000_2018-10-13@G");
                FlightInventory inventoryNew = getInventory("IA_TK_1000_2018-10-13@G");
                FlightInventory inventoryOld = getInventoryMC("IA_TK_1000_2018-10-10@G");
                FlightInventory inventoryNew = getInventory("IA_TK_1000_2018-10-10@G");*/
            InventoryChangeReporter changeReporter = new InventoryChangeReporter(comparator);
            List<ChangeReport> output = changeReporter.generateChangeReport(null, inventoryNew);
            System.out.println(output);
        }
        catch (CouchbaseClientException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
        //		try {
        //			System.out.println(convertToDisplayList(output));
        //		} catch (ParseException e) {
        //			// TODO Auto-generated catch block
        //			e.printStackTrace();
        //		}
        //
        //		System.out.println(output.toString());
    }

    private static List<ChangeReportDisplay> convertToDisplayList(List<ChangeReport> output) throws ParseException
    {
        List<ChangeReportDisplay> displayList = new ArrayList<ChangeReportDisplay>();
        for (ChangeReport changeReport : output)
        {
            ChangeReportDisplay display = new ChangeReportDisplay(changeReport);
            displayList.add(display);
        }
        return displayList;
    }

    public static Boolean connectCouchBase() {
    		BasicConfigurator.configure();
    		// Logger logger.info("**** CouchbaseStartup ****");
    		String confdir = System.getProperty("thy.appdir");
    		String couchFullPath = "E:/thy//inventory-feed-all-application//conf//couchbase.json";
    
    		try {
    			CouchbaseClientConfig.getInstance().loadConfiguration(new FileConfigurationLoader(couchFullPath));
    		} catch (ConfigurationLoaderException e4) {
    			e4.printStackTrace();
    			// logger.error(e4.getMessage(), e4);
    		}
    		try {
    			CouchbaseConnectionHandler.getInstance().connect();
    		} catch (CouchbaseClientException e) {
    			e.printStackTrace();
    			// logger.error(e.getMessage(), e);
    		}
    		return true;
    	}
    
    	private static FlightInventory getInventory(String key) throws CouchbaseClientException {
    		JsonDocument jsonDoc = Couchbase.retrieve(key, getBucket("AV_INVENTORY"));
    		if (jsonDoc == null) {
    			return null;
    		}
    		Gson gson = new Gson();
    		FlightInventory inventory = gson.fromJson(jsonDoc.content().toString(), FlightInventory.class);
    		return inventory;
    	}
    
    	private static FlightInventory getInventoryMC(String key) throws CouchbaseClientException {
    		JsonDocument jsonDoc = Couchbase.retrieve(key, getBucket("MERCURY_CONSOLE"));
    		if (jsonDoc == null) {
    			return null;
    		}
    		Gson gson = new Gson();
    		FlightInventory inventory = gson.fromJson(jsonDoc.content().toString(), FlightInventory.class);
    		return inventory;
    	}
    
    private static Bucket getBucket(String bucketName) {
        return CouchbaseConnectionHandler.getInstance().getPrimaryCluster().getBucket(bucketName);
    }
}
