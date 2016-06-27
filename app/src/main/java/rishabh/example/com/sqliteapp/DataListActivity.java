package rishabh.example.com.sqliteapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DataListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDBHelper userDBHelper;
    Cursor cursor;
    ListDataAdaptor listDataAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
        listView=(ListView)findViewById(R.id.listview);

        //to retrieve table
        userDBHelper=new UserDBHelper(getApplicationContext());
        sqLiteDatabase=userDBHelper.getReadableDatabase();
        cursor=userDBHelper.getInformation(sqLiteDatabase);


        listDataAdaptor=new ListDataAdaptor(getApplicationContext(),R.layout.raw_layout);
        listView.setAdapter(listDataAdaptor);

       //retrieving every record from cursor
        if(cursor.moveToFirst()){
            do{
                String name,mob,email;
                name=cursor.getString(0);
                mob=cursor.getString(1);
                email=cursor.getString(2);
                DataProvider dataProvider=new DataProvider(name,mob,email);


                listDataAdaptor.add(dataProvider);

            }while (cursor.moveToNext());
        }
    }

}
