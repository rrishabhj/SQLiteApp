package rishabh.example.com.sqliteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jindal on 6/27/2016.
 */
public class ListDataAdaptor extends ArrayAdapter {
    List list=new ArrayList();
    public ListDataAdaptor(Context context, int resource) {
        super(context, resource);


    }

    static class LayoutHandler{
        TextView NAME,MOB,EMAIL;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.raw_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.NAME=(TextView)row.findViewById(R.id.listVIewName);
            layoutHandler.MOB=(TextView)row.findViewById(R.id.listViewMob);
            layoutHandler.EMAIL=(TextView)row.findViewById(R.id.listViewEmail);

            row.setTag(layoutHandler);
        }else{
            layoutHandler=(LayoutHandler)row.getTag();

        }
        DataProvider dataProvider=(DataProvider)this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.MOB.setText(dataProvider.getMobile());
        layoutHandler.EMAIL.setText(dataProvider.getEmail());


        return row;
    }
}
