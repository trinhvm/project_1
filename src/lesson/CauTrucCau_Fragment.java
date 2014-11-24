package lesson;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class CauTrucCau_Fragment extends Fragment {
	
	ListView listview;
	List<Article> lessonList;
	CustomAdapter adapter;
	
	private Fragment fragment = null;
	public CauTrucCau_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_content_list, container,false);
		
		listview = (ListView)view.findViewById(R.id.listview);		
		lessonList = new ArrayList<Article>();
		
		lessonList.add( new Article(1,"file:///android_asset/www/cautruccau.html","Cấu trúc chung của một câu"));
		lessonList.add( new Article(2,"file:///android_asset/www/cautruccau_cauhoi.html","Câu hỏi"));
		lessonList.add( new Article(3,"file:///android_asset/www/cautruccau_loinoiphuhoa.html","Lối nói phụ họa"));
		lessonList.add( new Article(4,"file:///android_asset/www/cautruccau_cauphudinh.html","Câu phủ định"));
		lessonList.add( new Article(5,"file:///android_asset/www/cautruccau_caumenhlenh.html","Câu mệnh lệnh"));
		lessonList.add( new Article(6,"file:///android_asset/www/cautruccau_caucaukhien.html","Câu điều kiện"));
		lessonList.add( new Article(7,"file:///android_asset/www/cautruccau_caibidong.html","Câu bị động"));
		lessonList.add( new Article(8,"file:///android_asset/www/cautruccau_caudieukien.html","Câu cầu khiến"));
		lessonList.add( new Article(9,"file:///android_asset/www/cautruccau_caugiadinh.html","Câu giả định"));
		lessonList.add( new Article(10,"file:///android_asset/www/cautruccau_causosanh.html","Câu so sánh"));		
		lessonList.add( new Article(11,"file:///android_asset/www/cautruccau_cautructiepcaugiantiep.html","Câu trực tiếp và câu gián tiếp"));
		
//		lessonList.add( new Article(13,"file:///android_asset/www/","Cấu trúc song song trong câu"));
//		lessonList.add( new Article(9,"file:///android_asset/www/","Câu phức hợp và đại từ quan hệ"));
//		lessonList.add( new Article(10,"file:///android_asset/www/","Cách sử dụng một số cấu trúc câu"));
//		lessonList.add( new Article(1,"file:///android_asset/www/","Sự hòa hợp giữa chủ ngữ và động từ"));
//		lessonList.add( new Article(15,"file:///android_asset/www/","Câu phức hợp và đại từ quan hệ"));
//		lessonList.add( new Article(16,"file:///android_asset/www/","Lối nói bao hàm"));
//		lessonList.add( new Article(17,"file:///android_asset/www/","Mệnh đề thể hiện sự nhượng bộ"));
//		lessonList.add( new Article(18,"file:///android_asset/www/","Sự phù hợp về thời gian giữa hai về của một câu"));
//		lessonList.add( new Article(19,"file:///android_asset/www/","Thông tin thừa"));		
//		lessonList.add( new Article(20,"file:///android_asset/www/","Mệnh đề quan hệ"));
//		lessonList.add( new Article(21,"file:///android_asset/www/","Giản lược mệnh đề quan hệ"));
		
		adapter = new CustomAdapter(getActivity(), lessonList);
		listview.setAdapter(adapter);
		
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				fragment = new LessonWebViewFragment();
				
				Bundle bun = new Bundle();
				bun.putString(LessonWebViewFragment.lessonWebUrl, lessonList.get(position).getarticleUrl());
				fragment.setArguments(bun);
				
//				FragmentManager fragmentManager = getFragmentManager();
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.fragment_list, fragment).addToBackStack(null).commit();
						
			}
		});		
		
		return view;
	}

}
