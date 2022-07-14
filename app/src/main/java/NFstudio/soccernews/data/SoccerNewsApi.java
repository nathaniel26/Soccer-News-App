package NFstudio.soccernews.data;

import java.util.List;

import NFstudio.soccernews.ui.dominio.News;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SoccerNewsApi {

    @GET("News.json")
    Call<List<News>> getNews();
}
