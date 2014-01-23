package com.lujianfei.androidradio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/*
版权所有：版权所有(C)2014，固派软件
文件名称：com.lujianfei.androidradio.LeftActivity.java
系统编号：
系统名称：android_radio_group_not_fragment
模块编号：
模块名称：
设计文档：
创建日期：2014-1-22 下午8:18:18
作 者：陆键霏
内容摘要：
类中的代码包括三个区段：类变量区、类属性区、类方法区。
文件调用:
 */
public class LeftActivity extends Activity {
	ListView listview; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.left);
		listview = (ListView)findViewById(R.id.listview);
		listview.setAdapter(new CouponAdpater());
	}
	public class CouponAdpater extends BaseAdapter {

		@Override
		public int getCount() {
			return 7;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = LeftActivity.this.getLayoutInflater().inflate(R.layout.left_item, null);
			}
			return convertView;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}


