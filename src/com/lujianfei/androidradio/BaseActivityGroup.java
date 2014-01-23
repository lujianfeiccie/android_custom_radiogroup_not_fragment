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
版权所有：版权所有(C)2013，固派软件
文件名称：com.goopai.selfdrive.custom.AbstractMyActivityGroup.java
系统编号：
系统名称：SelfDrive
模块编号：
模块名称：
设计文档：
创建日期：2013-11-15 下午9:03:27
作 者：陆键霏
内容摘要：用于实现底部Tab效果
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
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

    //加载Activity的View容器，容器应该是ViewGroup的子类
    private ViewGroup container;
    
    private LocalActivityManager localActivityManager;
    
    /**
     * 加载Activity的View容器的id并不是固定的，将命名规则交给开发者
     * 开发者可以在布局文件中自定义其id，通过重写这个方法获得这个View容器的对象
     * @return
     */
    abstract protected ViewGroup getContainer();
    
    /**
     * 供实现类调用，根据导航按钮id初始化按钮
     * @param id
     */
    protected void initRadioBtn(int id){
        RadioButton btn = (RadioButton) findViewById(id);
        btn.setOnCheckedChangeListener(this);
    }
    
    /**
     * 开发者必须重写这个方法，来遍历并初始化所有的导航按钮
     */
    abstract protected void initRadioBtns();
    
    /**
     * 为启动Activity初始化Intent信息
     * @param cls
     * @return
     */
    private Intent initIntent(Class<?> cls){
        return new Intent(this, cls).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
    }
    
    /**
     * 供开发者在实现类中调用，能将Activity容器内的Activity移除，再将指定的某个Activity加入
     * @param activityName 加载的Activity在localActivityManager中的名字
     * @param activityClassTye    要加载Activity的类型
     */
    @SuppressWarnings("deprecation")
	protected void setContainerView(String activityName, Class<?> activityClassTye){
        if(null == localActivityManager){
            localActivityManager = getLocalActivityManager();
        }
        
        if(null == container){
            container = getContainer();
        }
        
        //移除内容部分全部的View
        container.removeAllViews();
        
//        Activity contentActivity = localActivityManager.getActivity(activityName);
//        if (null == contentActivity) {
//        	localActivityManager.startActivity(activityName, initIntent(activityClassTye));
//        }
        
        //加载Activity
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
		  * 设置为竖屏
		  */
		 if(getRequestedOrientation()!=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
		  setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		 }
	}
	
	/**
	 * 启用初始化,用于规范大家的方法命名
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
	 * 打开调试信息
	 * @param tag
	 * @param msg
	 */
	protected void print(String tag,String msg){
		if(canDebug() && LOG_TOGGLE){
			Log.d(tag, msg);
		}
	}
	/**
	 * 开启调试
	 */
	public abstract boolean canDebug();
}


