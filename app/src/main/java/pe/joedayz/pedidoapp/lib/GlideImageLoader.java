package pe.joedayz.pedidoapp.lib;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import pe.joedayz.pedidoapp.lib.base.ImageLoader;

/**
 * Created by josediaz on 2/12/2016.
 */

public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;

    public void setLoaderContext(Fragment fragment) {
        this.glideRequestManager = Glide.with(fragment);
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(800, 800)
                .centerCrop()
                .into(imageView);
    }
}
