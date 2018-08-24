package com.m520it.jdmall03.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//本质:传递一个Url还有请求的参数 返回String类型的数据
public class NetworkUtil {

	//执行一个网络请求 	HttpUrlConnection	开发步骤	1234
	public static String doPost(String urlPath,HashMap<String, String> paramsMap){
		try {
			//1.创建URL对象
			URL url=new URL(urlPath);
			//2.打开一个链接
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			//3.设置Post请求
			conn.setRequestMethod("POST");
			//4.提交请求参数
			String params=parseParams(paramsMap);
			conn.setDoOutput(true);
			conn.getOutputStream().write(params.getBytes());
			//5.获取响应码
			if (conn.getResponseCode()==200) {
				//6.获取响应流
				InputStream is = conn.getInputStream();
				BufferedReader reader=new BufferedReader(new InputStreamReader(is));
				return reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private static String parseParams(HashMap<String, String> paramsMap){
		String result="";
		for (Map.Entry<String, String> entry: paramsMap.entrySet()) {
			result+=("&"+entry.getKey()+"="+entry.getValue());
		}
//		&username=xx&pwd=xxx
		return result.substring(1);
	}
	
}
