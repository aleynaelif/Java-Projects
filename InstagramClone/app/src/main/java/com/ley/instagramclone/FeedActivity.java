package com.ley.instagramclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class FeedActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //initilize
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.add_post){
            //upload activity
            Intent intentToUpload = new Intent(FeedActivity.this,UploadActivity.class);
            startActivity(intentToUpload);
            //finish demedik çünkü kullanıcı yüklemekten vazgeçebilir
        }
        else if(item.getItemId()==R.id.sign_out){
            //signout

            auth.signOut();
            //listenera gerek yok kendisi çıkış yapacak
            Intent intentToMain =  new Intent(FeedActivity.this,FeedActivity.class);
            startActivity(intentToMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}