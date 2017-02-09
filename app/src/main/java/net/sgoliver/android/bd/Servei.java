package net.sgoliver.android.bd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Servei extends Service {
    public Servei() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
