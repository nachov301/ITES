package app.iggy.ites;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends BaseActivity {
    private static final String TAG = "Main2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        activateToolbar(true);



        Intent intent = getIntent();

        Item item = (Item) intent.getSerializableExtra(PHOTO_TRANSFER);
        if (item!=null){
            Log.d(TAG, "onCreate: starts");
            TextView author = (TextView) findViewById(R.id.author);
            Resources resources = getResources();
            String text = resources.getString(R.string.author, item.getRemitente());
            author.setText(text);

            TextView content = (TextView) findViewById(R.id.content);
            content.setText(resources.getString(R.string.content, item.getContenido()));

            TextView subject = (TextView) findViewById(R.id.subject);
            subject.setText(resources.getString(R.string.subject, item.getAsunto()));
            Log.d(TAG, "onCreate: ends");
        }

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
