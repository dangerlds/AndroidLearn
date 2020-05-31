package com.dangerdasheng.litepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createBtn = (Button)findViewById(R.id.create);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        Button addBtn = (Button)findViewById(R.id.add_data);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setAuthor("dasheng1");
                book.setName("AAA");
                book.setPages(1000);
                book.setPrice(111.11);
                book.setPress("Unknow");
                book.save();
            }
        });

        Button update = (Button)findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Book book = new Book();
//                book.setAuthor("dasheng2");
//                book.setName("BBB");
//                book.setPages(2000);
//                book.setPrice(222.11);
//                book.setPress("Unknow");
//                book.save();
//                book.setPrice(222.22);
//                book.save();
//                Book book = new Book();
//                book.setPrice(111.99);
//                book.setAuthor("dasheng1");
//                book.updateAll("author = ? ","dasheng");
                Book book = new Book();
                book.setToDefault("pages");
                book.update(1);
            }
        });

        Button deleteBtn = (Button)findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"id = 1");
            }
        });

        Button queryBtn = (Button)findViewById(R.id.search);
        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book : books){
                    Log.d(TAG,book.getName());
                    Log.d(TAG,book.getAuthor());
                    Log.d(TAG,book.getPress());
                    Log.d(TAG,"" + book.getPages());
                    Log.d(TAG,"" + book.getPrice());
                }
            }
        });
    }
}
