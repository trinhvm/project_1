package com.example.projectlearningenglish;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lesson.HoTro_Fragment;
import lesson.Tab_Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

public class MainActivity extends FragmentActivity implements
		View.OnClickListener {

	private DrawerLayout drawer;
	private FrameLayout frameLayout;
	private ActionBarDrawerToggle toggle;
	private ListView listview;
	private List<DrawerItem> drawerlist;
	CustomDrawerAdapter adapter;
	
	DatabaseHandle myDB;
	
	private Bundle bun = new Bundle();
	private FragmentManager fragmentManager;
	private Fragment fragment = null;

	Button thi, tuloai, cautruc, diemnguphap;

	int drawerPosition = 0;
	private long lastPressedTime = 0;

	// private CharSequence mdrawertitle, mtitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawer = (DrawerLayout) findViewById(R.id.drawerlayout);
		listview = (ListView) findViewById(R.id.drawer_list);
		frameLayout = (FrameLayout) findViewById(R.id.framelayout);

		thi = (Button) findViewById(R.id.thi);
		tuloai = (Button) findViewById(R.id.tuloai);
		cautruc = (Button) findViewById(R.id.cautruccau);
		diemnguphap = (Button) findViewById(R.id.diemnguphap);

		thi.setOnClickListener(this);
		tuloai.setOnClickListener(this);
		cautruc.setOnClickListener(this);
		diemnguphap.setOnClickListener(this);

		myDB = new DatabaseHandle(this);
		try {
			myDB.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mdrawertitle = mtitle = getTitle();
		// Log.d("check title at first time","mtitle = "+mtitle);

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// drawer.setDrawerShadow(R.drawable.drawer_shadow,
		// GravityCompat.START);

		drawerlist = new ArrayList<DrawerItem>();

		drawerlist.add(new DrawerItem(1, "Trang Chủ", R.drawable.ic_home));
		// drawerlist.add(1,new DrawerItem("Chủ Đề",0));
		drawerlist.add(new DrawerItem(2, "Thì", R.drawable.ic_thi));
		drawerlist.add(new DrawerItem(3, "Từ Loại",
				R.drawable.ic_tuloai));
		drawerlist.add(new DrawerItem(4, "Cấu Trúc Câu", R.drawable.ic_cautruccau));
		drawerlist
				.add(new DrawerItem(5, "Điểm Ngứ Pháp", R.drawable.ic_tudacbiet));
//		drawerlist.add(new DrawerItem(6, "Mẫu câu thông dụng",
//				R.drawable.ic_maucau));
		drawerlist.add(new DrawerItem(6, "Hỗ trợ", R.drawable.ic_hotro));

		adapter = new CustomDrawerAdapter(MainActivity.this,
				R.layout.custom_drawer_item, drawerlist);

		listview.setAdapter(adapter);

		toggle = new ActionBarDrawerToggle(this, drawer, R.drawable.ic_drawer,
				0, 0) {

			public void onDrawerClose(View view) {
				getActionBar().getTitle();
				invalidateOptionsMenu();
			}

			public void onDrawerOpen(View view) {
				getActionBar().getTitle();
				invalidateOptionsMenu();
			}
		};

		drawer.setDrawerListener(toggle);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectItem(position);
				drawerPosition = drawerlist.get(position).getItemId();
				Log.d("============", "drawerid :" + drawerPosition);
			}
		});

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.thi:
			
			fragment = new Tab_Fragment();
			
			bun.putInt(Tab_Fragment.drawerPosition, 1);
			bun.putString(Tab_Fragment.drawerTitle, "Thì");
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
		case R.id.tuloai:
			
			fragment = new Tab_Fragment();
			
			bun.putInt(Tab_Fragment.drawerPosition, 2);
			bun.putString(Tab_Fragment.drawerTitle, "Từ Loại");
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			
			break;
		case R.id.cautruccau:
			
			fragment = new Tab_Fragment();
			
			bun.putInt(Tab_Fragment.drawerPosition, 3);
			bun.putString(Tab_Fragment.drawerTitle, "Cấu Trúc Câu");
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
		case R.id.diemnguphap:
			
			fragment = new Tab_Fragment();
			
			bun.putInt(Tab_Fragment.drawerPosition, 4);
			bun.putString(Tab_Fragment.drawerTitle, "Điểm Ngữ Pháp");
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;

			default:
				break;
		}
	}

	public void selectItem(int position) {

		Bundle bun = new Bundle();
		FragmentManager fragmentManager;
		Fragment fragment = null;
		switch (position) {
		case 0:

			getSupportFragmentManager()
					.beginTransaction()
					.remove(getSupportFragmentManager().findFragmentById(
							R.id.framelayout)).commit();

			break;
		case 1:
			fragment = new Tab_Fragment();

			bun.putInt(Tab_Fragment.drawerPosition, position);
			bun.putString(Tab_Fragment.drawerTitle, drawerlist.get(position)
					.getItemName());
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
		case 2:
			fragment = new Tab_Fragment();

			bun.putInt(Tab_Fragment.drawerPosition, position);
			bun.putString(Tab_Fragment.drawerTitle, drawerlist.get(position)
					.getItemName());
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
		case 3:
			fragment = new Tab_Fragment();

			bun.putInt(Tab_Fragment.drawerPosition, position);
			bun.putString(Tab_Fragment.drawerTitle, drawerlist.get(position)
					.getItemName());
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
		case 4:
			fragment = new Tab_Fragment();

			bun.putInt(Tab_Fragment.drawerPosition, position);
			bun.putString(Tab_Fragment.drawerTitle, drawerlist.get(position)
					.getItemName());
			fragment.setArguments(bun);

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
//		case 5:
//			fragment = new HoTro_Fragment();
//
//			bun.putInt(Tab_Fragment.drawerPosition, position);
//			bun.putString(Tab_Fragment.drawerTitle, drawerlist.get(position)
//					.getItemName());
//			fragment.setArguments(bun);
//
//			fragmentManager = getSupportFragmentManager();
//			fragmentManager.beginTransaction()
//					.replace(R.id.framelayout, fragment).addToBackStack(null)
//					.commit();
//			break;
		case 5:
			fragment = new HoTro_Fragment();		

			fragmentManager = getSupportFragmentManager();
			fragmentManager.beginTransaction()
					.add(R.id.framelayout, fragment).addToBackStack(null)
					.commit();
			break;
		default:
			break;
		}

		// bun.putInt(Tab_Fragment.drawerPosition, position);
		// bun.putString(Tab_Fragment.drawerTitle,
		// drawerlist.get(position).getItemName());
		// fragment.setArguments(bun);
		//
		// fragmentManager = getSupportFragmentManager();
		// fragmentManager.beginTransaction().replace(R.id.framelayout,
		// fragment).addToBackStack(null).commit();

		int backCount = getFragmentManager().getBackStackEntryCount();
		Log.d("=======", "backcount: " + backCount);

		listview.setItemChecked(position, true);
		// setTitle(drawerlist.get(position).getItemName());
		drawer.closeDrawer(listview);

	}

	// @Override
	// public void setTitle(CharSequence title) {
	// // TODO Auto-generated method stub
	// mtitle = title;
	// Log.d("check title at seconde time","mtitle = "+mtitle);
	// getActionBar().setTitle(mtitle);
	// }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		if (toggle.onOptionsItemSelected(item)) {
			return true;
		}
		return false;
	}

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	//
	// fragment = getSupportFragmentManager().findFragmentByTag("Home");
	// if(fragment instanceof Home_Fragment){
	// if(event.getKeyCode()==KeyEvent.KEYCODE_BACK){
	// switch (event.getAction()) {
	// case KeyEvent.ACTION_DOWN:
	// if(event.getDownTime() - lastPressedTime < 3000){
	// finish();
	// }else{
	// Toast.makeText(getApplicationContext(), "Press again to exit",
	// Toast.LENGTH_SHORT).show();
	// lastPressedTime = event.getEventTime();
	// }
	// return true;
	// }
	// }
	// return false;
	// }
	// return false;
	// }

	// private static long back_pressed;
	// private Toast toast;
	// @Override
	// public void onBackPressed(){
	// // final android.app.FragmentManager fm = getFragmentManager();
	// // int fmCount = fm.getBackStackEntryCount();
	// Fragment fragment =
	// getSupportFragmentManager().findFragmentByTag("Home");
	// if(fragment instanceof Home_Fragment ){
	// Log.d("=======", "fragment: "+ fragment);
	// Log.d("=======", "home_fragment: ");
	// Toast.makeText(getBaseContext(), "Press once again to exit!",
	// Toast.LENGTH_SHORT).show();
	// // if (back_pressed + 2000 > System.currentTimeMillis())
	// // {
	// //
	// // // need to cancel the toast here
	// // toast.cancel();
	// //
	// // // code for exit
	// // Intent intent = new Intent(Intent.ACTION_MAIN);
	// // intent.addCategory(Intent.CATEGORY_HOME);
	// // intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	// // startActivity(intent);
	// //
	// // }
	// // else
	// // {
	// // // ask user to press back button one more time to close app
	// // toast= Toast.makeText(getBaseContext(), "Press once again to exit!",
	// Toast.LENGTH_SHORT);
	// // toast.show();
	// // }
	// // back_pressed = System.currentTimeMillis();
	// }else{
	// super.onBackPressed();
	// }
	// }

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);

		toggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);

		toggle.onConfigurationChanged(newConfig);
	}
}
