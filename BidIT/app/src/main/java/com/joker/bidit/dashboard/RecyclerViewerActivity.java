package com.joker.bidit.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joker.bidit.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerViewProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_viewer);

        initView();
    }

    private void initView() {
        mRecyclerViewProducts = findViewById(R.id.recyclerview_products);

        //set the layout manager for the current recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerViewProducts.setLayoutManager(layoutManager);

        //create the adapter
        ProductAdapter giftAdapter = new ProductAdapter(getGiftsList());

        //set the adapter to the recycler view
        mRecyclerViewProducts.setAdapter(giftAdapter);
    }

    //get the data source
    private List<Product> getGiftsList() {
        List<Product> products = new ArrayList<>();

        Product product1 = new Product("red", 3.0, "Book", 200,
                "https://images.unsplash.com/photo-1510546462255-979b0e0ca1b5?w=800&q=60");
        Product product2 = new Product("pink", 2.0, "Scarf", 20,
                "https://images.unsplash.com/photo-1514207994142-98522b5a2b23?w=800&q=60");
        Product product3 = new Product("blue", 5.0, "T-shirt", 160,
                "https://images.unsplash.com/photo-1512909481869-0eaa1e9817ba?w=800&q=60");
        Product product4 = new Product("white", 1.0, "Scarf", 80,
                "https://images.unsplash.com/photo-1514192631-251f5f0b14f2?w=800&q=60");
        Product product5 = new Product("green", 2.0, "Book", 250,
                "https://images.unsplash.com/photo-1519894520384-1ee1adbe7bd8?w=800&q=60");
        Product product6 = new Product("yellow", 1.5, "Toy car", 400,
                "https://images.unsplash.com/photo-1511837008003-71eca36ceb70?w=800&q=60");
        Product product7 = new Product("blue", 1.5, "Chocolate", 560,
                "https://images.unsplash.com/photo-1481391319762-47dff72954d9?w=800&q=60");
        Product product8 = new Product("magenta", 1.5, "Phone", 530,
                "https://images.unsplash.com/photo-1480717846107-87837abec1e9?w=800&q=60");
        Product product9 = new Product("black", 3.5, "Blazer", 520,
                "https://images.unsplash.com/photo-1513796430146-c91cf8e4d65c?w=800&q=60");
        Product product10 = new Product("orange", 7.0, "Shoes", 720,
                "https://images.unsplash.com/photo-1480632563560-30f503c09195?w=800&q=60");

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product7);
        products.add(product8);
        products.add(product9);
        products.add(product10);

        return products;
    }
}