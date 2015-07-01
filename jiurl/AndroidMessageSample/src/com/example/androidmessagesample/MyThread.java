package com.example.androidmessagesample;

import android.os.Handler;
import android.os.Message;

public class MyThread extends Thread {
	private boolean bExit;
	
	private Handler handler;
	private String name;
	public int i;

	public void Exit()
	{
		bExit = true;
	}
	
	public MyThread( Handler handler, int i, String name )
	{
		this.handler = handler;
		this.name = name;
		this.i = i;
		bExit = false;
	}
	
	public void run()
	{
		String str;
		Message msg;
		
		if( i==1 )
		{
			str = name+" "+"MY_MSG1 "+this.getId();
			msg = Message.obtain();
			msg.what = MainActivity.MY_MSG1;
			msg.arg1 = (int)this.getId();
			msg.obj = str;
			handler.sendMessage(msg);
		}
		
		if( i==2 )
		{
			str = name+" "+"MY_MSG2 "+this.getId();
			msg = Message.obtain();
			msg.what = MainActivity.MY_MSG2;
			msg.arg1 = (int)this.getId();
			msg.obj = str;
			handler.sendMessage(msg);
		}
		
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
