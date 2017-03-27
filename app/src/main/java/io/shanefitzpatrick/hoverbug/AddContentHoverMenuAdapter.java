package io.shanefitzpatrick.hoverbug;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.mattcarroll.hover.HoverMenuAdapter;
import io.mattcarroll.hover.NavigatorContent;

public class AddContentHoverMenuAdapter implements HoverMenuAdapter {

    private final Context context;
    private final Set<ContentChangeListener> contentChangeListeners;
    private final List<NavigatorContent> content;

    public AddContentHoverMenuAdapter(Context context) {
        this.context = context;
        this.contentChangeListeners = new HashSet<>();
        this.content = new ArrayList<>();
        this.content.add(new PlaceholderContent(this.context));
    }

    public void onAddContent() {
        content.add(new PlaceholderContent(context));
        notifyDataSetChanged();
    }

    @Override
    public int getTabCount() {
        return content.size();
    }

    @Override
    public long getTabId(int position) {
        return position;
    }

    @Override
    public View getTabView(int position) {
        return createTabView(R.drawable.ic_orange_circle, 0xFFFF9600, null);
    }

    @Override
    public NavigatorContent getNavigatorContent(int position) {
        return content.get(position);
    }

    @Override
    public void addContentChangeListener(@NonNull ContentChangeListener listener) {
        contentChangeListeners.add(listener);
    }

    @Override
    public void removeContentChangeListener(@NonNull ContentChangeListener listener) {
        contentChangeListeners.remove(listener);
    }

    private void notifyDataSetChanged() {
        for (ContentChangeListener listener : contentChangeListeners) {
            listener.onContentChange(this);
        }
    }

    private View createTabView(@DrawableRes int tabBitmapRes, @ColorInt int backgroundColor, @ColorInt Integer iconColor) {
        Resources resources = context.getResources();
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, resources.getDisplayMetrics());

        DemoTabView view = new DemoTabView(context, resources.getDrawable(R.drawable.tab_background), resources.getDrawable(tabBitmapRes));
        view.setTabBackgroundColor(backgroundColor);
        view.setTabForegroundColor(iconColor);
        view.setPadding(padding, padding, padding, padding);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.setElevation(padding);
        }
        return view;
    }
}
