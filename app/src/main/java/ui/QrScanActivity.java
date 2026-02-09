package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.eventopia.R;

public class QrScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);

        TextView textResult = findViewById(R.id.textScanResult);
        textResult.setText(
                "Bilet Doğrulama Ekranı\n\n" +
                        "- Bu ekranda normalde kamerayla QR kodu okunur.\n" +
                        "- Okunan biletin içeriği burada gösterilir.\n\n" +
                        "Demo sürümde sadece açıklama gösteriyoruz."
        );
    }
}

