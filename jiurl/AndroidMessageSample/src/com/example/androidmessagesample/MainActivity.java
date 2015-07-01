package com.example.androidmessagesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	public static final int MY_MSG1 = 1;
	public static final int MY_MSG2 = 2;
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private TextView text1;
	private TextView text2;
	
	private Handler handler;
	
	private MyThread thread1;
	private MyThread thread2;
	private long thread1Id;
	private long thread2Id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		handler = new Handler()
		{
			public void handleMessage(Message msg)
			{
				String str;
				
				switch( msg.what )
				{
				case MY_MSG1:
				{
					str = (String) msg.obj;
					
					if( (long)msg.arg1==thread1Id)
					{
						str = str+" from thread 1";
					}
					
					if( (long)msg.arg1==thread2Id)
					{
						str = str+" from thread 2";
					}
					
					text1.setText(str);
				}
				break;
				
				case MY_MSG2:
				{
					str = (String) msg.obj;
					
					if( (long)msg.arg1==thread1Id)
					{
						str = str+" from thread 1";
					}
					
					if( (long)msg.arg1==thread2Id)
					{
						str = str+" from thread 2";
					}
					
					text2.setText(str);
				}
				break;
				
				default:
					super.handleMessage(msg);
					break;
				}
			}
		};
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		text1 = (TextView)findViewById(R.id.textView1);
		text2 = (TextView)findViewById(R.id.textView2);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch( v.getId() )
		{
		case R.id.button1:
			{
				thread1 = new MyThread(handler, 1, "thread1");
				thread1Id = thread1.getId();
				thread1.start();
			}
			break;
		
		case R.id.button2:
			{
				thread1 = new MyThread(handler, 2, "thread1");
				thread1Id = thread1.getId();
				thread1.start();
			}
			break;
			
		case R.id.button3:
			{
				thread2 = new MyThread(handler, 1, "thread2");
				thread2Id = thread2.getId();
				thread2.start();
			}
			break;
			
		case R.id.button4:
			{
				thread2 = new MyThread(handler, 2, "thread2");
				thread2Id = thread2.getId();
				thread2.start();
			}
			break;
			
		default:
			break;
		}
	}
}
