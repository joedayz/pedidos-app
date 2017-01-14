package pe.joedayz.pedidoapp.productlist;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import pe.joedayz.pedidoapp.R;
import pe.joedayz.pedidoapp.productlist.ui.ArticuloListView;
import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenre;

import pe.joedayz.pedidoapp.productlist.events.ArticuloListEvent;
import pe.joedayz.pedidoapp.domain.Product;
import pe.joedayz.pedidoapp.lib.base.EventBus;

import static pe.joedayz.pedidoapp.productlist.ui.fake.GenreDataFactory.makeClassicArtists;


/**
 * Created by josediaz on 12/23/16.
 */

public class ArticuloListPresenterImpl implements ArticuloListPresenter {

    EventBus eventBus;
    ArticuloListView articuloListView;
    ArticuloListInteractor articuloListInteractor;


    public ArticuloListPresenterImpl(EventBus eventBus, ArticuloListView articuloListView, ArticuloListInteractor articuloListInteractor) {
        this.eventBus = eventBus;
        this.articuloListView = articuloListView;
        this.articuloListInteractor = articuloListInteractor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }


    @Override
    public void onDestroy() {
        articuloListView = null;
        eventBus.unregister(this);
    }

    @Override
    @Subscribe
    public void onEventMainThread(ArticuloListEvent event) {
        if (this.articuloListView != null) {
            switch (event.getType()){
                case ArticuloListEvent.READ_EVENT:
                    List<Product> productList = event.getProducts();
                    List<SingleCheckGenre> genreList = new ArrayList<>();

                    for(Product product : productList){
                        SingleCheckGenre genre = new SingleCheckGenre(  product.getName(), makeClassicArtists(), R.drawable.ic_violin);
                        genreList.add(genre);
                    }
                    articuloListView.setArticulos(genreList);
                    break;
                case ArticuloListEvent.ERROR_EVENT:

                    break;

            }
        }
    }


    @Override
    public void obtenerArticulos() {
        articuloListInteractor.obtenerArticulos();
    }
}
