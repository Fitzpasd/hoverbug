package io.shanefitzpatrick.hoverbug;

import android.content.Intent;

import io.mattcarroll.hover.HoverMenuAdapter;
import io.mattcarroll.hover.defaulthovermenu.window.HoverMenuService;

public class DemoHoverMenuService extends HoverMenuService {

    private AddContentHoverMenuAdapter addContentHoverMenuAdapter;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getBooleanExtra(MainActivity.ADD_CONTENT, false)) {
            addContentHoverMenuAdapter.onAddContent();
        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected HoverMenuAdapter createHoverMenuAdapter() {
        addContentHoverMenuAdapter = new AddContentHoverMenuAdapter(this);
        return addContentHoverMenuAdapter;
    }
}
