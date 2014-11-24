package exercise;

import java.util.ArrayList;
import java.util.List;

import com.example.projectlearningenglish.DatabaseHandle;
import com.example.projectlearningenglish.Exercise;
import com.example.projectlearningenglish.R;
import com.example.projectlearningenglish.R.layout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
public class BaiTap_Fragment extends Fragment {	
	
	public BaiTap_Fragment() {
		// Required empty public constructor
	}
	public static final String exerciseName = "excerciseName";
	public static final String exerciseUrl = "exerciseUrl";
	int exID;

	private DatabaseHandle myDB;
	private List<Exercise> questionList;
	
	int da1, da2, da3, da4, da5, da6, da7, da8, da9, da10, diem;
	int tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,tl9,tl10;
	TextView cauhoi1, cauhoi2, cauhoi3, cauhoi4, cauhoi5, cauhoi6, cauhoi7,
			cauhoi8, cauhoi9, cauhoi10,testArticle;
	RadioButton pa1a, pa2a, pa3a, pa4a, pa5a, pa6a, pa7a, pa8a, pa9a, pa10a,
			pa1b, pa2b, pa3b, pa4b, pa5b, pa6b, pa7b, pa8b, pa9b, pa10b, pa1c,
			pa2c, pa3c, pa4c, pa5c, pa6c, pa7c, pa8c, pa9c, pa10c;
	RadioGroup cau1, cau2, cau3, cau4, cau5, cau6, cau7,
			cau8, cau9, cau10;

	Button submit;	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_bai_tap, container,
				false);

		testArticle = (TextView) view.findViewById(R.id.testArticle);
		String testTitle = getArguments().getString(exerciseName);
		testArticle.setText(testTitle);
		
		cauhoi1 = (TextView) view.findViewById(R.id.cauhoi1);
		cauhoi2 = (TextView) view.findViewById(R.id.cauhoi2);
		cauhoi3 = (TextView) view.findViewById(R.id.cauhoi3);
		cauhoi4 = (TextView) view.findViewById(R.id.cauhoi4);
		cauhoi5 = (TextView) view.findViewById(R.id.cauhoi5);
		cauhoi6 = (TextView) view.findViewById(R.id.cauhoi6);
		cauhoi7 = (TextView) view.findViewById(R.id.cauhoi7);
		cauhoi8 = (TextView) view.findViewById(R.id.cauhoi8);
		cauhoi9 = (TextView) view.findViewById(R.id.cauhoi9);
		cauhoi10 = (TextView) view.findViewById(R.id.cauhoi10);

		cau1 = (RadioGroup) view.findViewById(R.id.traloi1);
		cau2 = (RadioGroup) view.findViewById(R.id.traloi2);
		cau3 = (RadioGroup) view.findViewById(R.id.traloi3);
		cau4 = (RadioGroup) view.findViewById(R.id.traloi4);
		cau5 = (RadioGroup) view.findViewById(R.id.traloi5);
		cau6 = (RadioGroup) view.findViewById(R.id.traloi6);
		cau7 = (RadioGroup) view.findViewById(R.id.traloi7);
		cau8 = (RadioGroup) view.findViewById(R.id.traloi8);
		cau9 = (RadioGroup) view.findViewById(R.id.traloi9);
		cau10 = (RadioGroup) view.findViewById(R.id.traloi10);

		pa1a = (RadioButton) view.findViewById(R.id.pa1a);
		pa2a = (RadioButton) view.findViewById(R.id.pa2a);
		pa3a = (RadioButton) view.findViewById(R.id.pa3a);
		pa4a = (RadioButton) view.findViewById(R.id.pa4a);
		pa5a = (RadioButton) view.findViewById(R.id.pa5a);
		pa6a = (RadioButton) view.findViewById(R.id.pa6a);
		pa7a = (RadioButton) view.findViewById(R.id.pa7a);
		pa8a = (RadioButton) view.findViewById(R.id.pa8a);
		pa9a = (RadioButton) view.findViewById(R.id.pa9a);
		pa10a = (RadioButton) view.findViewById(R.id.pa10a);

		pa1b = (RadioButton) view.findViewById(R.id.pa1b);
		pa2b = (RadioButton) view.findViewById(R.id.pa2b);
		pa3b = (RadioButton) view.findViewById(R.id.pa3b);
		pa4b = (RadioButton) view.findViewById(R.id.pa4b);
		pa5b = (RadioButton) view.findViewById(R.id.pa5b);
		pa6b = (RadioButton) view.findViewById(R.id.pa6b);
		pa7b = (RadioButton) view.findViewById(R.id.pa7b);
		pa8b = (RadioButton) view.findViewById(R.id.pa8b);
		pa9b = (RadioButton) view.findViewById(R.id.pa9b);
		pa10b = (RadioButton) view.findViewById(R.id.pa10b);

		pa1c = (RadioButton) view.findViewById(R.id.pa1c);
		pa2c = (RadioButton) view.findViewById(R.id.pa2c);
		pa3c = (RadioButton) view.findViewById(R.id.pa3c);
		pa4c = (RadioButton) view.findViewById(R.id.pa4c);
		pa5c = (RadioButton) view.findViewById(R.id.pa5c);
		pa6c = (RadioButton) view.findViewById(R.id.pa6c);
		pa7c = (RadioButton) view.findViewById(R.id.pa7c);
		pa8c = (RadioButton) view.findViewById(R.id.pa8c);
		pa9c = (RadioButton) view.findViewById(R.id.pa9c);
		pa10c = (RadioButton) view.findViewById(R.id.pa10c);

		submit = (Button) view.findViewById(R.id.submit);

		questionList = new ArrayList<Exercise>();
		
		myDB = new DatabaseHandle(getActivity());

		String maBT = getArguments().getString(exerciseUrl);

		questionList = myDB.getContentExcercise(maBT);

		for (int i = 0; i < questionList.size(); i++) {
			Log.d("=========check list=======", "MA:  "
					+ questionList.get(i).getMa());
			Log.d("=========check list=======", "CAU HOI:  "
					+ questionList.get(i).getCauHoi());
			Log.d("=========check list=======", "A:  "
					+ questionList.get(i).getA());
			Log.d("=========check list=======", "B:  "
					+ questionList.get(i).getB());
			Log.d("=========check list=======", "C:  "
					+ questionList.get(i).getC());
			Log.d("=========check list=======",
					"DAP AN:  " + questionList.get(i).getDapAn());

			switch (i) {
			case 0:
				da1 = questionList.get(i).getDapAn();
				cauhoi1.setText(questionList.get(i).getCauHoi());
				pa1a.setText(questionList.get(i).getA());
				pa1b.setText(questionList.get(i).getB());
				pa1c.setText(questionList.get(i).getC());				
				break;
			case 1:
				da2 = questionList.get(i).getDapAn();
				cauhoi2.setText(questionList.get(i).getCauHoi());
				pa2a.setText(questionList.get(i).getA());
				pa2b.setText(questionList.get(i).getB());
				pa2c.setText(questionList.get(i).getC());
				break;

			case 2:
				da3 = questionList.get(i).getDapAn();
				cauhoi3.setText(questionList.get(i).getCauHoi());
				pa3a.setText(questionList.get(i).getA());
				pa3b.setText(questionList.get(i).getB());
				pa3c.setText(questionList.get(i).getC());
				break;
			case 3:
				da4 = questionList.get(i).getDapAn();
				cauhoi4.setText(questionList.get(i).getCauHoi());
				pa4a.setText(questionList.get(i).getA());
				pa4b.setText(questionList.get(i).getB());
				pa4c.setText(questionList.get(i).getC());
				break;
			case 4:
				da5 = questionList.get(i).getDapAn();
				cauhoi5.setText(questionList.get(i).getCauHoi());
				pa5a.setText(questionList.get(i).getA());
				pa5b.setText(questionList.get(i).getB());
				pa5c.setText(questionList.get(i).getC());
				break;
			case 5:
				da6 = questionList.get(i).getDapAn();
				cauhoi6.setText(questionList.get(i).getCauHoi());
				pa6a.setText(questionList.get(i).getA());
				pa6b.setText(questionList.get(i).getB());
				pa6c.setText(questionList.get(i).getC());
				break;
			case 6:
				da7 = questionList.get(i).getDapAn();
				cauhoi7.setText(questionList.get(i).getCauHoi());
				pa7a.setText(questionList.get(i).getA());
				pa7b.setText(questionList.get(i).getB());
				pa7c.setText(questionList.get(i).getC());
				break;
			case 7:
				da8 = questionList.get(i).getDapAn();
				cauhoi8.setText(questionList.get(i).getCauHoi());
				pa8a.setText(questionList.get(i).getA());
				pa8b.setText(questionList.get(i).getB());
				pa8c.setText(questionList.get(i).getC());
				break;
			case 8:
				da9 = questionList.get(i).getDapAn();
				cauhoi9.setText(questionList.get(i).getCauHoi());
				pa9a.setText(questionList.get(i).getA());
				pa9b.setText(questionList.get(i).getB());
				pa9c.setText(questionList.get(i).getC());
				break;
			case 9:
				da10 = questionList.get(i).getDapAn();
				cauhoi10.setText(questionList.get(i).getCauHoi());
				pa10a.setText(questionList.get(i).getA());
				pa10b.setText(questionList.get(i).getB());
				pa10c.setText(questionList.get(i).getC());
				break;
			default:
				break;
			}
			
			
			cau1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa1a:
						tl1 = 1;
						break;
					case R.id.pa1b:
						tl1 = 2;
						break;
					case R.id.pa1c:
						tl1=3;
						break;
					default:
						break;
					}
				}
			});
			
			
			cau2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa2a:
						tl2 = 1;
						break;
					case R.id.pa2b:
						tl2 = 2;
						break;
					case R.id.pa2c:
						tl2=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa3a:
						tl3 = 1;
						break;
					case R.id.pa3b:
						tl3 = 2;
						break;
					case R.id.pa3c:
						tl3=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa4a:
						tl4 = 1;
						break;
					case R.id.pa4b:
						tl4 = 2;
						break;
					case R.id.pa4c:
						tl4=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau5.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa5a:
						tl5 = 1;
						break;
					case R.id.pa5b:
						tl5 = 2;
						break;
					case R.id.pa5c:
						tl5=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau6.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa6a:
						tl6 = 1;
						break;
					case R.id.pa6b:
						tl6 = 2;
						break;
					case R.id.pa6c:
						tl6=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau7.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa7a:
						tl7 = 1;
						break;
					case R.id.pa7b:
						tl7 = 2;
						break;
					case R.id.pa7c:
						tl7=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau8.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa8a:
						tl8 = 1;
						break;
					case R.id.pa8b:
						tl8 = 2;
						break;
					case R.id.pa8c:
						tl8=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau9.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa9a:
						tl9 = 1;
						break;
					case R.id.pa9b:
						tl9 = 2;
						break;
					case R.id.pa9c:
						tl9=3;
						break;
					default:
						break;
					}
				}
			});
			
			cau10.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
					switch(checkedId){
					case R.id.pa10a:
						tl10 = 1;
						break;
					case R.id.pa10b:
						tl10 = 2;
						break;
					case R.id.pa10c:
						tl10=3;
						break;
					default:
						break;
					}
				}
			});
	
			submit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					diem = 0;
					if(tl1==da1)
						diem++;
					if(tl2==da2)
						diem++;
					if(tl3==da3)
						diem++;
					if(tl4==da4)
						diem++;
					if(tl5==da5)
						diem++;
					if(tl6==da6)
						diem++;
					if(tl7==da7)
						diem++;
					if(tl8==da8)
						diem++;
					if(tl9==da9)
						diem++;
					if(tl10==da10)
						diem++;
					
					AlertDialog alert = new AlertDialog.Builder(getActivity()).create();
					alert.setTitle("Finish Test");
					alert.setMessage("Your Score is:  "+diem);					
					alert.setButton("OK", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					alert.show();
				}
			});					
		}	

		return view;
	}
}
