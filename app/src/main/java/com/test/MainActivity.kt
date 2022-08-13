package com.test

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.test.databinding.ActivityMainBinding
import java.io.File
import java.lang.Exception
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imagePath : String

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            binding.imageView.setImageURI(Uri.parse(imagePath))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btGet.setOnClickListener {
            takePicture()
        }

    }

    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file : File
        try {
            file = createImageFile()
            val photoUri = FileProvider.getUriForFile(this,"com.test.provider",file)
            intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
            resultLauncher.launch(intent)

        }
        catch (e: Exception){

        }
    }

    private fun createImageFile(): File {
        val fileName = "MyPictures"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val file = File.createTempFile(fileName,".jpg",storageDir)
        imagePath = file.absolutePath
        return file
    }
}
