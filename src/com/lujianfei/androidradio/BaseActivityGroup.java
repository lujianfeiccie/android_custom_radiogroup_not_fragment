package com.lujianfei.androidradio;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
/*
��Ȩ���У���Ȩ����(C)2013���������
�ļ����ƣ�com.goopai.selfdrive.custom.AbstractMyActivityGroup.java
ϵͳ��ţ�
ϵͳ���ƣ�SelfDrive
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2013-11-15 ����9:03:27
�� �ߣ�½����
����ժҪ������ʵ�ֵײ�TabЧ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public abstract class BaseActivityGroup extends ActivityGroup implements
CompoundButton.OnCheckedChangeListener{
    
	public static boolean LOG_TOGGLE= true;
	
	public class FirstContainerObj{
		public String activityName;
		public Class<?> activityClassTye;
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    //����Activity��View����������Ӧ����ViewGroup������
    private ViewGroup container;
    
    private LocalActivityManager localActivityManager;
    
    /**
     * ����Activity��View������id�����ǹ̶��ģ����������򽻸�������
     * �����߿����ڲ����ļ����Զ�����id��ͨ����д�������������View�����Ķ���
     * @return
     */
    abstract protected ViewGroup getContainer();
    
    /**
     * ��ʵ������ã����ݵ�����ťid��ʼ����ť
     * @param id
     */
    protected void initRadioBtn(int id){
        RadioButton btn = (RadioButton) findViewById(id);
        btn.setOnCheckedChangeListener(this);
    }
    
    /**
     * �����߱�����д�������������������ʼ�����еĵ�����ť
     */
    abstract protected void initRadioBtns();
    
    /**
     * Ϊ����Activity��ʼ��Intent��Ϣ
     * @param cls
     * @return
     */
    private Intent initIntent(Class<?> cls){
        return new Intent(this, cls).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    }
    
    /**
     * ����������ʵ�����е��ã��ܽ�Activity�����ڵ�Activity�Ƴ����ٽ�ָ����ĳ��Activity����
     * @param activityName ���ص�Activity��localActivityManager�е�����
     * @param activityClassTye    Ҫ����Activity������
     */
    @SuppressWarnings("deprecation")
	protected void setContainerView(String activityName, Class<?> activityClassTye){
        if(null == localActivityManager){
            localActivityManager = getLocalActivityManager();
        }
        
        if(null == container){
            container = getContainer();
        }
        
        //�Ƴ����ݲ���ȫ����View
        container.removeAllViews();
        
//        Activity contentActivity = localActivityManager.getActivity(activityName);
//        if (null == contentActivity) {
//        	localActivityManager.startActivity(activityName, initIntent(activityClassTye));
//        }
        
        //����Activity
//        container.addView(
//                localActivityManager.getActivity(activityName)
//                        .getWindow().getDecorView(),
//                new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,
//                        LayoutParams.FILL_PARENT));
        container.addView(localActivityManager.startActivity(activityName, initIntent(activityClassTye)).getDecorView());
       
        
//        if(activityName.equals(MainActivity.CONTENT_ACTIVITY_NAME_0)){
////        	localActivityManager.dispatchPause(isFinishing());
//        	localActivityManager.dispatchStop();
//        	localActivityManager.dispatchResume();
//        	
//        }else if(activityName.equals(MainActivity.CONTENT_ACTIVITY_NAME_1)){
////        	localActivityManager.dispatchPause(isFinishing());
//        	localActivityManager.dispatchStop();
//        	localActivityManager.dispatchResume();
//        }else if(activityName.equals(MainActivity.CONTENT_ACTIVITY_NAME_2)){
////        	localActivityManager.dispatchPause(isFinishing());
//        	localActivityManager.dispatchStop();
//        	localActivityManager.dispatchResume();
//        }
    }

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		/**
		  * ����Ϊ����
		  */
		 if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
		  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 }
	}
	
	/**
	 * ���ó�ʼ��,���ڹ淶��ҵķ�������
	 */
    protected void startInit(){
    	initView();
		initData();
		initEvent();
    	initRadioBtns();
    }	
	public abstract void initView();
	public abstract void initData();
	public abstract void initEvent();
	
	/**
	 * �򿪵�����Ϣ
	 * @param tag
	 * @param msg
	 */
	protected void print(String tag,String msg){
		if(canDebug() && LOG_TOGGLE){
			Log.d(tag, msg);
		}
	}
	/**
	 * ��������
	 */
	public abstract boolean canDebug();
}


