package com.m520it.jdmall03.controller;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.m520it.jdmall03.bean.RResult;
import com.m520it.jdmall03.cons.IDiyMessage;
import com.m520it.jdmall03.cons.NetworkConst;
import com.m520it.jdmall03.utils.NetworkUtil;

public class LoginController extends BaseController {
	
	@Override
	protected void handleMessage(int action, Object... values) {
		switch (action) {
			case IDiyMessage.LOGIN_ACTION:
				RResult resultBean = login((String) values[0], (String) values[1]);//RResult iOS中的模型
				onModelChanged(action,resultBean);
				break;
		}
	}
	//发送网络请求，实际的请求
	private RResult login(String name, String pwd) {
		HashMap<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("username", name);
		paramsMap.put("pwd", pwd);
		String jsonStr = NetworkUtil.doPost(NetworkConst.LOGIN_URL, paramsMap);
		return JSON.parseObject(jsonStr, RResult.class);
	}

}
