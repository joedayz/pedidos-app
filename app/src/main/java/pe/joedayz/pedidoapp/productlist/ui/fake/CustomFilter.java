package pe.joedayz.pedidoapp.productlist.ui.fake;

import android.widget.Filter;

import java.util.ArrayList;

import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenre;
import pe.joedayz.pedidoapp.productlist.ui.fake.singlecheck.SingleCheckGenreAdapter;


/**
 * Created by josediaz on 12/23/16.
 */

public class CustomFilter extends Filter {

    SingleCheckGenreAdapter adapter;
    ArrayList<SingleCheckGenre> filterList;


    public CustomFilter(ArrayList<SingleCheckGenre> filterList,SingleCheckGenreAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<SingleCheckGenre> filteredPlayers=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getTitle().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.groups= (ArrayList<SingleCheckGenre>) results.values;
        adapter.setGroups((ArrayList<SingleCheckGenre>) results.values);

        adapter.notifyDataSetChanged();
    }
}