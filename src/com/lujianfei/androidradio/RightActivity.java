package com.lujianfei.androidradio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/*
��Ȩ���У���Ȩ����(C)2014���������
�ļ����ƣ�com.lujianfei.androidradio.LeftActivity.java
ϵͳ��ţ�
ϵͳ���ƣ�android_radio_group_not_fragment
ģ���ţ�
ģ�����ƣ�
����ĵ���
�������ڣ�2014-1-22 ����8:18:18
�� �ߣ�½����
����ժҪ��
���еĴ�������������Σ���������������������෽������
�ļ�����:
 */
public class RightActivity extends Activity {
	ListView listview; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.right);
		listview = (ListView)findViewById(R.id.listview);
		listview.setAdapter(new CouponAdpater());
	}
	public class CouponAdpater extends BaseAdapter {

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = RightActivity.this.getLayoutInflater().inflate(R.layout.right_item, null);
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


