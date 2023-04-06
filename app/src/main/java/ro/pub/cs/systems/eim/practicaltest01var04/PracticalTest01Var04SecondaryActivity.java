package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        Intent intent = getIntent();

        String text1 = intent.getExtras().getString("text1");
        String text2 = intent.getExtras().getString("text2");

        TextView textView1 = (TextView)findViewById(R.id.textView2);
        TextView textView2 = (TextView)findViewById(R.id.textView3);

        textView1.setText(text1);
        textView2.setText(text2);

        Button ok = (Button)findViewById(R.id.button3);
        Button cancel = (Button)findViewById(R.id.button4);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, new Intent());
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, new Intent());
                finish();
            }
        });
    }
}