package com.example.rohithkumar.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_register);
    }
    public void Register(View V)
    {
        EditText FullName = (EditText) findViewById (R.id.editText_Uname);
        EditText Email = (EditText) findViewById (R.id.editText_email);
        EditText Password = (EditText) findViewById (R.id.editText_Pwd);
        CheckBox Check1 =(CheckBox) findViewById (R.id.checkBox_terms);

        String SfullName = FullName.getText ().toString ();
        String SEmail = Email.getText ().toString ();
        String Spassword = Password.getText ().toString ();

        if (SfullName.isEmpty () || SEmail.isEmpty () || Spassword.isEmpty ())
        {
            Toast.makeText (getApplicationContext (),"Please fill the details",Toast.LENGTH_SHORT).show ();
        }
        else if (!Check1.isChecked ())
        {
            Toast.makeText (getApplicationContext (),"Please accept the terms and conditions",Toast.LENGTH_SHORT).show ();
        }
        else
        {
            Intent Redirect = new Intent(RegisterActivity.this,MainActivity.class);
            startActivity (Redirect);
        }

    }

}