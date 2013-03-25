package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.d("main", "O hai we have started!");
		
		
		try {
			// Change font of header textview
			TextView headerTV = (TextView) findViewById(R.id.mainTextview);
			Typeface robotoThin = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light_0.ttf");
			headerTV.setTypeface(robotoThin);
			Log.d("main", "font set!");
			
			// Set button onclick
			Button go = (Button) findViewById(R.id.go);
			go.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					goButtonOnClick();
				}
			});
			Log.d("main", "button onclick set!");
			
		} catch (Exception e) {
			Log.d("main", "ERROR: " + e.getMessage(), e);
		} 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void goButtonOnClick() {
		try {
			// Get num values
			EditText num1Box = (EditText) findViewById(R.id.num1);
			EditText num2Box = (EditText) findViewById(R.id.num2);
			
			Double num1 = Double.valueOf(num1Box.getText().toString());
			Double num2 = Double.valueOf(num2Box.getText().toString());
			Double result = 0.0;
			
			// Get operator
			Spinner ops = (Spinner) findViewById(R.id.op);
			String op = ops.getSelectedItem().toString();
			
			Log.d("main", "num1: " + num1);
			Log.d("main", "num2: " + num2);
			Log.d("main", "Operator: " + op);
			
			// Calculate
			if (op.equals("+")) {
				result = num1 + num2;
			} else if (op.equals("-")) {
				result = num1 - num2;
			} else if (op.equals("x")) {
				result = num1 * num2;
			} else if (op.equals("/")) {
				result = num1 / num2;
			}
			
			// Truncate Double result
			String resultStr = new DecimalFormat("#.#########").format(result);
			
			Log.d("main", "resultNum: " + result);
			Log.d("main", "resultStr: " + resultStr);
			
			// Print result
			TextView main = (TextView) findViewById(R.id.mainTextview);
			main.setText(resultStr);
		} catch (Exception e) {
			Log.d("main", "ERROR: " + e.getMessage(), e);
		}
		
	}

}