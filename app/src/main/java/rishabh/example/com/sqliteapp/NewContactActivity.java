package rishabh.example.com.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewContactActivity extends AppCompatActivity {

    EditText name,email,mobile;
    UserDBHelper userDBHelper;
    Context context=this;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact_layout);
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        email=(EditText)findViewById(R.id.email);

    }

    public void addContact(View v){
        String contactname=name.getText().toString();
        String contactmobile=mobile.getText().toString();
        String contactemail=email.getText().toString();
        Toast.makeText(getBaseContext(),"data saved1", Toast.LENGTH_SHORT).show();
        userDBHelper=new UserDBHelper(context);
        sqLiteDatabase=userDBHelper.getWritableDatabase();
        userDBHelper.addInformation(contactname,contactmobile,contactemail,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"data saved", Toast.LENGTH_SHORT).show();
        userDBHelper.close();
    }
}
