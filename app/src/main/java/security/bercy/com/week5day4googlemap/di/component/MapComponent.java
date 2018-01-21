package security.bercy.com.week5day4googlemap.di.component;

import dagger.Component;
import security.bercy.com.week5day4googlemap.view.MapActivity;

/**
 * Created by Bercy on 1/20/18.
 */
@Component
public interface MapComponent {
    void inject(MapActivity activity);
}
