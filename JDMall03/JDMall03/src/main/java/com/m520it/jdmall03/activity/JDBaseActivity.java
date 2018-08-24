package com.m520it.jdmall03.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.m520it.jdmall03.controller.BaseController;
import com.m520it.jdmall03.listener.IModelChangeListener;
import com.m520it.jdmall03.utils.ActivityUtil;

public abstract class JDBaseActivity extends FragmentActivity implements IModelChangeListener{

	protected BaseController mController;
	private Handler mHandler=new Handler(){
		
		public void handleMessage(Message msg) {
			handleUIMessage(msg);
		}
		
	};
	
	protected void handleUIMessage(Message msg){
		//default Empty implements
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	
	protected abstract void initUI();
	
	protected void initController(){
		//default Empty implement
	}
	
	protected void tip(String msg){
		ActivityUtil.showTip(this, msg);
	}
	
	//返回主线程操作 Handler
	@Override
	public void onModelChanged(int action, Object... values) {//onModelChanged 在BaseController中调用了，这里算是网络请求成功后回调
		mHandler.obtainMessage(action, values[0]).sendToTarget();//sendToTarget调用这个方法，Handler才执行
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (mHandler!=null) {
			mHandler.removeCallbacksAndMessages(null);
		}
	}
	
}
