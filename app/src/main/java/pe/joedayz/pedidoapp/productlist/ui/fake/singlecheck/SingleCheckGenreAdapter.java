package pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;


import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;


import java.util.ArrayList;
import java.util.List;

import pe.joedayz.pedidoapp.R;
import pe.joedayz.pedidoapp.productlist.ui.fake.Artist;
import pe.joedayz.pedidoapp.productlist.ui.fake.CustomFilter;
import pe.joedayz.pedidoapp.productlist.ui.fake.expand.GenreViewHolder;


public class SingleCheckGenreAdapter extends
        CheckableChildRecyclerViewAdapter<GenreViewHolder, SingleCheckArtistViewHolder> implements Filterable{


  public ArrayList<SingleCheckGenre> groups,filterList;
  CustomFilter filter;


  public SingleCheckGenreAdapter(List<SingleCheckGenre> groups) {
    super(groups);
    this.groups = (ArrayList<SingleCheckGenre>)groups;
    this.filterList = (ArrayList<SingleCheckGenre>)groups;
  }

  @Override
  public SingleCheckArtistViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_singlecheck_arist, parent, false);
    return new SingleCheckArtistViewHolder(view);
  }

  @Override
  public void onBindCheckChildViewHolder(SingleCheckArtistViewHolder holder, int position,
                                         CheckedExpandableGroup group, int childIndex) {
    final Artist artist = (Artist) group.getItems().get(childIndex);
    holder.setArtistName(artist.getName());
  }

  @Override
  public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_genre, parent, false);
    return new GenreViewHolder(view);
  }

  @Override
  public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition,
                                    ExpandableGroup group) {
    holder.setGenreTitle(group);
  }


  @Override
  public Filter getFilter() {
    if(filter==null)
    {
      filter=new CustomFilter(filterList,this);
    }

    return filter;
  }
}