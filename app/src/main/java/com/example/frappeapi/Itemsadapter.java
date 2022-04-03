package com.example.frappeapi;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Itemsadapter extends RecyclerView.Adapter<Itemsadapter.myviewholder>
{
	private  Context mCtx;
	ArrayList<items> dataProductmodel;

	public  String proImage;
	public  String productName;
	public  String proDescription;
	private FragmentManager f_manager;

	public Itemsadapter(Context mCtx, ArrayList<items> dataProductmodel)
	{
		this.mCtx=mCtx;
		this.dataProductmodel = dataProductmodel;
	}

	public Itemsadapter(Context context, ArrayList<items> productModel, FragmentManager fragmentManager) {
		this.mCtx=context;
		this.dataProductmodel = productModel;
		this. f_manager=fragmentManager;

	}

	@NonNull
	@Override
	public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		View view= LayoutInflater.from(parent.getContext()).inflate(
				R.layout.productrecycler_row_design,parent,false);
		return new myviewholder(view);
	}
	//variable to store data of product to send it with put extra
	public   String Extraproname;
	public   String Extraprodescrption;
	public   String ExtraImage;
	String   ExtraproId;
	private  items Extraprodata;
	items  dataAdapterOBJ;
	@Override
	public void onBindViewHolder(@NonNull myviewholder holder, final int position)
	{
		final items current = dataProductmodel.get(position);
		dataAdapterOBJ =  dataProductmodel.get(position);
		// Picasso.with(mCtx).load(dataAdapterOBJ.getImage()).into(holder.imgproduct);
		holder.proName.setText(dataAdapterOBJ.getItemname());
		//dataAdapterOBJ.getProname()
	//	holder.proDesc.setText(dataAdapterOBJ.getItemname());

//		//___________________to show images in recyclerview
//		String aUrl =dataAdapterOBJ.getImge().replace("http", "https");
//		Picasso.with(mCtx)
//				.load(aUrl)
//				.into(holder.imgproduct);

	//	Log.e(TAG, "onBindViewHolderh: "+aUrl);
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v)
			{

			}
		});
	}


	@Override
	public int getItemCount() {
		return dataProductmodel.size();
	}

	class myviewholder extends RecyclerView.ViewHolder  implements View.OnClickListener
	{
		ImageView imgproduct;
		TextView proName,proDesc;
		public myviewholder(@NonNull View itemView)
		{
			super(itemView);
			//imgproduct=itemView.findViewById(R.id.imgproduct);
			proName=itemView.findViewById(R.id.nametxt);
			//proDesc=itemView.findViewById(R.id.desctxt);
			itemView.setClickable(true);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {

		}
	}
}
