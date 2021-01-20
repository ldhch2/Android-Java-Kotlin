package org.techtown.quizlocker2

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Environment
import android.text.TextUtils
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_file_ex.*
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream

class FileExActivity : AppCompatActivity() {

    val granted = false
    val filename = "data.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_ex)

        checkPermission()

        saveButton.setOnClickListener{
            val text = textField.text.toString()
            //textField의 현재 텍스트를 가져온다.
            when{
                //텍스트가 비어있을 때 오류메시지 출력
                TextUtils.isEmpty(text)->{
                    Toast.makeText(applicationContext,"텍스트가 비어있습니다.",Toast.LENGTH_LONG).show()
                }
                !isExternalStorageWritable()->{
                    Toast.makeText(applicationContext,"외부 저장장치가 없습니다.", Toast.LENGTH_LONG).show()
                }
                else->{
                //    saveToInnerStorage(text, filename)
                    saveToExternalStorage(text,filename)
                }
            }
        }

        loadButton.setOnClickListener{
            try{
                textField.setText(loadFromExternalStorage(filename))
            } catch(e: FileNotFoundException){
                Toast.makeText(applicationContext,"저장된 텍스트가 없습니다.",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename,Context.MODE_PRIVATE)

        fileOutputStream.write(text.toByteArray())

        fileOutputStream.close()
    }
    //내부저장소 파일의 텍스트를 불러온다.
    fun loadFromInnerStorage():String{
        //내부저장소의 전달된 파일이름의 파일 입력 스트림을 가져온다
        val fileInputStream = openFileInput(filename)
        //파일의 저장된 내용을 읽어 String 형태로 불러온다.
        return fileInputStream.reader().readText()
    }


    //외부 저장장치를 사용할 수 있고 슬 수 있는지 체크하는 함수
    fun isExternalStorageWritable():Boolean{
        when{
            //외부 저장장치 상태가 MEDIA_MONTED면 사용 가능
            Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED -> return true
            else -> return false
        }
    }

    //외부저장장치에서 앱 전용데이터로 사용할 파일 객체를 반환하는 함수
    fun getAppDateFileFromExternalStorage(filename: String): File {
        //KITKAT 버전 부터는 앱전용 디렉토리의 디렉토리 타입 상수인 Environment.DIRECTORY_DOCUMENTS를 지원
        val dir = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
        }else{
            //하위버전일때는 직접 디렉토리 이름 입력
            File(Environment.getExternalStorageDirectory().absolutePath + "/Documents")
        }
        //디렉토리 경로 중 없는 디렉토리가 있을 경우에 생성
        dir?.mkdirs()
        return File("${dir?.absolutePath}${File.separator}${filename}")

    }

    //외부저장소 앱 전용 디렉토리에 파일로 저장하는 함수
    fun saveToExternalStorage(text:String, filename: String){
        val fileOutputStream = FileOutputStream(getAppDateFileFromExternalStorage(filename))
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

    //외부저장소 앱 전용 디렉토리에서 파일 데이터를 불러오는 함수
    fun loadFromExternalStorage(filename: String): String{
        return FileInputStream(getAppDateFileFromExternalStorage(filename)).reader().readText()
    }
    val MY_PERMISSION_REQUEST = 999

    fun checkPermission(){
        val permissionCheck = ContextCompat.checkSelfPermission(this@FileExActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        when{
            permissionCheck != PackageManager.PERMISSION_GRANTED ->{
                ActivityCompat.requestPermissions(
                        this@FileExActivity,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        MY_PERMISSION_REQUEST
                )
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,grantResults: IntArray){
        when(requestCode){
            MY_PERMISSION_REQUEST ->{
                when {
                    grantResults.size >0 && grantResults[0]==PackageManager.PERMISSION_GRANTED ->{
                        granted = true
                    }
                    else->{
                        granted = false
                    }
                }
            }
        }
    }

    fun saveToExternalCustomDirectory(text: String, filepath: String = "/sdcard/data.txt"){
        when{
            granted->{
                val fileOutputStream = FileOutputStream(File(filepath))
                fileOutputStream.write(text.toByteArray())
                fileOutputStream.close()
            }
            else->{
                Toast.makeText(applicationContext,"권한이 없습니다.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun loadFromExternalCustomDirectory(filepath: String = "/sdcard/data.txt"): String{
        when{
            granted->{
                return FileInputStream(File(filepath)).reader().readText()
            }
            else->{
                Toast.makeText(applicationContext,"권한이 없습니다.",Toast.LENGTH_SHORT).show()
                return ""
            }
        }
    }

}