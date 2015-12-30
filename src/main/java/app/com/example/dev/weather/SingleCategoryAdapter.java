package app.com.example.dev.weather;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 984872 on 12/26/2015.
 */
public class SingleCategoryAdapter extends BaseAdapter {

    List<SingleCategoryDesc> items;
    int resource;
    LayoutInflater inflater;
    Activity activity;
    AsyncImageLoader loader;
    Context context;

    public SingleCategoryAdapter(Activity activity, int resource, List<SingleCategoryDesc> items, Context context) {
        super();
        this.items = items;
        this.resource = resource;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
        this.context = context;


    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getItemId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RowHolder holder;
        if(convertView == null) {
            holder = new RowHolder();
            convertView = inflater.inflate(R.layout.row_single_category, parent, false);
            holder.image = (ImageView)convertView.findViewById(R.id.imageIcon);
            holder.title = (TextView)convertView.findViewById(R.id.txtTitle);
            holder.desc = (TextView)convertView.findViewById(R.id.txtDescription);
            holder.ratingBar = (RatingBar)convertView.findViewById(R.id.ratingBar);
            holder.custReviews = (TextView)convertView.findViewById(R.id.txtCustViewer);
        } else {
            holder = (RowHolder)convertView.getTag();
        }


        SingleCategoryDesc c = items.get(position);
        if( c != null) {
            //loader = new AsyncImageLoader(activity,c.imgId,holder.image.getId());
            //loader.execute();
            holder.title.setText(c.title);
            holder.desc.setText(c.desc);
            holder.ratingBar.setRating(Float.parseFloat(c.numStars));
            holder.custReviews.setText("( "+c.numCustReviews+" Customer Reviews )");
        } else {
            System.out.println("ITEM "+position+" NULL");
        }

        final int pos = position;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ON ITEM CLICK "+pos);
                Intent intent = new Intent(context, ProductDetailPage.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("item",items.get(pos));
                intent.putExtra("extras", bundle);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    class RowHolder {
        ImageView image;
        TextView title;
        TextView desc;
        RatingBar ratingBar;
        TextView custReviews;
        String imgId;
        Bitmap bmp;
    }
}
