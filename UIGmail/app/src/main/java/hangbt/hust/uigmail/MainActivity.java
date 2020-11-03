package hangbt.hust.uigmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MailAdapter mailAdapter = new MailAdapter();
    private List<Faker> fakers = new ArrayList<>();

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initView();
        initData();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(mailAdapter);
    }

    private void initData() {
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
        fakers.add(new Faker());
//        Log.d(TAG, "initData: " + fakers.get(i).);

        mailAdapter.updateData(fakers);
    }
}