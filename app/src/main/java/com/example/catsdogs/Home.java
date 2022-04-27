package com.example.catsdogs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Home extends AppCompatActivity {
    ImageButton imageButton1,imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Doggos and Cattos");

        imageButton1 = (ImageButton) findViewById(R.id.sayoribtn);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenDog();
            }
        });

        imageButton2 = (ImageButton) findViewById(R.id.yuribtn);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenCat();
            }
        });
    }

    public void OpenDog(){
        Intent intent = new Intent(this, Dog.class);
        startActivity(intent);
    }

    public void OpenCat(){
        Intent intent = new Intent(this, Cat.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.web, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.toWeb:
                Intent intent = new Intent(this, Web.class);
                startActivity(intent);
                return true;

            case R.id.toVideo:
                Intent intent2 = new Intent(this, Video.class);
                startActivity(intent2);
                return true;

            case R.id.exit:
                this.finishAffinity();
                System.exit(0);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
        System.exit(0);
        super.onBackPressed();
    }
}