package com.gps.jaxws;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

/**
 * Class use GeoOP webservice stub to find country name based on IPAddress
 * 
 * @author GPS
 *
 */
public class IPLocationFinder {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("You need to pass in one IP Address...");
		} else {
			String ipAddress = args[0];
			// <wsdl:service name="GeoIPService">
			// <wsdl:port name="GeoIPServiceSoap"
			// binding="tns:GeoIPServiceSoap">
			GeoIPService geoIPService = new GeoIPService();
			// This is stub
			GeoIPServiceSoap geoIPServiceSoap = geoIPService
					.getGeoIPServiceSoap();
			GeoIP geoIp = geoIPServiceSoap.getGeoIP(ipAddress);
			System.out.println("Country name [" + geoIp.getCountryName()
					+ "] for IPAddress [" + ipAddress + "]");
		}
	}
}
