
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Ghanshyam.
 */
public class TouchableMapFragment extends SupportMapFragment{

    private View mOriginalContentView;
    private TouchableWrapper mTouchView;

    public void setTouchListener(TouchableWrapper.OnTouchListener onTouchListener) {
        if(mTouchView != null)
           mTouchView.setTouchListener(onTouchListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        mOriginalContentView = super.onCreateView(inflater, parent,
                savedInstanceState);

        mTouchView = new TouchableWrapper(getActivity());
        mTouchView.addView(mOriginalContentView);

        return mTouchView;
    }

    @Override
    public View getView() {
        return mOriginalContentView;
    }

}
