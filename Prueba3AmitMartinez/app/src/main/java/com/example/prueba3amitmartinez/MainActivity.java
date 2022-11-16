package com.example.prueba3amitmartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText precioProducto;
    private EditText cantidadProducto;
    private TextView ivaPagar;
    private TextView totalPagar;
    private Button botonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EditText variables
        precioProducto = findViewById(R.id.editPrecio);
        cantidadProducto = findViewById(R.id.editarCantidad);
        //TextView variables
        ivaPagar = findViewById(R.id.totalIva);
        totalPagar = findViewById(R.id.totalResultado);
        //Button variables
        botonCalcular = findViewById(R.id.buttonCalcular);
        botonCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                // Otra manera
                //double precio = Double.parseDouble(precioProducto.getText().toString()),
                  //      cantidad = Double.parseDouble( cantidadProducto.getText().toString()),
                    //    iva = 0.19;
                //double total_iva = (precio * cantidad) * iva;
                //double total_pagar = (precio * cantidad) + total_iva;
                //ivaPagar.setText(String.valueOf(total_iva));
                //totalPagar.setText(String.valueOf(total_pagar));

                ivaPagar.setText(String.valueOf(calcularIva(
                        Double.parseDouble(precioProducto.getText().toString()),
                        Double.parseDouble(cantidadProducto.getText().toString()))));

                totalPagar.setText(String.valueOf(calcularTotal(
                        Double.parseDouble(ivaPagar.getText().toString()),
                        Double.parseDouble(precioProducto.getText().toString()),
                        Double.parseDouble(cantidadProducto.getText().toString()))));
            }
        });
        }
    public double calcularIva(double precioUnidad, double unidad){
        return (unidad*precioUnidad)*0.19;
    }
    public double calcularTotal(double iva, double precioUnidad, double unidad){
        return (unidad*precioUnidad) + iva;
    }
}