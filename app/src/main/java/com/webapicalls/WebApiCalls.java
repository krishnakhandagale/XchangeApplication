package com.webapicalls;

import android.content.ContentValues;
import android.provider.Settings;
import android.util.Log;

import com.webapicalls.models.PostsModel;

import org.apache.http.client.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by krishna.khandagale on 6/10/2015.
 */
public class WebApiCalls {





            public boolean AdPost(PostsModel post) {
                try {
                    Log.d("LOGG", "WEb PI CAlls");
                    URL url = new URL(CallingUrls.adPostUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestMethod("POST");
                    ContentValues params= new ContentValues();
                    params.put("title",post.getTitle());
                    params.put("description",post.getDescription());
                    params.put("category",post.getCategory());
                    params.put("state",post.getState());
                    params.put("city",post.getCity());
                    params.put("locality",post.getLocality());
                    params.put("issell",post.getIsSell());
                    params.put("isexchange",post.getIsExchange());
                    params.put("preferreditem",post.getPreferredItem());

                    String queryParams= URLEncoder.encode("title","UTF-8")+"="+URLEncoder.encode(params.get("title").toString(),"UTF-8")+
                            "&"+ URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(params.get("description").toString(),"UTF-8")+
                            "&"+ URLEncoder.encode("category","UTF-8")+"="+URLEncoder.encode(params.get("category").toString(),"UTF-8")+
                            "&"+URLEncoder.encode("state","UTF-8")+"="+URLEncoder.encode(params.get("state").toString(),"UTF-8")+
                            "&"+URLEncoder.encode("city","UTF-8")+"="+URLEncoder.encode(params.get("city").toString(),"UTF-8")+
                            "&"+URLEncoder.encode("locality","UTF-8")+"="+URLEncoder.encode(params.get("locality").toString(),"UTF-8")+
                            "&"+URLEncoder.encode("issell","UTF-8")+"="+URLEncoder.encode(params.get("issell").toString(),"UTF-8")+
                            "&"+URLEncoder.encode("isexchange","UTF-8")+"="+URLEncoder.encode(params.get("isexchange").toString(),"UTF-8")+
                            "&"+URLEncoder.encode("preferredItem","UTF-8")+"="+URLEncoder.encode(params.get("preferreditem").toString(),"UTF-8");
                    OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
                    wr.write(queryParams);
                    wr.flush();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


                    if(reader.readLine().equals("true")){
                        return true;
                    }

                }catch (Exception e){
                    Log.d("LOGG",e.getMessage()+"");
                    e.printStackTrace();
                    return false;
                }
                return false;
            }



}
