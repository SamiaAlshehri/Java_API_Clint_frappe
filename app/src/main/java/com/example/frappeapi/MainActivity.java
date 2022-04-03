package com.example.frappeapi;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList<items> dataProduct;
    RecyclerView recyclerView;
    String getUrl ,Token,contentType;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclpro);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getUrl="https://restaurant.partner-cons.com//api/resource/Item";
        Token="token 335871b31ca841b:230980629872bfb";
        contentType="application/json";
        //initializing the productlist
        dataProduct = new ArrayList<>();
        getDatabtn();
    }

    /**
     * this function to get response from api
     */
    public void getDatabtn() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,getUrl
               , new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response)
                    {
                        //adaptr=new catogryadapter(getContext(),data);
                        JSONArray JA = null;
                        try {
                            //convert the string to json array object
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            Log.e(TAG, "onResponse3: " + String.valueOf(jsonArray));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                items modlproduct = new items();
                                try {
                                    JSONObject data = jsonArray.getJSONObject(i);
                                    Log.e(TAG, "onResponse11: "+jsonArray.length() );
                                    modlproduct.setItemname(data.getString("name"));
                                //    modlproduct.setDesc(data.getString("description"));
                                   // modlproduct.setImge(data.getString("image"));

                                    Log.e(TAG, "onResponse13: "+modlproduct );

                                    dataProduct.add(modlproduct);

                                } catch (JSONException ex) {
                                    ex.printStackTrace();
                                    Log.e(TAG, "onErrorResponseon3: "+ ex);
                                }
                            }

                            recyclerView.setAdapter(new Itemsadapter(MainActivity.this, dataProduct));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e(TAG, "onErrorResponseon2: "+ e);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "onErrorResponseon: "+ error);                    }
                }) {
    //        This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Authorization", Token);
                params.put("content-type", contentType);
                //Save API Secret: 230980629872bfb
                //api secrt : ***************
                return params;
            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> productMap = new HashMap< >();
                items product = new items();

                return productMap;
            }
        };
        // To prevent timeout error
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(50000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);

    }
}