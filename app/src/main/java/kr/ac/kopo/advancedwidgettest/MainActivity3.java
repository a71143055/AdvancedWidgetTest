package kr.ac.kopo.advancedwidgettest;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String[] items = {"AISoftware", "AIRobot", "AIPhoto", "AIGPT", "AIGemini"};

        AutoCompleteTextView auto = findViewById(R.id.auto);
        MultiAutoCompleteTextView multi = findViewById(R.id.multi);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);

        MultiAutoCompleteTextView.CommaTokenizer commaToken = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(commaToken);
        multi.setAdapter(adapter);
    }
}