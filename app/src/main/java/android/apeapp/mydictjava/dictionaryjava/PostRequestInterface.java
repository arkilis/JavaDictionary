package android.apeapp.mydictjava.dictionaryjava;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ben on 6/2/18.
 */

public interface PostRequestInterface {

    @POST("v2?key=AIzaSyAFxNjprKkTrbdDJcR6sqA55ZDxy8HOi3U&target=zh")
    @FormUrlEncoded
    Call<TranslationModel.Data> getCall(@Field("q") String targetSentence);


}
