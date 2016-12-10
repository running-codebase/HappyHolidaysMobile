package au.com.happyholidays.happyholidays;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class PinActivity extends AppCompatActivity {

    EditText pinEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        pinEditText = (EditText) findViewById(R.id.pinEditText);
        pinEditText.requestFocus();
        pinEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    Intent intent = new Intent(getApplicationContext(), ConfirmedPinActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }




}
