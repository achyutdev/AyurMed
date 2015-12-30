package app.com.example.dev.weather;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Dev on 12/27/2015.
 */
public class MedProductListActivity extends AppCompatActivity {
    ListView listView;
    List<SingleCategoryDesc> items=new ArrayList<>();
    SingleCategoryAdapter adapter;
    String category="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        category=(String)getIntent().getBundleExtra("extras").get("category");
       // Toast.makeText(MedProductListActivity.this, category, Toast.LENGTH_LONG).show();

        setContentView(R.layout.list_view_page_includer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(category);
        toolbar.setTitleTextColor(Color.WHITE);
        listView = (ListView)findViewById(R.id.lists);

        loadItems();
    }

    private void loadItems() {
        MyAsyncProductDetailsLoader loader = new MyAsyncProductDetailsLoader();
        loader.execute();
    }

    private void renderListView() {
        System.out.println("RENDERRRRRRRRRRRRRRRRR");

        for(SingleCategoryDesc d: items) {
            System.out.println(d.toString());
        }

        adapter = new SingleCategoryAdapter(MedProductListActivity.this,
                R.layout.row_single_category,items, MedProductListActivity.this);
        listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new MyListClickListener());

        System.out.println("RENDERRRRRRRRRRRRRRRRR1111111111111111111111");
    }

    class MyListClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }

    class MyAsyncProductDetailsLoader extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            UploadUtils uploadUtils = new UploadUtils();
            List<NameValuePair> prms = new ArrayList<>();
            prms.add(new BasicNameValuePair("category", category));
            JSONObject objs = uploadUtils.upload(prms, Constants.getProductDetails);
            try {
                JSONArray array = objs.getJSONArray("products");
                //items = new ArrayList<>();
                for(int i=0;i<array.length();i++) {
                    System.out.println(array.get(i).toString());
                    JSONObject obj = (JSONObject)array.get(i);
                    SingleCategoryDesc d = new SingleCategoryDesc();
                    d.setItemId(Long.parseLong(obj.getString("product_id")));
                    d.setTitle((String) obj.get("product_name"));
                    d.setDesc(URLDecoder.decode(((String) obj.get("product_description")),"UTF-8"));
                    d.setNumStars(new Random().nextInt(5)+"");
                    d.setNumCustReviews("10");
                    d.setImgId("1");

                    items.add(d);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    renderListView();
                }
            });

        }
    }
}
