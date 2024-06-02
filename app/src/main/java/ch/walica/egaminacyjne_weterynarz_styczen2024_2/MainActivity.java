package ch.walica.egaminacyjne_weterynarz_styczen2024_2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etGoal, etTime;
    private Button btnOk;
    private ListView listView;
    private SeekBar seekBar;
    private TextView tvAge, tvResult;

    private String[] animals = {"Pies", "Kot", "Świnka morska"};
    private int[] ages = {18, 20, 9};
    private int selectedAge = 0;
    private String selectedAnimal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etGoal = findViewById(R.id.etGoal);
        etTime = findViewById(R.id.etTime);
        btnOk = findViewById(R.id.btnOK);
        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekbar);
        tvAge = findViewById(R.id.tvAge);
        tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.tvItem, animals);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                seekBar.setMax(ages[position]);
                selectedAnimal = animals[position];

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                selectedAge = progress;
                tvAge.setText("Ile ma lat? " + selectedAge);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnOk.setOnClickListener(view -> {
            String name = etName.getText().toString();
            String goal = etGoal.getText().toString();
            String time = etTime.getText().toString();
            tvResult.setText(name + ", " + selectedAnimal + ", " + selectedAge + ", " + goal + ", " + time);
        });

    }
}