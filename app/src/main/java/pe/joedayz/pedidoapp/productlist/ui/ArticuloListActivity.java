package pe.joedayz.pedidoapp.productlist.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import pe.joedayz.pedidoapp.ProformaApp;
import pe.joedayz.pedidoapp.R;
import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenre;
import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenreAdapter;


import pe.joedayz.pedidoapp.productlist.ArticuloListPresenter;
import pe.joedayz.pedidoapp.base.BaseActivity;



/**
 * Created by josediaz on 12/13/16.
 */

public class ArticuloListActivity extends BaseActivity implements ArticuloListView {


    @Bind(R.id.clear_button)
    Button btnLimpiarArticulos;

    @Bind(R.id.mSearch)
    SearchView sv;

    @Bind(R.id.recycler_articulos)
    RecyclerView recyclerView;

    @Bind(R.id.progressBarArticulos)
    ProgressBar progressBar;

    private ProformaApp app;

    @Inject
    ArticuloListPresenter presenter;

    @Inject
    SingleCheckGenreAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);
        ButterKnife.bind(this);
        app = (ProformaApp) getApplication();

        
        setupToolbar();

        setupInjection();


        presenter.onCreate();
        presenter.obtenerArticulos();


        //SEARCH
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                //FILTER AS YOU TYPE


                ((SingleCheckGenreAdapter) recyclerView.getAdapter()).getFilter().filter(query);

                return false;
            }
        });

    }

    private void setupRecyclerView(List<SingleCheckGenre> data) {

        recyclerView.setLayoutManager(new  LinearLayoutManager(this));
        recyclerView.setAdapter(new SingleCheckGenreAdapter(data));
    }

    private void setupInjection() {

        app.getArticuloListComponent(this).inject(this);

    }


    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
            case R.id.action_logout:
                logout();


        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.clear_button)
    public void handleLimpiarArticulos() {

        ((SingleCheckGenreAdapter) recyclerView.getAdapter()).clearChoices();
    }

    @Override
    protected int getSelfNavDrawerItem() {
        return R.id.nav_articulos;
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setArticulos(List<SingleCheckGenre> data) {
        setupRecyclerView(data);

    }


}
