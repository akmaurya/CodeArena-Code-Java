package com.gps.jaxws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Get SOAP Response XML based on SOAP Request
 * 
 * @author GPS
 *
 */
public class SOAPServiceClient {
	public static void main(String[] args) {
		SOAPServiceClient soapServiceClient = new SOAPServiceClient();

		soapServiceClient.getGeoIpResponseXML();
	}

	private void getGeoIpResponseXML() {
		String soapRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.webservicex.net/\">"
				+ "<soapenv:Header/>"
				+ "<soapenv:Body>"
				+ "<web:GetGeoIP>"
				+ "<!--Optional:-->"
				+ "<web:IPAddress>74.125.130.105</web:IPAddress>"
				+ "</web:GetGeoIP>" + "</soapenv:Body>" + "</soapenv:Envelope>";
		String endPointUrl = "http://www.webservicex.net/geoipservice.asmx";
		ResponseInfo response = new ResponseInfo();
		HttpURLConnection httpConn = null;
		try {
			URL endpoint = new URL(endPointUrl);
			httpConn = (HttpURLConnection) endpoint.openConnection();
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);
			httpConn.setUseCaches(false);
			httpConn.setAllowUserInteraction(false);

			httpConn.setRequestProperty("Content-Type",
					"text/xml; charset=utf-8");
			System.out.println("Request:" + soapRequest);
			httpConn.setRequestProperty("Content-Length",
					"" + soapRequest.length());
			OutputStream out = httpConn.getOutputStream();
			out.write(soapRequest.getBytes());
			out.flush();
			out.close();
			InputStream in = null;
			if (httpConn.getResponseCode() == 200) {
				in = httpConn.getInputStream();
				System.out.println("Success: Received response code "
						+ httpConn.getResponseCode() + " in response");
			} else {
				in = httpConn.getErrorStream();
				System.out.println("Error: Received error code "
						+ httpConn.getResponseCode() + " in response-"
						+ httpConn.getResponseMessage());
			}
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			String tempStr = reader.readLine();
			StringBuffer finalStr = new StringBuffer();
			while (tempStr != null) {
				finalStr.append(tempStr);
				tempStr = reader.readLine();
			}
			// e.g. he may want to see if network related failure i.e.
			// resonse code >400, then generate alarm
			System.out.println("Response:" + finalStr.toString());
			response.setResponseString(finalStr.toString());
			response.setResponseCodeNumber(httpConn.getResponseCode());
			// genResponseStatusAlarm(httpConn.getResponseCode(), profile);
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
			System.out.println("Endpoint URL is not formatted properly: "
					+ mue.getMessage());
			response.reset();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Unable to output the request: "
					+ ioe.getMessage());
			response.reset();
		} finally {
			try {
				httpConn.disconnect();
			} catch (Exception e) {
			}
		}
	}
}
