package com.joker.bidit.dashboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.joker.bidit.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class ProductAdaptor extends RecyclerView.Adapter<ProductsViewHolder> {

    private List<Product> products;
    private Context context;

    public Context getContext() {
        return context;
    }

    public ProductAdaptor(List<Product> products) {
        this.products = products;
    }

    public ProductAdaptor(Context context, List<Product> data) {
        this.context = context;
        this.products = data;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ProductsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Product currentProduct = products.get(position);

        holder.mTextViewName.setText(currentProduct.getName());
        holder.mTextViewColorAndWeight.setText(currentProduct.getColor() + " /" +
                currentProduct.getWeight());
        holder.mTextViewPrice.setText(currentProduct.getPrice() + " RON");

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        StorageReference storageReference = firebaseStorage.getReference();

        storageReference.child(firebaseAuth.getUid()).child("Images").child(currentProduct.getName())
                .getDownloadUrl().addOnSuccessListener(uri -> {
            // Using "Picasso" (http://square.github.io/picasso/) after adding the dependency in the Gradle.
            // ".fit().centerInside()" fits the entire image into the specified area.
            // Finally, add "READ" and "WRITE" external storage permissions in the Manifest.
            Picasso.get().load(uri).fit().centerInside().into(holder.getImageView());
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
