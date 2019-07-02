package com.thy.mercury.object_comparator;

import java.util.Arrays;
import java.util.List;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import org.apache.log4j.Logger;

public class CbConnectionBase {

    protected static final Logger LOGGER = Logger.getLogger("devguide");

    protected final Cluster cluster;
    protected final Bucket bucket;

    //=== EDIT THESE TO ADAPT TO YOUR COUCHBASE INSTALLATION ===
    public static final String bucketName = "AV_SCHEDULE";//MERCURY_CONSOLE, AV_SCHEDULE, SIMULATION
    public static final String bucketPassword ="V9t23m1."; //"V9t23m1."; // ; //"Xe4f145d106s2";//"Xe4f145d106s2"
    public static final List<String> nodes = Arrays.asList("10.11.75.70", "10.11.75.71", "10.11.75.72");//     "10.11.75.81", "10.11.75.82", "10.11.75.83" "10.11.75.70", "10.11.75.71", "10.11.75.72"

    public CbConnectionBase() {
        //connect to the cluster by hitting one of the given nodes
        cluster = CouchbaseCluster.create(nodes);
        //get a Bucket reference from the cluster to the configured bucket
        bucket = cluster.openBucket(bucketName, bucketPassword);
    }
    
    public CbConnectionBase(String bucketName, boolean isProd) {
       String bucketPass = null;
       if(isProd) {
           cluster = CouchbaseCluster.create(Arrays.asList("10.11.75.70", "10.11.75.71", "10.11.75.72"));
           bucketPass = "V9t23m1.";
       }else {
           cluster = CouchbaseCluster.create(Arrays.asList("10.11.75.81", "10.11.75.82", "10.11.75.83"));
           bucketPass = "Xe4f145d106s2";
       }
       bucket = cluster.openBucket(bucketName, bucketPass);
    }

    public void disconnect() {
        //release shared resources and close all open buckets
        cluster.disconnect();
    }

    public void execute() {
        //connection has been done in the constructor
        doWork();
        disconnect();
    }

    /**
     * Override this method to showcase specific examples.
     * Make them executable by adding a main method calling new ExampleClass().execute();
     */
    protected void doWork() {
        //this one just showcases connection methods, see constructor and shutdown()
        LOGGER.info("Connected to the cluster, opened bucket " + bucketName);
    }

    public static void main(String[] args) {
        new CbConnectionBase().execute();
    }

	public Bucket getBucket() {
		return bucket;
	}
    
    
}
