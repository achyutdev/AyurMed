package app.com.example.dev.weather;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dev on 12/28/2015.
 */
public class DoshaTestActivity extends AppCompatActivity{
    static final String[] vataQuestions = new String[] { "I am lively and enthusiastic.",
            "I am talkative.", "I get easily excited.","I easily get afraid and worried.","I find it difficult to make decisions."
    ,"I do things quickly.","Cold weather does not suit me.","I walk fast.","I can quickly pick up something new.",
            "I find it hard to learn something by heart and retain it.","I have difficulty falling asleep and wake up often in the night.",
            "I often have dry skin, and cold hands and feet.","I tend towards flatulence or constipation.","I have a light build and do not gain weight easily."};

    static final String[] pitaQuestions = new String[] { "PITA I am lively and enthusiastic.",
            "PITA I am talkative.", "PITA I get easily excited."};

    static final String[] kafaQuestions = new String[] { "KAFA I am lively and enthusiastic.",
            "KAFA I am talkative.", "KAFA I get easily excited."};

    List<DosaTestDesc> qList;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dosha_test_includer);
//        Toast.makeText(DoshaTestActivity.this, "dosha test", Toast.LENGTH_LONG).show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Dosha Test");

        loadList();

        ListView listView = (ListView)findViewById(R.id.doshatestlist);
        CustomAdapterDoshTest adapter= new CustomAdapterDoshTest(DoshaTestActivity.this, qList);
        listView.setAdapter(adapter);

        Button submitdoshatest = (Button)findViewById(R.id.submitdoshatest);
        if(submitdoshatest!=null)
            submitdoshatest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DoshaTestActivity.this, YourDoshaActivity.class);
                    startActivity(intent);
                }
            });
    }

    private void loadList() {
        qList=new ArrayList<>();

        /*DosaTestDesc d = new DosaTestDesc();
        d.setId(1000);
        d.setRowType(DoshaTestQType.VATA);
        qList.add(d);*/

        for(int i=0;i<vataQuestions.length;i++) {
            DosaTestDesc d = new DosaTestDesc();
            d.setId(i*100+i);
            d.setQuestion(vataQuestions[i]);
            d.setRowType(DoshaTestQType.QUESTION);
            qList.add(d);
        }

        /*d = new DosaTestDesc();
        d.setId(1001);
        d.setRowType(DoshaTestQType.EMPTY);
        qList.add(d);*/

        /*d = new DosaTestDesc();
        d.setId(2000);
        d.setRowType(DoshaTestQType.PITTA);
        qList.add(d);

        for(int i=0;i<pitaQuestions.length;i++) {
            d = new DosaTestDesc();
            d.setId(i*200+i);
            d.setQuestion(pitaQuestions[i]);
            d.setRowType(DoshaTestQType.QUESTION);
            qList.add(d);
        }

        d = new DosaTestDesc();
        d.setId(2001);
        d.setRowType(DoshaTestQType.EMPTY);
        qList.add(d);

        d = new DosaTestDesc();
        d.setId(3000);
        d.setRowType(DoshaTestQType.KAFA);
        qList.add(d);

        for(int i=0;i<kafaQuestions.length;i++) {
            d = new DosaTestDesc();
            d.setId(i*300+i);
            d.setQuestion(kafaQuestions[i]);
            d.setRowType(DoshaTestQType.QUESTION);
            qList.add(d);
        }*/
    }

}
