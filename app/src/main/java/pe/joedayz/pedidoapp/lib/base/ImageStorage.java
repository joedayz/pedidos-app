package pe.joedayz.pedidoapp.lib.base;

import java.io.File;

/**
 * Created by josediaz on 2/12/2016.
 */

public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
