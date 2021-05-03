package com.example.postapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView responseText;
    private PostApi postApi;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtEmail;

    private Button button;
    private Button getButton;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        responseText = findViewById(R.id.txtResponse);

        //user input

        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);

        button = findViewById(R.id.button);
        getButton = findViewById(R.id.buttonGet);





        //api links below

      /*  http://dummy.restapiexample.com/api/v1/create*/

     /*   https://jsonplaceholder.typicode.com/*/

     /*   https://animechan.vercel.app/api/quotes*/

        /*https://reqres.in/api/users*/

        
        Gson gson =new GsonBuilder().serializeNulls().create();

           Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        postApi = retrofit.create(PostApi.class);

      /*  PostModel postModel = new PostModel(1,"test run","lets see what happend");
        responseText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "on click", Toast.LENGTH_SHORT).show();
                creatPost(postModel);

            }
        });*/

       // cratePost();
        //cratePostDummy();
        //createAnimPost();


        //below successful put and delete
        //getPut();

       //createPut();
       //createPut2();

        //createDelet();

        createPatch();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Postin Data", Toast.LENGTH_SHORT).show();

                String name =  edtFirstName.getText().toString();
                String lastName=  edtLastName.getText().toString();
                String email =  edtEmail.getText().toString();

                createUser(name,lastName,email);



            }
        });

   /*     getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GetActivity.class);
                startActivity(intent);

            }
        });*/



    }

    private void createPatch() {
        UserModel userModel = new UserModel(null,"morpheus","reza");
        Call<UserModel> call = postApi.createPatch(userModel);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                responseText.setText("CODE = " + response.code());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });
    }

    private void createDelet() {
        Call<Void> call = postApi.createDelet();
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                responseText.setText("CODE=" + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                    responseText.setText(t.getMessage());
            }
        });
    }


    private void createPut2() {
        UserModel userModel = new UserModel("gmail@gmail.com","donreza","vitoe");

        Call<UserModel> call = postApi.createPut2(2,7,userModel);
        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(!response.isSuccessful()){
                    responseText.setText("CODE" + response.code());
                    return;
                }
                UserModel userModel1 = response.body();
                String content = "";
                content +="code==" + response.code() + "\n";
                content +="First_Name: " +userModel1.getFirst_name() +"\n";
                content +="Last_name: " + userModel1.getLast_name() + "\n";
                content += "Email= "  + userModel1.getEmail() + "\n";
               // content += "id" + userModel1.getId() + "\n";

                responseText.setText(content);
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                responseText.setText(t.getMessage());
            }
        });
    }

    //getPut successful
    private void getPut() {
       ModelPost2 modelPost2 = new ModelPost2(2,"hellow","world");

        Call<ModelPost2> call = postApi.getPut(2,modelPost2);
           call.enqueue(new Callback<ModelPost2>() {
               @Override
               public void onResponse(Call<ModelPost2> call, Response<ModelPost2> response) {
                   if(!response.isSuccessful()){
                       responseText.setText("code:" + response.code());
                       return;
                   }
                   ModelPost2 modelPost21 = response.body();

                   String content = "";
                   content +="Code" + response.code() + "\n";
                  // content +="ID" + modelPost21.getId() + "\n";
                   content +="User ID" + modelPost21.getUserId() + "\n";
                   content +="Title" + modelPost21.getTitle() + "\n";
                   content +="Body" + modelPost21.getBody()+ "\n";

                   responseText.setText(content);
               }

               @Override
               public void onFailure(Call<ModelPost2> call, Throwable t) {
                    responseText.setText(t.getMessage());
               }
           });

    }

    //createPut successful
    private void createPut() {
        UserModel userModel = new UserModel("reza.rabbi@email.com","don","rabbi");

        Call<UserModel> call = postApi.createPut(3,userModel);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(!response.isSuccessful()){
                    responseText.setText("Code:" + response.code());
                    return;
                }

                UserModel userModel1 = response.body();
                String content = "";
                content +="code==" + response.code() + "\n";
                content +="First_Name: " +userModel1.getFirst_name() +"\n";
                content +="Last_name: " + userModel1.getLast_name() + "\n";
                content += "Email= "  + userModel1.getEmail() + "\n";
               // content += "id" + userModel1.getId() + "\n";

                responseText.setText(content);


            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                    responseText.setText(t.getMessage());
            }
        });

    }


    private void createUser(String name,String lastName,String  email) {
     /*   UserModel userModel = new UserModel("rezarabbi@gmail.com","reza","rabbi");*/
        UserModel userModel = new UserModel(email,name,lastName);

        Call<UserModel> call = postApi.createUser(userModel);

        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                if(!response.isSuccessful()){
                    responseText.setText("CODE" + response.code());
                    return;
                }
                UserModel userModel1 = response.body();
                String content = "";
                content +="code==" + response.code() + "\n";
                content +="First_Name: " +userModel1.getFirst_name() +"\n";
                content +="Last_name: " + userModel1.getLast_name() + "\n";
                content += "Email= "  + userModel1.getEmail() + "\n";
                content += "id" + userModel1.getId() + "\n";

                responseText.setText(content);



            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                responseText.setText(t.getMessage());
            }
        });

    }

    private void createAnimPost() {
        AnimModel animModel = new AnimModel("Naruto","jr.naruto","never stop trying");
        Call<AnimModel> call = postApi.createAnimPost(animModel);
        call.enqueue(new Callback<AnimModel>() {
            @Override
            public void onResponse(Call<AnimModel> call, Response<AnimModel> response) {
                if(!response.isSuccessful())
                {
                    responseText.setText("response" + response.code());
                    return;
                }
                AnimModel animModel1 = response.body();

                String content = "";
                content+="Code" + response.code()+ "\n";
                content+="Anime: " + animModel1.getAnime() + "\n";
                content+="Character" + animModel1.getCharacter() + "\n";
                content+="Quote: " + animModel1.getQuote() +"\n";

                responseText.setText(content);

            }

            @Override
            public void onFailure(Call<AnimModel> call, Throwable t) {
                    responseText.setText(t.getMessage());
            }
        });

    }

    //successful createPostDummy

    private void cratePostDummy() {
        PostModelDummy postModelDummy = new PostModelDummy("test",123,23);
        Call<PostModelDummy> call = postApi.createPost(postModelDummy);
        call.enqueue(new Callback<PostModelDummy>() {
            @Override
            public void onResponse(Call<PostModelDummy> call, Response<PostModelDummy> response) {
                if(!response.isSuccessful()){
                    responseText.setText("Code" + response.code());
                    return;
                }
                PostModelDummy postModelDummy1 = response.body();

                String content = "";

                content += "CODE" + response.code() + "\n";
                content +="id" + postModelDummy1.getId() + "\n";
                content +="Name" + postModelDummy1.getName() + "\n";
                content +="Salary" + postModelDummy1.getSalary() + "\n";
                content +="Age" + postModelDummy1.getAge()+ "\n";

                responseText.setText(content);

            }

            @Override
            public void onFailure(Call<PostModelDummy> call, Throwable t) {
                responseText.setText(t.getMessage());

            }
        });

    }

    //successful

   /* private void cratePost() {
        ModelPost2 modelPost2 = new ModelPost2(23,"new title","new text");
        Call<ModelPost2> modelPost2Call = postApi.createPost(modelPost2);

        modelPost2Call.enqueue(new Callback<ModelPost2>() {
            @Override
            public void onResponse(Call<ModelPost2> call, Response<ModelPost2> response) {
                if(!response.isSuccessful()){
                    responseText.setText("code:" + response.code());
                    return;
                }
                ModelPost2 modelPost21 = response.body();

                String content = "";
                content +="Code" + response.code() + "\n";
                content +="ID" + modelPost21.getId() + "\n";
                content +="User ID" + modelPost21.getUserId() + "\n";
                content +="Title" + modelPost21.getTitle() + "\n";
                content +="Body" + modelPost21.getBody()+ "\n";

                responseText.setText(content);
            }

            @Override
            public void onFailure(Call<ModelPost2> call, Throwable t) {
                responseText.setText(t.getMessage());

            }
        });

    }*/




}