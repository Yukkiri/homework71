package ru.puchkova.homework71;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sync).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                Intent intent = new Intent(Intent.ACTION_SYNC);
                LocalTime time = LocalTime.now();
                int intTime = time.getHour();
                if (intTime >= 6 && intTime < 14) {
                    intent.setData(Uri.parse("http://morning"));
                    toast = Toast.makeText(getApplicationContext(),
                            "Утро", Toast.LENGTH_SHORT);
                } else if (intTime >= 14 && intTime < 15) {
                    intent.setData(Uri.parse("http://afternoon"));
                    toast = Toast.makeText(getApplicationContext(),
                            "День", Toast.LENGTH_SHORT);
                } else {
                    intent.setData(Uri.parse("http://evening"));
                    toast = Toast.makeText(getApplicationContext(),
                            "Вечер", Toast.LENGTH_SHORT);
                }
                toast.show();
                startActivity(intent);
            }
        });
    }
}
