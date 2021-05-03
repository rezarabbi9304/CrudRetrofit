package com.example.postapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PostApi {

/*@POST("create")
    Call<PostModel> createPost(@Body PostModel postModel);*/


    @GET("users")
    Call<List<UserModel>> getUsers();


    //below successful post
/*    @POST("posts")
    Call<ModelPost2> createPost(@Body ModelPost2 modelPost2);*/
    @POST("create")
    Call<PostModelDummy> createPost(@Body PostModelDummy postModelDummy);

    @POST("quotes")
    Call<AnimModel> createAnimPost(@Body AnimModel animModel);

    //below successful
    @POST("users")
    Call<UserModel> createUser(@Body UserModel userModel);

    @PUT("users/{id}")
  Call<UserModel> createPut(   @Path("id") int id ,@Body UserModel userModel);

    //below working on it
    @PUT("posts/{id}")
    Call<ModelPost2> getPut(@Path("id") int id , @Body ModelPost2 modelPost2);

    @PUT("users")
    Call<UserModel> createPut2(@Query("page") int page , @Query("id") int id ,  @Body UserModel userModel);

     @DELETE("users/2")
      Call<Void> createDelet();

     @PATCH("users/2")
    Call<UserModel> createPatch(@Body UserModel userModel);


}
