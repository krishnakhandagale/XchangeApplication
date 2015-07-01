package com.com.listadapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.krishnakhandagale.login.R;

import java.util.List;

/**
 * Created by krishna.khandagale on 6/8/2015.
 */
public class MenuListAdapter extends BaseAdapter {

    List<MenuModel> menus;
    Context context;
    public MenuListAdapter(Context context,List<MenuModel> menus){
        this.context=context;
        this.menus=menus;

    }
    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int position) {
        return menus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= LayoutInflater.from(context);
        convertView=inflater.inflate(R.layout.custommenulist,null);
        ImageView image= (ImageView) convertView.findViewById(R.id.image);
        TextView lable= (TextView)convertView.findViewById(R.id.lable);
        image.setImageResource(menus.get(position).getImgId());
        lable.setText(menus.get(position).getLable());

        return convertView;
    }
}
