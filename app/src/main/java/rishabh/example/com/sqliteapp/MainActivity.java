package rishabh.example.com.sqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



    }

    public  void addContact(View v){
        Intent intent=new Intent(this,rishabh.example.com.sqliteapp.NewContactActivity.class);
        startActivity(intent);
    }

    public void viewContact(View v){
        Intent intent=new Intent(this,DataListActivity.class);
        startActivity(intent);
    }
}
