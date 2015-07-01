package com.postAd;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.test.ActivityTestCase;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.krishnakhandagale.login.R;
import com.webapicalls.WebApiCalls;
import com.webapicalls.models.PostsModel;

public class PostAdActivity extends Activity {

    Button submitAd;
    EditText title,description,city,locality,category,pereferedExchangeItem;
    RadioButton isExchange,isSell;
    LinearLayout dynamicAttr;
    PostsModel post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ad);
        dynamicAttr= (LinearLayout) findViewById(R.id.dynamicAttributes);
        isExchange= (RadioButton) findViewById(R.id.isExchange);
        isSell=(RadioButton)findViewById(R.id.isSell);
        title= (EditText) findViewById(R.id.adTitle);
        description= (EditText) findViewById(R.id.adDescription);
        city= (EditText) findViewById(R.id.adCity);
        locality= (EditText) findViewById(R.id.adLocality);
        submitAd= (Button) findViewById(R.id.submitAdButton);
        category= (EditText) findViewById(R.id.adCategory);
        pereferedExchangeItem= (EditText) findViewById(R.id.preferredExchangeItem);
        submitAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(areAllFieldsValid()){
                    //Call web api  here to post the ad and save that into databas
                    Log.d("LOG","Submit" );
                    post= new PostsModel();
                    post.setTitle(title.getText().toString());
                    post.setDescription(description.getText().toString());
                    post.setCategory(category.getText().toString());
                    post.setState("Dummy");
                    post.setCity(city.getText().toString());
                    post.setLocality(locality.getText().toString());
                    if(isExchange.isChecked()){
                        post.setIsExchange(1);
                        post.setPreferredItem(post.getPreferredItem());
                    }else{
                        post.setIsExchange(0);
                        post.setPreferredItem("");
                    }
                     if(isSell.isChecked()){
                        post.setIsSell(1);
                    }
                    else{
                         post.setIsSell(0);
                     }
                    new postAdAyncTask().execute("");
                }
            }
        });


        isExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dynamicAttr.getVisibility()==View.GONE){

                    dynamicAttr.setVisibility(View.VISIBLE);
                }
                else{
                    dynamicAttr.setVisibility(View.GONE);
                }
            }
        });
        isSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dynamicAttr.getVisibility()==View.VISIBLE){

                    dynamicAttr.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    private boolean areAllFieldsValid() {

        String ad_title=title.getText().toString();
        String ad_description=description.getText().toString();
        String ad_category= category.getText().toString();
        String ad_city=city.getText().toString();
        String ad_locality= locality.getText().toString();
        boolean ad_isSell= isSell.isChecked();
        boolean ad_isExchange=isExchange.isChecked();
        String ad_prefered_exchange= pereferedExchangeItem.getText().toString();
        if(ad_title==null ||ad_title.trim().isEmpty()){
            title.setError("Please enter title.");
            return false;
        }
        else if(ad_description==null||ad_description.trim().isEmpty()){
            description.setError("Please enter description.");
            return false;
        }
        else if(ad_category==null ||ad_description.trim().isEmpty()){
            category.setError("Please select category");
            return false;
        }
        else if(ad_city==null ||ad_city.trim().isEmpty()){
            city.setError("Please select city");
            return false;
        }
        else if(ad_locality==null||ad_locality.trim().isEmpty()){
            locality.setError("Please select locality");
            return false;
        }
        else if(ad_isExchange==false &&ad_isSell==false){
            Toast.makeText(PostAdActivity.this,"Please select any of the option.",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(ad_isExchange==true&&(ad_prefered_exchange.trim().isEmpty()||ad_prefered_exchange==null)){
            pereferedExchangeItem.setError("Please enter preferred exchange item");
            return false;
        }
        return true;
    }



    class postAdAyncTask  extends AsyncTask<String,Void,String>{




        @Override
        protected String doInBackground(String... params) {
            WebApiCalls call= new WebApiCalls();
            Log.d("LOG","doInBackground" );
            boolean result=call.AdPost(post);
            Log.d("LOG","doInBackground"+result );
            if(result==true){
                return "true";
            }
            return "false";
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(PostAdActivity.this,s,Toast.LENGTH_LONG).show();
        }
    }


}
