/**
 * Created by RohithKumar on 2/15/2017.
 */

package com.example.rohithkumar.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        Button button= (Button) findViewById(R.id.button_Signin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText UserName = (EditText) findViewById(R.id.editText_Uname);
                EditText Password = (EditText) findViewById(R.id.editText_email);
                String S_username = UserName.getText().toString();
                String S_pwd = Password.getText().toString();
               if (S_username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter User Name", Toast.LENGTH_SHORT).show();
                } else if (S_pwd.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
                } else if (!S_username.equals("LAB4")) {
                    Toast.makeText(getApplicationContext(), "Invalid UserName", Toast.LENGTH_SHORT).show();
                } else if (!S_pwd.equals("LAB4")) {
                    Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                } else {
                   Intent redirect1 = new Intent("com.example.rohithkumar.myfirstapplication.HomeActivity");
                   startActivity(redirect1);
               }
            }
        });
    }

    public void Register(View V) {
        Intent Redirect = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(Redirect);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
