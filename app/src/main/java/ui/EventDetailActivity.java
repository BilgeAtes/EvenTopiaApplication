package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.eventopia.R;

public class EventDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // DOSYA ADI: activity_event_detail.xml
        setContentView(R.layout.activity_event_detail);

        TextView title = findViewById(R.id.detailTitle);
        TextView desc = findViewById(R.id.detailDescription);
        TextView date = findViewById(R.id.detailDate);
        TextView location = findViewById(R.id.detailLocation);
        Button buttonBuy = findViewById(R.id.buttonBuyTicket);

        // Liste ekranından gelen veriler
        String eventTitle = getIntent().getStringExtra("title");
        String eventDesc = getIntent().getStringExtra("description");
        String eventDate = getIntent().getStringExtra("date");
        String eventLocation = getIntent().getStringExtra("location");

        // Ekrana yaz
        title.setText(eventTitle);
        desc.setText(eventDesc);
        date.setText(eventDate);
        location.setText(eventLocation);

        // QR ekranına geçiş
        buttonBuy.setOnClickListener(v -> {
            // Ödev için basit: etkinlik bilgilerini QR içine yazıyoruz
            String qrData = "Etkinlik: " + eventTitle
                    + "\nTarih: " + eventDate
                    + "\nYer: " + eventLocation;

            Intent intent = new Intent(EventDetailActivity.this, TicketQrActivity.class);
            intent.putExtra("qrData", qrData);
            startActivity(intent);
        });
    }
}

