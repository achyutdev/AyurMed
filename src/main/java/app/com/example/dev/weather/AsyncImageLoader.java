package app.com.example.dev.weather;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.ImageView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by 984872 on 12/26/2015.
 */
public class AsyncImageLoader extends AsyncTask<String, Void, Void> {
    final Activity activity;
    String imgId = "";
    int stub;

    public AsyncImageLoader(Activity activity, String imgId, int stub) {
        this.activity = activity;
        this.imgId = imgId;
        this.stub = stub;
    }

    private void loadImage(final Bitmap bmp) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (bmp != null) {
                    ImageView imageView = (ImageView) activity.findViewById(stub);
                    imageView.setImageBitmap(bmp);
                }
            }
        });
    }

    @Override
    protected Void doInBackground(String... params) {

        UploadUtils utils = new UploadUtils();

        List<NameValuePair> lv = new ArrayList<>();
        lv.add(new BasicNameValuePair("product_id", imgId));

        JSONObject obj = utils.upload(lv, Constants.getImageDetails);
        System.out.println("IMAGELOADER: " + utils.getUrl());
        String image = null;
        try {
            image = (String) obj.get("image");
            byte[] imgBytes = Base64.decode(image, Base64.DEFAULT);
            final Bitmap bmp = BitmapFactory.decodeByteArray(imgBytes, 0, imgBytes.length);
            loadImage(bmp);
        } catch (JSONException e) {
            e.printStackTrace();

        }

        return null;
    }
}