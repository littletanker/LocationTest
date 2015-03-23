package hp.com.location;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements LocationTracker.LocationUpdateListener {

    private TextView location;
    private StringBuffer msg =new StringBuffer();

    @Override
    public void onUpdate(Location oldLoc, long oldTime, Location newLoc, long newTime) {
        msg.append("\n");
        msg.append("location change:"+newLoc.getLongitude()+","+newLoc.getLatitude());
        location.setText(msg);
    }

    private FallbackLocationTracker fallbackLocationTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location = (TextView) findViewById(R.id.location);
        fallbackLocationTracker = new FallbackLocationTracker(this);
        fallbackLocationTracker.start(this);
        setLocation();
    }

    private void setLocation(){
        Location location1 = fallbackLocationTracker.getPossiblyStaleLocation();
        msg.append(location1.getLongitude()+","+location1.getLatitude());
        location.setText(msg);
    }


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
