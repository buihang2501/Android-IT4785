package hangbt.hust.uigmail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
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

        registerForContextMenu(recyclerView);
        recyclerView.setLongClickable(true);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,101,"Reply");
        menu.add(0,0,102,"Delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Faker selectedItem = fakers.get(info.position);

        int id = item.getItemId();
        if (id == 101) {
            Log.v("TAG", "Reply email  " + selectedItem.internet.userName());
        } else if (id == 102) {
            Log.v("TAG", "Delete email  " + selectedItem.team.name());
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.v("TAG", "Search with keyword: " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.v("TAG", "Keyword: " + newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Log.v("TAG", "Search action");
        } else if (id == R.id.action_favorite) {
            Log.v("TAG", "Share action");
        }
        return super.onOptionsItemSelected(item);
    }
}