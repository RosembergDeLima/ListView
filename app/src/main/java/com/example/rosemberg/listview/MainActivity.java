package com.example.rosemberg.listview;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private String[] lstNomes;
    private ListView lView;
    private EditText eText;
    private ArrayList<String> pesq = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lView = (ListView) findViewById(R.id.listView);
        eText = (EditText) findViewById(R.id.editText);

        lstNomes = new String[] {"Ana", "Rafaela", "Fabio", "Marcelo", "Natalia", "Sergio", "Joao", "Fatima", "Ze"};

        Pesquisar();

        eText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Pesquisar();

                lView.setAdapter(new ArrayAdapter<String >(MainActivity.this, android.R.layout.simple_list_item_1, pesq));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void Pesquisar(){
        int textLength = eText.getText().length();
        pesq.clear();

        for(int i = 0; i < lstNomes.length; i++){
            if(textLength <= lstNomes[i].length()){
                if(eText.getText().toString().equalsIgnoreCase((String)lstNomes[i].subSequence(0, textLength))){
                    pesq.add(lstNomes[i]);
                }
            }
        }
    }
}
