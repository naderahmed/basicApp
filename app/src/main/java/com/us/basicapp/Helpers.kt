package com.us.basicapp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity




fun Context.sendEmail(adress: String?, subject: String?, body: String?){

    val selectorIntent = Intent(Intent.ACTION_SENDTO)
    selectorIntent.data = Uri.parse("mailto:")

    val emailIntent = Intent(Intent.ACTION_SEND)
    emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(adress))
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
    emailIntent.putExtra(Intent.EXTRA_TEXT, body)
    emailIntent.selector = selectorIntent

    try{
        startActivity(emailIntent)
    }
    catch (ex:java.lang.Exception){
        showMessege(getString(R.string.no_app_to_perform_action))
    }

}


var oldToast: Toast? = null
fun Context.showMessege(msg: String) {
    oldToast?.cancel()
    oldToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    oldToast?.show()
}

fun Context.makeACall(number:String)
{
    val callIntent = Intent(Intent.ACTION_DIAL)
    callIntent.data = Uri.parse("tel:$number")
    try{
        startActivity(this,callIntent,null)
    }
    catch (ex:java.lang.Exception){
        showMessege(getString(R.string.no_app_to_perform_action))
    }
}
