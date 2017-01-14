package pe.joedayz.pedidoapp.productlist.ui;


import java.util.List;

import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenre;

/**
 * Created by josediaz on 12/23/16.
 */

public interface ArticuloListView {

    void showProgress();
    void hideProgress();

    void setArticulos(List<SingleCheckGenre> data);


}
