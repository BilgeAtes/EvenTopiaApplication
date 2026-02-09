package ui;

import androidx.appcompat.app.AppCompatActivity;
import util.EventPrefs;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eventopia.R;

import data.FakeDataSource;
import model.Event;

public class CreateEventActivity extends AppCompatActivity {

    private EditText editTitle, editDescription, editDate, editLocation;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);  // XML dosyanızın adı bu

        editTitle = findViewById(R.id.editTitle);
        editDescription = findViewById(R.id.editDescription);
        editDate = findViewById(R.id.editDate);
        editLocation = findViewById(R.id.editLocation);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(v -> {
            String title = editTitle.getText().toString().trim();
            String desc = editDescription.getText().toString().trim();
            String date = editDate.getText().toString().trim();
            String loc  = editLocation.getText().toString().trim();

            if (title.isEmpty() || desc.isEmpty() || date.isEmpty() || loc.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                return;
            }

            // Yeni etkinlik oluştur
            Event newEvent = new Event(title, desc, date, loc);

            // FakeDataSource içindeki listeye ekle
            FakeDataSource.addEvent(newEvent);

            // Telefona kalıcı kaydet
            util.EventPrefs.saveEvent(this, newEvent);

            Toast.makeText(this, "Etkinlik kaydedildi!", Toast.LENGTH_SHORT).show();

            // Bu activity'yi kapat → liste ekranına geri dön
            finish();
        });
    }
}

