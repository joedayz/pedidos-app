package pe.joedayz.pedidoapp.api;

import pe.joedayz.pedidoapp.domain.Product;
import rx.Observable;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by josediaz on 12/12/16.
 */

public interface ProductService {

    @GET("products")
    Call<List<Product>> getProductsByName(@Query("name") String name);

    @GET("products")
    Observable<List<Product>> getProducts();



}
