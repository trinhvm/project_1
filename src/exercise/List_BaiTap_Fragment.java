package exercise;

import java.util.ArrayList;
import java.util.List;

import com.example.projectlearningenglish.Article;
import com.example.projectlearningenglish.CustomAdapter;
import com.example.projectlearningenglish.R;
import com.example.projectlearningenglish.R.id;
import com.example.projectlearningenglish.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class List_BaiTap_Fragment extends Fragment {
	
	private ListView listview;
	private CustomAdapter adapter;
	private List<Article> exerciseList;
	private Fragment fragment=null;
	private FragmentManager fragmentmanager;
	public List_BaiTap_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
//		getActivity().getSupportFragmentManager().beginTransaction().remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_list)).commit();
		View view = inflater.inflate(R.layout.fragment_content_list, container, false);
		
		listview = (ListView) view.findViewById(R.id.listview);
		
		exerciseList = new ArrayList<Article>();
		exerciseList.add(new Article(1, "thi_HTD-HTTD", "Thì hiện tại đơn - hiện tại tiếp diễn"));
		exerciseList.add(new Article(2, "thi_QKD", "Thì quá khứ đơn"));
		exerciseList.add(new Article(3, "thi_QKHT", "Thì quá khứ hoàn thành"));
		exerciseList.add(new Article(4, "thi_TONGHOP", "Chọn thì thích hợp"));
		exerciseList.add(new Article(5, "thi_TONGHOP2", "Trắc nghiệm tổng hợp các thì 1"));
		exerciseList.add(new Article(6, "thi_TONGHOP3", "Trắc nghiệm tổng hợp các thì 2"));
		exerciseList.add(new Article(7, "diemnguphap_SOLUONG", "Điểm ngữ pháp: về lượng"));
		exerciseList.add(new Article(8, "diemnguphap_FORSINCE", "Điểm ngữ pháp: For và Since"));
		exerciseList.add(new Article(9, "tuloai_CHONTU", "Từ loại: chọn từ thích hợp"));
		exerciseList.add(new Article(10, "diemnguphap_PHRASALVERBS", "Từ loại: ngữ động từ"));
		
		
		adapter = new CustomAdapter(getActivity(), exerciseList);
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectItem(position);				
			}
		});
		
			
		
		return view;
	}

	public void selectItem(int position){
		Bundle bun = new Bundle();		
		
		
		switch(position){
		case 0:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 1:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 2:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 3:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 4:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 5:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 6:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 7:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		case 8:
			fragment = new BaiTap_Fragment();
			bun.putString(BaiTap_Fragment.exerciseUrl, exerciseList.get(position).getarticleUrl());
			bun.putString(BaiTap_Fragment.exerciseName, exerciseList.get(position).getArticleName());
			break;
		default:
			break;
		}
		
		fragment.setArguments(bun);
		fragmentmanager = getActivity().getSupportFragmentManager();
		FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
		fragmenttransaction.replace(R.id.fragment_list,fragment).addToBackStack(null).commit();
	}
	
	
}
