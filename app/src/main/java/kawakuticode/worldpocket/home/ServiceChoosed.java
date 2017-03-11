package kawakuticode.worldpocket.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import kawakuticode.worldpocket.adapters.CustomGridViewAdapter;
import com.lisbonpocket.code.kawakuti.worldpocket.R;

public class ServiceChoosed extends AppCompatActivity {

    private TextView curr_address;
    private int[] serviceIcons;
    private String[] listOfServices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        curr_address = (TextView) findViewById(R.id.current_address);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                curr_address.setText(extras.getString("LOCATION"));
                serviceIcons = extras.getIntArray("CURRENT_ICONS");
                listOfServices = extras.getStringArray("CURRENT_SERVICES");
            } else {
                curr_address.setText(null);
                serviceIcons = null;
                listOfServices = null;
            }
        } else {
            curr_address.setText((String) savedInstanceState.getSerializable("LOCATION"));
            serviceIcons = (int[]) savedInstanceState.getSerializable("CURRENT_ICONS");
            listOfServices = (String[]) savedInstanceState.getSerializable("CURRENT_SERVICES");
        }
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CustomGridViewAdapter(ServiceChoosed.this, serviceIcons, listOfServices));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent findplaces = new Intent(ServiceChoosed.this, FindPlaces.class);
                if(listOfServices[position].equalsIgnoreCase("Coffee")) {
                    findplaces.putExtra("TYPE_OF_PLACE", "cafe");
                }else if (listOfServices[position].equalsIgnoreCase("Hotel")) {
                    findplaces.putExtra("TYPE_OF_PLACE", "lodging");
//teste
                 }else if (listOfServices[position].equalsIgnoreCase("GSupermarket")) {
                findplaces.putExtra("TYPE_OF_PLACE", "grocery_or_supermarket    ");

            } else {
                    String choose = listOfServices[position].replace(" ", "_").toLowerCase();
                    findplaces.putExtra("TYPE_OF_PLACE", choose);
                }
               startActivity(findplaces);
            }
        });

    }

}
