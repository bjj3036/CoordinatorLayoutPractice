package kr.hs.dgsw.coordinatorpr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MemoListAdapter extends RecyclerView.Adapter<MemoListAdapter.ViewHolder> {
    private Context context;
    private int resource;
    private ArrayList<MemoItem> itemList;

    public MemoListAdapter(Context context, int resource,
                           ArrayList<MemoItem> itemList) {
        this.context = context;
        this.resource = resource;
        this.itemList = itemList;
    }

    public void addItem(MemoItem item) {
        this.itemList.add(0, item);
        notifyDataSetChanged();
    }

    public void addItemList(ArrayList<MemoItem> itemList) {
        this.itemList.addAll(itemList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(resource, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final MemoItem item = itemList.get(i);
        viewHolder.categoryText.setText(item.category);
        viewHolder.memoText.setText(item.memo);
        viewHolder.dateText.setText(item.date);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(context, item.memo,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public int getItemCount() {
        return this.itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryText;
        TextView memoText;
        TextView dateText;

        public ViewHolder(View itemView) {
            super(itemView);
            categoryText = itemView.findViewById(R.id.category);
            memoText = itemView.findViewById(R.id.memo);
            dateText = itemView.findViewById(R.id.regdate);
        }
    }
}
