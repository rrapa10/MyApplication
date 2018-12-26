package com.rya.rye.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.rya.rye.myapplication.R;
import com.rya.rye.myapplication.model.Cancha;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CanchaAdapter extends RecyclerView.Adapter<CanchaAdapter.CanchaViewHolder> {
    private List<Cancha> dataList;
    private Context context;

    public CanchaAdapter(Context context, List<Cancha> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public CanchaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new CanchaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CanchaViewHolder holder, int position) {
        Cancha cancha = dataList.get(position);
        holder.txtNoticeTitle.setText(cancha.getNombre());
        holder.txtNoticeBrief.setText(cancha.getDireccion());
        holder.txtNoticeFilePath.setText(cancha.getTelefono());
        holder.txtId.setText(cancha.getId());
        RequestOptions myOptions = new RequestOptions()
                .fitCenter();
        Glide.with(context)
                .load("https://uncumbered-oar.000webhostapp.com/cancha/Api/getImage/id/" + cancha.getId())
                .thumbnail(Glide.with(context).load(R.drawable.palceholderengif))
                .apply(myOptions)
                .transition(withCrossFade())
                .apply(new RequestOptions().transforms(new RoundedCorners(20)))
                .into(holder.imgfoto);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CanchaViewHolder extends RecyclerView.ViewHolder {

        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath, txtId;
        ImageView imgfoto;

        CanchaViewHolder(View itemView) {
            super(itemView);
            txtNoticeTitle = itemView.findViewById(R.id.txt_cancha_title);
            txtNoticeBrief = itemView.findViewById(R.id.txt_direccion);
            txtNoticeFilePath = itemView.findViewById(R.id.txt_telefono);
            imgfoto = itemView.findViewById(R.id.img_foto);
            txtId = itemView.findViewById(R.id.txt_id);
        }
    }


}
