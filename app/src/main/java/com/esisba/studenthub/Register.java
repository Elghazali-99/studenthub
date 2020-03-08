package com.esisba.studenthub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {
    Button signup;
    TextInputEditText editName, editEmail, editPassword,editcpassword;
    DatabaseHelper mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //--------------------iHaveAccountButton------------------------
        Button ihave;
       mydb = new DatabaseHelper(this);
        signup =  findViewById(R.id.SignUp);
        editName =  findViewById(R.id.usrIn);
        editEmail =  findViewById(R.id.email);
        editPassword =  findViewById(R.id.pswIn);
        editcpassword =  findViewById(R.id.repswIn);
        ihave =findViewById(R.id.ihave);

        ihave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--------------------Goback-------------------
                Intent rgt = new Intent(Register.this, LogIn.class);
                startActivity(rgt);
                finish();
                //----------------------------------------------------


            }
        });
       signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setEmail(editEmail.getText().toString());
                user.setName(editName.getText().toString());
                user.setPassword(editPassword.getText().toString());
                boolean isInserted = mydb.insertData(user);

                if (isInserted == true)
                    Toast.makeText(Register.this, "Data inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Register.this, "Data is not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

}
