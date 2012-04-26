package com.orbotix.collisions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.CheckBox;
import android.widget.TextView;
import orbotix.robot.app.StartupActivity;
import orbotix.robot.base.RobotProvider;

public class CollisionsActivity extends Activity {
	
	private static final int STARTUP_ACTIVITY_RESULTS = 0;
	
	private TextView mAccelXValueLabel;
	private TextView mAccelYValueLabel;
	private TextView mAccelZValueLabel;
	private CheckBox mXAxisCheckBox;
	private CheckBox mYAxisCheckBox;
	private TextView mPowerXValueLabel;
	private TextView mPowerYValueLabel;
	private TextView mSpeedValueLabel;
	private TextView mTimestampLabel;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //initialize value labels
       mAccelXValueLabel = (TextView)findViewById(R.id.accel_x_value);
       mAccelXValueLabel.setText("0.0");
       
       mAccelYValueLabel = (TextView)findViewById(R.id.accel_y_value);
       mAccelYValueLabel.setText("0.0");
       
       mAccelZValueLabel = (TextView)findViewById(R.id.accel_z_value);
       mAccelZValueLabel.setText("0.0");
       
       mXAxisCheckBox = (CheckBox)findViewById(R.id.axis_x_checkbox);
       mXAxisCheckBox.setChecked(false);
       
       mYAxisCheckBox = (CheckBox)findViewById(R.id.axis_y_checkbox);
       mYAxisCheckBox.setChecked(false);
       
       mPowerXValueLabel = (TextView)findViewById(R.id.power_x_value);
       mPowerXValueLabel.setText("0.0");
       
       mPowerYValueLabel = (TextView)findViewById(R.id.power_y_value);
       mPowerYValueLabel.setText("0.0");
       
       mSpeedValueLabel = (TextView)findViewById(R.id.speed_value);
       mSpeedValueLabel.setText("0.0");
       
       mTimestampLabel = (TextView)findViewById(R.id.time_stamp_value);
       mTimestampLabel.setText(SystemClock.uptimeMillis() + " ms");
    }
    
    @Override
    protected void onStart() {
    	super.onStart();
    	
    	Intent intent = new Intent(this, StartupActivity.class);
    	startActivityForResult(intent, STARTUP_ACTIVITY_RESULTS);
    }
    
    @Override
    protected void onStop() {
    	super.onStop();
    	
    	// Disconnect from the robot.
    	RobotProvider.getDefaultProvider().removeAllControls();
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	if (requestCode == STARTUP_ACTIVITY_RESULTS && resultCode == Activity.RESULT_OK) {
    		
    	}
    	
    }
}