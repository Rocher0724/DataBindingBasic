package choongyul.android.com.databinding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import choongyul.android.com.databinding.common.view.BaseRecyclerViewAdapter;
import choongyul.android.com.databinding.databinding.ListItemBinding;


/**
 * Created by myPC on 2017-03-16.
 */

public class CustomAdapter extends BaseRecyclerViewAdapter<User, CustomAdapter.UserViewHolder> {

    public CustomAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindView(UserViewHolder holder, int position) {
        User user = getItem(position);
        holder.binding.setUser(user);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new UserViewHolder(view);
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ListItemBinding binding;

        public UserViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }




}


