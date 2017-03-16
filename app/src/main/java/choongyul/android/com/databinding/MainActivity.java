package choongyul.android.com.databinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import choongyul.android.com.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setActivity(this);

        binding.rcContent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        setRecyclerView();

    }
    private void setRecyclerView() {

        binding.rcContent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rcContent.addItemDecoration(new SimpleDividerItemDecoration(this));
        CustomAdapter adapter = new CustomAdapter(this);
        binding.rcContent.setAdapter(adapter);


        adapter.updateItems(DataUtil.getUsers());

    }




    public void onButtonClick(View view) {
        Toast.makeText(this,"Button Click",Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.button:

                break;
            case R.id.button2:
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
        }

    }
    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public static void loadImage(ImageView imageView, String url, Drawable errorDrawable) {
        ImageUtil.loadImage(imageView, url, errorDrawable);
    }
}

class DataUtil {


    public static List<User> getUsers(){


        List<User> users = new ArrayList();

        users.add(new User("Ted",32,"http://cfile25.uf.tistory.com/image/251F6B4C558E627E26807B"));
        users.add(new User("Jane",20,"http://image.celebtide.com/celeb/new/ve/279_ve_1452259300.jpg"));
        users.add(new User("Paul",40,"http://res.heraldm.com/content/image/2013/12/01/20131201000224_0.jpg"));
        users.add(new User("Ailee",25,"http://cfile8.uf.tistory.com/image/194599374F7049A9010251"));



        return users;
    }



}






/**
 * Created by TedPark on 15. 11. 26..
 */
class SimpleDividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;

    public SimpleDividerItemDecoration(Context context) {
        mDivider = context.getResources().getDrawable(R.drawable.line_divider);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + mDivider.getIntrinsicHeight();

            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}