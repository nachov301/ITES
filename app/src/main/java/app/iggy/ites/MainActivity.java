package app.iggy.ites;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private ListView contactNames;
    FloatingActionButton fab = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contactNames = (ListView) findViewById(R.id.contact_names);


                    Log.d(TAG, "onClick: starts");
                    final ArrayList<Item> contactsList = new ArrayList<Item>();

        Item contact = new Item("Jorge", "Lorem ipsum dolor sit amet", "Hola", "pink");
        contactsList.add(contact);

        Item contact2 = new Item("Juan", "Lorem ipsum dolor sit amet", "Hola soy Juan y tengo 29 años", "blue");
        contactsList.add(contact2);

        Item contact3 = new Item("Pedro", "Lorem ipsum dolor sit amet", "Hola soy Pedro y tengo 49 años", "blue");
        contactsList.add(contact3);

        Item contact4 = new Item("Frigoberto", "Lorem ipsum dolor sit amet", "Hola soy Frigoberto y tengo 89 años", "yellow");
        contactsList.add(contact4);

        Item contact5 = new Item("Ruperta", "Lorem ipsum dolor sit amet", "Hola soy Ruperta y tengo 16 años", "blue");
        contactsList.add(contact5);

        Item contact6 = new Item("Jorgelina", "Lorem ipsum dolor sit amet", "Hola soy Jorgelina y tengo 26 años", "gray");
        contactsList.add(contact6);

        Item contact7 = new Item("Ricardo", "Lorem ipsum dolor sit amet", "Hola soy Ricardo y tengo 36 años", "blue");
        contactsList.add(contact7);

        Item contact8 = new Item("Ignacio", "Lorem ipsum dolor sit amet", "Hola soy Ignacio y tengo 26 años", "blue");
        contactsList.add(contact8);

        Item contact9 = new Item("Horacio", "Lorem ipsum dolor sit amet", "Hola soy Horacio y tengo 36 años", "blue");
        contactsList.add(contact9);

        Item contact10 = new Item("Pedro", "Lorem ipsum dolor sit amet", "Hola soy Pedro y tengo 36 años", "red");
        contactsList.add(contact10);

                    final Adapter adapter = new Adapter(MainActivity.this, R.layout.contact_detail, contactsList);
                    contactNames.setAdapter(adapter);

                    contactNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String content = contactsList.get(position).getContenido();
                            Toast.makeText(MainActivity.this, "Item numero: " + position + " Contenido: " + content, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            intent.putExtra(PHOTO_TRANSFER, adapter.getItem(position));
                            startActivity(intent);
                        }
                    });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar Item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
