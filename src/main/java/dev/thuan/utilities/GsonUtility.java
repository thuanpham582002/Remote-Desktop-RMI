package dev.thuan.utilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtility {
    public static String toJson(Object obj) {
        System.out.println("GsonUtility.toJson");
        return new Gson().toJson(obj);
    }

    public static <T> T fromJson(String jsonString) {
        return new Gson().fromJson(jsonString, new TypeToken<T>() {
        }.getType());
    }
}
