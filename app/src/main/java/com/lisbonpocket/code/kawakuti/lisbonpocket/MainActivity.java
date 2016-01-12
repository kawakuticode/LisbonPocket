package com.lisbonpocket.code.kawakuti.lisbonpocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> concelhos_lisboa = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }






  /*      ListView lv = (ListView) findViewById(R.id.concelho_list);
        initList();
        ListAdapter concelhos;
        concelhos = new SimpleAdapter(this, concelhos_lisboa,
                android.R.layout.simple_list_item_1, new String[]{"concelho"}, new int[]{android.R.id.text1});
        lv.setAdapter(concelhos);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView clickedView = (TextView) view;
                Intent choose = new Intent(MainActivity.this, Where_I_Am.class);
                startActivity(choose);
               *//* Toast.makeText(MainActivity.this, "Item with id [" + id + "] - " +
                        "Position [" + position + "] - concelho [" + clickedView.getText() + "]",
                        Toast.LENGTH_SHORT).show();*//*


            }
        });

    }


    private void initList() {
        // We populate concelhos
        concelhos_lisboa.add(createConcelho("concelho", "Alenquer"));
        concelhos_lisboa.add(createConcelho("concelho", "Amadora"));
        concelhos_lisboa.add(createConcelho("concelho", "Arruda dos Vinhos"));
        concelhos_lisboa.add(createConcelho("concelho", "Azambuja"));
        concelhos_lisboa.add(createConcelho("concelho", "Cadaval"));
        concelhos_lisboa.add(createConcelho("concelho", "Cascais"));
        concelhos_lisboa.add(createConcelho("concelho", "Lisboa"));
        concelhos_lisboa.add(createConcelho("concelho", "Loures"));
        concelhos_lisboa.add(createConcelho("concelho", "Lourinha"));
        concelhos_lisboa.add(createConcelho("concelho", "Mafra"));
        concelhos_lisboa.add(createConcelho("concelho", "Odivelas"));
        concelhos_lisboa.add(createConcelho("concelho", "Oeiras"));
        concelhos_lisboa.add(createConcelho("concelho", "Sintra"));
        concelhos_lisboa.add(createConcelho("concelho", "Sobral do Monte Agraço"));
        concelhos_lisboa.add(createConcelho("concelho", "Torres Vedras"));
        concelhos_lisboa.add(createConcelho("concelho", "Vila Franca de Xira"));
        concelhos_lisboa.add(createConcelho("concelho", "Onde estou ? "));


    }

    private HashMap<String, String> createConcelho(String key, String name) {
        HashMap<String, String> concelho_ = new HashMap<String, String>();
        concelho_.put(key, name);
        return concelho_;
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
