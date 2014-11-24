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
public class TuLoai_Fragment extends Fragment {
	
	private Fragment fragment = null;
	
	ListView listview;
	CustomAdapter adapter;
	List<Article> lessonList;

	public TuLoai_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_content_list, container,false);
		
		listview = (ListView) view.findViewById(R.id.listview);
		lessonList = new ArrayList<Article>();
		
		lessonList.add( new Article(1,"file:///android_asset/www/tuloai_cacdangdongtu.html","Các dạng động từ"));
		lessonList.add( new Article(2,"file:///android_asset/www/tuloai_tobe.html","Động từ to be"));
		lessonList.add( new Article(3,"file:///android_asset/www/tuloai_tanngu.html","Tân ngữ"));
		lessonList.add( new Article(4,"file:///android_asset/www/tuloai_danhtu.html","Danh từ"));		
		lessonList.add( new Article(5,"file:///android_asset/www/tuloai_tinhtu.html","Tính từ, Phó từ"));
		lessonList.add( new Article(6,"file:///android_asset/www/tuloai_gioitu.html","Giới từ"));
		lessonList.add( new Article(7,"file:///android_asset/www/tuloai_maotu.html","Mạo từ"));
		lessonList.add( new Article(8,"file:///android_asset/www/tuloai_lientu.html","Liên từ"));	
		lessonList.add( new Article(9,"file:///android_asset/www/tuloai_trangtu.html","Trạng từ"));
		lessonList.add( new Article(10,"file:///android_asset/www/tuloai_gerun_toinfinitive.html","Các dạng động từ: Gerun(V_ing)) và To infinitive"));
		lessonList.add( new Article(11,"file:///android_asset/www/tuloai_dontukhiemkhuyet.html","Động từ khiếm khuyết"));
		lessonList.add( new Article(12,"file:///android_asset/www/tuloai_trodongtu.html","Các trợ động từ"));
		lessonList.add( new Article(13,"file:///android_asset/www/tuloai_nhungdongtugaynhamlan.html","Những động từ dễ gây nhầm lẫn"));		
		lessonList.add( new Article(14,"file:///android_asset/www/tuloai_dongtudacbie.html","Một số động từ đặc biệt"));
		lessonList.add( new Article(15,"file:///android_asset/www/tuloai_dongtulamtanngu.html","Động từ dùng làm tân ngữ"));
		lessonList.add( new Article(16,"file:///android_asset/www/tuloai_danhtudungnhutinhtu.html","Danh từ dùng làm tính từ"));
		
		
		
//		lessonList.add( new Article(6,"file:///android_asset/www/","Verb phrase(ngữ động từ))"));
//		lessonList.add( new Article(8,"file:///android_asset/www/","Trợ động từ hình thái ở hiện tại"));
//		lessonList.add( new Article(9,"file:///android_asset/www/","Trợ động từ diễn đạt tình huống quá khứ"));
//		lessonList.add( new Article(14,"file:///android_asset/www/","Noun phrase(ngữ danh từ))"));
//		lessonList.add( new Article(17,"file:///android_asset/www/","So sánh tính từ và phó từ"));		
//		lessonList.add( new Article(20,"file:///android_asset/www/","Đại từ"));
		
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
				FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				fragmentManager.beginTransaction().replace(R.id.fragment_list, fragment).addToBackStack(null).commit();
						
			}
		});		
		
		return view;
	}

}
