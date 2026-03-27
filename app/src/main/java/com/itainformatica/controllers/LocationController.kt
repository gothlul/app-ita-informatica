package com.itainformatica.controllers

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent

//class LocationController : Service() {
//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//    private val locationCallback = object : LocationCallback() {
//        override fun onLocationResult(result: LocationResult) {
//            result.lastLocation?.let { location ->
//                val intent = Intent("ACTION_LOCATION_UPDATE")
//                intent.putExtra("lat", location.latitude)
//                intent.putExtra("lng", location.longitude)
//                sendBroadcast(intent)
//            }
//        }
//    }
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        startForeground(1, createNotification()) // Notificação obrigatória
//        requestLocationUpdates()
//        return START_STICKY
//    }
//
//    @SuppressLint("MissingPermission")
//    private fun requestLocationUpdates() {
//        val request = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build()
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//        fusedLocationClient.requestLocationUpdates(request, locationCallback, Looper.getMainLooper())
//    }
//
//    override fun onBind(intent: Intent?): IBinder? = null
//}