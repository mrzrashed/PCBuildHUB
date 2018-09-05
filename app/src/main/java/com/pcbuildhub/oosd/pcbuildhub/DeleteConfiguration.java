package com.pcbuildhub.oosd.pcbuildhub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class DeleteConfiguration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_configuration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.menu_add_configuration:
                startActivity(new Intent(this,AddConfiguration.class));
                break;
            case R.id.menu_update_configuration:
                startActivity(new Intent(this,UpdateConfiguration.class));
                break;
            case R.id.menu_delete_configuration:
                startActivity(new Intent(this,DeleteConfiguration.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
