package com.nagarro.utility;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class RestCommunication {
	
	public String sendGetRequest(String req) {
		
			String url="http://localhost:8081"+req;
			System.out.println(url);
		String res=null;
		//httprequest
		HttpRequest hr=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		HttpClient hc=HttpClient.newBuilder().build();
		
		HttpResponse<String> response;
		try {
			
			response = hc.send(hr, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.statusCode());
		
		res=response.body();
		System.out.println(res);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public void sendPutRequest(String req,JSONObject jo) {
		 String query_url = "http://localhost:8081"+req;
		 System.out.println(query_url);
         String json =jo.toString();
         System.out.println(json);
		 try {
	           URL url = new URL(query_url);
	           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	           conn.setConnectTimeout(5000);
	           conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	           conn.setDoOutput(true);
	           conn.setDoInput(true);
	           conn.setRequestMethod("PUT");
	           OutputStream os = conn.getOutputStream();
	           os.write(json.getBytes("UTF-8"));
	           os.close(); 
	           // read the response
	           InputStream in = new BufferedInputStream(conn.getInputStream());
	           String result = IOUtils.toString(in, "UTF-8");
	           System.out.println(result);
	           System.out.println("result after Reading JSON Response");
	           JSONObject myResponse = (JSONObject)new  JSONParser().parse(result);
	           System.out.println("jsonrpc- "+myResponse);
	           in.close();
	           conn.disconnect();
	           } catch (Exception e) {
	   			System.out.println(e);
	   		}
	}
	
	public void sendDeleteRequest(String req) {
		String url="http://localhost:8081"+req;
		System.out.println(url);
	String res=null;
	//httprequest
	HttpRequest hr=HttpRequest.newBuilder().DELETE().uri(URI.create(url)).build();
	
	HttpClient hc=HttpClient.newBuilder().build();
	
	HttpResponse<String> response;
	try {
		
		response = hc.send(hr, HttpResponse.BodyHandlers.ofString());
	
	System.out.println(response.statusCode());
	
	res=response.body();
	System.out.println(res);
	} catch (IOException | InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void sendPostRequest(String req,JSONObject jo) {
		 String query_url = "http://localhost:8081"+req;
		 System.out.println(query_url);
         String json =jo.toString();
         System.out.println(json);
		 try {
	           URL url = new URL(query_url);
	           HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	           conn.setConnectTimeout(5000);
	           conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	           conn.setDoOutput(true);
	           conn.setDoInput(true);
	           conn.setRequestMethod("POST");
	           OutputStream os = conn.getOutputStream();
	           os.write(json.getBytes("UTF-8"));
	           os.close(); 
	           // read the response
	           InputStream in = new BufferedInputStream(conn.getInputStream());
	           String result = IOUtils.toString(in, "UTF-8");
	           System.out.println(result);
	           System.out.println("result after Reading JSON Response");
	           JSONObject myResponse = (JSONObject)new  JSONParser().parse(result);
	           System.out.println("jsonrpc- "+myResponse);
	           in.close();
	           conn.disconnect();
	           } catch (Exception e) {
	   			System.out.println(e);
	   		}
		
	}
}
