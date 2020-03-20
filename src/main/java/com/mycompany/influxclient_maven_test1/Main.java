/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.influxclient_maven_test1;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Pong;
import org.slf4j.LoggerFactory;

/**
 *
 * @author pconroy
 */
public class Main {
    private static final String             version = "InfluxDB_ColdSeal v0.9 (added Downtime)";
    
    private static final String             databaseURL = "http://localhost:8086";
    private static final String             databaseName = "ColdSeal";
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        System.out.println( "Starting " + version );
        
        
        System.out.println( "Attempting to connect to InfluxDB server on " + databaseURL );
        InfluxDB influxDB = InfluxDBFactory.connect( databaseURL, "notused", "notused" );
        Pong response = influxDB.ping();
        if (response.getVersion().equalsIgnoreCase( "unknown" )) {
            System.out.println( "Error pinging server." );
            return;
        } else {
            System.out.println( "Connected to InfluxDB Server. Version: " + response.getVersion() );
        }     
    }
}
