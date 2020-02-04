package app.harshit.objectdetection

import androidx.appcompat.app.AppCompatActivity
import app.harshit.objectdetection.callback.OnFragmentInteractionListener
import app.harshit.objectdetection.callback.TaskImpl
import com.google.android.gms.tasks.Task
import com.otaliastudios.cameraview.CameraView.PERMISSION_REQUEST_CODE
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.os.Bundle
import android.os.PersistableBundle
import androidx.core.app.ActivityCompat



open class BaseActivity: AppCompatActivity(), OnFragmentInteractionListener {

    lateinit var taskImpl: TaskImpl<Boolean>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
    override fun onFragmentInteraction(str: String): Task<Boolean> {
        taskImpl = TaskImpl()
        requestPermission()
        return taskImpl

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        taskImpl.listener.onSuccess(true)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


     fun requestPermission() {

        ActivityCompat.requestPermissions(
            this,
            arrayOf(ACCESS_FINE_LOCATION, CAMERA),
            PERMISSION_REQUEST_CODE
        )

    }
}