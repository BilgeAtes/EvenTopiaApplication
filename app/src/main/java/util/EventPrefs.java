package util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import model.Event;

public class EventPrefs {

    private static final String PREFS_NAME = "event_prefs";
    private static final String KEY_EVENTS = "saved_events";

    // Tek bir etkinliği kaydet (eskinin sonuna ekler)
    public static void saveEvent(Context context, Event event) {
        SharedPreferences prefs =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String old = prefs.getString(KEY_EVENTS, "");

        String encoded = encode(event);

        prefs.edit()
                .putString(KEY_EVENTS, old + encoded)
                .apply();
    }

    // Kaydedilmiş etkinlikleri oku
    public static List<Event> loadEvents(Context context) {
        SharedPreferences prefs =
                context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        String data = prefs.getString(KEY_EVENTS, "");
        List<Event> result = new ArrayList<>();

        if (data.isEmpty()) return result;

        String[] items = data.split("§§");
        for (String item : items) {
            if (item.trim().isEmpty()) continue;
            String[] parts = item.split("\\|\\|");
            if (parts.length == 4) {
                result.add(new Event(
                        parts[0], // title
                        parts[1], // description
                        parts[2], // date
                        parts[3]  // location
                ));
            }
        }
        return result;
    }

    // Event'i tek satırlık stringe çevir
    private static String encode(Event e) {
        return e.getTitle() + "||"
                + e.getDescription() + "||"
                + e.getDate() + "||"
                + e.getLocation() + "§§";
    }
}
