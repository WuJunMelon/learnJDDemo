package com.m520it.jdmall03.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.m520it.jdmall03.activity.JDBaseActivity;

public class ActivityUtil {

	public static void start(Context c,Class<? extends JDBaseActivity> clazz,boolean ifFinish){
		Intent intent=new Intent(c,clazz);
		c.startActivity(intent);
		if (ifFinish) {
			((Activity)c).finish();
		}
	}
	
	public static void showTip(Context c,String msg){
		Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
	}
	
}
