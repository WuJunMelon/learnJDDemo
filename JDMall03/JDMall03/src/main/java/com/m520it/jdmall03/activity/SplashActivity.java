package com.m520it.jdmall03.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Bundle;
import android.widget.ImageView;

import com.m520it.jdmall03.R;
import com.m520it.jdmall03.utils.ActivityUtil;

public class SplashActivity extends JDBaseActivity {

	private ImageView mLogoIv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		initUI();
		initSplashAnim();
	}

	private void initSplashAnim() {
		ValueAnimator animator=ValueAnimator.ofFloat(0,0.5f,1.0f);
		animator.setDuration(2000);
		animator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				//1.获取当前的值
				float value=(Float) animation.getAnimatedValue();
				//2.setAlpha是3.0以上才有的
				mLogoIv.setAlpha(value);
			}
		});
		animator.addListener(new AnimatorListenerAdapter() {
			
			@Override
			public void onAnimationEnd(Animator animation) {
				ActivityUtil.start(SplashActivity.this, LoginActivity.class,true);
			}
			
		});
		animator.start();
	}

	@Override
	protected void initUI() {
		mLogoIv =(ImageView) findViewById(R.id.logo_iv);
	}

}
