package NFstudio.soccernews.ui.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import NFstudio.soccernews.databinding.NewsItemBinding;
import NFstudio.soccernews.ui.dominio.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> news;

    public NewsAdapter(List<News> news){
        this.news = news;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent,
                false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        News news = this.news.get(position);

        holder.biding.tvTitle.setText(news.getTitle());
        holder.biding.tvDescription.setText(news.getDescription());

        //imagem
        Picasso.get().load(news.getImage()).fit().into(holder.biding.ivThunbnai);

        //botão link
        holder.biding.btOpenLink.setOnClickListener(View ->{

            String url = news.getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            holder.itemView.getContext().startActivity(i);

        });

    }



    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final NewsItemBinding biding;

        public ViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.biding = binding;
        }
    }
}
