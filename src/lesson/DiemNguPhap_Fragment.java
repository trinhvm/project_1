package lesson;

import java.util.ArrayList;

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
public class DiemNguPhap_Fragment extends Fragment {
	
	ListView listview;
	ArrayList<Article> lessonList;
	CustomAdapter adapter;
	
	private Fragment fragment = null;

	public DiemNguPhap_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_content_list, container,false);
		
		listview = (ListView) view.findViewById(R.id.listview);
		lessonList = new ArrayList<Article>();
		

		lessonList.add( new Article(1,"file:///android_asset/www/diemnguphap_dungshouldtruonghopdacbiet.html","Dùng should trong trường hợp đặc biệt"));
		lessonList.add( new Article(2,"file:///android_asset/www/diemnguphap_cachdungkhaccuathat.html","Những cách dùng khác của that"));
		lessonList.add( new Article(3,"file:///android_asset/www/diemnguphap_say-tell-talk-speak.html","Say / to tell / speak / talk"));
		lessonList.add( new Article(4,"file:///android_asset/www/diemnguphap_cauhoivoihow.html","Câu hỏi với How"));
		lessonList.add( new Article(5,"file:///android_asset/www/diemnguphap_can-could-ableto.html","Can / could / be able to"));
		lessonList.add( new Article(6,"file:///android_asset/www/diemnguphap_may-might.html","May / Might"));
		lessonList.add( new Article(7,"file:///android_asset/www/diemnguphap_must-haveto.html","Must / have to"));
		lessonList.add( new Article(8,"file:///android_asset/www/diemnguphap_hadbetter.html","Had better"));
		lessonList.add( new Article(9,"file:///android_asset/www/diemnguphap_some-any-many-much.html","Some / Any / many / much"));
		lessonList.add( new Article(10,"file:///android_asset/www/diemnguphap_both-neither-either-notonly.html","Both(of)) / Neither (of)) / Either (of))"));
		lessonList.add( new Article(11,"file:///android_asset/www/diemnguphap_all-every.html","All / every"));
		lessonList.add( new Article(12,"file:///android_asset/www/diemnguphap_so-such.html","So / Such"));
		lessonList.add( new Article(13,"file:///android_asset/www/diemnguphap_quite-rather.html","Quite / rather"));
		lessonList.add( new Article(14,"file:///android_asset/www/diemnguphap_too-enought.html","Enough / too"));
		lessonList.add( new Article(15,"file:///android_asset/www/diemnguphap_still-for-since-yet-already-just.html","Still / yet / already / Any more / no longer"));
		lessonList.add( new Article(16,"file:///android_asset/www/diemnguphap_event.html","Even"));
		lessonList.add( new Article(17,"file:///android_asset/www/diemnguphap_during-white-for.html","For / during / while"));
		
//		lessonList.add( new Article(3,"file:///android_asset/www/","Các cụm từ nối mang tính quan hệ nhân quả"));
//		lessonList.add( new Article(1,"file:///android_asset/www/","Một số động từ đặc biệt(need, dare, to be, get"));
//		lessonList.add( new Article(5,"file:///android_asset/www/","to know, to know how"));
//		lessonList.add( new Article(7,"file:///android_asset/www/","One and you"));
//		lessonList.add( new Article(9,"file:///android_asset/www/","Have và Have got"));
//		lessonList.add( new Article(10,"file:///android_asset/www/","Use to (do))"));
//		lessonList.add( new Article(11,"file:///android_asset/www/","(I'm)) going to (do))"));
//		lessonList.add( new Article(13,"file:///android_asset/www/","Could(do)) và Could have (done))"));
//		lessonList.add( new Article(14,"file:///android_asset/www/","Must / Can't"));
//		lessonList.add( new Article(17,"file:///android_asset/www/","Must / mustn't / needn't"));	
//		lessonList.add( new Article(19,"file:///android_asset/www/","There / it"));
//		lessonList.add( new Article(20,"file:///android_asset/www/","Myself / yourself / themselves"));
//		lessonList.add( new Article(22,"file:///android_asset/www/","No / one / any"));
//		lessonList.add( new Article(23,"file:///android_asset/www/","Much / many / little / few / alot / plenty"));
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
