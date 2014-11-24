package lesson;

import com.example.projectlearningenglish.R;
import com.example.projectlearningenglish.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class Home_Fragment extends Fragment {

	private long lastPressedTime = 0;
	Fragment fragment=null;
	
	public Home_Fragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		
		
		
		return view;
	}	
	 
}

