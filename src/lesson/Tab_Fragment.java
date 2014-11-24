package lesson;

import com.example.projectlearningenglish.R;
import com.example.projectlearningenglish.R.layout;

import exercise.List_BaiTap_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost.OnTabChangeListener;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class Tab_Fragment extends Fragment implements OnTabChangeListener{
	
	public static final String drawerPosition = "position";
	public static final String drawerTitle = "Title";
	
	private FragmentTabHost tab;
	private boolean createTab = false;
	
	public Tab_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_tab, container, false);
		int pos = getArguments().getInt(drawerPosition);
		Log.d("check position","position = "+pos);		
		
		tab = (FragmentTabHost) view.findViewById(android.R.id.tabhost);
		tab.setup(getActivity(), getChildFragmentManager(), android.R.id.tabcontent);		
		
		switch (pos) {		
		case 1:
			tab.addTab(tab.newTabSpec("thi").setIndicator("Thì"), Thi_Fragment.class,null);
			tab.addTab(tab.newTabSpec("baitapthi").setIndicator("Bài Tập"), List_BaiTap_Fragment.class,null);			
			break;
		case 3:
			tab.addTab(tab.newTabSpec("cautruc").setIndicator("Cấu Trúc Câu"), CauTrucCau_Fragment.class,null);
			tab.addTab(tab.newTabSpec("baitapcautruc").setIndicator("Bài Tập"), List_BaiTap_Fragment.class,null);
			break;
		case 2:
			tab.addTab(tab.newTabSpec("tuloai").setIndicator("Từ Loại"), TuLoai_Fragment.class,null);
			tab.addTab(tab.newTabSpec("baitaptuloai").setIndicator("Bài Tập"), List_BaiTap_Fragment.class,null);
			break;
		case 4:
			tab.addTab(tab.newTabSpec("thi").setIndicator("Điểm Ngữ Pháp"), DiemNguPhap_Fragment.class,null);
			tab.addTab(tab.newTabSpec("baitapbaitap").setIndicator("Bài Tập"), List_BaiTap_Fragment.class,null);
			break;		
		default:
			break;
		}
		tab.setOnTabChangedListener(this);
		
		
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		if(!createTab){
			createTab = true;
			tab.setup(getActivity(),getActivity().getSupportFragmentManager());
		}		
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		tab=null;
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
	}
	
}
