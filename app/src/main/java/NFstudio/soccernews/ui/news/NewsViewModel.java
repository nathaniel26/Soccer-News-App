package NFstudio.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import NFstudio.soccernews.ui.dominio.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mNews;

    public NewsViewModel() {
        mNews = new MutableLiveData<>();

        List<News> noticias = new ArrayList<>();
        noticias.add(new News("Gremio perde novamente", "Gremio é derrotado " +
                "pelo Naltico"));

        noticias.add(new News("Vitoria Colorada", "Inter vence " +
                "o colo colo por 4x1"));

        noticias.add(new News("CR7 Vem para o inter?", "CR7" +
                "Visita o beira-rio para discutir possivel contrato"));

        mNews.setValue(noticias);

    }

    public LiveData<List<News>> getText() {
        return mNews;
    }
}