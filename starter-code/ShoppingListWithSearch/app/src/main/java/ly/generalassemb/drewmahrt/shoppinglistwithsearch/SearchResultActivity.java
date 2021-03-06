package ly.generalassemb.drewmahrt.shoppinglistwithsearch;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by stacyzolnikov on 7/14/16.
 */
public class SearchResultActivity extends AppCompatActivity{
    ListView mListView;

   @Override
   protected void onCreate(Bundle savedInstanceState) {


       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_search_result);
       mListView = (ListView) findViewById(R.id.search_result_list);
       if(Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
           String query = getIntent().getStringExtra(SearchManager.QUERY);
           Cursor cursor = ShoppingSQLiteOpenHelper.getInstance(this).searchGroceryList(query);



               CursorAdapter adapter = new CursorAdapter(this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER) {
                   @Override
                   public View newView(Context context, Cursor cursor, ViewGroup parent) {
                       return LayoutInflater.from(context).inflate( android.R.layout.simple_list_item_1, parent, false);
                   }

                   @Override
                   public void bindView(View view, Context context, Cursor cursor) {
                       TextView textView = (TextView) view.findViewById(android.R.id.text1);
                       int grocery = cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME);

                       textView.setText(cursor.getString(grocery));
                   }
               };
               mListView.setAdapter(adapter);

           }




       }
   }



