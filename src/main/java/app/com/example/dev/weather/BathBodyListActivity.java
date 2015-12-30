package app.com.example.dev.weather;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Dev on 12/26/2015.
 */
public class BathBodyListActivity extends AppCompatActivity {

    static final String[] bath = new String[] { "Aroma Therapeutic Blends", "Body Cleansing", "Massage Oils", "Young Skin" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_page_includer);
//        Toast.makeText(BathBodyListActivity.this, "CategoryListActivity", Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Bath & Body");
        toolbar.setTitleTextColor(Color.WHITE);

        ListView listView = (ListView)findViewById(R.id.lists);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(BathBodyListActivity.this, android.R.layout.simple_list_item_1,bath);
        listView.setAdapter(adapter);
    }
}
