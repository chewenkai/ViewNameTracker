package cf.chewenkai.viewnametracker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by calvinche
 * on 2018/12/19
 * Email: calvinche@tencent.com
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_main, container, false);
        rootView.findViewById(R.id.activity_jump_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Hi", Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
