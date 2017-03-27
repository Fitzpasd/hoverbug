package io.shanefitzpatrick.hoverbug;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import io.mattcarroll.hover.Navigator;
import io.mattcarroll.hover.NavigatorContent;

public class PlaceholderContent extends FrameLayout implements NavigatorContent {

    public PlaceholderContent(@NonNull Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(R.layout.view_placeholder_content, this, true);
    }

    @NonNull
    @Override
    public View getView() {
       return this;
    }

    @Override
    public void onShown(@NonNull Navigator navigator) {
        // No-op.
    }

    @Override
    public void onHidden() {
        // No-op.
    }
}
