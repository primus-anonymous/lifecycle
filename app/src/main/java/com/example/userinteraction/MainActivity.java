package com.example.userinteraction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.userinteraction.domain.Pair;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_ARRAY = "key_array";
    public static final String KEY_PAIR = "key_pair";
    public static final String KEY_LIST_OF_PAIRS = "key_list_of_pairs";
    private static final String KEY_COUNTER = "KEY_COUNTER";
    private int counterValue = 0;
    private int[] arrayOfIntValues = {1, 2, 3, 4};
    private Pair pair = new Pair();
    private ArrayList<Pair> listOfPairs = new ArrayList<>();
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counter_value);

        if (savedInstanceState == null) {
            logLifecycle("Первый запуск");
            updateCounterView();

        } else {
            logLifecycle("Повторный запуск");
        }

        Button addValue = findViewById(R.id.btn_add);

        addValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterValue++;

                updateCounterView();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY_COUNTER, counterValue);
        outState.putIntArray(KEY_ARRAY, arrayOfIntValues);
        outState.putParcelable(KEY_PAIR, pair);

        outState.putParcelableArrayList(KEY_LIST_OF_PAIRS, listOfPairs);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        counterValue = savedInstanceState.getInt(KEY_COUNTER);
        arrayOfIntValues = savedInstanceState.getIntArray(KEY_ARRAY);
        pair = (Pair) savedInstanceState.getParcelable(KEY_PAIR);
        listOfPairs = savedInstanceState.getParcelableArrayList(KEY_LIST_OF_PAIRS);

        updateCounterView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        logLifecycle("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        logLifecycle("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        logLifecycle("onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();

        logLifecycle("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        logLifecycle("onDestroy");
    }

    private void logLifecycle(String log) {
        Toast.makeText(this, log, Toast.LENGTH_SHORT).show();
        Log.d("MainActivity", log);
    }

    private void updateCounterView() {
        counterText.setText(getString(R.string.counter_value, counterValue));
    }
}