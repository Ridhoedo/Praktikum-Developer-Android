package id.ac.poliban.e020320049.listindemo;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private final Context mContext;
    private final List<String> mList;

    public FriendAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_layout, parent, false);


        return new  ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvFriend.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFriend;
        private final FriendAdapter mAdapter;

        public ViewHolder(@NonNull View itemView, FriendAdapter mAdapter) {
            super(itemView);
            tvFriend = itemView.findViewById(R.id.tv_item);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this::onItemClicked);
            itemView.setOnLongClickListener(this::onItemLongClicked);
        }

        private boolean onItemLongClicked(View view) {
            //ingin menghapus data
            int pos = getLayoutPosition();
            String friend = mAdapter.mList.get(pos);
            new AlertDialog.Builder(mContext)
                    .setTitle("Delete Confirmation")
                    .setMessage(String.format("Delete Your Friends %s", friend))
                    .setNegativeButton("cancel", null)
                    .setPositiveButton("Yes", (dialogInterface, i) -> {
                        mAdapter.mList.remove(friend); // hapus item di list
                        mAdapter.notifyDataSetChanged(); // tampilkan oerubahan ke ryceclerView
                    })
                    .show();

            return true;
        }

        private void onItemClicked(View view) {
            //tangkap posisi item yg diklik
            int pos = getLayoutPosition();
            String item = mAdapter.mList.get(pos);
            //tampilkan item di snackbar
            Snackbar.make(view, String.format("$s terkena clicked!", item), Snackbar.LENGTH_SHORT)
                    .show();

        }
    }
}
