package com.java.other;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.json.simple.JSONObject;

public class IOSDeviceTokenCheckStatus {
	
	static String  token ="eyJraWQiOiJZNjc1Uk0yWVhOIiwiYWxnIjoiRVMyNTYifQ.eyJpc3MiOiI0RTlLM1A3MjYyIiwiaWF0IjoxNTgzODQwNzM4fQ.GyrL-gdeC9Y8XZWVjdu5uySyYxYAiw05muIRW6amVAjAEXbglFmdpPo4ikm5Ee-imH0f1gBXcu6tq4C7pidPvA";
	public static void main(String[] args) throws IOException {
		
		String device_token = "AgAAADqi5FYsV2zn1D+86KR/B9kEUNk0+me89vLfv5ZingpyOOkgXXXyjPzYTzWmWSu+BYqcD47byirLZ++3dJccpF99hWppT7G5xAuU+y56WpSYsAS89W3P4/ypg+gUz1pOVSwwD98VbJgPGqRQvS/dkQ8wiVErleOeuU/P69gP4zX3kL78u61FwkrlVj+VC24jg8m46AcAAJtOYPS5u+qxuJbz8XYS65hjg+TInT0FOLRZQUVvH/H1eXMGzQ5k+ibHWpOyen2YriGlBHrTZlYxkDu6mFKwCJXm+w9uRtpDAkitAn9v6VV/q/VmGxw6ieP8f8tOfhPnAUiXevPmYSDsgXXyLaDxZO9p6HzGbbfBjGw+ID4w+5fMM7ddAcTEzQtxnAtyBuen5JF4QVIHXDEWp+NWgZYl/wumvQzTn02RrJb0YHfNYAP2u6CwXzSQPKvu+qfCKlJVlC+AyalK9tsNcZdzSzdwVRF9UrtD3K4DSHqazgbzter3a/5MrC3AOosalsrMH/dwNFuw+Enb1bAf66Ih4IkQAHTnuoSkQXtezMrT6aj3Cv8V3FeQrEP8TrxKjhS+pDcZJ2xyD9CYY+sOrBwssYvZvC1QD3lPHZHTgwlCUMLdSOfIrfZfn61gCbMBzP57iaJVgcBVvifS5EiHqIogFuGbAiEzsfHYNKmHsay97Vfb5s/+ySqNz6BewBEhYtJhXoInfaNYw4j1qFdwCWxVA1uJmbXgvfVHxdUpc0xM/NiYdzzTNZMAhfBP37vF5AVROMwGEqmdzLgaDFNKF9XOGv/De44BC+vAPBgCS+yaWeiTGsJLTJUxfq18jUM4t/n39lV86NFUk7/0zSNxLAN6ylXODkNI6R99UyQh6+EpvGcNxtCsa+1RrxHM894Ao/M4vC9AIb91rKFk/qaaFt/vBMjaEaJs78/yNp/ocQXmwdKPjsd/RvyhYJDvs5K4xMWoa4N2uVbNzLBXqW5PLtb9fDSeuV2y9u+qeoeUx89UyNKQRv7cL5fyoWgzOxQsnkY7nzLk4+BwfxaVeRZDBELMwuRTGW907lMBFpG60cTXEW3PaBJKsDT5dZ7hpAu0OKJw73XnuNY8V2dVtWMWSioZu2Qxdu6CGZ1xjfqvzKN4DyF0cg4FUS1HNSYZAuFbitYW0RaPnJxbSFQLmlHj3iPT+8NWk/tvumupXEWA5/zMqzd8uUS9i5tMqspxTvkdrFrU3q1Yj0QT9uDLlnwm6C2aA8QKs15nmHUFzA/VR57B7C3MP5CKB6w/bDfJUE7Aj7GifJr1X4KGmzV2RzbCVD67ixIrD6v5QDtTJe852j2LUgGDOajICPiMzQi1Pn6LY9fBbaz+BTwx5B//XXSEk01Rh/sPmYh5G9XLKo1U+g9uFge72tLxk0g2E8fv5Hrv4jubQxwIFOdtejCSs9a3xti7yNTehPGUAMVBAiNgg3gObh7NM9P/Mbp4qhbXDCUgZN0+tzFykooRFkIT+Wjp8v7SV0BOdE3a1uHot7LO5qmSe/uMkcQCOrW6J96rHAB4goWDSD3CW5IQ4gKiUFxHPpOTH0smImXGf6roSkDz5y+rEKOjUfyvFwyWx5SbihHB3ir1bQpmdy6HNHRHACK93PCpnJv2MCM5ZWZLwVHbk9W4bNAKeZUsF0W/hBT8mmwI6IEdfIKrL8pd/bP65qJENr+L5PO6k0V8jz5uHvAA4kbenJcO3MO4ClyXF6eyp2fA2k+/JOafj0GEezBaglYSydCIsAe57gZFSSK00v7WFo+NNWrwWnQjjo7lnGpEsqDb/gEkmDuGpk+WQ6BA/awGn3WHTTyGpDRKE04iD6hDGTsSqaYrwWWESNUFqj/4asDMd4q9GLgaP2KE0elvZQYjXLnH4bIKjsuqur7IN6uPrggPyYDxc5XIMtBsVUzfD9pGEUNDlgeeyTPqcVggQD7ypEO5QaERW/Gmq8GU89/3e7AYp8HRbl1lRAA5qoVNFmbGAtTKDhZTC4oP/9c+svLCCQMcnRguf9M4j3UhcU136Wmjb8ipTZCBFga5UbRCYRGIn79JCTmq9YxGGIZPHa51K+qAYxuZzPqx5itk8htVFvDNtgBNBARQwgCvnl2gnggt/2htxhm19kMfYSxHRgvcqXW9AWCH+D98IqhFpQULuNP02ct3J61+WJXBxA6fG5G+Thw8Rbpci+dhAI5XldxDc8/UFRbJMxc7cTjlt/uooAfIHo353A4rzyOCTg/J4+f7on0zlxZ2MKb7Vx+hxjvFVYYdkfDP/ll57Mt8Tbi6vGMJk0oQpSqpWPjn6EDdqEDxN3bSZtQXDRMIzfcHaRXaoTEZXhg90qLKvsth+odYX4CK+lSNDd4ynlEf/7mVMKkewFof4tLft4hhB3qo5AeNN1fgA/Bm5tg0Y1FndHi8rg0oYnze5V6LkcNaXTL4YZumWqdt1Vvrwr+9+nCbwe5BVbxEw1+9u2bKcl8Az/RQSEwrY9AfzQdREuXeMxKaCpfemnAHdh7i6kdYXTvl6WmtcP5CoEmnVMSGpW/Vw+/G5FDjipgDiTK/TNKzKhEO4rOAL0krO4PTLUwFh0gkNc6TVlrSBlzgx2Y3v/uBdsSG6KHGwdxODa5x3CvQsvEilZii0aITndDmgihkqgP3BrPETl1rzMD2FaaAnmF4JVDI/BK3/zmtwWn5addjT6P+BLaSwv6oDdMdpv3bDwVaAfVidqjis69GzTSWhYB16DSR+GB86ywiWCd7S7iZyBCiL90G80ziUGP4QObQjmMUxKbJsZSM2Ejn3txEmbHEG5zlVbHcAfGdN9Cl7tSR1kzmka5mFbg/7yeKs6EA+6Z4nj8fjWKF56mwDxgKlK30DH47uiQl2k6pf6+KyPJdpD4jaNmZ50ut1LzDXh2avxCH5gQ7";
		JSONObject requestBody = new JSONObject();
		requestBody.put("device_token", device_token);
		requestBody.put("timestamp", System.currentTimeMillis());
		requestBody.put("transaction_id", UUID.randomUUID().toString());
		
		System.out.println(requestBody);
		
		String req =URLEncoder.encode(requestBody.toString(),"UTF-8");
		
		
		String statusurl ="https://api.development.devicecheck.apple.com/v1/query_two_bits";
		URL url = new URL(statusurl);
		
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("content-type", "application/json; charset=UTF-8");
		con.setRequestProperty("Authorization", "Bearer "+token);
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		
		
	DataOutputStream writer = new DataOutputStream(con.getOutputStream());
		writer.write(req.getBytes());
		writer.flush();
		writer.close();
		
		
		/*try(OutputStream os = con.getOutputStream()) {
			
			
		    byte[] input = URLEncoder.encode(requestBody.toString(), "UTF-8").getBytes();
		    os.write(input, 0, input.length);           
		}*/
		
		System.out.println(con.getResponseCode());
		System.out.println(con.getResponseMessage());
		
		StringBuffer resp = new StringBuffer();
		if(con.getResponseCode()==HttpURLConnection.HTTP_OK){
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		//StringBuffer resp = new StringBuffer();
		String realResponse;
		while((realResponse = in.readLine()) !=null){
			resp.append(realResponse);
		}
		}
		
		System.out.println("Response ::: "+resp.toString());
		
		
		
		
		
		
		
	}

}
