package data;

import java.util.ArrayList;
import java.util.List;

import model.Event;

public class FakeDataSource {

    // Uygulamadaki tüm etkinliklerin tutulduğu ortak static liste
    private static final List<Event> events = new ArrayList<>();

    // Başlangıç örnek verileri
    static {
        events.add(new Event(
                "Konser Gecesi",
                "Harika bir müzik deneyimi.",
                "12.12.2025",
                "İstanbul"
        ));
        events.add(new Event(
                "Tiyatro Gösterisi",
                "Klasik bir oyun.",
                "20.12.2025",
                "Ankara"
        ));
        events.add(new Event(
                "Atölye Çalışması",
                "Yaratıcı yazarlık atölyesi.",
                "05.01.2026",
                "İzmir"
        ));
    }

    // Listeyi isteyenlere ver
    public static List<Event> getParticipantEvents() {
        return events;
    }

    // CreateEventActivity burayı kullanarak yeni etkinlik ekler
    public static void addEvent(Event event) {
        events.add(event);
    }
}

