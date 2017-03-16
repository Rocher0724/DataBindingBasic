package choongyul.android.com.databinding;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by myPC on 2017-03-16.
 */

public class ImageUtil {

    public static void loadImage(ImageView imageView, String url, Drawable errorDrawable) {
        Glide.with(imageView.getContext()).load(url).error(errorDrawable).into(imageView);
    }

}