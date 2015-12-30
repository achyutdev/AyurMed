package app.com.example.dev.weather;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;

/**
 * Created by Dev on 12/26/2015.
 */
public class CategoryListActivity extends AppCompatActivity
                            implements ListView.OnItemClickListener {
    static final String[] FRUITS = new String[] { "digestion", "Allergen Defense", "Dexon",
            "Mine and Memory", "Sleep" };

    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_page_includer);
//        Toast.makeText(CategoryListActivity.this,"CategoryListActivity", Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Catagory");
        toolbar.setTitleTextColor(Color.WHITE);

        listView = (ListView)findViewById(R.id.lists);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(CategoryListActivity.this, android.R.layout.simple_list_item_1,FRUITS);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(CategoryListActivity.this, MedProductListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("category",FRUITS[position]);
        intent.putExtra("extras", bundle);
        startActivity(intent);
    }
}
