package NFstudio.soccernews.ui.news;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import NFstudio.soccernews.data.SoccerNewsApi;
import NFstudio.soccernews.ui.dominio.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mNews = new MutableLiveData<>();
    private final SoccerNewsApi api;


    public NewsViewModel() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://nathaniel26.github.io/Soccer-News-App-Api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(SoccerNewsApi.class);

        this.findNews();
    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()){
                    mNews.setValue(response.body());

                }
                else{
                    //pensar no tratamento de erro
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //pensar no tratamento de erro

            }
        });
    }

    public LiveData<List<News>> getNews() {
        return mNews;
    }
}