package com.eggdevs.theeverythingtestproject

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.content.pm.PackageManager
import android.util.Log
import java.lang.Exception
import java.util.*


class MyBroadCastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

//        val clickedComponent : ComponentName = intent?.getParcelableExtra(Intent.EXTRA_CHOSEN_COMPONENT)!!
//        Toast.makeText(context, "$clickedComponent", Toast.LENGTH_SHORT).show()

        for (key in Objects.requireNonNull(intent!!.extras)!!.keySet()) {
            try {
                val componentInfo = intent.extras!![key] as ComponentName?
                val packageManager = context!!.packageManager
                assert(componentInfo != null)
                val appName = packageManager.getApplicationLabel(
                    packageManager.getApplicationInfo(
                        componentInfo!!.packageName, PackageManager.GET_META_DATA
                    )
                ).toString()
                Log.i("mytag", appName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}
