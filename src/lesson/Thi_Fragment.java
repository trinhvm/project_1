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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class Thi_Fragment extends Fragment {

	private ListView listview;
	private CustomAdapter adapter;
	private List<Article> lessonList;
	private Fragment fragment = null;
	private FragmentManager fragmentManager;
	
	public Thi_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
//		getFragmentManager().beginTransaction().remove(getFragmentManager().findFragmentById(android.R.id.tabcontent)).commit();
//		fragmentManager.popBackStack();
		View view = inflater.inflate(R.layout.fragment_content_list, container, false);
		
		listview = (ListView) view.findViewById(R.id.listview);		
		lessonList = new ArrayList<Article>();
		
		lessonList.add( new Article(1,"file:///android_asset/www/thi_hientaidon.html","Thì hiện tại đơn"));
		lessonList.add( new Article(2,"file:///android_asset/www/thi_quakhudon.html","Quá khứ đơn"));
		lessonList.add( new Article(3,"file:///android_asset/www/thi_tuonlaidon.html","Tương lai đơn - Tương lai gần"));
		lessonList.add( new Article(4,"file:///android_asset/www/thi_hientaitiepdien.html","Hiện tại tiếp diễn"));
		lessonList.add( new Article(5,"file:///android_asset/www/thi_quakhutiepdien.html","Quá khư tiếp diễn"));
//		lessonList.add( new Article(6,"file:///android_asset/www/","Tương lai tiếp diễn"));
		lessonList.add( new Article(6,"file:///android_asset/www/thi_hientaihoanthanh.html","Hiện tại hoàn thành"));
		lessonList.add( new Article(7,"file:///android_asset/www/thi_quakhuhoanthanh.html","Quá khứ hoàn thành"));
		lessonList.add( new Article(8,"file:///android_asset/www/thi_hientaihoanthanhtiepdien.html","Hiện tại hoàn thành tiếp diễn"));
//		lessonList.add( new Article(0,"file:///android_asset/www/","Quá khứ hoàn thành tiếp diễn"));
		lessonList.add( new Article(9,"file:///android_asset/www/thi_tuonglaitiepdien-tuonglaihoanthanh.html","Tương lai hoàn thành - tương lai tiếp diễn"));
//		lessonList.add( new Article(12,"file:///android_asset/www/","Tổng hợp thì đơn và tiếp diễn"));
//		lessonList.add( new Article(13,"file:///android_asset/www/","Tổng hợp thì hoàn thành và tiếp diễn"));
		
		adapter = new CustomAdapter(getActivity(),lessonList);
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
				fragmentManager = getActivity().getSupportFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.fragment_list, fragment).addToBackStack(null).commit();
						
			}
		});		
		
		
		return view;
	}
	
	

}
