package com.com.listadapters;

import com.example.krishnakhandagale.login.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by krishna.khandagale on 6/8/2015.
 */
public class MenuListCreator {

    int [] images ={R.drawable.mobiles,R.drawable.book,R.drawable.imac,R.drawable.vehicle,R.drawable.homeandfurniture,R.drawable.animals};
    String lable []={"Mobiles and Accessories","Books","Laptops and Computers","Vehicles","Homes and Furniture","Animals"};
    public List<MenuModel> getMenuList(){
        List<MenuModel> list= new ArrayList<MenuModel>();
        for(int i=0;i<images.length;i++){
            MenuModel model= new MenuModel();
            model.setImgId(images[i]);
            model.setLable(lable[i]);
            list.add(model);
        }
        return list;
    }

}
