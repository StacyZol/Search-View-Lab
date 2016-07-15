package ly.generalassemb.drewmahrt.shoppinglistwithsearch;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ly.generalassemb.drewmahrt.shoppinglistwithsearch.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    //ListView listView;
    //List<GroceryListItem> items = new ArrayList<GroceryListItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        //ShoppingSQLiteOpenHelper instance = new ShoppingSQLiteOpenHelper(this);
        Cursor cursor = ShoppingSQLiteOpenHelper.getInstance(MainActivity.this).groceryList();
        ListView listView = (ListView) findViewById(R.id.main_list_view);

        CursorAdapter adapter = new CursorAdapter(MainActivity.this,cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER) {

            @Override
            public View newView(Context context, Cursor cursor, ViewGroup Viewgroup) {
                return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, Viewgroup, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView textView = (TextView) view.findViewById(android.R.id.text1);
            int grocery = cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME);

                textView.setText(cursor.getString(grocery));
            }
        };
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        ComponentName componentName = new ComponentName(this,SearchResultActivity.class);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName));


        return true;
    }



    }

