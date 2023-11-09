package dev.thuan.viewer;

import com.google.gson.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Type;

public class KeyEventAdapter implements JsonSerializer<KeyEvent>, JsonDeserializer<KeyEvent> {
    @Override
    public JsonElement serialize(KeyEvent src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("keyCode", src.getKeyCode());
        jsonObject.addProperty("keyChar", src.getKeyChar());
        jsonObject.addProperty("id", src.getID());
        return jsonObject;
    }

    @Override
    public KeyEvent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        int keyCode = jsonObject.get("keyCode").getAsInt();
        char keyChar = jsonObject.get("keyChar").getAsCharacter();
        int id = jsonObject.get("id").getAsInt();
        return new KeyEvent(new Button(), id, System.currentTimeMillis(), 0, keyCode, keyChar);
    }
}