package org.robolectric.shadows;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.TestRunners;
import org.robolectric.annotation.Config;

import static android.os.Build.VERSION_CODES.JELLY_BEAN_MR2;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(TestRunners.MultiApiWithDefaults.class)
@Config(minSdk = JELLY_BEAN_MR2)
public class ShadowBluetoothManagerTest {
    private final BluetoothManager manager = (BluetoothManager) RuntimeEnvironment.application.getSystemService(Context.BLUETOOTH_SERVICE);

    @Test
    public void getAdapter_shouldReturnBluetoothAdapter() {
        assertThat(manager.getAdapter()).isSameAs(BluetoothAdapter.getDefaultAdapter());
    }
}
