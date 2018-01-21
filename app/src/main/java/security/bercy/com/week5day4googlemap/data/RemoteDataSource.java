package security.bercy.com.week5day4googlemap.data;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import security.bercy.com.week5day4googlemap.model.address.FromAddressResult;

/**
 * Created by Bercy on 1/20/18.
 */

public class RemoteDataSource {
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/";
    public static final String TAG = "RemoteDataSource";
    private static final String API_KEY = "AIzaSyD_DiDOCWIf0GZ5ClOBJ0vpruknpNV7ngY";




    public static Retrofit create() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return  retrofit;


    }


    public Observable<FromAddressResult> getResultFromAddress(String address) {
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getResult(address,API_KEY);
    }



    interface RemoteService {
        @GET("json")
        Observable<FromAddressResult> getResult(
                @Query("address") String address,
                @Query("key") String key);
    }

    }
