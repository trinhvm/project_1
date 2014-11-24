package lesson;

import com.example.projectlearningenglish.R;
import com.example.projectlearningenglish.R.id;
import com.example.projectlearningenglish.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class LessonWebViewFragment extends Fragment {

	WebView lessonWeb;
	public static final String lessonWebUrl = "Url";
	
	
	public LessonWebViewFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_lesson_web_view, container,
				false);
		lessonWeb = (WebView) view.findViewById(R.id.webview);
		String sourceLesson = getArguments().getString(lessonWebUrl);
		lessonWeb.loadUrl(sourceLesson);
		
		return view;
	}

}
