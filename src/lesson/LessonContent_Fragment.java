package lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;

import com.example.projectlearningenglish.R;
import com.example.projectlearningenglish.R.id;
import com.example.projectlearningenglish.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class LessonContent_Fragment extends Fragment implements CordovaInterface {
	
	CordovaWebView myWeb;
	
	public static final String lessonUrl = "Url";
	
	//plugin to call when activity result is received			
	protected CordovaPlugin activityResultCallback = null;
	protected boolean activityResultKeepRunning;


	public LessonContent_Fragment newInstance() {
		LessonContent_Fragment fragment = new LessonContent_Fragment();
		return fragment;
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		
//		LayoutInflater localInflater = Inflater.cloneInContext(new CordovaContext(getActivity(), this));
		
		LayoutInflater localInflater = inflater.cloneInContext(new CordovaContext(getActivity(), this));		
		
		View view = localInflater.inflate(R.layout.fragment_lesson_content, container,
				false);
		
		myWeb = (CordovaWebView) view.findViewById(R.id.web);
//		Config.init(getActivity());
		myWeb.loadUrl("file:///android_asset/www/index.html");
		
		
		
		return view;
	}
	
private class CordovaContext extends ContextWrapper implements CordovaInterface{
		
		CordovaInterface cordova;

		public CordovaContext(Context base, CordovaInterface cordova) {
			super(base);
			this.cordova = cordova;
		}		
//		@Override
		public Activity getActivity() {
			
			return cordova.getActivity();
		}
//		@Override
		public ExecutorService getThreadPool() {
			 
			return cordova.getThreadPool();
		}
//		@Override
		public Object onMessage(String id, Object data) {
			 
			return cordova.onMessage(id, data);
		}
//		@Override
		public void setActivityResultCallback(CordovaPlugin plugin) {
			 cordova.setActivityResultCallback(plugin);
			
		}
//		@Override
		public void startActivityForResult(CordovaPlugin command, Intent intent,
				int requestCode) {
			cordova.startActivityForResult(command,intent,requestCode);			
		}
	}


//Keep app running when pause is received.(default = true)
// if true then the javascript and native code continue to run tin the background
//when another application (activity) is started.

protected boolean keepRunning = true;	

private final ExecutorService threaPool = Executors.newCachedThreadPool();
	

	@Override
	public ExecutorService getThreadPool() {
		// TODO Auto-generated method stub
		return threaPool;
	}

	@Override
	public Object onMessage(String id, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setActivityResultCallback(CordovaPlugin plugin) {
		this.activityResultCallback = plugin;
		
	}

	@Override
	public void startActivityForResult(CordovaPlugin command, Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		
		this.activityResultCallback = command;
		this.activityResultKeepRunning = this.keepRunning;
		
		if(command != null){
			this.keepRunning = false;
		}
	}

}
