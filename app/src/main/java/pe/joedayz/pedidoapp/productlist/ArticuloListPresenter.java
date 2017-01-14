package pe.joedayz.pedidoapp.productlist;

import pe.joedayz.pedidoapp.productlist.events.ArticuloListEvent;


/**
 * Created by josediaz on 12/23/16.
 */

public interface ArticuloListPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(ArticuloListEvent event);
    void obtenerArticulos();
}
