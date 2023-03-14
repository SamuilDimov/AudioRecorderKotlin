package com.example.audiorecorder.record
import java.io.File

class AndroidAudioRecorder(
    private val context: Context
):AudioRecorder {

    private var recorder: MediaRecorder? = null
    private fun createRecorder(): MediaRecorder{
        return if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.S){
            
        }
    }
    override fun start(outputFile: File){

    }
    override fun stop(){

    }
}