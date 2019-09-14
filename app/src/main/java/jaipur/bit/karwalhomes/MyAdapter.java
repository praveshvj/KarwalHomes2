package jaipur.bit.karwalhomes;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SingleItem> singleItems;

    public MyAdapter(Context context, ArrayList<SingleItem> singleItems) {
        this.context = context;
        this.singleItems = singleItems;
    }

    @Override
    public int getCount() {
        return singleItems.size();
    }

    @Override
    public Object getItem(int position) {
        return singleItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=View.inflate(context,R.layout.singleitem,null);
        }

        ImageView imageView=convertView.findViewById(R.id.myimage);
        TextView textView=convertView.findViewById(R.id.rent);
        TextView textView3=convertView.findViewById(R.id.address);
        SingleItem singleItem=singleItems.get(position);

        imageView.setImageResource(singleItem.getImage());
        textView.setText("\u20B9"+singleItem.getRent());
        textView3.setText(singleItem.getAddress());

        return convertView;
    }
}
