package io.shanefitzpatrick.hoverbug;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String ADD_CONTENT = "add_content";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_service).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DemoHoverMenuService.class);
                startService(i);
            }
        });

        findViewById(R.id.add_content).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DemoHoverMenuService.class);
                i.putExtra(ADD_CONTENT, true);
                startService(i);
            }
        });
    }
}
