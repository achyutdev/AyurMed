package app.com.example.dev.weather;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Dev on 12/28/2015.
 */
public class CustomAdapterDoshTest extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    Activity activity;

    List<DosaTestDesc> qList;

    public CustomAdapterDoshTest(DoshaTestActivity doshaTestActivity, List<DosaTestDesc> qList) {
        this.qList = qList;
        this.activity=doshaTestActivity;
        inflater = ( LayoutInflater )activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return qList.size();
    }

    @Override
    public Object getItem(int position) {
        return qList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return qList.get(position).getId();
    }

    class Holder {
        TextView question;
        SeekBar sb;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;

        DosaTestDesc q = qList.get(position);

        if(convertView==null) {
            holder = new Holder();
            if(q.getRowType()==DoshaTestQType.QUESTION) {
                convertView = inflater.inflate(R.layout.dosha_questions, parent, false);
                holder.question = (TextView) convertView.findViewById(R.id.question);
                holder.sb = (SeekBar) convertView.findViewById(R.id.sb1);

                holder.question.setText(q.getQuestion());
                holder.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(activity,seekBar.getProgress()+"",Toast.LENGTH_LONG).show();
                        qList.get(position).setAnswer(seekBar.getProgress());
                    }
                });
            } /*else if(q.getRowType()==DoshaTestQType.VATA) {
                convertView = inflater.inflate(R.layout.dost_test_title_row, parent, false);
                holder.question = (TextView) convertView.findViewById(R.id.dosha_test_row);
                holder.question.setText("VATA");
            } *//*else if(q.getRowType()==DoshaTestQType.KAFA) {
                convertView = inflater.inflate(R.layout.dost_test_title_row, parent, false);
                holder.question = (TextView) convertView.findViewById(R.id.dosha_test_row);
                holder.question.setText("KAFA");
            } else if(q.getRowType()==DoshaTestQType.PITTA) {
                convertView = inflater.inflate(R.layout.dost_test_title_row, parent, false);
                holder.question = (TextView) convertView.findViewById(R.id.dosha_test_row);
                holder.question.setText("PITTA");
            } else if(q.getRowType()==DoshaTestQType.EMPTY) {
                convertView = inflater.inflate(R.layout.dosha_test_empty_row, parent, false);
                holder.question = (TextView) convertView.findViewById(R.id.dosha_test_empty_row);
            }*/
        } else {
            holder = (Holder)convertView.getTag();
        }



        return convertView;

    }
}
