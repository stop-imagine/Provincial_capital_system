package util;


import com.google.gson.Gson;
import entity.ShengHui;
import java.util.ArrayList;
import java.util.Map;

public class JSONToShenghui {

    public String ObjectToGson(ShengHui sh) {
        Gson gson = new Gson();
        String str = gson.toJson(sh);
        return str;
    }
    public ShengHui GsonToObject(String stringGson) {
        Gson gson = new Gson();
        ShengHui sh = gson.fromJson(stringGson, ShengHui.class);
        return sh;
    }
    public String ListToGson(ArrayList<Map<String, Object>> list){
        Gson gson=new Gson();
        String str=gson.toJson(list);
        return str;
    }

}