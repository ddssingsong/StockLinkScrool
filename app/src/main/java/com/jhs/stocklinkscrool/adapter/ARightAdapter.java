package com.jhs.stocklinkscrool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jhs.stocklinkscrool.R;
import com.jhs.stocklinkscrool.Stock;

import java.util.List;

public class ARightAdapter extends BaseAdapter {
    private Context context;
    List<Stock> list;


    public ARightAdapter(Context context, List<Stock> models) {
        super();
        this.context = context;
        this.list = models;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold;
        if (convertView == null) {
            viewHold = new ViewHold();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_right_item_a, parent,false);
            viewHold.textView1 = (TextView) convertView.findViewById(R.id.right_item_textview0);
            viewHold.textView2 = (TextView) convertView.findViewById(R.id.right_item_textview1);
            viewHold.textView3 = (TextView) convertView.findViewById(R.id.right_item_textview2);
            viewHold.textView4 = (TextView) convertView.findViewById(R.id.right_item_textview3);
            viewHold.textView5 = (TextView) convertView.findViewById(R.id.right_item_textview4);
            viewHold.textView6 = (TextView) convertView.findViewById(R.id.right_item_textview5);
            viewHold.textView7 = (TextView) convertView.findViewById(R.id.right_item_textview6);
            convertView.setTag(viewHold);
        } else {
            viewHold = (ViewHold) convertView.getTag();
        }
        Stock stock = (Stock) getItem(position);
        viewHold.textView1.setText(stock.getTxt1());
        viewHold.textView2.setText(stock.getTxt2());
        viewHold.textView3.setText(stock.getTxt3());
        viewHold.textView4.setText(stock.getTxt4());
        viewHold.textView5.setText(stock.getTxt5());
        viewHold.textView6.setText(stock.getTxt6());
        viewHold.textView7.setText(stock.getTxt7());



        return convertView;
    }

    static class ViewHold {

        TextView  textView1, textView2, textView3, textView4, textView5, textView6,textView7;

    }

}
