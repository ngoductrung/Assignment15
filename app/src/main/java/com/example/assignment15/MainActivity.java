package com.example.assignment15;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    List<ItemModel> items = new ArrayList<>();
    public static BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        LinearLayout listItems = findViewById(R.id.list_item);
        ItemModel item;
        View view;
        for(int i = 0; i< items.size(); i++){
            item = items.get(i);
            view = LayoutInflater.from(this).inflate(R.layout.items_list_layout, null);

            ImageView image = view.findViewById(R.id.imageView);
            TextView name = view.findViewById(R.id.username_text);
            TextView email = view.findViewById(R.id.gmail_text);

//            image.setImageDrawable(item.getAvatar());
            email.setText(item.getGmail());
            name.setText(item.getUsername());
            listItems.addView((view));
        }
        listItems.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                

            }
        });





    }
    public class GetTask extends AsyncTask<Void,Void,Boolean>{
        @Override
        protected Boolean doInBackground(Void... voids) {
            try{
                URL url = new URL("https://lebavui.github.io/jsons/users.json");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null)
                    builder.append(line);
                String responseBody = builder.toString();
                return true;
            }catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
//    public static ItemModel readJSON(Context context) throws IOException, JSONException{
//        JSONObject jsonRoot = new JSONObject((Map) reader);
//        int id = jsonRoot.getInt("id");
//        while (id != null) {
//            String name = jsonRoot.getString("name");
//            String username = jsonRoot.getString("username");
//            String email = jsonRoot.getString("email");
//            Image avatar =
//        }
//    }
}