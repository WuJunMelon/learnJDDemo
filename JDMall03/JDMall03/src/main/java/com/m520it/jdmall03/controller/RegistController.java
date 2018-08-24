package com.m520it.jdmall03.controller;

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.m520it.jdmall03.bean.RResult;
import com.m520it.jdmall03.cons.IDiyMessage;
import com.m520it.jdmall03.cons.NetworkConst;
import com.m520it.jdmall03.utils.NetworkUtil;

public class RegistController extends BaseController {

	@Override
	protected void handleMessage(int action, Object... values) {
		switch (action) {
		case IDiyMessage.REGIST_ACTION:
			RResult resultBean = regist((String) values[0], (String) values[1]);
			onModelChanged(action, resultBean);
			break;
		}
	}

	private RResult regist(String name, String pwd) {
		HashMap<String, String> paramsMap = new HashMap<String, String>();
		paramsMap.put("username", name);
		paramsMap.put("pwd", pwd);
		String jsonStr = NetworkUtil.doPost(NetworkConst.REGIST_URL, paramsMap);
		return JSON.parseObject(jsonStr, RResult.class);
	}

}
