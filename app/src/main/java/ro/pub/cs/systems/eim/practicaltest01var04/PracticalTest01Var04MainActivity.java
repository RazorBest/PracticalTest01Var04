package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        if (savedInstanceState != null) {
            ((TextView)findViewById(R.id.editText1)).setText(savedInstanceState.getString("text1"));
            ((TextView)findViewById(R.id.editText2)).setText(savedInstanceState.getString("text2"));
            ((CheckBox)findViewById(R.id.checkBox)).setSelected(savedInstanceState.getString("isChecked1").equals("true"));
            ((CheckBox)findViewById(R.id.checkBox2)).setSelected(savedInstanceState.getString("isChecked2").equals("true"));
        }



        Button nextActivityButton = (Button)findViewById(R.id.button);
        Button displayInfoButton = (Button)findViewById(R.id.button2);
        CheckBox checkbox1 = (CheckBox)findViewById(R.id.checkBox);
        CheckBox checkbox2 = (CheckBox)findViewById(R.id.checkBox2);

        EditText editText = (EditText)findViewById(R.id.editText1);
        EditText editText2 = (EditText)findViewById(R.id.editText2);

        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setVisibility(View.INVISIBLE);

        displayInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                Log.d("Test", "Clicked");
                if(checkbox1.isChecked()) {
                    if (editText.getText().toString().trim().isEmpty()) {
                        Log.d("Test", "Empty");
                        Toast.makeText(getApplicationContext(), "Please complete first text", Toast.LENGTH_LONG).show();
                        return;
                    }
                    text += editText.getText();
                }
                if(checkbox2.isChecked()) {
                    if (editText.getText().toString().trim().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "Please complete second text", Toast.LENGTH_LONG).show();
                        return;
                    }
                    text += editText2.getText();
                }
                // Set text view visible
                textView.setText(text);
                textView.setVisibility(View.VISIBLE);
            }
        });

        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), PracticalTest01Var04SecondaryActivity.class);
               intent.putExtra("text1", ((TextView)findViewById(R.id.editText1)).getText().toString());
               intent.putExtra("text2", ((TextView)findViewById(R.id.editText2)).getText().toString());
               startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("text1", ((TextView)findViewById(R.id.editText1)).getText().toString());
        outState.putString("text2", ((TextView)findViewById(R.id.editText2)).getText().toString());
        outState.putString("isChecked1", ((CheckBox)findViewById(R.id.checkBox)).isChecked() ? "true" : "false");
        outState.putString("isChecked2", ((CheckBox)findViewById(R.id.checkBox2)).isChecked() ? "true" : "false");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ((TextView)findViewById(R.id.editText1)).setText(savedInstanceState.getString("text1"));
        ((TextView)findViewById(R.id.editText2)).setText(savedInstanceState.getString("text2"));
        ((CheckBox)findViewById(R.id.checkBox)).setSelected(savedInstanceState.getString("isChecked1").equals("true"));
        ((CheckBox)findViewById(R.id.checkBox2)).setSelected(savedInstanceState.getString("isChecked2").equals("true"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getApplicationContext(), Integer.toString(resultCode), Toast.LENGTH_LONG).show();
    }
}