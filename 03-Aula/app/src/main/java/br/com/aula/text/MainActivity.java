
package br.com.aula.text;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void calcular(View view) {
        TextInputEditText nome = findViewById(R.id.TextInputEditNome);
        TextInputEditText peso = findViewById(R.id.TextInputEditPeso);
        TextInputEditText altura = findViewById(R.id.TextInputEditAltura);

        TextView result1 = findViewById(R.id.result1);
        TextView result2 = findViewById(R.id.result2);

        String nome1 = nome.getText().toString();
        String peso1 = peso.getText().toString();
        String altura1 = altura.getText().toString();

        double numPeso = Double.parseDouble(peso1);
        double numAltura = Double.parseDouble(altura1);
        double numImc = numPeso / (numAltura * numAltura);

        String imc = String.valueOf(numImc);

        DecimalFormat df = new DecimalFormat("#.##");
        imc = df.format(numImc);

        result1.setText(imc);

        if (numImc < 18.5) {
            result2.setText("Abaixo do peso");
        }
        else if (numImc >= 18.5 && numImc <=24.9) {
            result2.setText("Peso normal");
        }
        else if (numImc >= 25 && numImc <=29.9) {
            result2.setText("Sobrepeso");
        }
        else if (numImc >= 30 && numImc <=34.9) {
            result2.setText("Obesidade grau 1");
        }
        else if (numImc >= 35) {
            result2.setText("Obesidade grau 2");
        }

    }

    public void limpar(View view) {

        TextInputEditText nome = findViewById(R.id.TextInputEditNome);
        TextInputEditText peso = findViewById(R.id.TextInputEditPeso);
        TextInputEditText altura = findViewById(R.id.TextInputEditAltura);

        TextView result1 = findViewById(R.id.result1);
        TextView result2 = findViewById(R.id.result2);

            result1.setText("");
            result2.setText("");


    }

}