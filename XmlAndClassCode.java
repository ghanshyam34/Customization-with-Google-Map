
XML-->

<fragment
    android:id="@+id/map"
    class=".TouchableMapFragment"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent" />




Code-->


private void setupMap() {
    try {
        touchableMapFragment = ((TouchableMapFragment) getChildFragmentManager().findFragmentById(R.id.map));
        if (touchableMapFragment == null) {

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            touchableMapFragment = (TouchableMapFragment) SupportMapFragment.newInstance();
            fragmentTransaction.replace(R.id.map, touchableMapFragment).commit();

        } else {

            touchableMapFragment.getView().setBackgroundResource(android.R.color.transparent);

        }

        if (touchableMapFragment != null) {

            touchableMapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap map) {
                    onGoogleMapReady(map);
                }
            });
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

