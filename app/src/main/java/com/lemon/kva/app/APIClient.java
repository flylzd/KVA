package com.lemon.kva.app;


import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.lemon.kva.constant.Config;
import com.lemon.kva.constant.Urls;
import com.lemon.kva.model.BaseModel;
import com.lemon.kva.util.Logger;
import com.lemon.kva.volley.GsonPostRequest;
import com.lemon.kva.volley.ResponseListener;
import com.lemon.kva.volley.VolleySingleton;

import java.util.HashMap;
import java.util.Map;

public class APIClient {

    public static final String TAG = "ApiClient";
    private static Logger logger = Logger.getLogger(Logger.class);
    public static final RequestQueue requestQueue = VolleySingleton.getRequestQueue();


    public static  void login(String tag, ResponseListener listener) {

        listener.onStarted();

//        Map<String, String> requestParams = getSignatureMap();
//        requestParams.put("keywords", username);
//        requestParams.put("password", passwrod);
//        requestParams.put("valicode", valicode);
//        requestParams.put("q", "action/login");
//        requestParams.put(Urls.ACTION, "users");
//
//        String url = Urls.ACTION_INDEX;
//        GsonPostRequest request = createGsonPostRequest(url, requestParams, BaseModel.class, listener);
//        request.setTag(tag);
//        requestQueue.add(request);

    }

    public static  void register(String tag, String phonenumber,String password, String verCode,  ResponseListener listener) {

        listener.onStarted();

        Map<String, String> requestParams = new HashMap<String,String>();
        requestParams.put("phonenumber", phonenumber);
        requestParams.put("userName", phonenumber);
        requestParams.put("password", password);
        requestParams.put("verCode", verCode);
        requestParams.put("appKey", Config.APPKEY);
        requestParams.put("zone", "86");

        String url = Urls.URL_REGISTER;
        GsonPostRequest request = createGsonPostRequest(url, requestParams, BaseModel.class, listener);
        request.setTag(tag);
        requestQueue.add(request);

    }



    private static <T> GsonPostRequest createGsonPostRequest(String url, Map<String, String> requestParamsMap, Class<T> clazz, final ResponseListener listener) {

        GsonPostRequest request = new GsonPostRequest(url, clazz, requestParamsMap, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                Log.d(TAG, "onResponse = " + response.toString());
                listener.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG, "volleyError = " + volleyError.toString());
                listener.onErrorResponse(volleyError);
            }
        });
        try {
            Log.d(TAG, "request Headers = " + request.getHeaders().toString());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        String params = requestParamsMap.toString().substring(1, requestParamsMap.toString().length() - 1);
        Log.d(TAG, "request Url-Params = " + request.getUrl() + "?" + params);
//        Log.d(TAG, "request Url-Params = " + request.getUrl());

        return request;
    }


}
