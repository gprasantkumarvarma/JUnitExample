package com.thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;


public class JSPCalling {
	
	public static void main(String[] args) throws IOException {
		
		JSONObject json = new JSONObject();
		json.put("test", "test");
		json.put("test1", "test");
		json.put("test2", "test");
		json.put("test3", "test");
		URL url = new URL("http://localhost:8080/test/test.jsp");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/json; charset=utf-8");
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(json.toString());
		wr.flush();
		wr.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		System.out.println(in.readLine());
	}

}
