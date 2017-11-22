package hafizdwp.app.androidmvpexample.feature.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import hafizdwp.app.androidmvpexample.R;
import hafizdwp.app.androidmvpexample.data.DataManager;
import hafizdwp.app.androidmvpexample.data.model.RestClient;
import hafizdwp.app.androidmvpexample.data.pojo.ApiGithubPojo;
import hafizdwp.app.androidmvpexample.feature.base.BaseActivity;

/**
 * Created by Asus on 11/21/2017.
 */

public class MainActivity extends BaseActivity implements MainView {

    @BindView(R.id.main_et)
    EditText editText;
    @BindView(R.id.main_btn)
    Button button;

    private RestClient restClient = RestClient.getInstance();
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseBind();

        mPresenter = new MainPresenter(new DataManager(restClient.getApiService()));
        mPresenter.attachView(this);

        //request api
        button.setOnClickListener(view -> {
            String username = editText.getText().toString();
            mPresenter.requestApi(username);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /* MvpView implementation */

    @Override
    public void onRequestApiSuccess(ApiGithubPojo pojo) {

        String avatar = pojo.getAvatarUrl();
        String login = pojo.getLogin();
        String url = pojo.getUrl();
        String htmlUrl = pojo.getHtmlUrl();
        int id = pojo.getId();
        int followers = pojo.getFollowers();
        int following = pojo.getFollowing();

        View view = getLayoutInflater().inflate(R.layout.dialog_main, null);
        ImageView imageView = view.findViewById(R.id.main_dialog_imageview);
        TextView textView = view.findViewById(R.id.main_dialog_textview);

        //set content
        if (avatar != null){
            Glide.with(this).load(avatar).into(imageView);
        }
        textView.setText(new StringBuilder()
                .append(" login: " + login)
                .append("\n id: " + id)
                .append("\n url: " + url)
                .append("\n htmlUrl: " + htmlUrl)
                .append("\n followers: " + followers)
                .append("\n following: " + following)
        );

        new AlertDialog.Builder(this)
                .setTitle("Result")
                .setView(view)
                .setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    @Override
    public void showLoading(boolean isShow) {
        baseShowLoading(isShow);
    }

    @Override
    public void showError(String errorMessage) {
        baseShowToast(errorMessage);
    }

    /* End of MvpView implementation */
}
