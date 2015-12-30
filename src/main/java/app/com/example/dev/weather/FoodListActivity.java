package app.com.example.dev.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Dev on 12/26/2015.
 */
public class FoodListActivity extends AppCompatActivity {
    static final String[] drinks = new String[] { "Basmati Rice", "Apple", "Salad","Daal" };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_page_includer);
//        Toast.makeText(FoodListActivity.this, "CategoryListActivity", Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Food");

        ListView listView = (ListView)findViewById(R.id.lists);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(FoodListActivity.this, android.R.layout.simple_list_item_1,drinks);
        listView.setAdapter(adapter);
    }
}
