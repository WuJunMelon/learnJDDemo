package com.m520it.jdmall03.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.m520it.jdmall03.R;
import com.m520it.jdmall03.fragment.CategoryFragment;
import com.m520it.jdmall03.fragment.HomeFragment;
import com.m520it.jdmall03.fragment.MyJDFragment;
import com.m520it.jdmall03.fragment.ShopCarFragment;
import com.m520it.jdmall03.listener.IButtonBarClickListener;
import com.m520it.jdmall03.ui.BottomBar;

public class MainActivity extends JDBaseActivity implements IButtonBarClickListener{

    private BottomBar mBottomBar;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

	@Override
	protected void initUI() {
		
		mBottomBar =(BottomBar) findViewById(R.id.bottom_bar);
		mBottomBar.setIButtonBarClickListener(this);
		showTopBar(new HomeFragment());
	}

	@Override
	public void onItemClicked(int tabItemId) {
		switch (tabItemId) {
			case R.id.frag_main_ll:
				showTopBar(new HomeFragment());
				break;
			case R.id.frag_category_ll:
				showTopBar(new CategoryFragment());
				break;
			case R.id.frag_shopcar_ll:
				showTopBar(new ShopCarFragment());
				break;
			case R.id.frag_mine_ll:
				showTopBar(new MyJDFragment());
				break;
		}
	}
	
	private void showTopBar(Fragment f){
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.replace(R.id.top_bar,f);
		transaction.commitAllowingStateLoss();
	}

}
