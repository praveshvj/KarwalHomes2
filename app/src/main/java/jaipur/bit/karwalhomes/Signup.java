package jaipur.bit.karwalhomes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    private EditText nameet;
    private EditText emailet;
    private EditText phoneet;
    private EditText passwordet;
    private Button registerbtn;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        init();
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name,email,phone,password;
                name=nameet.getText().toString().trim();
                email=emailet.getText().toString().trim();
                phone=phoneet.getText().toString().trim();
                password=passwordet.getText().toString().trim();
                if(name.isEmpty()||email.isEmpty()||phone.isEmpty()||password.isEmpty()){
                    Toast.makeText(Signup.this, "Fields can't be Empty", Toast.LENGTH_LONG).show();
                }else{
                    User u=new User();
                    u.setName(name);
                    u.setEmail(email);
                    u.setPhone(phone);
                    u.setPassword(password);
                    mDatabase.child("users").push().setValue(u);
                    //code to store user in firebase
                    Intent intent=new Intent(Signup.this,Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void init() {
        nameet=findViewById(R.id.nameet1);
        emailet=findViewById(R.id.emailet);
        phoneet=findViewById(R.id.phoneet1);
        passwordet=findViewById(R.id.passwordet);
        registerbtn=findViewById(R.id.registerbtn);
    }
}

