package com.userprofile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.com.listadapters.MenuListAdapter;
import com.com.listadapters.MenuListCreator;
import com.com.listadapters.MenuModel;
import com.example.krishnakhandagale.login.R;
import com.postAd.PostAdActivity;

import java.util.List;

import static android.support.v7.app.ActionBar.DISPLAY_SHOW_CUSTOM;

public class UserProfileActivity extends AppCompatActivity {
    DrawerLayout categoriesDrawerLayout;
    ListView categoryList;
   ImageButton menuBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        /*menuBtn= (ImageButton) findViewById(R.id.slidingmenucategories);*/
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        getSupportActionBar().setDisplayOptions(DISPLAY_SHOW_CUSTOM);
        View v = getSupportActionBar().getCustomView();
       /* getSupportActionBar().setBackgroundDrawable(new ColorDrawable(R.color.blue));*/
        menuBtn = (ImageButton) v.findViewById(R.id.slidingmenucategories);

       menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(categoriesDrawerLayout.isDrawerOpen(categoryList)){
                    categoriesDrawerLayout.closeDrawer(categoryList);
                }
                else{
                    categoriesDrawerLayout.openDrawer(categoryList);
                }
            }
        });
        categoriesDrawerLayout= (DrawerLayout) findViewById(R.id.categoriesDrawer);
        categoryList= (ListView)findViewById(R.id.categoriesList);
        MenuListCreator listcreater= new MenuListCreator();
        List<MenuModel> menuList= listcreater.getMenuList();
        MenuListAdapter adapter= new MenuListAdapter(this,menuList);
        categoryList.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if(id==R.id.post_ad){
            Intent i= new Intent(this, PostAdActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
