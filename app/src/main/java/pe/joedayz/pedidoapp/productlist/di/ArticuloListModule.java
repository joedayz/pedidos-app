package pe.joedayz.pedidoapp.productlist.di;



import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pe.joedayz.pedidoapp.productlist.ArticuloListInteractor;
import pe.joedayz.pedidoapp.productlist.ArticuloListInteractorImpl;
import pe.joedayz.pedidoapp.productlist.ArticuloListPresenter;
import pe.joedayz.pedidoapp.productlist.ArticuloListPresenterImpl;
import pe.joedayz.pedidoapp.productlist.ArticuloListRepository;
import pe.joedayz.pedidoapp.productlist.ui.ArticuloListView;
import pe.joedayz.pedidoapp.productlist.ArticuloListRepositoryImpl;
import pe.joedayz.pedidoapp.lib.base.EventBus;
import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenre;
import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenreAdapter;


/**
 * Created by josediaz on 12/23/16.
 */


@Module
public class ArticuloListModule {

    ArticuloListView view;

    public ArticuloListModule(ArticuloListView view){
        this.view = view;
    }


    @Provides
    @Singleton
    ArticuloListView providesArticuloListView() {
        return this.view;
    }


    @Provides @Singleton
    ArticuloListPresenter providesArticuloListPresenter(EventBus eventBus,
                                                        ArticuloListView articuloListView,
                                                        ArticuloListInteractor articuloListInteractor) {
        return new ArticuloListPresenterImpl(eventBus, articuloListView, articuloListInteractor);
    }

    @Provides @Singleton
    ArticuloListInteractor providesArticuloListInteractor(ArticuloListRepository repository) {
        return new ArticuloListInteractorImpl(repository);
    }


    @Provides @Singleton
    ArticuloListRepository providesArticuloListRepository(EventBus eventBus) {
        return new ArticuloListRepositoryImpl(eventBus);
    }


    @Provides @Singleton
    SingleCheckGenreAdapter provideArticulosAdapter(List<SingleCheckGenre> genres) {
        return new SingleCheckGenreAdapter(genres);
    }

    @Provides @Singleton
    List<SingleCheckGenre> provideArticuloList() {
        return new ArrayList<SingleCheckGenre>();
    }

}
