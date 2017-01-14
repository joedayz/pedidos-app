package pe.joedayz.pedidoapp.lib.base;

/**
 * Created by josediaz on 2/12/2016.
 */

public interface EventBus {

    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
