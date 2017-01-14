package pe.joedayz.pedidoapp.lib.di;

import javax.inject.Singleton;

import dagger.Component;
import pe.joedayz.pedidoapp.ProformaAppModule;


/**
 * Created by josediaz on 2/12/2016.
 */

@Singleton
@Component(modules = {LibsModule.class, ProformaAppModule.class})
public interface LibsComponent {
}
