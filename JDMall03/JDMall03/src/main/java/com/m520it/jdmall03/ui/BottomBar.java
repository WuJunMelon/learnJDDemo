package com.m520it.jdmall03.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.m520it.jdmall03.R;
import com.m520it.jdmall03.listener.IButtonBarClickListener;

public class BottomBar extends LinearLayout implements OnClickListener {

	private ImageView mMainIv;
	private TextView mMainTv;
	private ImageView mCategoryIv;
	private TextView mCategoryTv;
	private ImageView mShopcarIv;
	private TextView mShopcarTv;
	private ImageView mMyJdIv;
	private TextView mMyJdTv;
	private IButtonBarClickListener mListener;
	private int mCurrenTabId=-1;
	

	public void setIButtonBarClickListener(IButtonBarClickListener listener) {
		mListener=listener;
	}

	public BottomBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	// 当布局加载完毕的时候 才能够获取子控件
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		initUI();
		//模拟控件被点击
		findViewById(R.id.frag_main_ll).performClick();
	}

	private void initUI() {
		findViewById(R.id.frag_main_ll).setOnClickListener(this);
		findViewById(R.id.frag_category_ll).setOnClickListener(this);
		findViewById(R.id.frag_shopcar_ll).setOnClickListener(this);
		findViewById(R.id.frag_mine_ll).setOnClickListener(this);

		mMainIv = (ImageView) findViewById(R.id.frag_main_iv);
		mMainTv = (TextView) findViewById(R.id.frag_main);
		mCategoryIv = (ImageView) findViewById(R.id.frag_category_iv);
		mCategoryTv = (TextView) findViewById(R.id.frag_category);
		mShopcarIv = (ImageView) findViewById(R.id.frag_shopcar_iv);
		mShopcarTv = (TextView) findViewById(R.id.frag_shopcar);
		mMyJdIv = (ImageView) findViewById(R.id.frag_mine_iv);
		mMyJdTv = (TextView) findViewById(R.id.frag_mine);
	}

	@Override
	public void onClick(View v) {
		if (mCurrenTabId==v.getId()) {
			return;
		}
		mCurrenTabId=v.getId();
		defaultIndicator();
		if (mListener!=null) {
			mListener.onItemClicked(v.getId());
		}
		switch (v.getId()) {
			case R.id.frag_main_ll:
				mMainIv.setSelected(true);
				mMainTv.setSelected(true);
				break;
			case R.id.frag_category_ll:
				mCategoryIv.setSelected(true);
				mCategoryTv.setSelected(true);
				break;
			case R.id.frag_shopcar_ll:
				mShopcarIv.setSelected(true);
				mShopcarTv.setSelected(true);
				break;
			case R.id.frag_mine_ll:
				mMyJdIv.setSelected(true);
				mMyJdTv.setSelected(true);
				break;
		}
	}

	/**
	 * 初始化指示器
	 */
	private void defaultIndicator() {
		mMainIv.setSelected(false);
		mMainTv.setSelected(false);
		mCategoryIv.setSelected(false);
		mCategoryTv.setSelected(false);
		mShopcarIv.setSelected(false);
		mShopcarTv.setSelected(false);
		mMyJdIv.setSelected(false);
		mMyJdTv.setSelected(false);
	}

}
