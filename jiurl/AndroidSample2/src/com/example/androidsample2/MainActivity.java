package com.example.androidsample2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	private Button button1;
	private EditText text1;
	private EditText text2;
	
	private int nPasswordLength;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button)findViewById(R.id.button1);
		text1 = (EditText)findViewById(R.id.editText1);
		text2 = (EditText)findViewById(R.id.editText2);
		
		button1.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch( v.getId() )
		{
		case R.id.button1:
			{
				String strText;
				strText = this.text1.getText().toString();
				nPasswordLength = Integer.valueOf(strText);
				
				// generate nPass passwords one time to choose
				final int nPass = 10;
				RandomPassword[] rndpass = new RandomPassword[nPass];
				
				int i;
				for(i=0; i<nPass; i++)
				{
					rndpass[i] = new RandomPassword(nPasswordLength);
				}
				
				// display the results
				/*
				for(i=0; i<nPass; i++)
				{
					Log.d("onClick", rndpass[i].GetRandomPassword());
				}
				//*/
				
				String strText2="";
				for(i=0; i<nPass; i++)
				{
					strText2 = strText2 + rndpass[i].GetRandomPassword() + "\n";
				}
				this.text2.setText( strText2 );
			}
			break;
			
		default:
			break;
		}
	}
}
