package pe.joedayz.pedidoapp.productlist;

import java.util.List;

import pe.joedayz.pedidoapp.api.ProductService;
import pe.joedayz.pedidoapp.productlist.events.ArticuloListEvent;

import pe.joedayz.pedidoapp.domain.Product;
import pe.joedayz.pedidoapp.lib.base.EventBus;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by josediaz on 12/23/16.
 */

public class ArticuloListRepositoryImpl implements ArticuloListRepository {

    private EventBus eventBus;

    private final Retrofit mRetrofit;

    public static final String BASE_URL_REAL_DOMAIN
            = "http://<PON-AQUI-TU-DOMINIO-O-IP-PUBLICA>/api.appproducts.com/v1/";
    public static final String BASE_URL_REAL_DEVICE =
            "http://<PON-AQUI-TU-IP-LOCAL/api.appproducts.com/v1/";
    public static final String BASE_URL_AVD = "http://10.0.2.2/api.appproducts.com/v1/";
    public static final String BASE_URL_GENYMOTION = "http://10.0.3.2/api.appproducts.com/v1/";

    private final ProductService mRestService;

    public ArticuloListRepositoryImpl(EventBus eventBus) {
        this.eventBus = eventBus;

        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_AVD)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();

        mRestService = mRetrofit.create(ProductService.class);
    }

    @Override
    public void obtenerArticulos() {


        Observable<List<Product>> call = mRestService.getProducts();


        call.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(articulos -> {
                    post(ArticuloListEvent.READ_EVENT, articulos);
                });




    }
    private void post(int type, String errorMessage, List<Product> products) {
        ArticuloListEvent event = new ArticuloListEvent();
        event.setType(type);
        event.setErrorMesage(errorMessage);
        event.setProducts(products);
        eventBus.post(event);
    }

    private void post(int type, List<Product> products) {
        ArticuloListEvent event = new ArticuloListEvent();
        event.setProducts(products);
        event.setType(type);
        eventBus.post(event);
    }

    private void post(int type) {
        post(type, null);
    }
}
