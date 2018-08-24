package com.m520it.jdmall03.activity;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.m520it.jdmall03.R;
import com.m520it.jdmall03.bean.RResult;
import com.m520it.jdmall03.cons.IDiyMessage;
import com.m520it.jdmall03.controller.RegistController;

public class RegistActivity extends JDBaseActivity {


	private EditText mNameEt;
	private EditText mPwdEt;
	private EditText mSurePwdEt;
	
	@Override
	protected void handleUIMessage(Message msg) {
		switch (msg.what) {
			case IDiyMessage.REGIST_ACTION:
				handleRegistResult((RResult) msg.obj);
				break;
		}
	}
	
	private void handleRegistResult(RResult resultBean){
		//如果注册成功 跳转到登录页面(finish)  如果注册失败 弹出一个提示
		if (resultBean.isSuccess()) {
			tip("注册成功!");
			finish();
		}else {
			tip(resultBean.getErrorMsg());
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		initController();
		initUI();
	}
	
	@Override
	protected void initController() {
		mController=new RegistController();
		mController.setIModelChangeListener(this);
	}

	@Override
	protected void initUI() {
		mNameEt =(EditText) findViewById(R.id.username_et);
		mPwdEt =(EditText) findViewById(R.id.pwd_et);
		mSurePwdEt =(EditText) findViewById(R.id.surepwd_et);
	}
	
	public void registClick(View v){
		String name = mNameEt.getText().toString();
		String pwd = mPwdEt.getText().toString();
		String surePwd = mSurePwdEt.getText().toString();
		if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)||TextUtils.isEmpty(surePwd)) {
			tip("请输入完整的注册信息");
			return;
		}
		if (!pwd.equals(surePwd)) {
			tip("两次密码不一致");
			return;
		}
		mController.sendAsyncMessage(IDiyMessage.REGIST_ACTION, name,pwd);
	}
	
	
	
	
	//类
		//属性
		//构造器
		//set/get方法
		//生命周期
		//自己定义的方法
		//onActivityResult()/onCreateOptionMenu.../onTouch...
	
}
