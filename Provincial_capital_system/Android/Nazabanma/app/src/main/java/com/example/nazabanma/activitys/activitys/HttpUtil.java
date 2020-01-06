package com.example.nazabanma.activitys.activitys;


import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {

    //轮播
    static void ShenghuiWithOkHttp(String address, String id, Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id", id)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        /**
         * OkHttp在enqueue()方法的内部已经帮我们开好了子线程
         *  然后会在子线程中去执行HTTP请求
         * 并将最终的请求结果回调到okhttp3.Callback当中
         **/
        client.newCall(request).enqueue(callback);
    }

    //查询
    public static void selectWithOkHttp(String address, String shengming, Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("shengming", shengming)
                .build();
        Request request = new Request.Builder()
                .url(address)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    //增加
    public static void addWithOkHttp(String address,String addShengming,String addHuiming,String addMeishi, String addJingdian, String addGaoxiao,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();       //创建okHttpClient对象
        RequestBody body = new FormBody.Builder()       //构建FormBody传入参数
                .add("shengming",addShengming)
                .add("huiming",addHuiming)
                .add("meishi",addMeishi)
                .add("jingdian",addJingdian)
                .add("gaoxiao",addGaoxiao)
                .build();
        Request request = new Request.Builder()
                .url(address)   //请求链接
                .post(body)     //将FormBody作为post方法传入
                .build();       //创建Request对象
        client.newCall(request).enqueue(callback);  //将Request封装成Call,调用请求
        //System.out.println("打印测试");
    }

    //删除
    public static void DeleteWithOkHttp(String address, String addShengming, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();       //创建okHttpClient对象
        RequestBody body = new FormBody.Builder()       //构建FormBody传入参数
                .add("shengming",addShengming)
                .build();
        Request request = new Request.Builder()
                .url(address)   //请求链接
                .post(body)     //将FormBody作为post方法传入
                .build();       //创建Request对象
        client.newCall(request).enqueue(callback);  //将Request封装成Call,调用请求
    }
    //修改
    public static void updateWithOkHttp(String address,String updateShengming,String updateHuiming,String updateMeishi, String updateJingdian, String updateGaoxiao,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();       //创建okHttpClient对象
        RequestBody body = new FormBody.Builder()       //构建FormBody传入参数
                .add("shengming",updateShengming)
                .add("huiming",updateHuiming)
                .add("meishi",updateMeishi)
                .add("jingdian",updateJingdian)
                .add("gaoxiao",updateGaoxiao)
                .build();
        Request request = new Request.Builder()
                .url(address)   //请求链接
                .post(body)     //将FormBody作为post方法传入
                .build();       //创建Request对象
        client.newCall(request).enqueue(callback);  //将Request封装成Call,调用请求
    }


}
