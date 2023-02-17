package com.materialdesign.viewflipper;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private ViewFlipper view_flipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		view_flipper = findViewById(R.id.view_flipper);
		TextView textView = new TextView(this);
		textView.setText("Dynamically added TextView");
		textView.setGravity(Gravity.CENTER);
		view_flipper.addView(textView);
	}

	public void previousView(View v) {
		view_flipper.showPrevious();
	}

	public void nextView(View v) {
		view_flipper.showNext();
	}
}