package jaipur.bit.karwalhomes;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login,register;
    private DatabaseReference mDatabase;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        init();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code to check user and then change the activity
                final String uemail =email.getText().toString().trim();
                final String upass =password.getText().toString().trim();
                mDatabase.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        boolean flag=false;
                        for(DataSnapshot usersnapshot:dataSnapshot.getChildren()){
                            User u=usersnapshot.getValue(User.class);
                            String email=u.getEmail();
                            String password=u.getPassword();
                            if(email.equals(uemail)&&password.equals(upass)){
                                flag=true;
                                break;
                            }
                        } if(flag){

                                  Intent intent=new Intent(Login.this,Homes.class);
                                  startActivity(intent);
                                  finish();
                        }else {
                            Toast.makeText(Login.this, "USER NOT FOUND", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(Login.this, "BLALALALLALALALALAL", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        email=findViewById(R.id.emailet);
        password=findViewById(R.id.passwordet);
        login=findViewById(R.id.loginbtn);
        register=findViewById(R.id.registerbtn);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabase.child("users").removeEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
