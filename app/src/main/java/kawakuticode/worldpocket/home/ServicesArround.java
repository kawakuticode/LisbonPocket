package kawakuticode.worldpocket.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import kawakuticode.worldpocket.model.Item;
import kawakuticode.worldpocket.adapters.ItemAdapter;
import kawakuticode.worldpocket.adapters.ItemDecoration;
import com.lisbonpocket.code.kawakuti.worldpocket.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesArround extends AppCompatActivity implements ItemAdapter.Listener {

    TextView curr_address;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    GridLayoutManager grid;
    ItemAdapter mAdapter;
    List<Item> mItems;


    private String[] listOfServices = {
            "Services",
            "Restaurants",
            "Lounge",
            "Shopping",
            "Transports"
    };

    private int[] mThumbIds = {
            R.drawable.services,
            R.drawable.restaurant,
            R.drawable.lazer,
            R.drawable.shoopings,
            R.drawable.transports
    };


    public void prepareServices() {
        mItems = new ArrayList<>();
        for (int i = 0; i < listOfServices.length; i++) {

            Item temp = new Item();
            temp.setType(listOfServices[i]);
            temp.setIcon(mThumbIds[i]);
            mItems.add(temp);
        }

    }

    private String[] servicesNames = {
            "Atm",
            "Bank",
            "Church",
            "Embassy",
            "Hotel", //lodging
            "Health",
            "Hospital",
            "Post Office", //post_office
            "Parking",
            "Pharmacy",
            "Police",
            "School",
            "University",
    };

    private int[] servicesIcons = {
            R.drawable.atm,
            R.drawable.bank,
            R.drawable.hotels,
            R.drawable.embassy,
            R.drawable.hotels,
            R.drawable.health,
            R.drawable.hospital,
            R.drawable.mailpost,
            R.drawable.parking,
            R.drawable.pharmacy,
            R.drawable.police,
            R.drawable.schools,
            R.drawable.university
    };

    private String[] restaurantsNames = {
            "Bakery",
            "Coffee", //cafe
            "Restaurant"
    };

    private int[] restaurantsIcons = {
            R.drawable.cakesshop,
            R.drawable.coffeeshop,
            R.drawable.restaurants,
    };
    private String[] shoppingNames = {
            "Store",
            "Shopping Mall",
            "GSupermarket",
            "Liquor Store" //liquor_store
    };

    private int[] shoopingIcons = {
            R.drawable.bank,
            R.drawable.shoopings,
            R.drawable.grossery,
            R.drawable.liquor
    };

    private String[] transportsNames = {
            "Airport",
            "Bus Station",      //bus_station
            "Subway Station", //subway_station
            "Train Station",   //train_station
            "Taxi Stand"       ////taxi_stand


    };

    private int[] transportIcons = {
            R.drawable.airport,
            R.drawable.transports,
            R.drawable.metro,
            R.drawable.transports,
            R.drawable.transports
    };

    private String[] loungeNames = {
            "Bar",
            "Night Club",      //night_club
            "Movie rental",   //movie_rental
            "Movie theater", //movie_theater
            "Park"
    };

    private int[] loungeIcons = {
            R.drawable.bars,
            R.drawable.discos,
            R.drawable.movierent,
            R.drawable.movietheater,
            R.drawable.park,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        prepareServices();

        setContentView(R.layout.activity_service_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        curr_address = (TextView) findViewById(R.id.current_address);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        assert mRecyclerView != null;

        mRecyclerView.setHasFixedSize(true);
       grid = new GridLayoutManager(this, 2);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ItemDecoration itemDecoration = new ItemDecoration(this, R.dimen.item_offset);
        mRecyclerView.addItemDecoration(itemDecoration);
        mRecyclerView.setLayoutManager(grid);

        mAdapter = new ItemAdapter(mItems, this);
        mRecyclerView.setAdapter(mAdapter);

        //we check the saved instancestate if in case you save the state of the application in a bundle,
        // when the activity activity needs to be recreated (e.g., orientation change)

          if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                curr_address.setText(extras.getString("Current_Address"));
            } else {
                curr_address.setText(null);
            }
        } else {
            curr_address.setText((String) savedInstanceState.getSerializable("Current_Address"));
        }


     /* GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CustomGridViewAdapter(ServicesArround.this, mThumbIds, listOfServices));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startIntentChoosed(position, (String) curr_address.getText());


            }
        });*/
    }

    //we check the saved instancestate if in case you save the state of the application in a bundle,
    // when the activity activity needs to be recreated (e.g., orientation change)


    public void startIntentChoosed(String type, String address) {

        switch (type) {
            case "Services":

                Intent localServices = new Intent(this, ServiceChoosed.class);
                localServices.putExtra("LOCATION", address);
                localServices.putExtra("CURRENT_SERVICES", servicesNames);
                localServices.putExtra("CURRENT_ICONS", servicesIcons);
                startActivity(localServices);
                break;
            case "Restaurants":

                Intent restaurantsServices = new Intent(this, ServiceChoosed.class);
                restaurantsServices.putExtra("LOCATION", address);
                restaurantsServices.putExtra("CURRENT_SERVICES", restaurantsNames);
                restaurantsServices.putExtra("CURRENT_ICONS", restaurantsIcons);
                startActivity(restaurantsServices);
                break;
            case "Lounge":

                Intent loungeServices = new Intent(this, ServiceChoosed.class);
                loungeServices.putExtra("LOCATION", address);
                loungeServices.putExtra("CURRENT_SERVICES", loungeNames);
                loungeServices.putExtra("CURRENT_ICONS", loungeIcons);
                startActivity(loungeServices);

                break;
            case "Shopping":

                Intent shoppingServices = new Intent(this, ServiceChoosed.class);
                shoppingServices.putExtra("LOCATION", address);
                shoppingServices.putExtra("CURRENT_SERVICES", shoppingNames);
                shoppingServices.putExtra("CURRENT_ICONS", shoopingIcons);
                startActivity(shoppingServices);

                break;
            case "Transports":

                Intent transportServices = new Intent(this, ServiceChoosed.class);
                transportServices.putExtra("LOCATION", address);
                transportServices.putExtra("CURRENT_SERVICES", transportsNames);
                transportServices.putExtra("CURRENT_ICONS", transportIcons);
                startActivity(transportServices);

                break;

            default:
                break;

        }
    }


    @Override
    public void onItemClicked(Item item) {
        if (item != null) {

            startIntentChoosed(item.getType(), (String) curr_address.getText());
            Toast.makeText(this, "You just selected " + item.getType() + "!", Toast.LENGTH_SHORT).show();
        }
    }
}



