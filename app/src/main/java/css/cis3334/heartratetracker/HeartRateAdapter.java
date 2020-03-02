package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HeartRateAdapter extends ArrayAdapter<HeartRate> {

    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulseDetail);
        tvPulse.setText(hr.getPulse().toString());

        TextView tvRange =(TextView) view.findViewById(R.id.textViewRangeDetail);
        tvRange.setText(hr.getRangeName());

        TextView tvDescription =(TextView) view.findViewById(R.id.textViewDescription);
        tvDescription.setText(hr.getRangeDescrtiption().toString());

        LinearLayout layoutMain = (LinearLayout) view.findViewById(R.id.layoutMain);

        if(hr.getRangeName().equals(hr.rangeNames[0])) {
            layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone1));
        }else if(hr.getRangeName().equals(hr.rangeNames[1])){
            layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone2));
        }else if(hr.getRangeName().equals(hr.rangeNames[2])){
            layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone3));
        }else if(hr.getRangeName().equals(hr.rangeNames[3])){
            layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone4));
        }else if(hr.getRangeName().equals(hr.rangeNames[4])){
            layoutMain.setBackgroundColor(ContextCompat.getColor(context, R.color.colorZone5));
        }







        return(view);
    }

}

