package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.eventopia.R;

import java.util.List;

import data.FakeDataSource;
import model.Event;
import util.EventPrefs;

public class EventListActivity extends AppCompatActivity {

    private ListView listView;
    private EventListAdapter adapter;
    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list_activity); // XML: event_list_activity.xml

        listView = findViewById(R.id.eventListView);
        Button buttonCreate = findViewById(R.id.buttonCreateEvent);

        // 1) Başlangıç fake etkinlikleri al
        events = FakeDataSource.getParticipantEvents();

        // 2) Telefona kalıcı kaydedilmiş etkinlikleri de listeye ekle
        List<Event> savedEvents = EventPrefs.loadEvents(this);
        events.addAll(savedEvents);

        // 3) Adapteri oluştur ve ListView'e bağla
        adapter = new EventListAdapter(this, events);
        listView.setAdapter(adapter);

        // 4) Liste elemanına tıklayınca detay sayfasına git
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Event clickedEvent = events.get(position);

            Intent intent = new Intent(EventListActivity.this, EventDetailActivity.class);
            intent.putExtra("title", clickedEvent.getTitle());
            intent.putExtra("description", clickedEvent.getDescription());
            intent.putExtra("date", clickedEvent.getDate());
            intent.putExtra("location", clickedEvent.getLocation());

            startActivity(intent);
        });

        // 5) "Yeni Etkinlik Oluştur" butonuna basınca CreateEventActivity aç
        buttonCreate.setOnClickListener(v -> {
            Intent intent = new Intent(EventListActivity.this, CreateEventActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // CreateEventActivity'den geri dönünce listeyi yenile
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
