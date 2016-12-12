package au.com.happyholidays.happyholidays;

import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_UP) {

                    WebApi.dropPin(getApplicationContext(), Double.toString(Util.getLocation(getApplicationContext()).getLatitude()),
                            Double.toString(Util.getLocation(getApplicationContext()).getLongitude()),
                            Long.toString(System.currentTimeMillis()));

                    createAndShowCheckInDialog();
                }
                return false;
            }
        });

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(pinEditText, InputMethodManager.SHOW_IMPLICIT);
    }


    private void createAndShowCheckInDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Check In Complete");
        builder.setMessage("You have succesfully checked in. You will be alerted next time you need to check in.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
        // Create the AlertDialog object and return it
        AlertDialog dialog = builder.create();
        dialog.show();

        NotificationManager mNotificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
//        // mId allows you to update the notification later on.
        mNotificationManager.cancel(84026643);
    }

}
