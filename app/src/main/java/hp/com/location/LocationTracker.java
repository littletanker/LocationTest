package hp.com.location;

import android.location.Location;

/**
 * @ClassName: LocationTracker
 * @Description: ${todo}
 * @Author huanpei.tan
 * @Date 2015/3/23 14:52
 */
public interface LocationTracker {

    public interface LocationUpdateListener {
        public void onUpdate(Location oldLoc, long oldTime, Location newLoc, long newTime);
    }

    public void start();

    public void start(LocationUpdateListener update);

    public void stop();

    public boolean hasLocation();

    public boolean hasPossiblyStaleLocation();

    public Location getLocation();

    public Location getPossiblyStaleLocation();

}

