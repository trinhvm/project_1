package com.example.projectlearningenglish;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	
	List<Article> listentry;
	public Context context;
	public LayoutInflater inflater;
	
	public CustomAdapter(Context context, List<Article> listentry){
		super();
		this.listentry=listentry;
		this.context=context;
		inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listentry.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return listentry.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		viewHolder holder;
		if(view==null){
			holder = new viewHolder();
			view = inflater.inflate(R.layout.custom_listview, null);
			holder.titile=(TextView)view.findViewById(R.id.tv_lesson);
			holder.stt=(TextView)view.findViewById(R.id.tv_stt);			
			view.setTag(holder);
		}else{
			holder = (viewHolder) view.getTag();
		}
		Article a = (Article) listentry.get(position);
//		holder.image.setBackgroundResource(R.drawable.new72);
		holder.titile.setText(a.getArticleName());
//		holder.description.setText(a.getDescription());
		holder.stt.setText(position+1+"");
		
		return view;
	}
	
	public static class viewHolder{
		TextView stt,titile;
	}

}
