package com.example.hw10_firebasemessaging

import android.content.Intent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        // Get updated InstanceID token.
        Log.d(TAG, "Refreshed token: $token")

        // TODO: Implement this method to send any registration to your app's servers.
        // sendRegistrationToServer(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val msgBody = remoteMessage.notification?.body

        startActivity(
                Intent(this, MainActivity::class.java).apply {
                    setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    putExtra("message", msgBody)
                })
    }

    companion object {
        const val TAG = "MyFirebaseMessaging"
    }
}