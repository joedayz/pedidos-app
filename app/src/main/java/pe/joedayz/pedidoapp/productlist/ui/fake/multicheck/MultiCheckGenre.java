package pe.joedayz.pedidoapp.productlist.ui.fake.multicheck;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;

import java.util.List;

import pe.joedayz.pedidoapp.productlist.ui.fake.Artist;


public class MultiCheckGenre extends MultiCheckExpandableGroup {

    private int iconResId;

    public MultiCheckGenre(String title, List<Artist> items, int iconResId) {
        super(title, items);
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }
}

