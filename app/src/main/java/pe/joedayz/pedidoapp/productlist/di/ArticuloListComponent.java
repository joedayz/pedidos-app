package pe.joedayz.pedidoapp.productlist.di;

import javax.inject.Singleton;

import dagger.Component;
import pe.joedayz.pedidoapp.ProformaAppModule;
import pe.joedayz.pedidoapp.productlist.ui.ArticuloListActivity;

import pe.joedayz.pedidoapp.lib.di.LibsModule;



/**
 * Created by josediaz on 12/23/16.
 */


@Singleton
@Component(modules = {ArticuloListModule.class,  LibsModule.class, ProformaAppModule.class})
public interface ArticuloListComponent {
    void inject(ArticuloListActivity activity);

}
