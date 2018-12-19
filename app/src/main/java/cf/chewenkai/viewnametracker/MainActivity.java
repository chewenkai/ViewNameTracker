package cf.chewenkai.viewnametracker;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFragment();

    }

    private void initFragment() {
        getFragmentManager().beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
