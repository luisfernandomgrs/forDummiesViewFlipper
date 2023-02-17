package com.materialdesign.viewflipper;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

	private ViewFlipper viewFlipper;
	private FloatingActionButton fabStartFlipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewFlipper = findViewById(R.id.view_flipper);
		TextView textView = new TextView(this);
		textView.setText("Dynamically added TextView");
		textView.setGravity(Gravity.CENTER);
		viewFlipper.addView(textView);

		viewFlipper.setFlipInterval(2000);
		viewFlipper.startFlipping();

		fabStartFlipper = findViewById(R.id.fabStartFlipper);
		fabStartFlipper.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				viewFlipper.setDisplayedChild(0);
			}
		});
	}

	public void previousView(View v) {
		viewFlipper.setInAnimation(this, R.anim.slide_in_right);
		viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
		viewFlipper.showPrevious();
	}

	public void nextView(View v) {
		viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
		viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
		viewFlipper.showNext();
	}
}