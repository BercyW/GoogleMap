package security.bercy.com.week5day4googlemap.utils;

/**
 * Created by Bercy on 1/19/18.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);
    void detachView();
}
