package com.lujianfei.androidradio;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class MainActivity extends BaseActivityGroup {
	
	RadioButton tab1,tab2,tab3;
	 public static final String CONTENT_ACTIVITY_NAME_0 = "contentActivity0";
	 public static final String CONTENT_ACTIVITY_NAME_1 = "contentActivity";
	 public static final String CONTENT_ACTIVITY_NAME_2 = "contentActivity2";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		super.startInit();
	}

	@Override
	public void initView() {
		tab1 = (RadioButton)findViewById(R.id.tab1);
		tab2 = (RadioButton)findViewById(R.id.tab2);
		tab3 = (RadioButton)findViewById(R.id.tab3);
	}

	@Override
	public void initData() {
		setContainerView(CONTENT_ACTIVITY_NAME_1, MidActivity.class);
		tab2.setChecked(true);
	}

	@Override
	public void initEvent() {
	}
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
            switch (buttonView.getId()) {
            case R.id.tab1:{
            	setContainerView(CONTENT_ACTIVITY_NAME_0, LeftActivity.class);
            }
                break;
            case R.id.tab2:{
            	setContainerView(CONTENT_ACTIVITY_NAME_1, MidActivity.class);
            }
            	break;
            case R.id.tab3:{
            	setContainerView(CONTENT_ACTIVITY_NAME_2, RightActivity.class);
            }
                break;
            default:
                break;
            }
        }
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected ViewGroup getContainer() {
		return (ViewGroup) findViewById(R.id.container);
	}

	@Override
	protected void initRadioBtns() {
		initRadioBtn(R.id.tab1);
		initRadioBtn(R.id.tab2);
		initRadioBtn(R.id.tab3);
	}

	@Override
	public boolean canDebug() {
		return true;
	}
}
