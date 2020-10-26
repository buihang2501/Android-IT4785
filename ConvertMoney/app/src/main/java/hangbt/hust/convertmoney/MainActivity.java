package hangbt.hust.convertmoney;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerFrom, spinnerTo;
    private EditText editTextAmount;
    private TextView textViewResult;
    private List<String> listMoney = new ArrayList<>();
    private String stringFrom, stringTo;

    private double usd2vnd = 23176.50;
    private double usd2euro = 0.85;
    private double usd2banganh = 0.77;
    private double usd2nhandante = 6.71;
    private double usd2yen = 104.84;
    private double usd2bat = 31.27;
    private double usd2rub = 76.46;
    private double usd2won = 1132.88;
    private double usd2franc = 0.91;

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
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextAmount = findViewById(R.id.editTextAmount);
        textViewResult = findViewById(R.id.textViewResult);
    }

    private void initData() {
        listMoney.add("USD");
        listMoney.add("EURO");
        listMoney.add("VND");
        listMoney.add("Bảng Anh");
        listMoney.add("Nhân dân tệ");
        listMoney.add("Yên Nhật");
        listMoney.add("Won");
        listMoney.add("RUB");
        listMoney.add("Bạt Thái Lan");
        listMoney.add("Franc");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, listMoney);

        spinnerFrom.setAdapter(adapter);
        spinnerFrom.setSelection(0);
        spinnerTo.setAdapter(adapter);
        spinnerTo.setSelection(2);

        editTextAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(final Editable editable) {
                stringFrom = spinnerFrom.getSelectedItem().toString();
                stringTo = spinnerTo.getSelectedItem().toString();
                if (!editable.toString().equals("")) {
                    convert(stringFrom, stringTo, editable.toString());
                }else{
                    convert(stringFrom, stringTo, "0");
                }
            }
        });

        Log.d(TAG, "initData: " + Common.commonFrom + Common.commonTo);
    }

    private void convert(String stringFrom, String stringTo, String editable) {
        Double amount = Double.parseDouble(editable);
        double res;
        if (stringFrom.equals("USD")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("EURO")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2euro;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * 1;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2euro;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2euro;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2euro;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2euro;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2euro;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("VND")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2vnd;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2vnd;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2vnd;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2vnd;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2vnd;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2vnd;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2vnd;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2vnd;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2vnd;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2vnd;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("Bảng Anh")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2banganh;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2banganh;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2banganh;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2banganh;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2banganh;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2banganh;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2banganh;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2banganh;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2banganh;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2banganh;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("Nhân dân tệ")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2nhandante;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2nhandante;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2nhandante;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2nhandante;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2nhandante;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2nhandante;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2nhandante;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2nhandante;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2nhandante;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2nhandante;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("Yên Nhật")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2yen;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2yen;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2yen;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2yen;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2yen;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2yen;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2yen;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2yen;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2yen;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2yen;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("Won")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2won;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2won;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2won;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2won;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2won;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2won;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2won;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2won;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2won;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2won;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("RUB")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2rub;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2rub;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2rub;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2rub;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2rub;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2rub;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("Bạt Thái Lan")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2bat;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2bat;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2bat;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2bat;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2bat;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2bat;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }

        if (stringFrom.equals("Franc")) {
            switch (stringTo) {
                case "USD":
                    res = amount * 1 / usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "EURO":
                    res = amount * usd2euro / usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "VND":
                    res = amount * usd2vnd / usd2franc;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Bảng Anh":
                    res = amount * usd2banganh / usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Nhân dân tệ":
                    res = amount * usd2nhandante / usd2franc;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Yên Nhật":
                    res = amount * usd2yen / usd2franc;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Won":
                    res = amount * usd2won / usd2franc;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "RUB":
                    res = amount * usd2rub / usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
                case "Bạt Thái Lan":
                    res = amount * usd2bat / usd2franc;
                    textViewResult.setText(String.format("%.0f", res));
                    break;
                case "Franc":
                    res = amount * usd2franc / usd2franc;
                    textViewResult.setText(String.format("%.2f", res));
                    break;
            }
        }
    }

}
