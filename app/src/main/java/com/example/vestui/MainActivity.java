package com.example.vestui;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lui);


        SeekBar compressionSeekBar = findViewById(R.id.compressionLevelSeekBar);
        TextView compressionLevelText = findViewById(R.id.compressionLevelText);

        compressionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String levelDescription = "";
                switch (progress) {
                    case 0:
                        levelDescription = "No Compression";
                        break;
                    case 1:
                        levelDescription = "Low Compression";
                        break;
                    case 2:
                        levelDescription = "Medium Compression";
                        break;
                    case 3:
                        levelDescription = "High Compression";
                        break;
                }
                compressionLevelText.setText("Compression Level: " + levelDescription);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // add future code for the seekbar here.
    }
}
