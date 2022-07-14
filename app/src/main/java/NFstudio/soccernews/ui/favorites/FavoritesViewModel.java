package NFstudio.soccernews.ui.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import NFstudio.soccernews.R;

public class FavoritesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FavoritesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is favorites fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}