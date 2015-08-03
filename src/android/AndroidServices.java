package com.androidServices;
// Needed imports
import org.json.JSONException;
import org.json.JSONObject;
import com.red_folder.phonegap.plugin.backgroundservice.BackgroundService;

//////
import java.text.SimpleDateFormat;
import java.util.Date;
import android.util.Log;

public class AndroidServices extends BackgroundService {

	private final static String TAG = AndroidServices.class.getSimpleName();

	private String mHelloTo = "World";
	private int soundAlarmLv=0;
	private int vibrateAlarmLv=0;



	@Override
	protected JSONObject doWork() {
		JSONObject result = new JSONObject();

		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String now = df.format(new Date(System.currentTimeMillis()));

			String msg = "Hello soundAlarmLv:" + soundAlarmLv + " - its currently " + now;
			result.put("Message", msg);
			result.put("vibrateAlarmLv", vibrateAlarmLv);
			Log.d(TAG, msg);
		} catch (JSONException e) {
		}

		return result;
	}

	@Override
	protected JSONObject getConfig() {
		JSONObject result = new JSONObject();

		try {
			result.put("HelloTo", this.mHelloTo);
		} catch (JSONException e) {
		}

		return result;
	}

	@Override
	protected void setConfig(JSONObject config) {
		try {
			if (config.has("soundAlarmLv"))
				this.soundAlarmLv = config.getInt("soundAlarmLv");
			if (config.has("vibrateAlarmLv"))
				this.vibrateAlarmLv = config.getInt("vibrateAlarmLv");
			if (config.has("HelloTo"))
				this.mHelloTo = config.getString("HelloTo");
		} catch (JSONException e) {
		}

	}

	@Override
	protected JSONObject initialiseLatestResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void onTimerEnabled() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onTimerDisabled() {
		// TODO Auto-generated method stub
	}
}
