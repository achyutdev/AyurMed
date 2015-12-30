package app.com.example.dev.weather;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dev on 12/27/2015.
 */
public class ProductDetailPage extends AppCompatActivity {

    SingleCategoryDesc item;
    String medName,medDescripetion;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        item = (SingleCategoryDesc)getIntent().getBundleExtra("extras").get("item");
//        Toast.makeText(ProductDetailPage.this, item.getTitle()+", "+item.getDesc(), Toast.LENGTH_LONG).show();

        setContentView(R.layout.detail_page_includer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);

       // Toast.makeText(getApplicationContext(), "Detail page", Toast.LENGTH_SHORT).show();

        final TextView medName = (TextView) findViewById(R.id.medNametextView);
        medName.setText(item.getTitle());

        final TextView medDescription = (TextView) findViewById(R.id.medDescriptionTextView);
        medDescription.setText(item.getDesc());


    }
}
