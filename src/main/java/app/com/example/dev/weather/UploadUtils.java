package app.com.example.dev.weather;

import android.provider.Settings;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
/*
*
 * Created by 984872 on 12/26/2015.
 */

public class UploadUtils {
    private String url="";
    public final JSONObject upload(List<NameValuePair> nvp, String url) {
        HttpClient client = new DefaultHttpClient();

        try {
            StringBuilder sb = new StringBuilder();
            for (NameValuePair p : nvp)
                sb.append(p.getName() + "=" + URLEncoder.encode(p.getValue(), "UTF-8") + "&").toString();


            URL u = new URL(url + sb.toString());
            url = url.toString();
            System.out.println(u.toString());
            URLConnection con = u.openConnection();
            con.connect();
            InputStream in = con.getInputStream();
            byte[] buffer = new byte[1024];
            sb = new StringBuilder();
            while (in.read(buffer) > 0) {
                sb.append(new String(buffer));
                //System.out.println("WHILE:" + new String(buffer));
            }

            System.out.println(sb.toString());
            return new JSONObject(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Inside exception: " + e.getMessage());
        }
/*
        HttpGet httpGet = new HttpGet(URL + sb.toString());
        System.out.println(URL + sb.toString());
        // httpGet.setEntity(new UrlEncodedFormEntity(nvp));
        HttpResponse response = client.execute(httpGet);
        //System.out.println("RESPONSE: "+EntityUtils.toString(client.execute(httpPost).getEntity()));
        System.out.println(EntityUtils.toString(response.getEntity()));
        return new JSONObject(EntityUtils.toString(response.getEntity()));*/

        return null;

    }

    public String getUrl() {
        return url;
    }
}
