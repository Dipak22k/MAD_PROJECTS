package com.example.mad_projects;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class  MainActivity4 extends AppCompatActivity {
    Button phoneCall,webBrowser,map,sms,email,shareto,backto;
    EditText userNumber,editTextMessage,editTextSubject,forEnail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        userNumber = findViewById(R.id.user);
        phoneCall = findViewById(R.id.call);
        webBrowser = findViewById(R.id.web);
        map = findViewById(R.id.Map);
        sms = findViewById(R.id.sms);
        email = findViewById(R.id.email);
        shareto = findViewById(R.id.Share);
        backto = findViewById(R.id.back);


        phoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = userNumber.getText().toString();
                if(!phoneNumber.isEmpty()){
                    Intent phoneNum = new Intent(Intent.ACTION_DIAL);
                    phoneNum.setData(Uri.parse("tel:"+phoneNumber));
                    startActivity(phoneNum);
                }
                else  {
                    Toast.makeText(MainActivity4.this, "Enter a Valid number", Toast.LENGTH_SHORT).show();
                }



            }
        });

        webBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = userNumber.getText().toString();
                if (url.isEmpty()) {

                    url = "https://www.google.com";
                } else {

                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url;
                    }
                }

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location =userNumber.getText().toString();
                if (location.isEmpty()) {

                    location = "Solapur, India";
                    Toast.makeText(MainActivity4.this, "Opening default location: Solapur", Toast.LENGTH_SHORT).show();
                }


                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(location));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(MainActivity4.this, "Google Maps not installed", Toast.LENGTH_SHORT).show();
                }
            }
        });



                sms.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String phoneNumber = userNumber.getText().toString();
                        if (phoneNumber.isEmpty()) {
                            Toast.makeText(MainActivity4.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Uri smsUri = Uri.parse("smsto:" + phoneNumber);
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, smsUri);
                        if (smsIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(smsIntent);
                        } else {
                            Toast.makeText(MainActivity4.this, "No SMS app found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                email.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String emailAddress = userNumber.getText().toString();

                        if(emailAddress.isEmpty()){
                            Toast.makeText(MainActivity4.this, "please enter an email address", Toast.LENGTH_SHORT).show();
                        }
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                        emailIntent.setData(Uri.parse("mailto:"+emailAddress));

                        if (emailIntent.resolveActivity(getPackageManager()) != null) {
                            startActivity(emailIntent);
                        } else {
                            Toast.makeText(MainActivity4.this, "No email app found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                shareto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent shareto = new Intent(Intent.ACTION_SEND);
                        shareto.putExtra(Intent.EXTRA_TEXT, "Hello ! I am Dipak Kongari.");
                        shareto.setType("text/plain");
                        startActivity(Intent.createChooser(shareto, "Choose an app"));
                    }
                });

                backto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent backToMAD_PROJECTS = new Intent(MainActivity4.this,secondActivity.class);
                        startActivity(backToMAD_PROJECTS);
                    }
                });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}