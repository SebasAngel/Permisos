package co.edu.permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.pm.PackageManager;
import android.Manifest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button checkPermissions;
    private Button requestPermissions;
    private TextView tvCamera;
    private TextView tvDactilar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        checkPermissions.setOnClickListener(this::verificarPermisos);
    }
    private void verificarPermisos(View view){
        int statusPermisoCam= ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);
        int statusPermisoBio= ContextCompat.checkSelfPermission(this,
                Manifest.permission.USE_BIOMETRIC);
        tvCamera.setText("Estatus del permiso de la Cámara:" + statusPermisoCam);
        tvDactilar.setText("Estatus del permiso de la Huella:" + statusPermisoBio);
        requestPermissions.setEnabled(true);
    }
    private void begin(){
        tvCamera=findViewById(R.id.tvCamera);
        tvDactilar=findViewById(R.id.tvBiometric);
        checkPermissions=findViewById(R.id.btnCheckPermissions);
        requestPermissions=findViewById(R.id.btnRquestPermissions);

        //Deshabilitar Button Request
        requestPermissions.setEnabled(false);

        }
}