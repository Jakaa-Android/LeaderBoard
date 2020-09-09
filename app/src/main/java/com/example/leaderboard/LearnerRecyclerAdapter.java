package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearnerRecyclerAdapter<LearnerInfo> extends RecyclerView.Adapter{

    private final Context mContext;
    private final List<LearnerInfo>mLeaner;
    private final LayoutInflater mLayoutInflater;

    public LearnerRecyclerAdapter(Context context, List<LearnerInfo> mLeaner) {
        mContext = context;
        this.mLeaner = mLeaner;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.item_learners_list,parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LearnerInfo learner=mLeaner.get(position);
        holder.mTextCourse.setText(learner.getCourse().getTitle());
        holder.mTextTitle.setText(learner.getTitle());
        holder.mCurrentPosition=position;

    }

    @Override
    public int getItemCount() {
        return mLeaner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView textCourse;
        public final TextView textTitle;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textCourse = (TextView) itemView.findViewById(R.id.text_course);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(mContext,LearnerActivity.class);
                    Intent PutExtra(LearnerActivity. LEARNER_POSITION, mCurrentPosition);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
