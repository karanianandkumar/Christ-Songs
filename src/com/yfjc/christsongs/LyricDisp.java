package com.yfjc.christsongs;

import java.util.Locale;



import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class LyricDisp extends Activity {

	TextView tv;
	String s[]={};
	
	Configuration config;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lyric_display);
		int size=(int) getResources().getDimension(R.dimen.font_size);
		Log.d("Font Size",""+size);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
		 Intent intent = getIntent();
		    
		    String fName = intent.getStringExtra("pos");
		    
		    int result=Integer.parseInt(fName);
		 Locale locale = new Locale("te");
	        Locale.setDefault(locale);
	        config = new Configuration();
	        config.locale = locale;
	        getBaseContext().getResources().updateConfiguration(config,
	                getBaseContext().getResources().getDisplayMetrics());
		
	        
		tv=(TextView)findViewById(R.id.textView1);
		Resources res=getResources();
		s=res.getStringArray( R.array.lyrics);
		tv.setText(s[result]);
		Typeface mfont=Typeface.createFromAsset(getAssets(), "fonts/Mallanna.ttf");
		tv.setTypeface(mfont,Typeface.BOLD);
		
	}
}



