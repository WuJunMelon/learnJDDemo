package com.m520it.jdmall03.activity;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.m520it.jdmall03.R;
import com.m520it.jdmall03.bean.RResult;
import com.m520it.jdmall03.cons.IDiyMessage;
import com.m520it.jdmall03.controller.LoginController;
import com.m520it.jdmall03.utils.ActivityUtil;

public class LoginActivity extends JDBaseActivity {

	private EditText mNameEt;
	private EditText mPwdEt;
	
	@Override
	protected void handleUIMessage(Message msg) {
		if (msg.what==IDiyMessage.LOGIN_ACTION) {
			handleLoginResult((RResult) msg.obj);
		}
	}
	
	private void handleLoginResult(RResult resultBean){
		if (!resultBean.isSuccess()) {
			tip("登录失败:"+resultBean.getErrorMsg());
			return;
		}
		tip("登录成功!");
		//TODO 
		//1.登录成功后 会将账号密码保存起来(只能保存一个用户)
		//2.要获取用户的信息 如用户名 用户的等级..
		//3.跳进主页
		ActivityUtil.start(this, MainActivity.class, true);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initController();
		initUI();
	}
	
	protected void initController(){
		mController = new LoginController();
		mController.setIModelChangeListener(this);//绑定控制器
	}

	@Override
	protected void initUI() {
		mNameEt =(EditText) findViewById(R.id.name_et);
		mPwdEt =(EditText) findViewById(R.id.pwd_et);
	}
	
	public void loginClick(View v){
		String name = mNameEt.getText().toString();
		String pwd = mPwdEt.getText().toString();
		if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pwd)) {
			tip("请输入账号/密码");
			return;
		}
		mController.sendAsyncMessage(IDiyMessage.LOGIN_ACTION, name,pwd);//发送网络请求
	}
	
	public void registClick(View v){
		ActivityUtil.start(this, RegistActivity.class, false);
	}

}
