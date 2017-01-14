package pe.joedayz.pedidoapp.productlist;

/**
 * Created by josediaz on 12/23/16.
 */

public class ArticuloListInteractorImpl implements ArticuloListInteractor {

    private ArticuloListRepository articuloListRepository;

    public ArticuloListInteractorImpl(ArticuloListRepository repository) {
        this.articuloListRepository = repository;
    }

    @Override
    public void obtenerArticulos() {
        articuloListRepository.obtenerArticulos();

    }
}
