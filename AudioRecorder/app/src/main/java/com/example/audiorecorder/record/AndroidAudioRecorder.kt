package com.example.audiorecorder.record
import java.io.File
import android.content.Context
import android.media.MediaRecorder
import android.os.Build
import java.io.FileOutputStream
import android.provider.MediaStore.Audio.Media


class AndroidAudioRecorder(
    private val context: Context
):AudioRecorder {

    private var recorder: MediaRecorder? = null
    private fun createRecorder(): MediaRecorder{
        return if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.S){
            MediaRecorder(context)
        } else MediaRecorder()
    }
    override fun start(outputFile: File){
        createRecorder().apply{
            setAudioSource(MediaRecorder.AudioSource.MIC)//microphone usage
            setOutputFormat(MediaRecorder.OutputFormat.MPEG_4)//format of recording
            setAudioEncoder(MediaRecorder.AudioEncoder.AAC)//voice quality encoder
            setOutputFile(FileOutputStream(outputFile).fd)//output file using file descriptor

            prepare()
            start()

            recorder = this
        }
    }
    override fun stop(){
    recorder?.stop()
        recorder?.reset()
        recorder = null
    }
}