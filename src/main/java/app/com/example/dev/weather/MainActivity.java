package app.com.example.dev.weather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;


public class MainActivity extends AppCompatActivity {

/*
    Bitmap b;
    public void load() throws JSONException {
        UploadUtils utils = new UploadUtils();

        List<NameValuePair> lv = new ArrayList<>();
        lv.add(new BasicNameValuePair("product_id", "1"));

        JSONObject obj = utils.upload(lv, Constants.getImageDetails);

        String image = (String) obj.get("image");
        byte[] imgBytes = Base64.decode(image, Base64.DEFAULT);
        final Bitmap bmp = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
        b=bmp;
        //imageMap.put(utils.getUrl(), bmp);
        //loadImage(bmp, (ImageView) mapper.get(utils.getUrl()));
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ImageButton im = (ImageButton) findViewById(R.id.topSeller);
                im.setImageBitmap(bmp);
            }
        });
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);



/*        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    load();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/


//        Search item
        final TextView search = (TextView) findViewById(R.id.searchText);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                search.setText("");
            }
        });

//        category image icon onClick

        final ImageButton category = (ImageButton) findViewById(R.id.category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoryListActivity.class);
//                Intent intent = new Intent(MainActivity.this,ProductDetailPage.class);
                startActivity(intent);
            }
        });

//      top Seller image icon onclick

        final ImageButton topSeller = (ImageButton) findViewById(R.id.topSeller);
        topSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SellerListActivity.class);
                startActivity(intent);
            }
        });


        //        category image icon onClick

        final ImageButton bath_body = (ImageButton) findViewById(R.id.bath_body);
        bath_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BathBodyListActivity.class);
                startActivity(intent);
            }
        });


        //        category image icon onClick

        final ImageButton skin_care = (ImageButton) findViewById(R.id.skin_care);
        skin_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SkinCareListActivity.class);
                startActivity(intent);
            }
        });


        //        category image icon onClick

        final ImageButton supplement = (ImageButton) findViewById(R.id.suplement);
        supplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SupplementListActivity.class);
                startActivity(intent);
            }
        });


        //        category image icon onClick

        final ImageButton beverage = (ImageButton) findViewById(R.id.beverage);
        beverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BeverageListActivity.class);
                startActivity(intent);
            }
        });


        //        category image icon onClick

        final ImageButton food = (ImageButton) findViewById(R.id.food);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
                startActivity(intent);
            }
        });


        //        category image icon onClick

        final ImageButton spicy = (ImageButton) findViewById(R.id.spicy);
        spicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SpicyListActivity.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.doshatest:
                Intent doshatest = new Intent(MainActivity.this, DoshaTestActivity.class);
                startActivity(doshatest);
                return true;
            case R.id.healthtips:
                Intent healthtips = new Intent(MainActivity.this, HealthTipsActivity.class);
                startActivity(healthtips);
                return true;
            case R.id.doshacontrol:
                Intent intent = new Intent(MainActivity.this, DoshaControlActivity.class);
                startActivity(intent);
                return true;
            case R.id.consultation:
                Intent consultation = new Intent(MainActivity.this, OnlineConsultationActivity.class);
                startActivity(consultation);
                return true;
            case R.id.action_settings:
                Intent setting = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(setting);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
