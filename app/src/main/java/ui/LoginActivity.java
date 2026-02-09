package ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eventopia.R;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(view -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                return;
            }

            // Şimdilik sabit kullanıcı
            if (email.equals("test@test.com") && password.equals("1234")) {
                Toast.makeText(this, "Giriş Başarılı!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(LoginActivity.this, EventListActivity.class);
                startActivity(intent);
                // finish(); // istersen login ekranına geri dönülmesin diye açık bırakabilirsin

            } else {
                Toast.makeText(this, "Hatalı giriş!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

