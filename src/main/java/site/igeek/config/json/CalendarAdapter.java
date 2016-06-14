package site.igeek.config.json;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * Created by jacobdong on 16/1/12.
 */
public class CalendarAdapter implements JsonSerializer<Calendar>, JsonDeserializer<Calendar> {

    @Override
    public Calendar deserialize(JsonElement json, Type arg1,
                                JsonDeserializationContext arg2) throws JsonParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(json.getAsJsonPrimitive().getAsLong());
        return calendar;
    }

    @Override
    public JsonElement serialize(Calendar calendar, Type arg1,
                                 JsonSerializationContext arg2) {
        return new JsonPrimitive(Long.valueOf(calendar.getTimeInMillis()));
    }


}
