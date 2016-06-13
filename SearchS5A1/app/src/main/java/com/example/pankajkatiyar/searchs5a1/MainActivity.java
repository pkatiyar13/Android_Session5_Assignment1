package com.example.pankajkatiyar.searchs5a1;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtSearchKeyword = (TextView)findViewById(R.id.txtKeyword);
        final Button btnSearch = (Button)findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent searchIntent = new Intent();
                searchIntent.setAction(Intent.ACTION_WEB_SEARCH);
                String searchKeyword = txtSearchKeyword.getText().toString();
                if (searchKeyword.isEmpty()|| searchKeyword.equals("Enter Keyword to perform search")){
                    Toast.makeText(MainActivity.this,"Please Enter Search Query",Toast.LENGTH_LONG).show();
                }else {
                    searchIntent.putExtra(SearchManager.QUERY,txtSearchKeyword.getText().toString());
                    //searchIntent.getStringExtra(SearchManager.QUERY);
                    startActivity(searchIntent);
                }

            }
        });
        txtSearchKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Clicked on Button",Toast.LENGTH_SHORT).show();
                if (txtSearchKeyword.getText().equals("Enter Keyword to perform search")){
                    Log.d("Input Text",txtSearchKeyword.getText().toString());
                    txtSearchKeyword.setText("");
                }
            }
        });

    }
}
