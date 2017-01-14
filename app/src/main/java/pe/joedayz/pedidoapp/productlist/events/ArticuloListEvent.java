package pe.joedayz.pedidoapp.productlist.events;

import java.util.List;

import pe.joedayz.pedidoapp.domain.Product;

/**
 * Created by josediaz on 12/23/16.
 */

public class ArticuloListEvent {

    private int type;
    private List<Product> products;
    public final static int READ_EVENT = 0;
    public final static int ERROR_EVENT=1;
    private String errorMesage;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMesage = errorMesage;
    }
}
