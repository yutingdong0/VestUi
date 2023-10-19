package com.example.vestui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import quevedo.soares.leandro.blemadeeasy.BLE
import quevedo.soares.leandro.blemadeeasy.BluetoothConnection

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBLEScanning()

    }

    @SuppressLint("MissingPermission")
    private fun startBLEScanning() {
        val ble = BLE(activity = this)

        ble.verifyPermissionsAsync(
            rationaleRequestCallback = { next ->
                // Include your code to show an Alert or UI explaining why the permissions are required
                // Calling the function bellow if the user agrees to give the permissions
                next()
            },
            callback = { granted ->
                if (granted) {
                    // Continue your code....
                } else {
                    // Include your code to show an Alert or UI indicating that the permissions are required
                }
            }
        )
        ble.scanForAsync(
                // You only need to supply one of these, no need for all of them!
            macAddress = "84:C6:92:87:91:E4",
            //name = "HMSoft",
            service = "0000FFE0-0000-1000-8000-00805F9B34FB",

            onFinish = { connection ->
                if (connection != null) {
                    // And you can continue with your code
                    connection.write("0000FFE1-0000-1000-8000-00805F9B34FB", "1")
                    setContentView(R.layout.lui)
                    
                } else {
                // Show an Alert or UI with your preferred error message about the device not being available
                }
            },

            onError = { errorCode ->
                // Show an Alert or UI with your preferred error message about the error
            }
        )

    }

    private fun showAlert(title: String, message: String, context: Context) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
