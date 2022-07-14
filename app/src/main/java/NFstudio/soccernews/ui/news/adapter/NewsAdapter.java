package NFstudio.soccernews.ui.news.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import NFstudio.soccernews.databinding.NewsItemBinding;
import NFstudio.soccernews.ui.dominio.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> noticias;

    public NewsAdapter(List<News> noticias){
        this.noticias = noticias;
    }

    public List<News> getNoticias() {
        return noticias;
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
        News news = this.noticias.get(position);

        holder.biding.tvTitle.setText(news.getTitle());
        holder.biding.tvDescription.setText(news.getDescription());

    }

    @Override
    public int getItemCount() {
        return this.noticias.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final NewsItemBinding biding;

        public ViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.biding = binding;
        }
    }
}
