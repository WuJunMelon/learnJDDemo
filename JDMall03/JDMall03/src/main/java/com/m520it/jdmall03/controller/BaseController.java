package com.m520it.jdmall03.controller;

import com.m520it.jdmall03.listener.IModelChangeListener;

public abstract class BaseController {
	
	protected IModelChangeListener mListener;//接口，控制器和view（avticity）通过接口关联。

	public void setIModelChangeListener(IModelChangeListener listener) {
		mListener=listener;
	}

	//发送一个异步的请求信息
	public void sendAsyncMessage(final int action,final Object... values){//放在父类，公用
		//替换技术:线程池
		new Thread(){
			public void run() {
				handleMessage(action,values);
			}
		}.start();
	}
	
	
	protected abstract void handleMessage(int action,Object... values);
	
	protected void onModelChanged(int action,Object... values){
		if (mListener!=null) {
			mListener.onModelChanged(action,values);
		}
	}
	
	
}
