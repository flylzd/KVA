package com.lemon.kva.volley;


public interface ResponseListener<T> {

    public void onStarted();

    public void onResponse(T response);

    public void onErrorResponse(com.android.volley.error.VolleyError volleyError);
}
