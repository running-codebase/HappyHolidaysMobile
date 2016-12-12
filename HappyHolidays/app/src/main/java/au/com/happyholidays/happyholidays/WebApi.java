package au.com.happyholidays.happyholidays;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by tco on 2016-12-10.
 */

public class WebApi {

    public static void dropPin(Context context, String latitude, String longitude, String date) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("lat", latitude);
            jsonObject.put("lon", longitude);
            jsonObject.put("time", date);
            StringEntity entity = new StringEntity(jsonObject.toString());

            ServerRestClient.post(context, "location/jenny", entity, "application/json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        Log.d("HappyHolidays", "dropPin: Post Results " + statusCode);
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Log.d("HappyHolidays", "dropPin: Post Results " + statusCode);
                }
            });

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
